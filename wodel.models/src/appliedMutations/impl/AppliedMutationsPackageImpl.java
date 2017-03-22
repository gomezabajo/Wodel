/**
 */
package appliedMutations.impl;

import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsFactory;
import appliedMutations.AppliedMutationsPackage;
import appliedMutations.AttributeChanged;
import appliedMutations.AttributeSwap;
import appliedMutations.CompositeMutation;
import appliedMutations.InformationChanged;
import appliedMutations.Mutations;
import appliedMutations.ObjectCloned;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ReferenceAtt;
import appliedMutations.ReferenceChanged;
import appliedMutations.ReferenceCreated;
import appliedMutations.ReferenceRemoved;
import appliedMutations.ReferenceSwap;
import appliedMutations.SourceReferenceChanged;
import appliedMutations.TargetReferenceChanged;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AppliedMutationsPackageImpl extends EPackageImpl implements AppliedMutationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appMutationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectCreatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectRemovedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceReferenceChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetReferenceChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCreatedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceRemovedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeChangedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceSwapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAttEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeSwapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeMutationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectClonedEClass = null;

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
	 * @see appliedMutations.AppliedMutationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AppliedMutationsPackageImpl() {
		super(eNS_URI, AppliedMutationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AppliedMutationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AppliedMutationsPackage init() {
		if (isInited) return (AppliedMutationsPackage)EPackage.Registry.INSTANCE.getEPackage(AppliedMutationsPackage.eNS_URI);

		// Obtain or create and register package
		AppliedMutationsPackageImpl theAppliedMutationsPackage = (AppliedMutationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AppliedMutationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AppliedMutationsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAppliedMutationsPackage.createPackageContents();

		// Initialize created meta-data
		theAppliedMutationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAppliedMutationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AppliedMutationsPackage.eNS_URI, theAppliedMutationsPackage);
		return theAppliedMutationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutations() {
		return mutationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutations_Muts() {
		return (EReference)mutationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAppMutation() {
		return appMutationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAppMutation_Def() {
		return (EReference)appMutationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectCreated() {
		return objectCreatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectCreated_Object() {
		return (EReference)objectCreatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectRemoved() {
		return objectRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectRemoved_Object() {
		return (EReference)objectRemovedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceChanged() {
		return referenceChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceChanged_Object() {
		return (EReference)referenceChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceChanged_SrcRefName() {
		return (EAttribute)referenceChangedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceChanged_RefName() {
		return (EAttribute)referenceChangedEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceChanged_From() {
		return (EReference)referenceChangedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceChanged_To() {
		return (EReference)referenceChangedEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceReferenceChanged() {
		return sourceReferenceChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceReferenceChanged_OldFrom() {
		return (EReference)sourceReferenceChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetReferenceChanged() {
		return targetReferenceChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetReferenceChanged_OldTo() {
		return (EReference)targetReferenceChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCreated() {
		return referenceCreatedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCreated_Object() {
		return (EReference)referenceCreatedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCreated_Ref() {
		return (EReference)referenceCreatedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceCreated_RefName() {
		return (EAttribute)referenceCreatedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceRemoved() {
		return referenceRemovedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRemoved_Object() {
		return (EReference)referenceRemovedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRemoved_Ref() {
		return (EReference)referenceRemovedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceRemoved_RefName() {
		return (EAttribute)referenceRemovedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInformationChanged() {
		return informationChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformationChanged_Object() {
		return (EReference)informationChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformationChanged_AttChanges() {
		return (EReference)informationChangedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInformationChanged_RefChanges() {
		return (EReference)informationChangedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeChanged() {
		return attributeChangedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeChanged_AttName() {
		return (EAttribute)attributeChangedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeChanged_OldVal() {
		return (EAttribute)attributeChangedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeChanged_NewVal() {
		return (EAttribute)attributeChangedEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceSwap() {
		return referenceSwapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSwap_RefObject() {
		return (EReference)referenceSwapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceSwap_FirstName() {
		return (EAttribute)referenceSwapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSwap_OtherFrom() {
		return (EReference)referenceSwapEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceSwap_OtherFromName() {
		return (EAttribute)referenceSwapEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSwap_OtherTo() {
		return (EReference)referenceSwapEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceSwap_OtherToName() {
		return (EAttribute)referenceSwapEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAtt() {
		return referenceAttEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAtt_AttName() {
		return (EAttribute)referenceAttEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAtt_OldVal() {
		return (EAttribute)referenceAttEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceAtt_NewVal() {
		return (EAttribute)referenceAttEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeSwap() {
		return attributeSwapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeSwap_AttObject() {
		return (EReference)attributeSwapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeSwap_FirstName() {
		return (EAttribute)attributeSwapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeMutation() {
		return compositeMutationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeMutation_Size() {
		return (EAttribute)compositeMutationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeMutation_Muts() {
		return (EReference)compositeMutationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectCloned() {
		return objectClonedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectCloned_Object() {
		return (EReference)objectClonedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AppliedMutationsFactory getAppliedMutationsFactory() {
		return (AppliedMutationsFactory)getEFactoryInstance();
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
		mutationsEClass = createEClass(MUTATIONS);
		createEReference(mutationsEClass, MUTATIONS__MUTS);

		appMutationEClass = createEClass(APP_MUTATION);
		createEReference(appMutationEClass, APP_MUTATION__DEF);

		objectCreatedEClass = createEClass(OBJECT_CREATED);
		createEReference(objectCreatedEClass, OBJECT_CREATED__OBJECT);

		objectRemovedEClass = createEClass(OBJECT_REMOVED);
		createEReference(objectRemovedEClass, OBJECT_REMOVED__OBJECT);

		referenceChangedEClass = createEClass(REFERENCE_CHANGED);
		createEReference(referenceChangedEClass, REFERENCE_CHANGED__OBJECT);
		createEAttribute(referenceChangedEClass, REFERENCE_CHANGED__SRC_REF_NAME);
		createEReference(referenceChangedEClass, REFERENCE_CHANGED__FROM);
		createEAttribute(referenceChangedEClass, REFERENCE_CHANGED__REF_NAME);
		createEReference(referenceChangedEClass, REFERENCE_CHANGED__TO);

		sourceReferenceChangedEClass = createEClass(SOURCE_REFERENCE_CHANGED);
		createEReference(sourceReferenceChangedEClass, SOURCE_REFERENCE_CHANGED__OLD_FROM);

		targetReferenceChangedEClass = createEClass(TARGET_REFERENCE_CHANGED);
		createEReference(targetReferenceChangedEClass, TARGET_REFERENCE_CHANGED__OLD_TO);

		referenceCreatedEClass = createEClass(REFERENCE_CREATED);
		createEReference(referenceCreatedEClass, REFERENCE_CREATED__OBJECT);
		createEReference(referenceCreatedEClass, REFERENCE_CREATED__REF);
		createEAttribute(referenceCreatedEClass, REFERENCE_CREATED__REF_NAME);

		referenceRemovedEClass = createEClass(REFERENCE_REMOVED);
		createEReference(referenceRemovedEClass, REFERENCE_REMOVED__OBJECT);
		createEReference(referenceRemovedEClass, REFERENCE_REMOVED__REF);
		createEAttribute(referenceRemovedEClass, REFERENCE_REMOVED__REF_NAME);

		informationChangedEClass = createEClass(INFORMATION_CHANGED);
		createEReference(informationChangedEClass, INFORMATION_CHANGED__OBJECT);
		createEReference(informationChangedEClass, INFORMATION_CHANGED__ATT_CHANGES);
		createEReference(informationChangedEClass, INFORMATION_CHANGED__REF_CHANGES);

		attributeChangedEClass = createEClass(ATTRIBUTE_CHANGED);
		createEAttribute(attributeChangedEClass, ATTRIBUTE_CHANGED__ATT_NAME);
		createEAttribute(attributeChangedEClass, ATTRIBUTE_CHANGED__OLD_VAL);
		createEAttribute(attributeChangedEClass, ATTRIBUTE_CHANGED__NEW_VAL);

		referenceSwapEClass = createEClass(REFERENCE_SWAP);
		createEReference(referenceSwapEClass, REFERENCE_SWAP__REF_OBJECT);
		createEAttribute(referenceSwapEClass, REFERENCE_SWAP__FIRST_NAME);
		createEReference(referenceSwapEClass, REFERENCE_SWAP__OTHER_FROM);
		createEAttribute(referenceSwapEClass, REFERENCE_SWAP__OTHER_FROM_NAME);
		createEReference(referenceSwapEClass, REFERENCE_SWAP__OTHER_TO);
		createEAttribute(referenceSwapEClass, REFERENCE_SWAP__OTHER_TO_NAME);

		referenceAttEClass = createEClass(REFERENCE_ATT);
		createEAttribute(referenceAttEClass, REFERENCE_ATT__ATT_NAME);
		createEAttribute(referenceAttEClass, REFERENCE_ATT__OLD_VAL);
		createEAttribute(referenceAttEClass, REFERENCE_ATT__NEW_VAL);

		attributeSwapEClass = createEClass(ATTRIBUTE_SWAP);
		createEReference(attributeSwapEClass, ATTRIBUTE_SWAP__ATT_OBJECT);
		createEAttribute(attributeSwapEClass, ATTRIBUTE_SWAP__FIRST_NAME);

		compositeMutationEClass = createEClass(COMPOSITE_MUTATION);
		createEAttribute(compositeMutationEClass, COMPOSITE_MUTATION__SIZE);
		createEReference(compositeMutationEClass, COMPOSITE_MUTATION__MUTS);

		objectClonedEClass = createEClass(OBJECT_CLONED);
		createEReference(objectClonedEClass, OBJECT_CLONED__OBJECT);
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
		objectCreatedEClass.getESuperTypes().add(this.getAppMutation());
		objectRemovedEClass.getESuperTypes().add(this.getAppMutation());
		referenceChangedEClass.getESuperTypes().add(this.getAppMutation());
		sourceReferenceChangedEClass.getESuperTypes().add(this.getReferenceChanged());
		targetReferenceChangedEClass.getESuperTypes().add(this.getReferenceChanged());
		referenceCreatedEClass.getESuperTypes().add(this.getAppMutation());
		referenceRemovedEClass.getESuperTypes().add(this.getAppMutation());
		informationChangedEClass.getESuperTypes().add(this.getAppMutation());
		attributeChangedEClass.getESuperTypes().add(this.getAppMutation());
		referenceSwapEClass.getESuperTypes().add(this.getReferenceChanged());
		referenceAttEClass.getESuperTypes().add(this.getReferenceChanged());
		attributeSwapEClass.getESuperTypes().add(this.getAttributeChanged());
		compositeMutationEClass.getESuperTypes().add(this.getAppMutation());
		objectClonedEClass.getESuperTypes().add(this.getAppMutation());

		// Initialize classes, features, and operations; add parameters
		initEClass(mutationsEClass, Mutations.class, "Mutations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutations_Muts(), this.getAppMutation(), null, "muts", null, 0, -1, Mutations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appMutationEClass, AppMutation.class, "AppMutation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppMutation_Def(), ecorePackage.getEObject(), null, "def", null, 1, 1, AppMutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectCreatedEClass, ObjectCreated.class, "ObjectCreated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectCreated_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ObjectCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(objectRemovedEClass, ObjectRemoved.class, "ObjectRemoved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectRemoved_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ObjectRemoved.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(referenceChangedEClass, ReferenceChanged.class, "ReferenceChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceChanged_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReferenceChanged_SrcRefName(), ecorePackage.getEString(), "srcRefName", null, 1, 1, ReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceChanged_From(), ecorePackage.getEObject(), null, "from", null, 1, 1, ReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceChanged_RefName(), ecorePackage.getEString(), "refName", null, 1, 1, ReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceChanged_To(), ecorePackage.getEObject(), null, "to", null, 1, 1, ReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceReferenceChangedEClass, SourceReferenceChanged.class, "SourceReferenceChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceReferenceChanged_OldFrom(), ecorePackage.getEObject(), null, "oldFrom", null, 1, 1, SourceReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(targetReferenceChangedEClass, TargetReferenceChanged.class, "TargetReferenceChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetReferenceChanged_OldTo(), ecorePackage.getEObject(), null, "oldTo", null, 1, 1, TargetReferenceChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceCreatedEClass, ReferenceCreated.class, "ReferenceCreated", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceCreated_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ReferenceCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReferenceCreated_Ref(), ecorePackage.getEReference(), null, "ref", null, 0, -1, ReferenceCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReferenceCreated_RefName(), ecorePackage.getEString(), "refName", null, 1, 1, ReferenceCreated.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceRemovedEClass, ReferenceRemoved.class, "ReferenceRemoved", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceRemoved_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ReferenceRemoved.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getReferenceRemoved_Ref(), ecorePackage.getEReference(), null, "ref", null, 0, -1, ReferenceRemoved.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getReferenceRemoved_RefName(), ecorePackage.getEString(), "refName", null, 1, 1, ReferenceRemoved.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(informationChangedEClass, InformationChanged.class, "InformationChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInformationChanged_Object(), ecorePackage.getEObject(), null, "object", null, 1, 1, InformationChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformationChanged_AttChanges(), this.getAttributeChanged(), null, "attChanges", null, 0, -1, InformationChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInformationChanged_RefChanges(), this.getReferenceChanged(), null, "refChanges", null, 0, -1, InformationChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeChangedEClass, AttributeChanged.class, "AttributeChanged", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeChanged_AttName(), ecorePackage.getEString(), "attName", null, 1, 1, AttributeChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeChanged_OldVal(), ecorePackage.getEString(), "oldVal", null, 1, 1, AttributeChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeChanged_NewVal(), ecorePackage.getEString(), "newVal", null, 1, 1, AttributeChanged.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceSwapEClass, ReferenceSwap.class, "ReferenceSwap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceSwap_RefObject(), ecorePackage.getEObject(), null, "refObject", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceSwap_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceSwap_OtherFrom(), ecorePackage.getEObject(), null, "otherFrom", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceSwap_OtherFromName(), ecorePackage.getEString(), "otherFromName", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceSwap_OtherTo(), ecorePackage.getEObject(), null, "otherTo", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceSwap_OtherToName(), ecorePackage.getEString(), "otherToName", null, 1, 1, ReferenceSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceAttEClass, ReferenceAtt.class, "ReferenceAtt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceAtt_AttName(), ecorePackage.getEString(), "attName", null, 1, 1, ReferenceAtt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceAtt_OldVal(), ecorePackage.getEString(), "oldVal", null, 1, 1, ReferenceAtt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceAtt_NewVal(), ecorePackage.getEString(), "newVal", null, 1, 1, ReferenceAtt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeSwapEClass, AttributeSwap.class, "AttributeSwap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeSwap_AttObject(), ecorePackage.getEObject(), null, "attObject", null, 1, 1, AttributeSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeSwap_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, AttributeSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeMutationEClass, CompositeMutation.class, "CompositeMutation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeMutation_Size(), ecorePackage.getEInt(), "size", null, 1, 1, CompositeMutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeMutation_Muts(), this.getAppMutation(), null, "muts", null, 0, -1, CompositeMutation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectClonedEClass, ObjectCloned.class, "ObjectCloned", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectCloned_Object(), ecorePackage.getEObject(), null, "object", null, 0, -1, ObjectCloned.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

} //AppliedMutationsPackageImpl
