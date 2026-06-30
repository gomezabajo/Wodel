/**
 */
package efinder.ir;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see efinder.ir.EfinderPackage
 * @generated
 */
public interface EfinderFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EfinderFactory eINSTANCE = efinder.ir.impl.EfinderFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specification</em>'.
	 * @generated
	 */
	Specification createSpecification();

	/**
	 * Returns a new object of class '<em>Temporary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Temporary</em>'.
	 * @generated
	 */
	Temporary createTemporary();

	/**
	 * Returns a new object of class '<em>Builtin Operation Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Operation Ref</em>'.
	 * @generated
	 */
	BuiltinOperationRef createBuiltinOperationRef();

	/**
	 * Returns a new object of class '<em>Defined Operation Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defined Operation Ref</em>'.
	 * @generated
	 */
	DefinedOperationRef createDefinedOperationRef();

	/**
	 * Returns a new object of class '<em>Tuple Field Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Field Ref</em>'.
	 * @generated
	 */
	TupleFieldRef createTupleFieldRef();

	/**
	 * Returns a new object of class '<em>Derived Property Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Property Ref</em>'.
	 * @generated
	 */
	DerivedPropertyRef createDerivedPropertyRef();

	/**
	 * Returns a new object of class '<em>Builtin Property Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Property Ref</em>'.
	 * @generated
	 */
	BuiltinPropertyRef createBuiltinPropertyRef();

	/**
	 * Returns a new object of class '<em>Metamodel Feature Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel Feature Ref</em>'.
	 * @generated
	 */
	MetamodelFeatureRef createMetamodelFeatureRef();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>EF Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Metamodel</em>'.
	 * @generated
	 */
	EFMetamodel createEFMetamodel();

	/**
	 * Returns a new object of class '<em>EF Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Package</em>'.
	 * @generated
	 */
	EFPackage createEFPackage();

	/**
	 * Returns a new object of class '<em>EF Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Class</em>'.
	 * @generated
	 */
	EFClass createEFClass();

	/**
	 * Returns a new object of class '<em>EF Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Primitive Type</em>'.
	 * @generated
	 */
	EFPrimitiveType createEFPrimitiveType();

	/**
	 * Returns a new object of class '<em>EF Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Enum</em>'.
	 * @generated
	 */
	EFEnum createEFEnum();

	/**
	 * Returns a new object of class '<em>EF Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Enum Literal</em>'.
	 * @generated
	 */
	EFEnumLiteral createEFEnumLiteral();

	/**
	 * Returns a new object of class '<em>EF Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EF Tuple Type</em>'.
	 * @generated
	 */
	EFTupleType createEFTupleType();

	/**
	 * Returns a new object of class '<em>Tuple Type Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type Element</em>'.
	 * @generated
	 */
	TupleTypeElement createTupleTypeElement();

	/**
	 * Returns a new object of class '<em>Meta Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Type Ref</em>'.
	 * @generated
	 */
	MetaTypeRef createMetaTypeRef();

	/**
	 * Returns a new object of class '<em>Invalid Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Type Ref</em>'.
	 * @generated
	 */
	InvalidTypeRef createInvalidTypeRef();

	/**
	 * Returns a new object of class '<em>Set Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type Ref</em>'.
	 * @generated
	 */
	SetTypeRef createSetTypeRef();

	/**
	 * Returns a new object of class '<em>Sequence Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type Ref</em>'.
	 * @generated
	 */
	SequenceTypeRef createSequenceTypeRef();

	/**
	 * Returns a new object of class '<em>Bag Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type Ref</em>'.
	 * @generated
	 */
	BagTypeRef createBagTypeRef();

	/**
	 * Returns a new object of class '<em>Ordered Set Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type Ref</em>'.
	 * @generated
	 */
	OrderedSetTypeRef createOrderedSetTypeRef();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EfinderPackage getEfinderPackage();

} //EfinderFactory
