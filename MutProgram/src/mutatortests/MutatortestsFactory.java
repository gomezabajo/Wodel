/**
 */
package mutatortests;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see mutatortests.MutatortestsPackage
 * @generated
 */
public interface MutatortestsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatortestsFactory eINSTANCE = mutatortests.impl.MutatortestsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mutator Tests</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutator Tests</em>'.
	 * @generated
	 */
	MutatorTests createMutatorTests();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test</em>'.
	 * @generated
	 */
	Test createTest();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MutatortestsPackage getMutatortestsPackage();

} //MutatortestsFactory
