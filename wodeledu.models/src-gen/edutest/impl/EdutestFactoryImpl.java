/**
 */
package edutest.impl;

import edutest.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdutestFactoryImpl extends EFactoryImpl implements EdutestFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EdutestFactory init() {
		try {
			EdutestFactory theEdutestFactory = (EdutestFactory) EPackage.Registry.INSTANCE
					.getEFactory(EdutestPackage.eNS_URI);
			if (theEdutestFactory != null) {
				return theEdutestFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EdutestFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdutestFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EdutestPackage.PROGRAM:
			return createProgram();
		case EdutestPackage.PROGRAM_CONFIGURATION:
			return createProgramConfiguration();
		case EdutestPackage.TEST_CONFIGURATION:
			return createTestConfiguration();
		case EdutestPackage.MULTI_CHOICE_EM_CONFIG:
			return createMultiChoiceEmConfig();
		case EdutestPackage.TEXT_CONFIGURATION:
			return createTextConfiguration();
		case EdutestPackage.ALTERNATIVE_RESPONSE:
			return createAlternativeResponse();
		case EdutestPackage.MULTI_CHOICE_DIAGRAM:
			return createMultiChoiceDiagram();
		case EdutestPackage.MULTI_CHOICE_EMENDATION:
			return createMultiChoiceEmendation();
		case EdutestPackage.MATCH_PAIRS:
			return createMatchPairs();
		case EdutestPackage.MISSING_WORDS:
			return createMissingWords();
		case EdutestPackage.MULTI_CHOICE_TEXT:
			return createMultiChoiceText();
		case EdutestPackage.ALTERNATIVE_TEXT:
			return createAlternativeText();
		case EdutestPackage.DRAG_AND_DROP_TEXT:
			return createDragAndDropText();
		case EdutestPackage.TEST:
			return createTest();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case EdutestPackage.ORDER:
			return createOrderFromString(eDataType, initialValue);
		case EdutestPackage.NAVIGATION:
			return createNavigationFromString(eDataType, initialValue);
		case EdutestPackage.MODE:
			return createModeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case EdutestPackage.ORDER:
			return convertOrderToString(eDataType, instanceValue);
		case EdutestPackage.NAVIGATION:
			return convertNavigationToString(eDataType, instanceValue);
		case EdutestPackage.MODE:
			return convertModeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramConfiguration createProgramConfiguration() {
		ProgramConfigurationImpl programConfiguration = new ProgramConfigurationImpl();
		return programConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestConfiguration createTestConfiguration() {
		TestConfigurationImpl testConfiguration = new TestConfigurationImpl();
		return testConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiChoiceEmConfig createMultiChoiceEmConfig() {
		MultiChoiceEmConfigImpl multiChoiceEmConfig = new MultiChoiceEmConfigImpl();
		return multiChoiceEmConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextConfiguration createTextConfiguration() {
		TextConfigurationImpl textConfiguration = new TextConfigurationImpl();
		return textConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeResponse createAlternativeResponse() {
		AlternativeResponseImpl alternativeResponse = new AlternativeResponseImpl();
		return alternativeResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiChoiceDiagram createMultiChoiceDiagram() {
		MultiChoiceDiagramImpl multiChoiceDiagram = new MultiChoiceDiagramImpl();
		return multiChoiceDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiChoiceEmendation createMultiChoiceEmendation() {
		MultiChoiceEmendationImpl multiChoiceEmendation = new MultiChoiceEmendationImpl();
		return multiChoiceEmendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchPairs createMatchPairs() {
		MatchPairsImpl matchPairs = new MatchPairsImpl();
		return matchPairs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissingWords createMissingWords() {
		MissingWordsImpl missingWords = new MissingWordsImpl();
		return missingWords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiChoiceText createMultiChoiceText() {
		MultiChoiceTextImpl multiChoiceText = new MultiChoiceTextImpl();
		return multiChoiceText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeText createAlternativeText() {
		AlternativeTextImpl alternativeText = new AlternativeTextImpl();
		return alternativeText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DragAndDropText createDragAndDropText() {
		DragAndDropTextImpl dragAndDropText = new DragAndDropTextImpl();
		return dragAndDropText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Test createTest() {
		TestImpl test = new TestImpl();
		return test;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Order createOrderFromString(EDataType eDataType, String initialValue) {
		Order result = Order.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOrderToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Navigation createNavigationFromString(EDataType eDataType, String initialValue) {
		Navigation result = Navigation.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNavigationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode createModeFromString(EDataType eDataType, String initialValue) {
		Mode result = Mode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdutestPackage getEdutestPackage() {
		return (EdutestPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EdutestPackage getPackage() {
		return EdutestPackage.eINSTANCE;
	}

} //EdutestFactoryImpl
