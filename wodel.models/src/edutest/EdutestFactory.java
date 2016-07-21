/**
 */
package edutest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edutest.EdutestPackage
 * @generated
 */
public interface EdutestFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdutestFactory eINSTANCE = edutest.impl.EdutestFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program</em>'.
	 * @generated
	 */
	Program createProgram();

	/**
	 * Returns a new object of class '<em>Program Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Program Configuration</em>'.
	 * @generated
	 */
	ProgramConfiguration createProgramConfiguration();

	/**
	 * Returns a new object of class '<em>Test Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Configuration</em>'.
	 * @generated
	 */
	TestConfiguration createTestConfiguration();

	/**
	 * Returns a new object of class '<em>Multi Choice Em Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Choice Em Config</em>'.
	 * @generated
	 */
	MultiChoiceEmConfig createMultiChoiceEmConfig();

	/**
	 * Returns a new object of class '<em>Alternative Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative Response</em>'.
	 * @generated
	 */
	AlternativeResponse createAlternativeResponse();

	/**
	 * Returns a new object of class '<em>Multi Choice Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Choice Diagram</em>'.
	 * @generated
	 */
	MultiChoiceDiagram createMultiChoiceDiagram();

	/**
	 * Returns a new object of class '<em>Multi Choice Emendation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Choice Emendation</em>'.
	 * @generated
	 */
	MultiChoiceEmendation createMultiChoiceEmendation();

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
	EdutestPackage getEdutestPackage();

} //EdutestFactory
