/**
 */
package mutatortests;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see mutatortests.MutatortestsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface MutatortestsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mutatortests";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mutatortests/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mutatortests";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatortestsPackage eINSTANCE = mutatortests.impl.MutatortestsPackageImpl.init();

	/**
	 * The meta object id for the '{@link mutatortests.impl.MutatorTestsImpl <em>Mutator Tests</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatortests.impl.MutatorTestsImpl
	 * @see mutatortests.impl.MutatortestsPackageImpl#getMutatorTests()
	 * @generated
	 */
	int MUTATOR_TESTS = 0;

	/**
	 * The feature id for the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_TESTS__CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Tests</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_TESTS__TESTS = 1;

	/**
	 * The number of structural features of the '<em>Mutator Tests</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_TESTS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mutator Tests</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_TESTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatortests.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatortests.impl.ConfigurationImpl
	 * @see mutatortests.impl.MutatortestsPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Retry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__RETRY = 0;

	/**
	 * The feature id for the '<em><b>Showall</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__SHOWALL = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatortests.impl.TestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatortests.impl.TestImpl
	 * @see mutatortests.impl.MutatortestsPackageImpl#getTest()
	 * @generated
	 */
	int TEST = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Question</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST__QUESTION = 1;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatortests.Parameter <em>Parameter</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatortests.Parameter
	 * @see mutatortests.impl.MutatortestsPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 3;


	/**
	 * Returns the meta object for class '{@link mutatortests.MutatorTests <em>Mutator Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Tests</em>'.
	 * @see mutatortests.MutatorTests
	 * @generated
	 */
	EClass getMutatorTests();

	/**
	 * Returns the meta object for the containment reference '{@link mutatortests.MutatorTests#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config</em>'.
	 * @see mutatortests.MutatorTests#getConfig()
	 * @see #getMutatorTests()
	 * @generated
	 */
	EReference getMutatorTests_Config();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatortests.MutatorTests#getTests <em>Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tests</em>'.
	 * @see mutatortests.MutatorTests#getTests()
	 * @see #getMutatorTests()
	 * @generated
	 */
	EReference getMutatorTests_Tests();

	/**
	 * Returns the meta object for class '{@link mutatortests.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see mutatortests.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link mutatortests.Configuration#getRetry <em>Retry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retry</em>'.
	 * @see mutatortests.Configuration#getRetry()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Retry();

	/**
	 * Returns the meta object for the attribute '{@link mutatortests.Configuration#getShowall <em>Showall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Showall</em>'.
	 * @see mutatortests.Configuration#getShowall()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Showall();

	/**
	 * Returns the meta object for class '{@link mutatortests.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see mutatortests.Test
	 * @generated
	 */
	EClass getTest();

	/**
	 * Returns the meta object for the attribute '{@link mutatortests.Test#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see mutatortests.Test#getSource()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Source();

	/**
	 * Returns the meta object for the attribute '{@link mutatortests.Test#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Question</em>'.
	 * @see mutatortests.Test#getQuestion()
	 * @see #getTest()
	 * @generated
	 */
	EAttribute getTest_Question();

	/**
	 * Returns the meta object for enum '{@link mutatortests.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter</em>'.
	 * @see mutatortests.Parameter
	 * @generated
	 */
	EEnum getParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MutatortestsFactory getMutatortestsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link mutatortests.impl.MutatorTestsImpl <em>Mutator Tests</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatortests.impl.MutatorTestsImpl
		 * @see mutatortests.impl.MutatortestsPackageImpl#getMutatorTests()
		 * @generated
		 */
		EClass MUTATOR_TESTS = eINSTANCE.getMutatorTests();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_TESTS__CONFIG = eINSTANCE.getMutatorTests_Config();

		/**
		 * The meta object literal for the '<em><b>Tests</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_TESTS__TESTS = eINSTANCE.getMutatorTests_Tests();

		/**
		 * The meta object literal for the '{@link mutatortests.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatortests.impl.ConfigurationImpl
		 * @see mutatortests.impl.MutatortestsPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Retry</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__RETRY = eINSTANCE.getConfiguration_Retry();

		/**
		 * The meta object literal for the '<em><b>Showall</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__SHOWALL = eINSTANCE.getConfiguration_Showall();

		/**
		 * The meta object literal for the '{@link mutatortests.impl.TestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatortests.impl.TestImpl
		 * @see mutatortests.impl.MutatortestsPackageImpl#getTest()
		 * @generated
		 */
		EClass TEST = eINSTANCE.getTest();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__SOURCE = eINSTANCE.getTest_Source();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST__QUESTION = eINSTANCE.getTest_Question();

		/**
		 * The meta object literal for the '{@link mutatortests.Parameter <em>Parameter</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatortests.Parameter
		 * @see mutatortests.impl.MutatortestsPackageImpl#getParameter()
		 * @generated
		 */
		EEnum PARAMETER = eINSTANCE.getParameter();

	}

} //MutatortestsPackage
