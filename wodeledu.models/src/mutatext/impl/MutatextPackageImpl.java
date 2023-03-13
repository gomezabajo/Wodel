/**
 */
package mutatext.impl;

import mutatext.Configuration;
import mutatext.Constant;
import mutatext.MutatextFactory;
import mutatext.MutatextPackage;
import mutatext.Option;
import mutatext.Text;
import mutatext.Variable;
import mutatext.VariableType;
import mutatext.Word;

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
public class MutatextPackageImpl extends EPackageImpl implements MutatextPackage {
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
	private EClass optionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableTypeEEnum = null;

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
	 * @see mutatext.MutatextPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MutatextPackageImpl() {
		super(eNS_URI, MutatextFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MutatextPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MutatextPackage init() {
		if (isInited) return (MutatextPackage)EPackage.Registry.INSTANCE.getEPackage(MutatextPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMutatextPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MutatextPackageImpl theMutatextPackage = registeredMutatextPackage instanceof MutatextPackageImpl ? (MutatextPackageImpl)registeredMutatextPackage : new MutatextPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMutatextPackage.createPackageContents();

		// Initialize created meta-data
		theMutatextPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMutatextPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MutatextPackage.eNS_URI, theMutatextPackage);
		return theMutatextPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Metamodel() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_Options() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOption() {
		return optionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_Type() {
		return (EReference)optionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_Object() {
		return (EReference)optionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_Valid() {
		return (EReference)optionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOption_Invalid() {
		return (EReference)optionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getText() {
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getText_Words() {
		return (EReference)textEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWord() {
		return wordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstant() {
		return constantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstant_Value() {
		return (EAttribute)constantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariable_Type() {
		return (EAttribute)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableType() {
		return variableTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatextFactory getMutatextFactory() {
		return (MutatextFactory)getEFactoryInstance();
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
		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__METAMODEL);
		createEReference(configurationEClass, CONFIGURATION__OPTIONS);

		optionEClass = createEClass(OPTION);
		createEReference(optionEClass, OPTION__TYPE);
		createEReference(optionEClass, OPTION__OBJECT);
		createEReference(optionEClass, OPTION__VALID);
		createEReference(optionEClass, OPTION__INVALID);

		textEClass = createEClass(TEXT);
		createEReference(textEClass, TEXT__WORDS);

		wordEClass = createEClass(WORD);

		constantEClass = createEClass(CONSTANT);
		createEAttribute(constantEClass, CONSTANT__VALUE);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__TYPE);

		// Create enums
		variableTypeEEnum = createEEnum(VARIABLE_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		constantEClass.getESuperTypes().add(this.getWord());
		variableEClass.getESuperTypes().add(this.getWord());

		// Initialize classes, features, and operations; add parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_Metamodel(), ecorePackage.getEString(), "metamodel", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_Options(), this.getOption(), null, "options", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionEClass, Option.class, "Option", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOption_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOption_Object(), ecorePackage.getEObject(), null, "object", null, 0, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOption_Valid(), this.getText(), null, "valid", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOption_Invalid(), this.getText(), null, "invalid", null, 1, 1, Option.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getText_Words(), this.getWord(), null, "words", null, 0, -1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wordEClass, Word.class, "Word", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstant_Value(), ecorePackage.getEString(), "value", null, 1, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Type(), this.getVariableType(), "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableTypeEEnum, VariableType.class, "VariableType");
		addEEnumLiteral(variableTypeEEnum, VariableType.OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.ATT_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.OLD_VALUE);
		addEEnumLiteral(variableTypeEEnum, VariableType.NEW_VALUE);
		addEEnumLiteral(variableTypeEEnum, VariableType.REF_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.OLD_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.SRC_REF_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.OLD_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_REF_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_REF_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_ATT_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.FIRST_VALUE);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_ATT_NAME);
		addEEnumLiteral(variableTypeEEnum, VariableType.SECOND_VALUE);
		addEEnumLiteral(variableTypeEEnum, VariableType.VALUE);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_OLD_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_OLD_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_FIRST_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_FIRST_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_FIRST_TO_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_SECOND_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_SECOND_FROM_OBJECT);
		addEEnumLiteral(variableTypeEEnum, VariableType.DESCRIBED_SECOND_TO_OBJECT);

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
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //MutatextPackageImpl
