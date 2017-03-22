/**
 */
package mutatormetrics.impl;

import mutatormetrics.Attribute;
import mutatormetrics.Folder;
import mutatormetrics.Mutant;
import mutatormetrics.MutatorMetrics;
import mutatormetrics.MutatormetricsFactory;
import mutatormetrics.MutatormetricsPackage;
import mutatormetrics.Reference;

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
public class MutatormetricsFactoryImpl extends EFactoryImpl implements MutatormetricsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MutatormetricsFactory init() {
		try {
			MutatormetricsFactory theMutatormetricsFactory = (MutatormetricsFactory)EPackage.Registry.INSTANCE.getEFactory(MutatormetricsPackage.eNS_URI);
			if (theMutatormetricsFactory != null) {
				return theMutatormetricsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MutatormetricsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatormetricsFactoryImpl() {
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
			case MutatormetricsPackage.MUTATOR_METRICS: return createMutatorMetrics();
			case MutatormetricsPackage.FOLDER: return createFolder();
			case MutatormetricsPackage.MUTANT: return createMutant();
			case MutatormetricsPackage.CLASS: return createClass();
			case MutatormetricsPackage.REFERENCE: return createReference();
			case MutatormetricsPackage.ATTRIBUTE: return createAttribute();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorMetrics createMutatorMetrics() {
		MutatorMetricsImpl mutatorMetrics = new MutatorMetricsImpl();
		return mutatorMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mutant createMutant() {
		MutantImpl mutant = new MutantImpl();
		return mutant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public mutatormetrics.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatormetricsPackage getMutatormetricsPackage() {
		return (MutatormetricsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MutatormetricsPackage getPackage() {
		return MutatormetricsPackage.eINSTANCE;
	}

} //MutatormetricsFactoryImpl
