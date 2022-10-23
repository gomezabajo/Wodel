/**
 */
package edutest.impl;

import edutest.AlternativeResponse;
import edutest.Configuration;
import edutest.EdutestFactory;
import edutest.EdutestPackage;
import edutest.MatchPairs;
import edutest.MissingWords;
import edutest.Mode;
import edutest.MultiChoiceDiagram;
import edutest.MultiChoiceEmConfig;
import edutest.MultiChoiceEmendation;
import edutest.MultiChoiceText;
import edutest.MultiChoiceTextConfig;
import edutest.MutatorTests;
import edutest.Navigation;
import edutest.Order;
import edutest.Program;
import edutest.ProgramConfiguration;
import edutest.Test;
import edutest.TestConfiguration;

import mutatorenvironment.MutatorenvironmentPackage;

import mutatorenvironment.impl.MutatorenvironmentPackageImpl;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdutestPackageImpl extends EPackageImpl implements EdutestPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatorTestsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiChoiceEmConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiChoiceTextConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternativeResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiChoiceDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiChoiceEmendationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchPairsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missingWordsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiChoiceTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum orderEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum navigationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum modeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edutest.EdutestPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EdutestPackageImpl() {
		super(eNS_URI, EdutestFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link EdutestPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EdutestPackage init() {
		if (isInited) return (EdutestPackage)EPackage.Registry.INSTANCE.getEPackage(EdutestPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEdutestPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EdutestPackageImpl theEdutestPackage = registeredEdutestPackage instanceof EdutestPackageImpl ? (EdutestPackageImpl)registeredEdutestPackage : new EdutestPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MutatorenvironmentPackage.eNS_URI);
		MutatorenvironmentPackageImpl theMutatorenvironmentPackage = (MutatorenvironmentPackageImpl)(registeredPackage instanceof MutatorenvironmentPackageImpl ? registeredPackage : MutatorenvironmentPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MiniOCLPackage.eNS_URI);
		MiniOCLPackageImpl theMiniOCLPackage = (MiniOCLPackageImpl)(registeredPackage instanceof MiniOCLPackageImpl ? registeredPackage : MiniOCLPackage.eINSTANCE);

		// Create package meta-data objects
		theEdutestPackage.createPackageContents();
		theMutatorenvironmentPackage.createPackageContents();
		theMiniOCLPackage.createPackageContents();

		// Initialize created meta-data
		theEdutestPackage.initializePackageContents();
		theMutatorenvironmentPackage.initializePackageContents();
		theMiniOCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEdutestPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EdutestPackage.eNS_URI, theEdutestPackage);
		return theEdutestPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProgram_Config() {
		return (EReference)programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProgram_Exercises() {
		return (EReference)programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMutatorTests() {
		return mutatorTestsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutatorTests_Blocks() {
		return (EReference)mutatorTestsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutatorTests_Tests() {
		return (EReference)mutatorTestsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProgramConfiguration() {
		return programConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProgramConfiguration_Navigation() {
		return (EAttribute)programConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestConfiguration() {
		return testConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestConfiguration_Retry() {
		return (EAttribute)testConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiChoiceEmConfig() {
		return multiChoiceEmConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiChoiceEmConfig_Weighted() {
		return (EAttribute)multiChoiceEmConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiChoiceEmConfig_Penalty() {
		return (EAttribute)multiChoiceEmConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiChoiceEmConfig_Order() {
		return (EAttribute)multiChoiceEmConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiChoiceEmConfig_Mode() {
		return (EAttribute)multiChoiceEmConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiChoiceTextConfig() {
		return multiChoiceTextConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiChoiceTextConfig_Identifier() {
		return (EAttribute)multiChoiceTextConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAlternativeResponse() {
		return alternativeResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAlternativeResponse_Config() {
		return (EReference)alternativeResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiChoiceDiagram() {
		return multiChoiceDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultiChoiceDiagram_Config() {
		return (EReference)multiChoiceDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiChoiceEmendation() {
		return multiChoiceEmendationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultiChoiceEmendation_Config() {
		return (EReference)multiChoiceEmendationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMatchPairs() {
		return matchPairsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMatchPairs_Config() {
		return (EReference)matchPairsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMissingWords() {
		return missingWordsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMissingWords_Config() {
		return (EReference)missingWordsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiChoiceText() {
		return multiChoiceTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMultiChoiceText_Config() {
		return (EReference)multiChoiceTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTest() {
		return testEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTest_Source() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTest_Question() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTest_Expression() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTest_Identifier() {
		return (EAttribute)testEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOrder() {
		return orderEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNavigation() {
		return navigationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getMode() {
		return modeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EdutestFactory getEdutestFactory() {
		return (EdutestFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		programEClass = createEClass(PROGRAM);
		createEReference(programEClass, PROGRAM__CONFIG);
		createEReference(programEClass, PROGRAM__EXERCISES);

		mutatorTestsEClass = createEClass(MUTATOR_TESTS);
		createEReference(mutatorTestsEClass, MUTATOR_TESTS__BLOCKS);
		createEReference(mutatorTestsEClass, MUTATOR_TESTS__TESTS);

		configurationEClass = createEClass(CONFIGURATION);

		programConfigurationEClass = createEClass(PROGRAM_CONFIGURATION);
		createEAttribute(programConfigurationEClass, PROGRAM_CONFIGURATION__NAVIGATION);

		testConfigurationEClass = createEClass(TEST_CONFIGURATION);
		createEAttribute(testConfigurationEClass, TEST_CONFIGURATION__RETRY);

		multiChoiceEmConfigEClass = createEClass(MULTI_CHOICE_EM_CONFIG);
		createEAttribute(multiChoiceEmConfigEClass, MULTI_CHOICE_EM_CONFIG__WEIGHTED);
		createEAttribute(multiChoiceEmConfigEClass, MULTI_CHOICE_EM_CONFIG__PENALTY);
		createEAttribute(multiChoiceEmConfigEClass, MULTI_CHOICE_EM_CONFIG__ORDER);
		createEAttribute(multiChoiceEmConfigEClass, MULTI_CHOICE_EM_CONFIG__MODE);

		multiChoiceTextConfigEClass = createEClass(MULTI_CHOICE_TEXT_CONFIG);
		createEAttribute(multiChoiceTextConfigEClass, MULTI_CHOICE_TEXT_CONFIG__IDENTIFIER);

		alternativeResponseEClass = createEClass(ALTERNATIVE_RESPONSE);
		createEReference(alternativeResponseEClass, ALTERNATIVE_RESPONSE__CONFIG);

		multiChoiceDiagramEClass = createEClass(MULTI_CHOICE_DIAGRAM);
		createEReference(multiChoiceDiagramEClass, MULTI_CHOICE_DIAGRAM__CONFIG);

		multiChoiceEmendationEClass = createEClass(MULTI_CHOICE_EMENDATION);
		createEReference(multiChoiceEmendationEClass, MULTI_CHOICE_EMENDATION__CONFIG);

		matchPairsEClass = createEClass(MATCH_PAIRS);
		createEReference(matchPairsEClass, MATCH_PAIRS__CONFIG);

		missingWordsEClass = createEClass(MISSING_WORDS);
		createEReference(missingWordsEClass, MISSING_WORDS__CONFIG);

		multiChoiceTextEClass = createEClass(MULTI_CHOICE_TEXT);
		createEReference(multiChoiceTextEClass, MULTI_CHOICE_TEXT__CONFIG);

		testEClass = createEClass(TEST);
		createEAttribute(testEClass, TEST__SOURCE);
		createEAttribute(testEClass, TEST__QUESTION);
		createEAttribute(testEClass, TEST__EXPRESSION);
		createEAttribute(testEClass, TEST__IDENTIFIER);

		// Create enums
		orderEEnum = createEEnum(ORDER);
		navigationEEnum = createEEnum(NAVIGATION);
		modeEEnum = createEEnum(MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MutatorenvironmentPackage theMutatorenvironmentPackage = (MutatorenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(MutatorenvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		programConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		testConfigurationEClass.getESuperTypes().add(this.getConfiguration());
		multiChoiceEmConfigEClass.getESuperTypes().add(this.getTestConfiguration());
		multiChoiceTextConfigEClass.getESuperTypes().add(this.getTestConfiguration());
		alternativeResponseEClass.getESuperTypes().add(this.getMutatorTests());
		multiChoiceDiagramEClass.getESuperTypes().add(this.getMutatorTests());
		multiChoiceEmendationEClass.getESuperTypes().add(this.getMutatorTests());
		matchPairsEClass.getESuperTypes().add(this.getMutatorTests());
		missingWordsEClass.getESuperTypes().add(this.getMutatorTests());
		multiChoiceTextEClass.getESuperTypes().add(this.getMutatorTests());

		// Initialize classes, features, and operations; add parameters
		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgram_Config(), this.getProgramConfiguration(), null, "config", null, 0, 1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Exercises(), this.getMutatorTests(), null, "exercises", null, 0, -1, Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatorTestsEClass, MutatorTests.class, "MutatorTests", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutatorTests_Blocks(), theMutatorenvironmentPackage.getBlock(), null, "blocks", null, 0, -1, MutatorTests.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorTests_Tests(), this.getTest(), null, "tests", null, 0, -1, MutatorTests.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(programConfigurationEClass, ProgramConfiguration.class, "ProgramConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgramConfiguration_Navigation(), this.getNavigation(), "navigation", null, 1, 1, ProgramConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testConfigurationEClass, TestConfiguration.class, "TestConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestConfiguration_Retry(), ecorePackage.getEBoolean(), "retry", "false", 1, 1, TestConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiChoiceEmConfigEClass, MultiChoiceEmConfig.class, "MultiChoiceEmConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiChoiceEmConfig_Weighted(), ecorePackage.getEBoolean(), "weighted", "false", 1, 1, MultiChoiceEmConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiChoiceEmConfig_Penalty(), ecorePackage.getEDouble(), "penalty", null, 1, 1, MultiChoiceEmConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiChoiceEmConfig_Order(), this.getOrder(), "order", null, 1, 1, MultiChoiceEmConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiChoiceEmConfig_Mode(), this.getMode(), "mode", null, 1, 1, MultiChoiceEmConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiChoiceTextConfigEClass, MultiChoiceTextConfig.class, "MultiChoiceTextConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiChoiceTextConfig_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1, MultiChoiceTextConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternativeResponseEClass, AlternativeResponse.class, "AlternativeResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternativeResponse_Config(), this.getTestConfiguration(), null, "config", null, 1, 1, AlternativeResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiChoiceDiagramEClass, MultiChoiceDiagram.class, "MultiChoiceDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiChoiceDiagram_Config(), this.getTestConfiguration(), null, "config", null, 1, 1, MultiChoiceDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiChoiceEmendationEClass, MultiChoiceEmendation.class, "MultiChoiceEmendation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiChoiceEmendation_Config(), this.getMultiChoiceEmConfig(), null, "config", null, 1, 1, MultiChoiceEmendation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchPairsEClass, MatchPairs.class, "MatchPairs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchPairs_Config(), this.getTestConfiguration(), null, "config", null, 1, 1, MatchPairs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(missingWordsEClass, MissingWords.class, "MissingWords", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMissingWords_Config(), this.getTestConfiguration(), null, "config", null, 1, 1, MissingWords.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiChoiceTextEClass, MultiChoiceText.class, "MultiChoiceText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiChoiceText_Config(), this.getMultiChoiceTextConfig(), null, "config", null, 1, 1, MultiChoiceText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTest_Source(), ecorePackage.getEString(), "source", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTest_Question(), ecorePackage.getEString(), "question", null, 1, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTest_Expression(), ecorePackage.getEBoolean(), "expression", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTest_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(orderEEnum, Order.class, "Order");
		addEEnumLiteral(orderEEnum, Order.FIXED);
		addEEnumLiteral(orderEEnum, Order.RANDOM);
		addEEnumLiteral(orderEEnum, Order.ASCENDING);
		addEEnumLiteral(orderEEnum, Order.DESCENDING);

		initEEnum(navigationEEnum, Navigation.class, "Navigation");
		addEEnumLiteral(navigationEEnum, Navigation.FREE);
		addEEnumLiteral(navigationEEnum, Navigation.LOCKED);

		initEEnum(modeEEnum, Mode.class, "Mode");
		addEEnumLiteral(modeEEnum, Mode.RADIOBUTTON);
		addEEnumLiteral(modeEEnum, Mode.CHECKBOX);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			   "mutatorenvironment", "MutatorEnvironment.ecore#/"
		   });
	}

} //EdutestPackageImpl
