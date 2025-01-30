/**
 */
package modeltext;

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
 * @see modeltext.ModeltextFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ModeltextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modeltext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modeltext/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modeltext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModeltextPackage eINSTANCE = modeltext.impl.ModeltextPackageImpl.init();

	/**
	 * The meta object id for the '{@link modeltext.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.ItemImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__NAME = 0;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.IdentifyElementsImpl <em>Identify Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.IdentifyElementsImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getIdentifyElements()
	 * @generated
	 */
	int IDENTIFY_ELEMENTS = 1;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS__METAMODEL = 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS__INSTANCES = 1;

	/**
	 * The number of structural features of the '<em>Identify Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Identify Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.MutatorInstanceImpl <em>Mutator Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.MutatorInstanceImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getMutatorInstance()
	 * @generated
	 */
	int MUTATOR_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__ELEMENTS = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mutator Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mutator Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.ValuedFeatureImpl <em>Valued Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.ValuedFeatureImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getValuedFeature()
	 * @generated
	 */
	int VALUED_FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Negation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__NEGATION = 1;

	/**
	 * The feature id for the '<em><b>Feat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__FEAT = 2;

	/**
	 * The feature id for the '<em><b>Ref Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__REF_FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__VALUE = 4;

	/**
	 * The number of structural features of the '<em>Valued Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Valued Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.ElementImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__REF = 1;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__WORDS = 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__FEATURE = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.WordImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 5;

	/**
	 * The number of structural features of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Word</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.ConstantImpl <em>Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.ConstantImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getConstant()
	 * @generated
	 */
	int CONSTANT = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT__VALUE = WORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_FEATURE_COUNT = WORD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_OPERATION_COUNT = WORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.VariableImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 7;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__REF = WORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__ID = WORD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = WORD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = WORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.MacroImpl <em>Macro</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.MacroImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getMacro()
	 * @generated
	 */
	int MACRO = 8;

	/**
	 * The feature id for the '<em><b>Item</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO__ITEM = WORD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO_FEATURE_COUNT = WORD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Macro</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACRO_OPERATION_COUNT = WORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeltext.MacroItem <em>Macro Item</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.MacroItem
	 * @see modeltext.impl.ModeltextPackageImpl#getMacroItem()
	 * @generated
	 */
	int MACRO_ITEM = 9;


	/**
	 * Returns the meta object for class '{@link modeltext.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see modeltext.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Item#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see modeltext.Item#getName()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_Name();

	/**
	 * Returns the meta object for class '{@link modeltext.IdentifyElements <em>Identify Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identify Elements</em>'.
	 * @see modeltext.IdentifyElements
	 * @generated
	 */
	EClass getIdentifyElements();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.IdentifyElements#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel</em>'.
	 * @see modeltext.IdentifyElements#getMetamodel()
	 * @see #getIdentifyElements()
	 * @generated
	 */
	EAttribute getIdentifyElements_Metamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link modeltext.IdentifyElements#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see modeltext.IdentifyElements#getInstances()
	 * @see #getIdentifyElements()
	 * @generated
	 */
	EReference getIdentifyElements_Instances();

	/**
	 * Returns the meta object for class '{@link modeltext.MutatorInstance <em>Mutator Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Instance</em>'.
	 * @see modeltext.MutatorInstance
	 * @generated
	 */
	EClass getMutatorInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link modeltext.MutatorInstance#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see modeltext.MutatorInstance#getElements()
	 * @see #getMutatorInstance()
	 * @generated
	 */
	EReference getMutatorInstance_Elements();

	/**
	 * Returns the meta object for class '{@link modeltext.ValuedFeature <em>Valued Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valued Feature</em>'.
	 * @see modeltext.ValuedFeature
	 * @generated
	 */
	EClass getValuedFeature();

	/**
	 * Returns the meta object for the reference '{@link modeltext.ValuedFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see modeltext.ValuedFeature#getName()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EReference getValuedFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.ValuedFeature#isNegation <em>Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negation</em>'.
	 * @see modeltext.ValuedFeature#isNegation()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EAttribute getValuedFeature_Negation();

	/**
	 * Returns the meta object for the reference '{@link modeltext.ValuedFeature#getFeat <em>Feat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feat</em>'.
	 * @see modeltext.ValuedFeature#getFeat()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EReference getValuedFeature_Feat();

	/**
	 * Returns the meta object for the reference '{@link modeltext.ValuedFeature#getRefFeature <em>Ref Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Feature</em>'.
	 * @see modeltext.ValuedFeature#getRefFeature()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EReference getValuedFeature_RefFeature();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.ValuedFeature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see modeltext.ValuedFeature#getValue()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EAttribute getValuedFeature_Value();

	/**
	 * Returns the meta object for class '{@link modeltext.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see modeltext.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Element#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see modeltext.Element#getType()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Type();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Element#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see modeltext.Element#getRef()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Ref();

	/**
	 * Returns the meta object for the containment reference list '{@link modeltext.Element#getWords <em>Words</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Words</em>'.
	 * @see modeltext.Element#getWords()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Words();

	/**
	 * Returns the meta object for the containment reference list '{@link modeltext.Element#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature</em>'.
	 * @see modeltext.Element#getFeature()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Feature();

	/**
	 * Returns the meta object for class '{@link modeltext.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Word</em>'.
	 * @see modeltext.Word
	 * @generated
	 */
	EClass getWord();

	/**
	 * Returns the meta object for class '{@link modeltext.Constant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant</em>'.
	 * @see modeltext.Constant
	 * @generated
	 */
	EClass getConstant();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.Constant#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see modeltext.Constant#getValue()
	 * @see #getConstant()
	 * @generated
	 */
	EAttribute getConstant_Value();

	/**
	 * Returns the meta object for class '{@link modeltext.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see modeltext.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Variable#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see modeltext.Variable#getRef()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Ref();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Variable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Id</em>'.
	 * @see modeltext.Variable#getId()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_Id();

	/**
	 * Returns the meta object for class '{@link modeltext.Macro <em>Macro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Macro</em>'.
	 * @see modeltext.Macro
	 * @generated
	 */
	EClass getMacro();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.Macro#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Item</em>'.
	 * @see modeltext.Macro#getItem()
	 * @see #getMacro()
	 * @generated
	 */
	EAttribute getMacro_Item();

	/**
	 * Returns the meta object for enum '{@link modeltext.MacroItem <em>Macro Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Macro Item</em>'.
	 * @see modeltext.MacroItem
	 * @generated
	 */
	EEnum getMacroItem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModeltextFactory getModeltextFactory();

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
		 * The meta object literal for the '{@link modeltext.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.ItemImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITEM__NAME = eINSTANCE.getItem_Name();

		/**
		 * The meta object literal for the '{@link modeltext.impl.IdentifyElementsImpl <em>Identify Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.IdentifyElementsImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getIdentifyElements()
		 * @generated
		 */
		EClass IDENTIFY_ELEMENTS = eINSTANCE.getIdentifyElements();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFY_ELEMENTS__METAMODEL = eINSTANCE.getIdentifyElements_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFY_ELEMENTS__INSTANCES = eINSTANCE.getIdentifyElements_Instances();

		/**
		 * The meta object literal for the '{@link modeltext.impl.MutatorInstanceImpl <em>Mutator Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.MutatorInstanceImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getMutatorInstance()
		 * @generated
		 */
		EClass MUTATOR_INSTANCE = eINSTANCE.getMutatorInstance();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_INSTANCE__ELEMENTS = eINSTANCE.getMutatorInstance_Elements();

		/**
		 * The meta object literal for the '{@link modeltext.impl.ValuedFeatureImpl <em>Valued Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.ValuedFeatureImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getValuedFeature()
		 * @generated
		 */
		EClass VALUED_FEATURE = eINSTANCE.getValuedFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUED_FEATURE__NAME = eINSTANCE.getValuedFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Negation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUED_FEATURE__NEGATION = eINSTANCE.getValuedFeature_Negation();

		/**
		 * The meta object literal for the '<em><b>Feat</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUED_FEATURE__FEAT = eINSTANCE.getValuedFeature_Feat();

		/**
		 * The meta object literal for the '<em><b>Ref Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUED_FEATURE__REF_FEATURE = eINSTANCE.getValuedFeature_RefFeature();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUED_FEATURE__VALUE = eINSTANCE.getValuedFeature_Value();

		/**
		 * The meta object literal for the '{@link modeltext.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.ElementImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__TYPE = eINSTANCE.getElement_Type();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__REF = eINSTANCE.getElement_Ref();

		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__WORDS = eINSTANCE.getElement_Words();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__FEATURE = eINSTANCE.getElement_Feature();

		/**
		 * The meta object literal for the '{@link modeltext.impl.WordImpl <em>Word</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.WordImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getWord()
		 * @generated
		 */
		EClass WORD = eINSTANCE.getWord();

		/**
		 * The meta object literal for the '{@link modeltext.impl.ConstantImpl <em>Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.ConstantImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getConstant()
		 * @generated
		 */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTANT__VALUE = eINSTANCE.getConstant_Value();

		/**
		 * The meta object literal for the '{@link modeltext.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.VariableImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__REF = eINSTANCE.getVariable_Ref();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__ID = eINSTANCE.getVariable_Id();

		/**
		 * The meta object literal for the '{@link modeltext.impl.MacroImpl <em>Macro</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.MacroImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getMacro()
		 * @generated
		 */
		EClass MACRO = eINSTANCE.getMacro();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACRO__ITEM = eINSTANCE.getMacro_Item();

		/**
		 * The meta object literal for the '{@link modeltext.MacroItem <em>Macro Item</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.MacroItem
		 * @see modeltext.impl.ModeltextPackageImpl#getMacroItem()
		 * @generated
		 */
		EEnum MACRO_ITEM = eINSTANCE.getMacroItem();

	}

} //ModeltextPackage
