/**
 */
package efinder.ir.util;

import efinder.ir.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see efinder.ir.EfinderPackage
 * @generated
 */
public class EfinderSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EfinderPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EfinderSwitch() {
		if (modelPackage == null) {
			modelPackage = EfinderPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EfinderPackage.SPECIFICATION: {
				Specification specification = (Specification)theEObject;
				T result = caseSpecification(specification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.TEMPORARY: {
				Temporary temporary = (Temporary)theEObject;
				T result = caseTemporary(temporary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.ABSTRACT_FUNCTION: {
				AbstractFunction abstractFunction = (AbstractFunction)theEObject;
				T result = caseAbstractFunction(abstractFunction);
				if (result == null) result = caseTypedElement(abstractFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.DERIVED_PROPERTY: {
				DerivedProperty derivedProperty = (DerivedProperty)theEObject;
				T result = caseDerivedProperty(derivedProperty);
				if (result == null) result = caseAbstractFunction(derivedProperty);
				if (result == null) result = caseTypedElement(derivedProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseAbstractFunction(operation);
				if (result == null) result = caseTypedElement(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.FEATURE_REF: {
				FeatureRef featureRef = (FeatureRef)theEObject;
				T result = caseFeatureRef(featureRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.OPERATION_FEATURE_REF: {
				OperationFeatureRef operationFeatureRef = (OperationFeatureRef)theEObject;
				T result = caseOperationFeatureRef(operationFeatureRef);
				if (result == null) result = caseFeatureRef(operationFeatureRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.BUILTIN_OPERATION_REF: {
				BuiltinOperationRef builtinOperationRef = (BuiltinOperationRef)theEObject;
				T result = caseBuiltinOperationRef(builtinOperationRef);
				if (result == null) result = caseOperationFeatureRef(builtinOperationRef);
				if (result == null) result = caseFeatureRef(builtinOperationRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.DEFINED_OPERATION_REF: {
				DefinedOperationRef definedOperationRef = (DefinedOperationRef)theEObject;
				T result = caseDefinedOperationRef(definedOperationRef);
				if (result == null) result = caseOperationFeatureRef(definedOperationRef);
				if (result == null) result = caseFeatureRef(definedOperationRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.PROPERTY_FEATURE_REF: {
				PropertyFeatureRef propertyFeatureRef = (PropertyFeatureRef)theEObject;
				T result = casePropertyFeatureRef(propertyFeatureRef);
				if (result == null) result = caseFeatureRef(propertyFeatureRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.TUPLE_FIELD_REF: {
				TupleFieldRef tupleFieldRef = (TupleFieldRef)theEObject;
				T result = caseTupleFieldRef(tupleFieldRef);
				if (result == null) result = casePropertyFeatureRef(tupleFieldRef);
				if (result == null) result = caseFeatureRef(tupleFieldRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.DERIVED_PROPERTY_REF: {
				DerivedPropertyRef derivedPropertyRef = (DerivedPropertyRef)theEObject;
				T result = caseDerivedPropertyRef(derivedPropertyRef);
				if (result == null) result = casePropertyFeatureRef(derivedPropertyRef);
				if (result == null) result = caseFeatureRef(derivedPropertyRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.BUILTIN_PROPERTY_REF: {
				BuiltinPropertyRef builtinPropertyRef = (BuiltinPropertyRef)theEObject;
				T result = caseBuiltinPropertyRef(builtinPropertyRef);
				if (result == null) result = casePropertyFeatureRef(builtinPropertyRef);
				if (result == null) result = caseFeatureRef(builtinPropertyRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.METAMODEL_FEATURE_REF: {
				MetamodelFeatureRef metamodelFeatureRef = (MetamodelFeatureRef)theEObject;
				T result = caseMetamodelFeatureRef(metamodelFeatureRef);
				if (result == null) result = casePropertyFeatureRef(metamodelFeatureRef);
				if (result == null) result = caseFeatureRef(metamodelFeatureRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseVariableDeclaration(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_METAMODEL: {
				EFMetamodel efMetamodel = (EFMetamodel)theEObject;
				T result = caseEFMetamodel(efMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_PACKAGE: {
				EFPackage efPackage = (EFPackage)theEObject;
				T result = caseEFPackage(efPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_TYPE: {
				EFType efType = (EFType)theEObject;
				T result = caseEFType(efType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_CLASS: {
				EFClass efClass = (EFClass)theEObject;
				T result = caseEFClass(efClass);
				if (result == null) result = caseEFType(efClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_PRIMITIVE_TYPE: {
				EFPrimitiveType efPrimitiveType = (EFPrimitiveType)theEObject;
				T result = caseEFPrimitiveType(efPrimitiveType);
				if (result == null) result = caseEFType(efPrimitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_ENUM: {
				EFEnum efEnum = (EFEnum)theEObject;
				T result = caseEFEnum(efEnum);
				if (result == null) result = caseEFType(efEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_ENUM_LITERAL: {
				EFEnumLiteral efEnumLiteral = (EFEnumLiteral)theEObject;
				T result = caseEFEnumLiteral(efEnumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.EF_TUPLE_TYPE: {
				EFTupleType efTupleType = (EFTupleType)theEObject;
				T result = caseEFTupleType(efTupleType);
				if (result == null) result = caseEFType(efTupleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.TUPLE_TYPE_ELEMENT: {
				TupleTypeElement tupleTypeElement = (TupleTypeElement)theEObject;
				T result = caseTupleTypeElement(tupleTypeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.TYPE_REF: {
				TypeRef typeRef = (TypeRef)theEObject;
				T result = caseTypeRef(typeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.META_TYPE_REF: {
				MetaTypeRef metaTypeRef = (MetaTypeRef)theEObject;
				T result = caseMetaTypeRef(metaTypeRef);
				if (result == null) result = caseTypeRef(metaTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.INVALID_TYPE_REF: {
				InvalidTypeRef invalidTypeRef = (InvalidTypeRef)theEObject;
				T result = caseInvalidTypeRef(invalidTypeRef);
				if (result == null) result = caseTypeRef(invalidTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.COLLECTION_TYPE_REF: {
				CollectionTypeRef collectionTypeRef = (CollectionTypeRef)theEObject;
				T result = caseCollectionTypeRef(collectionTypeRef);
				if (result == null) result = caseTypeRef(collectionTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.SET_TYPE_REF: {
				SetTypeRef setTypeRef = (SetTypeRef)theEObject;
				T result = caseSetTypeRef(setTypeRef);
				if (result == null) result = caseCollectionTypeRef(setTypeRef);
				if (result == null) result = caseTypeRef(setTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.SEQUENCE_TYPE_REF: {
				SequenceTypeRef sequenceTypeRef = (SequenceTypeRef)theEObject;
				T result = caseSequenceTypeRef(sequenceTypeRef);
				if (result == null) result = caseCollectionTypeRef(sequenceTypeRef);
				if (result == null) result = caseTypeRef(sequenceTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.BAG_TYPE_REF: {
				BagTypeRef bagTypeRef = (BagTypeRef)theEObject;
				T result = caseBagTypeRef(bagTypeRef);
				if (result == null) result = caseCollectionTypeRef(bagTypeRef);
				if (result == null) result = caseTypeRef(bagTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EfinderPackage.ORDERED_SET_TYPE_REF: {
				OrderedSetTypeRef orderedSetTypeRef = (OrderedSetTypeRef)theEObject;
				T result = caseOrderedSetTypeRef(orderedSetTypeRef);
				if (result == null) result = caseCollectionTypeRef(orderedSetTypeRef);
				if (result == null) result = caseTypeRef(orderedSetTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecification(Specification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Temporary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Temporary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemporary(Temporary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractFunction(AbstractFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derived Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derived Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivedProperty(DerivedProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureRef(FeatureRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Feature Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Feature Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationFeatureRef(OperationFeatureRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Operation Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Operation Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinOperationRef(BuiltinOperationRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Operation Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Operation Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinedOperationRef(DefinedOperationRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Feature Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Feature Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyFeatureRef(PropertyFeatureRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Field Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Field Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleFieldRef(TupleFieldRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derived Property Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derived Property Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivedPropertyRef(DerivedPropertyRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Property Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Property Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinPropertyRef(BuiltinPropertyRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel Feature Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel Feature Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelFeatureRef(MetamodelFeatureRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFMetamodel(EFMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFPackage(EFPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFType(EFType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFClass(EFClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFPrimitiveType(EFPrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Enum</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFEnum(EFEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFEnumLiteral(EFEnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EF Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EF Tuple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEFTupleType(EFTupleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tuple Type Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tuple Type Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTupleTypeElement(TupleTypeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRef(TypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meta Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meta Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetaTypeRef(MetaTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidTypeRef(InvalidTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeRef(CollectionTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTypeRef(SetTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceTypeRef(SequenceTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagTypeRef(BagTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetTypeRef(OrderedSetTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EfinderSwitch
