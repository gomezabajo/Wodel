package efinder.core.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.ir.IRBuilder;
import efinder.core.utils.IRCopier;
import efinder.ir.AbstractFunction;
import efinder.ir.DefinedOperationRef;
import efinder.ir.EFType;
import efinder.ir.EfinderFactory;
import efinder.ir.Parameter;
import efinder.ir.Specification;
import efinder.ir.TypeRef;
import efinder.ir.VariableDeclaration;
import efinder.ir.ocl.CollectionCallExp;
import efinder.ir.ocl.IfExp;
import efinder.ir.ocl.IterateExp;
import efinder.ir.ocl.IteratorExp;
import efinder.ir.ocl.LetExp;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclFactory;
import efinder.ir.ocl.OclInvariant;
import efinder.ir.ocl.OclOperation;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.VarExp;

public class UnfoldRecursionTransform implements IDialectAdaptation {

	private static final int DEFAULT_UNFOLDINGS = 5;
	private static int id = 1;

	@Override
	public void transform(@NonNull EFinderModel model) {		
		model.getSpecification().eAllContents().forEachRemaining(o -> {
			if (o instanceof OclOperation) {
				inOclOperation((OclOperation) o, model.getSpecification());
			}
			if (o instanceof IterateExp) {
				transformIterate((IterateExp) o, model.getSpecification());
			}
		});
	}

	private void inOclOperation(@NonNull OclOperation o, @NonNull Specification specification) {
		// TODO Auto-generated method stub
		List<OperationCallExp> sites = needsUnfolding(o);
		if (sites != null) {
			unfold(specification, o, sites, DEFAULT_UNFOLDINGS);
		}
	}

	private List<OperationCallExp> needsUnfolding(OclOperation operation) {
		ArrayList<OperationCallExp> unfoldingSites = null;
		// Don't start at the body because we need to process even the very first element of the tree
		TreeIterator<EObject> it = operation.eAllContents(); 
		while ( it.hasNext() ) {
			EObject o = it.next();
			if ( o instanceof OperationCallExp ) {
				OperationCallExp prop = ((OperationCallExp) o);
				if ( isResolvedBy(prop, operation)) {
					if ( unfoldingSites == null ) 
						unfoldingSites = new ArrayList<OperationCallExp>();
					unfoldingSites.add((OperationCallExp) o);
				}				
			}
		}
		return unfoldingSites;
	}

	
	private boolean isResolvedBy(@NonNull OperationCallExp prop, @NonNull OclOperation operation) {
		// TODO: Check dynamic resolvers?
		return prop.getFeature() instanceof DefinedOperationRef && ((DefinedOperationRef) prop.getFeature()).getOperation() == operation;
	}

	private void transformIterate(@NonNull IterateExp o, @NonNull Specification specification) {
		TypeRef resultType = o.getResult().getType();
		TypeRef sourceType = o.getSource().getType();
		Preconditions.checkState(resultType != null && sourceType != null, "No type information available for this transform");
		
		List<VariableDeclaration> localVariables = new ArrayList<VariableDeclaration>(getLocalVariables(o));
		
		// ArrayList<VariableDeclaration> localVariablesWithOnlyOneSelf = filterOnlyOneSelf(localVariables);

		List<Parameter> parameters = new ArrayList<Parameter>();
		
		// Two parameters: currentResult and collection
		Parameter parameter1 = EfinderFactory.eINSTANCE.createParameter();
		parameter1.setType(resultType);
		parameter1.setName(o.getResult().getName());
		parameters.add(parameter1);
		
		Parameter parameter2 = EfinderFactory.eINSTANCE.createParameter();
		parameter2.setType(sourceType);
		parameter2.setName("col_");
		parameters.add(parameter2);
		
		Parameter selfParameter = null;
		Map<VariableDeclaration, Parameter> localVarParameters = new HashMap<VariableDeclaration, Parameter>();
		for (VariableDeclaration variableDeclaration : localVariables) {
			if ( variableDeclaration.getName().equals("self") ) {
				if ( selfParameter != null ) {
					localVarParameters.put(variableDeclaration, selfParameter);
					continue;
				}
			}
			
			Parameter parameterN = EfinderFactory.eINSTANCE.createParameter();
			// ?????
			selfParameter = parameterN;
			parameterN.setType(EcoreUtil.copy(variableDeclaration.getType()));
			parameterN.setName(variableDeclaration.getName() + "_"); // To avoid name clashes (e.g., with self)
			parameters.add(parameterN);
		
			localVarParameters.put(variableDeclaration, parameterN);
		}

		EFType ctxType = findContext(o);
		
		OclOperation operation = OclFactory.eINSTANCE.createOclOperation();
		operation.setName("iterator" + id ++);
		operation.setType(EcoreUtil.copy(resultType));
		operation.setContext(ctxType); 
		operation.getParameters().addAll(parameters);
		VariableDeclaration self_ = IRBuilder.newVariableDeclaration("self", IRBuilder.newMetaTypeRef(ctxType));
		operation.setContextVariable(self_);
		
		// Helper body
		IfExp ifexp = OclFactory.eINSTANCE.createIfExp();
		CollectionCallExp condition = OclFactory.eINSTANCE.createCollectionCallExp();
		condition.setName("isEmpty");
		condition.setSource(IRBuilder.newVariableExp(parameter2));
		ifexp.setCondition(condition);
		
		// If isEmpty() then return acc
		ifexp.setThen(IRBuilder.newVariableExp(parameter1));

		// Else
		//   let current = col->any(true)
		//       in 
		IteratorExp colAny = IRBuilder.newIteratorExp("any", 
				IRBuilder.newVariableExp(parameter2), 
				IRBuilder.newIterator("dummy_it", null), // TODO: is null valid here? 
				IRBuilder.newBooleanExp(true));
		
		VariableDeclaration letExpVar = IRBuilder.newVariableDeclaration("current_var_", null);		
		VariableDeclaration accVar = IRBuilder.newVariableDeclaration("acc_var_", null);
		VariableDeclaration restVar = IRBuilder.newVariableDeclaration("rest_var_", null);
		
		// rest = col->select(it | it <> current_var)
		IteratorExp selectRest = 
				IRBuilder.newIteratorExp("select", 
						IRBuilder.newVariableExp(parameter2), 
						IRBuilder.newIterator("s_it", null), // TODO: is null valid here? 
						(it) -> {
							return IRBuilder.newOperatorCallExp(OperatorKind.DISTINCT, 
									IRBuilder.newVariableExp(it), 
									IRBuilder.newVariableExp(letExpVar));
						});

		// Convert the iterate body into an expression usable within the recursive operation
		IRCopier copier = new IRCopier(o.getBody()).
				bind(o.getResult(), parameter1).
				bind(o.getIterators().get(0), letExpVar);
		localVarParameters.forEach((v, p) -> copier.bind(v, p));				
			
		OclExpression body = (OclExpression) copier.copy();

		OperationCallExp recursiveCall = OclFactory.eINSTANCE.createOperationCallExp();
		recursiveCall.setName(operation.getName());
		recursiveCall.setSource(IRBuilder.newVariableExp(self_));
		recursiveCall.getArguments().add(IRBuilder.newVariableExp(accVar));
		recursiveCall.getArguments().add(IRBuilder.newVariableExp(restVar));
		recursiveCall.setFeature(IRBuilder.newDefinedOperationRef(operation));
		for (VariableDeclaration variableDeclaration : localVariables) {
			Parameter parameter = localVarParameters.get(variableDeclaration);
			recursiveCall.getArguments().add(IRBuilder.newVariableExp(parameter));
		}
		
		LetExp letCurrent = IRBuilder.newLetExp(letExpVar, colAny, 
				IRBuilder.newLetExp(accVar, body, 
					IRBuilder.newLetExp(restVar, selectRest, recursiveCall)));

		ifexp.setElse(letCurrent);
		
		operation.setBody(ifexp);
		
		// Replace the original iterate to a call to the recursive operation
		OperationCallExp firstCall = OclFactory.eINSTANCE.createOperationCallExp();
		firstCall.setName(operation.getName());
		firstCall.setSource(IRBuilder.newVariableExp(self_));
		firstCall.getArguments().add(o.getInit());
		firstCall.getArguments().add(o.getSource());
		for (VariableDeclaration variableDeclaration : localVariables) {
			firstCall.getArguments().add(IRBuilder.newVariableExp(variableDeclaration));
		}
		firstCall.setFeature(IRBuilder.newDefinedOperationRef(operation));
		EcoreUtil.replace(o, firstCall);
		
		// Add to the specification
		specification.getOperations().add(operation);

		unfold(specification, operation, Collections.singletonList(recursiveCall), DEFAULT_UNFOLDINGS);
	}
		
	private void unfold(@NonNull Specification specification, @NonNull OclOperation operation, final List<? extends OperationCallExp> originalSites, int numUnfoldings) {
		OclOperation previousOperation = operation;
		List<OperationCallExp> sites = new ArrayList<OperationCallExp>(originalSites);
		for(int i = 0; i < numUnfoldings; i++) {
			IRCopier copier = new IRCopier(operation);
			OclOperation copy = (OclOperation) copier.copy();
			String newName = operation.getName() + "_" + i;
			copy.setName(newName);
			
			for (final OperationCallExp s : sites) {
				s.setName(newName);
				s.setFeature(IRBuilder.newDefinedOperationRef(copy));
			}
			
			for (final OperationCallExp s : originalSites) {		
				// TOOD: When the site has polymorphic behaviour, then the static type has to be changed
				// generated new helpers as well (see unfolded recursion in original AnATLyzer's implementation)
				/*
				if ( s.getStaticResolver() != helper && s.getDynamicResolvers().contains(helper) ) {
					// TODO: Check that other unfolding of sibling classes has not done the same operation 
					//       over a common supertype
					Helper overridenHelper = slice.getCopiedHelper((Helper) s.getStaticResolver()); // because staticHelper points to the original, not to the copy made by the error slice					
					System.out.println(ATLUtils.getTypeName(ATLUtils.getHelperType(overridenHelper).getInferredType()) + "." + ATLUtils.getHelperName(overridenHelper));
					Helper newOverridenHelper = (Helper) ATLCopier.copySingleElement(overridenHelper);
					
					if ( newOverridenHelper.getDefinition().getFeature() instanceof Attribute ) {
						((Attribute) newOverridenHelper.getDefinition().getFeature()).setName(newHelperName);
					} else {
						((Operation) newOverridenHelper.getDefinition().getFeature()).setName(newHelperName);				
					}

					newHelpers.add(newOverridenHelper);					
				}
				*/
			}
	
		
			// Compute the call sites of the new element
			sites = originalSites.stream().map(s -> (OperationCallExp) copier.get(s)).collect(Collectors.toList());
			previousOperation = copy;
			
			specification.getOperations().add(copy);
		}

		// Change the body of the last helper to indicate "an error" because there are not enough unfoldings
		previousOperation.setBody(OclFactory.eINSTANCE.createOclUndefined());

	}


	private EFType findContext(@NonNull IterateExp o) {
		EObject parent = o.eContainer();		
		while (parent != null) {
			if (parent instanceof AbstractFunction) {
				return ((AbstractFunction) parent).getContext();
			} else if (parent instanceof OclInvariant) {
				return ((OclInvariant) parent).getKlass();
			}
			parent = parent.eContainer();
		}
		throw new IllegalStateException("No context");
	}

	private Set<VariableDeclaration> getLocalVariables(IterateExp iterate) {
		OclExpression body = iterate.getBody();
		
		Set<VariableDeclaration> vars = new HashSet<VariableDeclaration>();
		body.eAllContents().forEachRemaining(it -> {
			if ( it instanceof VarExp ) {
				VariableDeclaration vd = ((VarExp) it).getVariable();
				if ( vd.getName().equals("self") ||
					 vd.eContainer() instanceof LetExp ||
					 vd instanceof Parameter ) {
					vars.add(((VarExp) it).getVariable());					
				}
			}
		});

		return vars;
	}	
}
