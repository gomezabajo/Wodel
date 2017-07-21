/**
 */
package modeltext;

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
	 * The meta object id for the '{@link modeltext.impl.IdentifyElementsImpl <em>Identify Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.IdentifyElementsImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getIdentifyElements()
	 * @generated
	 */
	int IDENTIFY_ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS__METAMODEL = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFY_ELEMENTS__ELEMENTS = 1;

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
	 * The meta object id for the '{@link modeltext.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.ElementImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

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
	 * The feature id for the '<em><b>Att</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ATT = 2;

	/**
	 * The feature id for the '<em><b>Words</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__WORDS = 3;

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
	 * The meta object id for the '{@link modeltext.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.AttributeImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The feature id for the '<em><b>Negation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NEGATION = 0;

	/**
	 * The feature id for the '<em><b>Att</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ATT = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeltext.impl.WordImpl <em>Word</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeltext.impl.WordImpl
	 * @see modeltext.impl.ModeltextPackageImpl#getWord()
	 * @generated
	 */
	int WORD = 3;

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
	int CONSTANT = 4;

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
	int VARIABLE = 5;

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
	 * Returns the meta object for the containment reference list '{@link modeltext.IdentifyElements#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see modeltext.IdentifyElements#getElements()
	 * @see #getIdentifyElements()
	 * @generated
	 */
	EReference getIdentifyElements_Elements();

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
	 * Returns the meta object for the containment reference '{@link modeltext.Element#getAtt <em>Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Att</em>'.
	 * @see modeltext.Element#getAtt()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Att();

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
	 * Returns the meta object for class '{@link modeltext.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see modeltext.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link modeltext.Attribute#isNegation <em>Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negation</em>'.
	 * @see modeltext.Attribute#isNegation()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Negation();

	/**
	 * Returns the meta object for the reference '{@link modeltext.Attribute#getAtt <em>Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att</em>'.
	 * @see modeltext.Attribute#getAtt()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Att();

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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTIFY_ELEMENTS__ELEMENTS = eINSTANCE.getIdentifyElements_Elements();

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
		 * The meta object literal for the '<em><b>Att</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__ATT = eINSTANCE.getElement_Att();

		/**
		 * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__WORDS = eINSTANCE.getElement_Words();

		/**
		 * The meta object literal for the '{@link modeltext.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeltext.impl.AttributeImpl
		 * @see modeltext.impl.ModeltextPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Negation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NEGATION = eINSTANCE.getAttribute_Negation();

		/**
		 * The meta object literal for the '<em><b>Att</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__ATT = eINSTANCE.getAttribute_Att();

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

	}

} //ModeltextPackage
