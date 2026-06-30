package efinder.core.transform;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.base.Preconditions;

import efinder.core.EFinderModel;
import efinder.core.IDialectAdaptation;
import efinder.core.ir.IRBuilder;
import efinder.ir.CollectionTypeRef;
import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFPrimitiveType;
import efinder.ir.EFTupleType;
import efinder.ir.EFType;
import efinder.ir.MetaTypeRef;
import efinder.ir.TupleTypeElement;
import efinder.ir.TypeRef;
import efinder.ir.ocl.Iterator;
import efinder.ir.ocl.IteratorExp;
import efinder.ir.ocl.ModelElement;
import efinder.ir.ocl.OclExpression;
import efinder.ir.ocl.OperationCallExp;
import efinder.ir.ocl.OperatorCallExp;
import efinder.ir.ocl.OperatorKind;
import efinder.ir.ocl.PropertyCallExp;
import efinder.ir.ocl.TupleLiteralExp;
import efinder.ir.util.EfinderSwitch;

public class TupleToClassTransform implements IDialectAdaptation {

	@Override
	public void transform(@NonNull EFinderModel model) {
		
		// IRBuilder.newPackage(ePackage)
		Map<EFTupleType, EFClass> classes = new HashMap<>();
		for (EFTupleType tt : model.getSpecification().getTupleTypes()) {
			EClass c = EcoreFactory.eINSTANCE.createEClass();
			c.setName(tt.getId());
			for (TupleTypeElement tte : tt.getElements()) {
				c.getEStructuralFeatures().add(toFeature(tte));
			}
			
			EFClass efc = IRBuilder.newClass(c);
			classes.put(tt, efc);
			model.getSpecification().getTemporary().getClasses().add(efc);
			model.getSpecification().getTemporary().getDangling().add(c);
		}
				
		model.getSpecification().eAllContents().forEachRemaining(o -> {
			if (o instanceof TupleLiteralExp) {
				TupleLiteralExp exp = (TupleLiteralExp) o;
				transformTupleExp(exp, classes);
			} else if (o instanceof MetaTypeRef && ((MetaTypeRef) o).getType() instanceof EFTupleType) {
				EFTupleType tt = (EFTupleType) ((MetaTypeRef) o).getType();
				EFClass c = classes.get(tt);
				Preconditions.checkState(c != null);
				((MetaTypeRef) o).setType(c);
			}
		});		
	}

	private void transformTupleExp(@NonNull TupleLiteralExp exp, @NonNull Map<EFTupleType, EFClass> classes) {
		EFClass c = classes.get(exp.getTupleType());

		ModelElement newElement = IRBuilder.newModelElement(IRBuilder.newMetaTypeRef(c));
		OperationCallExp allInstances = IRBuilder.newOperationCallExp("allInstances", newElement);
				
		// T.allInstances()->any(o | o.prop1 = v1 and o.prop2 = v2...)
		// * For USE we cannot use "any" safely, so when possible we use "select"
		// * We check if the tuple is in a position in which the select may work
		//String iteratorName = self.eContainer() instanceof LoopExp ? "select" : "any";
		// => Not done in the new version...
		String iteratorName = "any";
		
		Iterator it = IRBuilder.newIterator("o_", IRBuilder.newMetaTypeRef(c));

		Optional<OperatorCallExp> body = exp.getParts().stream().map(p -> {
			EStructuralFeature f = c.getKlass().getEStructuralFeature(p.getName());
			if ( f == null )
				throw new IllegalStateException();

			OclExpression vexp = IRBuilder.newVariableExp(it);
			PropertyCallExp nav = IRBuilder.newProperyCallExp(p.getName(), f, vexp);
			// nav.getAnnotations().put("TUPLE_ACCESS", "true");
			
			OperatorCallExp eq = IRBuilder.newOperatorCallExp(OperatorKind.EQUAL, nav, p.getValue());

			return eq;
		}).collect(Collectors.reducing((l, r) -> {
			return IRBuilder.newOperatorCallExp(OperatorKind.AND, l, r);
		}));

		IteratorExp any = IRBuilder.newIteratorExp(iteratorName, allInstances, Collections.singletonList(it), body.orElseThrow(() -> new IllegalStateException()));
	
		EcoreUtil.replace(exp, any);
	}

	private EStructuralFeature toFeature(@NonNull TupleTypeElement tte) {
		TypeRef t = tte.getType();
		return new EfinderSwitch<EStructuralFeature>() {
			@Override
			public EStructuralFeature caseCollectionTypeRef(CollectionTypeRef object) {
				EStructuralFeature f = this.doSwitch(object.getContainedType());
				f.setUpperBound(-1);
				return f;
			}
			
			@Override
			public EStructuralFeature caseMetaTypeRef(MetaTypeRef object) {
				return this.doSwitch(object.getType());
			}
			
			@Override
			public EStructuralFeature caseEFClass(EFClass object) {
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setName(tte.getName());
				ref.setEType(object.getKlass());
				return ref;
			}
			
			@Override
			public EStructuralFeature caseEFEnum(EFEnum object) {
				EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
				att.setName(tte.getName());
				att.setEType(object.getEnum_());
				return att;
			}
			
			@Override
			public EStructuralFeature caseEFPrimitiveType(EFPrimitiveType object) {
				EAttribute att = EcoreFactory.eINSTANCE.createEAttribute();
				att.setName(tte.getName());
				EDataType edt = IRBuilder.DataTypes.get(object.getName());
				Preconditions.checkState(edt != null);
				att.setEType(edt);
				return att;
			}
		}.doSwitch(t);
	}
	
}
