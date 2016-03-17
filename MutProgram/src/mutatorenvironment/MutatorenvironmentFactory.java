/**
 */
package mutatorenvironment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.MutatorenvironmentPackage
 * @generated
 */
public interface MutatorenvironmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatorenvironmentFactory eINSTANCE = mutatorenvironment.impl.MutatorenvironmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mutator Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutator Environment</em>'.
	 * @generated
	 */
	MutatorEnvironment createMutatorEnvironment();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>Composite Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Mutator</em>'.
	 * @generated
	 */
	CompositeMutator createCompositeMutator();

	/**
	 * Returns a new object of class '<em>Load</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load</em>'.
	 * @generated
	 */
	Load createLoad();

	/**
	 * Returns a new object of class '<em>Create Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Object Mutator</em>'.
	 * @generated
	 */
	CreateObjectMutator createCreateObjectMutator();

	/**
	 * Returns a new object of class '<em>Random Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Type Selection</em>'.
	 * @generated
	 */
	RandomTypeSelection createRandomTypeSelection();

	/**
	 * Returns a new object of class '<em>Specific Object Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Object Selection</em>'.
	 * @generated
	 */
	SpecificObjectSelection createSpecificObjectSelection();

	/**
	 * Returns a new object of class '<em>Attribute Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Init</em>'.
	 * @generated
	 */
	AttributeInit createAttributeInit();

	/**
	 * Returns a new object of class '<em>Specific Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Boolean Type</em>'.
	 * @generated
	 */
	SpecificBooleanType createSpecificBooleanType();

	/**
	 * Returns a new object of class '<em>Random Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Boolean Type</em>'.
	 * @generated
	 */
	RandomBooleanType createRandomBooleanType();

	/**
	 * Returns a new object of class '<em>Specific String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific String Type</em>'.
	 * @generated
	 */
	SpecificStringType createSpecificStringType();

	/**
	 * Returns a new object of class '<em>Random String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random String Type</em>'.
	 * @generated
	 */
	RandomStringType createRandomStringType();

	/**
	 * Returns a new object of class '<em>Specific Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Integer Type</em>'.
	 * @generated
	 */
	SpecificIntegerType createSpecificIntegerType();

	/**
	 * Returns a new object of class '<em>Random Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Integer Type</em>'.
	 * @generated
	 */
	RandomIntegerType createRandomIntegerType();

	/**
	 * Returns a new object of class '<em>Specific Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Double Type</em>'.
	 * @generated
	 */
	SpecificDoubleType createSpecificDoubleType();

	/**
	 * Returns a new object of class '<em>Random Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Double Type</em>'.
	 * @generated
	 */
	RandomDoubleType createRandomDoubleType();

	/**
	 * Returns a new object of class '<em>Modify Source Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modify Source Reference Mutator</em>'.
	 * @generated
	 */
	ModifySourceReferenceMutator createModifySourceReferenceMutator();

	/**
	 * Returns a new object of class '<em>Specific Reference Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Reference Selection</em>'.
	 * @generated
	 */
	SpecificReferenceSelection createSpecificReferenceSelection();

	/**
	 * Returns a new object of class '<em>Modify Target Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modify Target Reference Mutator</em>'.
	 * @generated
	 */
	ModifyTargetReferenceMutator createModifyTargetReferenceMutator();

	/**
	 * Returns a new object of class '<em>Create Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Reference Mutator</em>'.
	 * @generated
	 */
	CreateReferenceMutator createCreateReferenceMutator();

	/**
	 * Returns a new object of class '<em>Remove Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Object Mutator</em>'.
	 * @generated
	 */
	RemoveObjectMutator createRemoveObjectMutator();

	/**
	 * Returns a new object of class '<em>Modify Information Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modify Information Mutator</em>'.
	 * @generated
	 */
	ModifyInformationMutator createModifyInformationMutator();

	/**
	 * Returns a new object of class '<em>Upper String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upper String Type</em>'.
	 * @generated
	 */
	UpperStringType createUpperStringType();

	/**
	 * Returns a new object of class '<em>Lower String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lower String Type</em>'.
	 * @generated
	 */
	LowerStringType createLowerStringType();

	/**
	 * Returns a new object of class '<em>List String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List String Type</em>'.
	 * @generated
	 */
	ListStringType createListStringType();

	/**
	 * Returns a new object of class '<em>Cat Start String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cat Start String Type</em>'.
	 * @generated
	 */
	CatStartStringType createCatStartStringType();

	/**
	 * Returns a new object of class '<em>Cat End String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cat End String Type</em>'.
	 * @generated
	 */
	CatEndStringType createCatEndStringType();

	/**
	 * Returns a new object of class '<em>Attribute Unset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Unset</em>'.
	 * @generated
	 */
	AttributeUnset createAttributeUnset();

	/**
	 * Returns a new object of class '<em>Attribute Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Set</em>'.
	 * @generated
	 */
	AttributeSet createAttributeSet();

	/**
	 * Returns a new object of class '<em>Attribute Swap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Swap</em>'.
	 * @generated
	 */
	AttributeSwap createAttributeSwap();

	/**
	 * Returns a new object of class '<em>Replace String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace String Type</em>'.
	 * @generated
	 */
	ReplaceStringType createReplaceStringType();

	/**
	 * Returns a new object of class '<em>Attribute Copy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Copy</em>'.
	 * @generated
	 */
	AttributeCopy createAttributeCopy();

	/**
	 * Returns a new object of class '<em>Remove Random Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Random Reference Mutator</em>'.
	 * @generated
	 */
	RemoveRandomReferenceMutator createRemoveRandomReferenceMutator();

	/**
	 * Returns a new object of class '<em>Remove Specific Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Specific Reference Mutator</em>'.
	 * @generated
	 */
	RemoveSpecificReferenceMutator createRemoveSpecificReferenceMutator();

	/**
	 * Returns a new object of class '<em>Complete Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Selection</em>'.
	 * @generated
	 */
	CompleteSelection createCompleteSelection();

	/**
	 * Returns a new object of class '<em>Complete Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Type Selection</em>'.
	 * @generated
	 */
	CompleteTypeSelection createCompleteTypeSelection();

	/**
	 * Returns a new object of class '<em>Remove Complete Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Complete Reference Mutator</em>'.
	 * @generated
	 */
	RemoveCompleteReferenceMutator createRemoveCompleteReferenceMutator();

	/**
	 * Returns a new object of class '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source</em>'.
	 * @generated
	 */
	Source createSource();

	/**
	 * Returns a new object of class '<em>Other Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other Selection</em>'.
	 * @generated
	 */
	OtherSelection createOtherSelection();

	/**
	 * Returns a new object of class '<em>Other Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other Type Selection</em>'.
	 * @generated
	 */
	OtherTypeSelection createOtherTypeSelection();

	/**
	 * Returns a new object of class '<em>Select Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select Object Mutator</em>'.
	 * @generated
	 */
	SelectObjectMutator createSelectObjectMutator();

	/**
	 * Returns a new object of class '<em>Binary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binary Operator</em>'.
	 * @generated
	 */
	BinaryOperator createBinaryOperator();

	/**
	 * Returns a new object of class '<em>Attribute Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Evaluation</em>'.
	 * @generated
	 */
	AttributeEvaluation createAttributeEvaluation();

	/**
	 * Returns a new object of class '<em>Attribute Reverse</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Reverse</em>'.
	 * @generated
	 */
	AttributeReverse createAttributeReverse();

	/**
	 * Returns a new object of class '<em>Reference Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Set</em>'.
	 * @generated
	 */
	ReferenceSet createReferenceSet();

	/**
	 * Returns a new object of class '<em>Reference Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Init</em>'.
	 * @generated
	 */
	ReferenceInit createReferenceInit();

	/**
	 * Returns a new object of class '<em>Reference Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Evaluation</em>'.
	 * @generated
	 */
	ReferenceEvaluation createReferenceEvaluation();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Reference Swap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Swap</em>'.
	 * @generated
	 */
	ReferenceSwap createReferenceSwap();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MutatorenvironmentPackage getMutatorenvironmentPackage();

} //MutatorenvironmentFactory
