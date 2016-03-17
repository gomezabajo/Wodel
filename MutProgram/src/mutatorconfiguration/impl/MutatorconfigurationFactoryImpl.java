/**
 */
package mutatorconfiguration.impl;

import mutatorconfiguration.*;

import org.eclipse.emf.ecore.EClass;
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
public class MutatorconfigurationFactoryImpl extends EFactoryImpl implements MutatorconfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MutatorconfigurationFactory init() {
		try {
			MutatorconfigurationFactory theMutatorconfigurationFactory = (MutatorconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(MutatorconfigurationPackage.eNS_URI);
			if (theMutatorconfigurationFactory != null) {
				return theMutatorconfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MutatorconfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorconfigurationFactoryImpl() {
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
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION: return createMutatorConfiguration();
			case MutatorconfigurationPackage.CONFIGURATION: return createConfiguration();
			case MutatorconfigurationPackage.PARAMETER: return createParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorConfiguration createMutatorConfiguration() {
		MutatorConfigurationImpl mutatorConfiguration = new MutatorConfigurationImpl();
		return mutatorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorconfigurationPackage getMutatorconfigurationPackage() {
		return (MutatorconfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MutatorconfigurationPackage getPackage() {
		return MutatorconfigurationPackage.eINSTANCE;
	}

} //MutatorconfigurationFactoryImpl
