/**
 */
package efinder.ir.util;

import efinder.ir.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see efinder.ir.EfinderPackage
 * @generated
 */
public class EfinderAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EfinderPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfinderAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EfinderPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EfinderSwitch<Adapter> modelSwitch =
		new EfinderSwitch<Adapter>() {
			@Override
			public Adapter caseSpecification(Specification object) {
				return createSpecificationAdapter();
			}
			@Override
			public Adapter caseTemporary(Temporary object) {
				return createTemporaryAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseAbstractFunction(AbstractFunction object) {
				return createAbstractFunctionAdapter();
			}
			@Override
			public Adapter caseDerivedProperty(DerivedProperty object) {
				return createDerivedPropertyAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseFeatureRef(FeatureRef object) {
				return createFeatureRefAdapter();
			}
			@Override
			public Adapter caseOperationFeatureRef(OperationFeatureRef object) {
				return createOperationFeatureRefAdapter();
			}
			@Override
			public Adapter caseBuiltinOperationRef(BuiltinOperationRef object) {
				return createBuiltinOperationRefAdapter();
			}
			@Override
			public Adapter caseDefinedOperationRef(DefinedOperationRef object) {
				return createDefinedOperationRefAdapter();
			}
			@Override
			public Adapter casePropertyFeatureRef(PropertyFeatureRef object) {
				return createPropertyFeatureRefAdapter();
			}
			@Override
			public Adapter caseTupleFieldRef(TupleFieldRef object) {
				return createTupleFieldRefAdapter();
			}
			@Override
			public Adapter caseDerivedPropertyRef(DerivedPropertyRef object) {
				return createDerivedPropertyRefAdapter();
			}
			@Override
			public Adapter caseBuiltinPropertyRef(BuiltinPropertyRef object) {
				return createBuiltinPropertyRefAdapter();
			}
			@Override
			public Adapter caseMetamodelFeatureRef(MetamodelFeatureRef object) {
				return createMetamodelFeatureRefAdapter();
			}
			@Override
			public Adapter caseVariableDeclaration(VariableDeclaration object) {
				return createVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseEFMetamodel(EFMetamodel object) {
				return createEFMetamodelAdapter();
			}
			@Override
			public Adapter caseEFPackage(EFPackage object) {
				return createEFPackageAdapter();
			}
			@Override
			public Adapter caseEFType(EFType object) {
				return createEFTypeAdapter();
			}
			@Override
			public Adapter caseEFClass(EFClass object) {
				return createEFClassAdapter();
			}
			@Override
			public Adapter caseEFPrimitiveType(EFPrimitiveType object) {
				return createEFPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseEFEnum(EFEnum object) {
				return createEFEnumAdapter();
			}
			@Override
			public Adapter caseEFEnumLiteral(EFEnumLiteral object) {
				return createEFEnumLiteralAdapter();
			}
			@Override
			public Adapter caseEFTupleType(EFTupleType object) {
				return createEFTupleTypeAdapter();
			}
			@Override
			public Adapter caseTupleTypeElement(TupleTypeElement object) {
				return createTupleTypeElementAdapter();
			}
			@Override
			public Adapter caseTypeRef(TypeRef object) {
				return createTypeRefAdapter();
			}
			@Override
			public Adapter caseMetaTypeRef(MetaTypeRef object) {
				return createMetaTypeRefAdapter();
			}
			@Override
			public Adapter caseInvalidTypeRef(InvalidTypeRef object) {
				return createInvalidTypeRefAdapter();
			}
			@Override
			public Adapter caseCollectionTypeRef(CollectionTypeRef object) {
				return createCollectionTypeRefAdapter();
			}
			@Override
			public Adapter caseSetTypeRef(SetTypeRef object) {
				return createSetTypeRefAdapter();
			}
			@Override
			public Adapter caseSequenceTypeRef(SequenceTypeRef object) {
				return createSequenceTypeRefAdapter();
			}
			@Override
			public Adapter caseBagTypeRef(BagTypeRef object) {
				return createBagTypeRefAdapter();
			}
			@Override
			public Adapter caseOrderedSetTypeRef(OrderedSetTypeRef object) {
				return createOrderedSetTypeRefAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.Specification
	 * @generated
	 */
	public Adapter createSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.Temporary <em>Temporary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.Temporary
	 * @generated
	 */
	public Adapter createTemporaryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.AbstractFunction <em>Abstract Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.AbstractFunction
	 * @generated
	 */
	public Adapter createAbstractFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.DerivedProperty <em>Derived Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.DerivedProperty
	 * @generated
	 */
	public Adapter createDerivedPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.FeatureRef <em>Feature Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.FeatureRef
	 * @generated
	 */
	public Adapter createFeatureRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.OperationFeatureRef <em>Operation Feature Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.OperationFeatureRef
	 * @generated
	 */
	public Adapter createOperationFeatureRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.BuiltinOperationRef <em>Builtin Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.BuiltinOperationRef
	 * @generated
	 */
	public Adapter createBuiltinOperationRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.DefinedOperationRef <em>Defined Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.DefinedOperationRef
	 * @generated
	 */
	public Adapter createDefinedOperationRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.PropertyFeatureRef <em>Property Feature Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.PropertyFeatureRef
	 * @generated
	 */
	public Adapter createPropertyFeatureRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.TupleFieldRef <em>Tuple Field Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.TupleFieldRef
	 * @generated
	 */
	public Adapter createTupleFieldRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.DerivedPropertyRef <em>Derived Property Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.DerivedPropertyRef
	 * @generated
	 */
	public Adapter createDerivedPropertyRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.BuiltinPropertyRef <em>Builtin Property Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.BuiltinPropertyRef
	 * @generated
	 */
	public Adapter createBuiltinPropertyRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.MetamodelFeatureRef <em>Metamodel Feature Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.MetamodelFeatureRef
	 * @generated
	 */
	public Adapter createMetamodelFeatureRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.VariableDeclaration
	 * @generated
	 */
	public Adapter createVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFMetamodel <em>EF Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFMetamodel
	 * @generated
	 */
	public Adapter createEFMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFPackage <em>EF Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFPackage
	 * @generated
	 */
	public Adapter createEFPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFType <em>EF Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFType
	 * @generated
	 */
	public Adapter createEFTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFClass <em>EF Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFClass
	 * @generated
	 */
	public Adapter createEFClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFPrimitiveType <em>EF Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFPrimitiveType
	 * @generated
	 */
	public Adapter createEFPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFEnum <em>EF Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFEnum
	 * @generated
	 */
	public Adapter createEFEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFEnumLiteral <em>EF Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFEnumLiteral
	 * @generated
	 */
	public Adapter createEFEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.EFTupleType <em>EF Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.EFTupleType
	 * @generated
	 */
	public Adapter createEFTupleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.TupleTypeElement <em>Tuple Type Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.TupleTypeElement
	 * @generated
	 */
	public Adapter createTupleTypeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.TypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.TypeRef
	 * @generated
	 */
	public Adapter createTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.MetaTypeRef <em>Meta Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.MetaTypeRef
	 * @generated
	 */
	public Adapter createMetaTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.InvalidTypeRef <em>Invalid Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.InvalidTypeRef
	 * @generated
	 */
	public Adapter createInvalidTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.CollectionTypeRef <em>Collection Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.CollectionTypeRef
	 * @generated
	 */
	public Adapter createCollectionTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.SetTypeRef <em>Set Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.SetTypeRef
	 * @generated
	 */
	public Adapter createSetTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.SequenceTypeRef <em>Sequence Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.SequenceTypeRef
	 * @generated
	 */
	public Adapter createSequenceTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.BagTypeRef <em>Bag Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.BagTypeRef
	 * @generated
	 */
	public Adapter createBagTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link efinder.ir.OrderedSetTypeRef <em>Ordered Set Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see efinder.ir.OrderedSetTypeRef
	 * @generated
	 */
	public Adapter createOrderedSetTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EfinderAdapterFactory
