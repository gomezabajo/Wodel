/**
 */
package appliedMutations.impl;

import appliedMutations.*;

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
public class AppliedMutationsFactoryImpl extends EFactoryImpl implements AppliedMutationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AppliedMutationsFactory init() {
		try {
			AppliedMutationsFactory theAppliedMutationsFactory = (AppliedMutationsFactory)EPackage.Registry.INSTANCE.getEFactory(AppliedMutationsPackage.eNS_URI);
			if (theAppliedMutationsFactory != null) {
				return theAppliedMutationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AppliedMutationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedMutationsFactoryImpl() {
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
			case AppliedMutationsPackage.MUTATIONS: return createMutations();
			case AppliedMutationsPackage.APP_MUTATION: return createAppMutation();
			case AppliedMutationsPackage.OBJECT_CREATED: return createObjectCreated();
			case AppliedMutationsPackage.OBJECT_REMOVED: return createObjectRemoved();
			case AppliedMutationsPackage.REFERENCE_CHANGED: return createReferenceChanged();
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED: return createSourceReferenceChanged();
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED: return createTargetReferenceChanged();
			case AppliedMutationsPackage.REFERENCE_CREATED: return createReferenceCreated();
			case AppliedMutationsPackage.REFERENCE_REMOVED: return createReferenceRemoved();
			case AppliedMutationsPackage.INFORMATION_CHANGED: return createInformationChanged();
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED: return createAttributeChanged();
			case AppliedMutationsPackage.REFERENCE_SWAP: return createReferenceSwap();
			case AppliedMutationsPackage.REFERENCE_ATT: return createReferenceAtt();
			case AppliedMutationsPackage.ATTRIBUTE_SWAP: return createAttributeSwap();
			case AppliedMutationsPackage.COMPOSITE_MUTATION: return createCompositeMutation();
			case AppliedMutationsPackage.OBJECT_CLONED: return createObjectCloned();
			case AppliedMutationsPackage.OBJECT_RETYPED: return createObjectRetyped();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mutations createMutations() {
		MutationsImpl mutations = new MutationsImpl();
		return mutations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppMutation createAppMutation() {
		AppMutationImpl appMutation = new AppMutationImpl();
		return appMutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectCreated createObjectCreated() {
		ObjectCreatedImpl objectCreated = new ObjectCreatedImpl();
		return objectCreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectRemoved createObjectRemoved() {
		ObjectRemovedImpl objectRemoved = new ObjectRemovedImpl();
		return objectRemoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceChanged createReferenceChanged() {
		ReferenceChangedImpl referenceChanged = new ReferenceChangedImpl();
		return referenceChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceReferenceChanged createSourceReferenceChanged() {
		SourceReferenceChangedImpl sourceReferenceChanged = new SourceReferenceChangedImpl();
		return sourceReferenceChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetReferenceChanged createTargetReferenceChanged() {
		TargetReferenceChangedImpl targetReferenceChanged = new TargetReferenceChangedImpl();
		return targetReferenceChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceCreated createReferenceCreated() {
		ReferenceCreatedImpl referenceCreated = new ReferenceCreatedImpl();
		return referenceCreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRemoved createReferenceRemoved() {
		ReferenceRemovedImpl referenceRemoved = new ReferenceRemovedImpl();
		return referenceRemoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationChanged createInformationChanged() {
		InformationChangedImpl informationChanged = new InformationChangedImpl();
		return informationChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeChanged createAttributeChanged() {
		AttributeChangedImpl attributeChanged = new AttributeChangedImpl();
		return attributeChanged;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSwap createReferenceSwap() {
		ReferenceSwapImpl referenceSwap = new ReferenceSwapImpl();
		return referenceSwap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAtt createReferenceAtt() {
		ReferenceAttImpl referenceAtt = new ReferenceAttImpl();
		return referenceAtt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeSwap createAttributeSwap() {
		AttributeSwapImpl attributeSwap = new AttributeSwapImpl();
		return attributeSwap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeMutation createCompositeMutation() {
		CompositeMutationImpl compositeMutation = new CompositeMutationImpl();
		return compositeMutation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectCloned createObjectCloned() {
		ObjectClonedImpl objectCloned = new ObjectClonedImpl();
		return objectCloned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectRetyped createObjectRetyped() {
		ObjectRetypedImpl objectRetyped = new ObjectRetypedImpl();
		return objectRetyped;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedMutationsPackage getAppliedMutationsPackage() {
		return (AppliedMutationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AppliedMutationsPackage getPackage() {
		return AppliedMutationsPackage.eINSTANCE;
	}

} //AppliedMutationsFactoryImpl
