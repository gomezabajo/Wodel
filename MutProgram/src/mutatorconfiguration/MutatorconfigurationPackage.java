/**
 */
package mutatorconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see mutatorconfiguration.MutatorconfigurationFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface MutatorconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mutatorconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mutatorconfiguration/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mutatorconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatorconfigurationPackage eINSTANCE = mutatorconfiguration.impl.MutatorconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link mutatorconfiguration.impl.MutatorConfigurationImpl <em>Mutator Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorconfiguration.impl.MutatorConfigurationImpl
	 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getMutatorConfiguration()
	 * @generated
	 */
	int MUTATOR_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_CONFIGURATION__CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_CONFIGURATION__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Question</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_CONFIGURATION__QUESTION = 2;

	/**
	 * The number of structural features of the '<em>Mutator Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mutator Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorconfiguration.impl.ConfigurationImpl
	 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Retry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__RETRY = 0;

	/**
	 * The feature id for the '<em><b>Showall</b></em>' containment reference.
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
	 * The meta object id for the '{@link mutatorconfiguration.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorconfiguration.impl.ParameterImpl
	 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link mutatorconfiguration.MutatorConfiguration <em>Mutator Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Configuration</em>'.
	 * @see mutatorconfiguration.MutatorConfiguration
	 * @generated
	 */
	EClass getMutatorConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorconfiguration.MutatorConfiguration#getConfig <em>Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Config</em>'.
	 * @see mutatorconfiguration.MutatorConfiguration#getConfig()
	 * @see #getMutatorConfiguration()
	 * @generated
	 */
	EReference getMutatorConfiguration_Config();

	/**
	 * Returns the meta object for the attribute list '{@link mutatorconfiguration.MutatorConfiguration#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Source</em>'.
	 * @see mutatorconfiguration.MutatorConfiguration#getSource()
	 * @see #getMutatorConfiguration()
	 * @generated
	 */
	EAttribute getMutatorConfiguration_Source();

	/**
	 * Returns the meta object for the attribute list '{@link mutatorconfiguration.MutatorConfiguration#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Question</em>'.
	 * @see mutatorconfiguration.MutatorConfiguration#getQuestion()
	 * @see #getMutatorConfiguration()
	 * @generated
	 */
	EAttribute getMutatorConfiguration_Question();

	/**
	 * Returns the meta object for class '{@link mutatorconfiguration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see mutatorconfiguration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorconfiguration.Configuration#getRetry <em>Retry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Retry</em>'.
	 * @see mutatorconfiguration.Configuration#getRetry()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Retry();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorconfiguration.Configuration#getShowall <em>Showall</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Showall</em>'.
	 * @see mutatorconfiguration.Configuration#getShowall()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Showall();

	/**
	 * Returns the meta object for class '{@link mutatorconfiguration.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see mutatorconfiguration.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link mutatorconfiguration.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorconfiguration.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MutatorconfigurationFactory getMutatorconfigurationFactory();

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
		 * The meta object literal for the '{@link mutatorconfiguration.impl.MutatorConfigurationImpl <em>Mutator Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorconfiguration.impl.MutatorConfigurationImpl
		 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getMutatorConfiguration()
		 * @generated
		 */
		EClass MUTATOR_CONFIGURATION = eINSTANCE.getMutatorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Config</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_CONFIGURATION__CONFIG = eINSTANCE.getMutatorConfiguration_Config();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR_CONFIGURATION__SOURCE = eINSTANCE.getMutatorConfiguration_Source();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR_CONFIGURATION__QUESTION = eINSTANCE.getMutatorConfiguration_Question();

		/**
		 * The meta object literal for the '{@link mutatorconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorconfiguration.impl.ConfigurationImpl
		 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Retry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__RETRY = eINSTANCE.getConfiguration_Retry();

		/**
		 * The meta object literal for the '<em><b>Showall</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__SHOWALL = eINSTANCE.getConfiguration_Showall();

		/**
		 * The meta object literal for the '{@link mutatorconfiguration.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorconfiguration.impl.ParameterImpl
		 * @see mutatorconfiguration.impl.MutatorconfigurationPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

	}

} //MutatorconfigurationPackage
