/**
 */
package mutatortests.impl;

import mutatortests.*;

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
public class MutatortestsFactoryImpl extends EFactoryImpl implements MutatortestsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MutatortestsFactory init() {
		try {
			MutatortestsFactory theMutatortestsFactory = (MutatortestsFactory)EPackage.Registry.INSTANCE.getEFactory(MutatortestsPackage.eNS_URI);
			if (theMutatortestsFactory != null) {
				return theMutatortestsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MutatortestsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatortestsFactoryImpl() {
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
			case MutatortestsPackage.PROGRAM: return createProgram();
			case MutatortestsPackage.PROGRAM_CONFIGURATION: return createProgramConfiguration();
			case MutatortestsPackage.TEST_CONFIGURATION: return createTestConfiguration();
			case MutatortestsPackage.MULTI_CHOICE_EM_CONFIG: return createMultiChoiceEmConfig();
			case MutatortestsPackage.ALTERNATIVE_RESPONSE: return createAlternativeResponse();
			case MutatortestsPackage.MULTI_CHOICE_DIAGRAM: return createMultiChoiceDiagram();
			case MutatortestsPackage.MULTI_CHOICE_EMENDATION: return createMultiChoiceEmendation();
			case MutatortestsPackage.TEST: return createTest();
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
			case MutatortestsPackage.ORDER:
				return createOrderFromString(eDataType, initialValue);
			case MutatortestsPackage.NAVIGATION:
				return createNavigationFromString(eDataType, initialValue);
			case MutatortestsPackage.MODE:
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
			case MutatortestsPackage.ORDER:
				return convertOrderToString(eDataType, instanceValue);
			case MutatortestsPackage.NAVIGATION:
				return convertNavigationToString(eDataType, instanceValue);
			case MutatortestsPackage.MODE:
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	public MutatortestsPackage getMutatortestsPackage() {
		return (MutatortestsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MutatortestsPackage getPackage() {
		return MutatortestsPackage.eINSTANCE;
	}

} //MutatortestsFactoryImpl
