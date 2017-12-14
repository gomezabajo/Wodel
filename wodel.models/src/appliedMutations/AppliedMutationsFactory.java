/**
 */
package appliedMutations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see appliedMutations.AppliedMutationsPackage
 * @generated
 */
public interface AppliedMutationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AppliedMutationsFactory eINSTANCE = appliedMutations.impl.AppliedMutationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mutations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutations</em>'.
	 * @generated
	 */
	Mutations createMutations();

	/**
	 * Returns a new object of class '<em>App Mutation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>App Mutation</em>'.
	 * @generated
	 */
	AppMutation createAppMutation();

	/**
	 * Returns a new object of class '<em>Object Created</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Created</em>'.
	 * @generated
	 */
	ObjectCreated createObjectCreated();

	/**
	 * Returns a new object of class '<em>Object Removed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Removed</em>'.
	 * @generated
	 */
	ObjectRemoved createObjectRemoved();

	/**
	 * Returns a new object of class '<em>Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Changed</em>'.
	 * @generated
	 */
	ReferenceChanged createReferenceChanged();

	/**
	 * Returns a new object of class '<em>Source Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source Reference Changed</em>'.
	 * @generated
	 */
	SourceReferenceChanged createSourceReferenceChanged();

	/**
	 * Returns a new object of class '<em>Target Reference Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Reference Changed</em>'.
	 * @generated
	 */
	TargetReferenceChanged createTargetReferenceChanged();

	/**
	 * Returns a new object of class '<em>Reference Created</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Created</em>'.
	 * @generated
	 */
	ReferenceCreated createReferenceCreated();

	/**
	 * Returns a new object of class '<em>Reference Removed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Removed</em>'.
	 * @generated
	 */
	ReferenceRemoved createReferenceRemoved();

	/**
	 * Returns a new object of class '<em>Information Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Information Changed</em>'.
	 * @generated
	 */
	InformationChanged createInformationChanged();

	/**
	 * Returns a new object of class '<em>Attribute Changed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Changed</em>'.
	 * @generated
	 */
	AttributeChanged createAttributeChanged();

	/**
	 * Returns a new object of class '<em>Reference Swap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Swap</em>'.
	 * @generated
	 */
	ReferenceSwap createReferenceSwap();

	/**
	 * Returns a new object of class '<em>Reference Att</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Att</em>'.
	 * @generated
	 */
	ReferenceAtt createReferenceAtt();

	/**
	 * Returns a new object of class '<em>Attribute Swap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Swap</em>'.
	 * @generated
	 */
	AttributeSwap createAttributeSwap();

	/**
	 * Returns a new object of class '<em>Composite Mutation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Mutation</em>'.
	 * @generated
	 */
	CompositeMutation createCompositeMutation();

	/**
	 * Returns a new object of class '<em>Object Cloned</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Cloned</em>'.
	 * @generated
	 */
	ObjectCloned createObjectCloned();

	/**
	 * Returns a new object of class '<em>Object Retyped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Retyped</em>'.
	 * @generated
	 */
	ObjectRetyped createObjectRetyped();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AppliedMutationsPackage getAppliedMutationsPackage();

} //AppliedMutationsFactory
