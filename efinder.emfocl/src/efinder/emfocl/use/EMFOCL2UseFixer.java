package efinder.emfocl.use;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.ir.IRBuilder;
import efinder.core.visitor.AbstractIRVisitor;
import efinder.ir.CollectionTypeRef;
import efinder.ir.EFPrimitiveType;
import efinder.ir.MetaTypeRef;
import efinder.ir.OrderedSetTypeRef;
import efinder.ir.Specification;
import efinder.ir.TypeRef;
import efinder.ir.TypedElement;
import efinder.ir.ocl.BooleanLiteralExp;
import efinder.ir.ocl.IntegerLiteralExp;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OclFactory;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.OperatorCallExp;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.PropertyCallExp;
import efinder.ir.ocl.SetLiteralExp;

public class EMFOCL2UseFixer extends AbstractIRVisitor<Void, Void> implements IDialectAdaptation {

	@Override
	public void transform(@NonNull EFinderModel ir) {
		Specification spec = ir.getSpecification();
		// Poor's man approach
		spec.eAllContents().forEachRemaining(o -> {
			if (o instanceof OperationCallExp) {
				inOperationCallExp((OperationCallExp) o);
			} else if (o instanceof PropertyCallExp) {
				inPropertyCallExp((PropertyCallExp) o);
			} else if (o instanceof OperatorCallExp) {
				inOperatorCallExp((OperatorCallExp) o);
			//} else if (o instanceof TypedElement) {
			//	inTypedElement((TypedElement) o);
			} else if (o instanceof CollectionTypeRef) {
				inCollectionTypeRef((CollectionTypeRef) o);
			}
		});
	}	

	// Change all OrderedSet by Set and let the FeatureChecker handle the invalid operations
	private void inCollectionTypeRef(CollectionTypeRef ref) {
		if (ref instanceof OrderedSetTypeRef) {
			TypeRef newType = IRBuilder.newSetTypeRef(ref.getContainedType());
			EcoreUtil.replace(ref, newType);
		}		
	}

	private void inPropertyCallExp(PropertyCallExp o) {
		if (o.getName().equals("oclContainer")) {
			OperationCallExp newOp = IRBuilder.newOperationCallExp(o.getName(), o.getSource());
			EcoreUtil.replace(o, newOp);
		}
	}

	private void inTypedElement(TypedElement self) {
		if (self.getType() instanceof CollectionTypeRef) {
			CollectionTypeRef ref = (CollectionTypeRef) self.getType();
			if (ref instanceof OrderedSetTypeRef) {
				TypeRef newType = IRBuilder.newSetTypeRef(ref.getContainedType());
				EcoreUtil.replace(ref, newType);
			}
		}
	}

	private void inOperatorCallExp(OperatorCallExp o) {
		// Pattern: self.name.size() > 0
		if (o.getOperator() == OperatorKind.GREATER || o.getOperator() == OperatorKind.GREATER_OR_EQUAL) {
			if (o.getSource() instanceof OperationCallExp) {
				OclExpression arg = o.getArgument();
				if (arg instanceof IntegerLiteralExp && ((IntegerLiteralExp) arg).getValue() == 0) {					
					OperationCallExp op = (OperationCallExp) o.getSource();
					TypeRef type = op.getSource().getType();
					if (op.getName().equals("size") && type instanceof MetaTypeRef && ((MetaTypeRef) type).getType() instanceof EFPrimitiveType) {
						EFPrimitiveType pt = (EFPrimitiveType) ((MetaTypeRef) type).getType();
						if (pt.getName().equals("String")) {
							if (o.getOperator() == OperatorKind.GREATER) {
								// Replace by self.name <> ''
								OperatorCallExp replacement = IRBuilder.newOperatorCallExp(OperatorKind.DISTINCT, op.getSource(), IRBuilder.newStringExp(""));
								EcoreUtil.replace(o, replacement);
							} else {
								// Replace by true because this is always true (the size of a string is always 0 or > 0)
								BooleanLiteralExp replacement = IRBuilder.newBooleanExp(true);
								EcoreUtil.replace(o, replacement);							
							}
							return;
						}
					}
				}
			}
		}
		
		// Pattern: collection = single-value
		if (o.getArgument() != null) {
			if ((o.getSource().getType() instanceof CollectionTypeRef && !(o.getArgument().getType() instanceof CollectionTypeRef)) ||
				(!(o.getSource().getType() instanceof CollectionTypeRef)) && o.getArgument().getType() instanceof CollectionTypeRef) {
				// These refers to ill-typed programs which are considered valid by EMF/OCL
				// The result would always be false
				BooleanLiteralExp replacement = IRBuilder.newBooleanExp(false);
				EcoreUtil.replace(o, replacement);	
			}
		}
		
	}
	
	// Report the changes?
	public void inOperationCallExp(@NonNull OperationCallExp self) {
		if ( self.getName().equals("oclAsSet") ) {			
			SetLiteralExp set = OclFactory.eINSTANCE.createSetLiteralExp();
			EcoreUtil.replace(self, set);			
			set.getParts().add(self.getSource());
			return;
		} else if (self.getName().equals("oclIsInvalid")) {
			// TODO: Report => This is probably what you mean:
			self.setName("oclIsUndefined");
		}
	}
	
}
