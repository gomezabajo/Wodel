/**
 */
package appliedMutations;

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
 * <!-- begin-model-doc -->
 * import mutatorenvironment : 'http://mutatorenvironment/1.0#/';
 * <!-- end-model-doc -->
 * @see appliedMutations.AppliedMutationsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface AppliedMutationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "appliedMutations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://appliedMutations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "appliedMutations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AppliedMutationsPackage eINSTANCE = appliedMutations.impl.AppliedMutationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link appliedMutations.impl.MutationsImpl <em>Mutations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.MutationsImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getMutations()
	 * @generated
	 */
	int MUTATIONS = 0;

	/**
	 * The feature id for the '<em><b>Muts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATIONS__MUTS = 0;

	/**
	 * The number of structural features of the '<em>Mutations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Mutations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.AppMutationImpl <em>App Mutation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.AppMutationImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAppMutation()
	 * @generated
	 */
	int APP_MUTATION = 1;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MUTATION__DEF = 0;

	/**
	 * The number of structural features of the '<em>App Mutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MUTATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>App Mutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APP_MUTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.ObjectCreatedImpl <em>Object Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ObjectCreatedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectCreated()
	 * @generated
	 */
	int OBJECT_CREATED = 2;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CREATED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CREATED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CREATED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CREATED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.ObjectRemovedImpl <em>Object Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ObjectRemovedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectRemoved()
	 * @generated
	 */
	int OBJECT_REMOVED = 3;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED__TYPE = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REMOVED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.ReferenceChangedImpl <em>Reference Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ReferenceChangedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceChanged()
	 * @generated
	 */
	int REFERENCE_CHANGED = 4;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__SRC_REF_NAME = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__FROM = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__REF_NAME = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED__TO = APP_MUTATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CHANGED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.SourceReferenceChangedImpl <em>Source Reference Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.SourceReferenceChangedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getSourceReferenceChanged()
	 * @generated
	 */
	int SOURCE_REFERENCE_CHANGED = 5;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__DEF = REFERENCE_CHANGED__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__OBJECT = REFERENCE_CHANGED__OBJECT;

	/**
	 * The feature id for the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__SRC_REF_NAME = REFERENCE_CHANGED__SRC_REF_NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__FROM = REFERENCE_CHANGED__FROM;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__REF_NAME = REFERENCE_CHANGED__REF_NAME;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__TO = REFERENCE_CHANGED__TO;

	/**
	 * The feature id for the '<em><b>Old From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED__OLD_FROM = REFERENCE_CHANGED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED_FEATURE_COUNT = REFERENCE_CHANGED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Source Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_REFERENCE_CHANGED_OPERATION_COUNT = REFERENCE_CHANGED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.TargetReferenceChangedImpl <em>Target Reference Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.TargetReferenceChangedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getTargetReferenceChanged()
	 * @generated
	 */
	int TARGET_REFERENCE_CHANGED = 6;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__DEF = REFERENCE_CHANGED__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__OBJECT = REFERENCE_CHANGED__OBJECT;

	/**
	 * The feature id for the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__SRC_REF_NAME = REFERENCE_CHANGED__SRC_REF_NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__FROM = REFERENCE_CHANGED__FROM;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__REF_NAME = REFERENCE_CHANGED__REF_NAME;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__TO = REFERENCE_CHANGED__TO;

	/**
	 * The feature id for the '<em><b>Old To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED__OLD_TO = REFERENCE_CHANGED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Target Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED_FEATURE_COUNT = REFERENCE_CHANGED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Target Reference Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_REFERENCE_CHANGED_OPERATION_COUNT = REFERENCE_CHANGED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.ReferenceCreatedImpl <em>Reference Created</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ReferenceCreatedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceCreated()
	 * @generated
	 */
	int REFERENCE_CREATED = 7;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED__REF = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED__REF_NAME = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Created</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_CREATED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.ReferenceRemovedImpl <em>Reference Removed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ReferenceRemovedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceRemoved()
	 * @generated
	 */
	int REFERENCE_REMOVED = 8;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED__REF = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED__REF_NAME = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Removed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.InformationChangedImpl <em>Information Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.InformationChangedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getInformationChanged()
	 * @generated
	 */
	int INFORMATION_CHANGED = 9;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Att Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED__ATT_CHANGES = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED__REF_CHANGES = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Information Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Information Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_CHANGED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.AttributeChangedImpl <em>Attribute Changed</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.AttributeChangedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAttributeChanged()
	 * @generated
	 */
	int ATTRIBUTE_CHANGED = 10;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED__ATT_NAME = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED__OLD_VAL = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED__NEW_VAL = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Attribute Changed</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link appliedMutations.impl.ReferenceSwapImpl <em>Reference Swap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ReferenceSwapImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceSwap()
	 * @generated
	 */
	int REFERENCE_SWAP = 11;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__DEF = REFERENCE_CHANGED__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OBJECT = REFERENCE_CHANGED__OBJECT;

	/**
	 * The feature id for the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__SRC_REF_NAME = REFERENCE_CHANGED__SRC_REF_NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__FROM = REFERENCE_CHANGED__FROM;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__REF_NAME = REFERENCE_CHANGED__REF_NAME;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__TO = REFERENCE_CHANGED__TO;

	/**
	 * The feature id for the '<em><b>Ref Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__REF_OBJECT = REFERENCE_CHANGED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__FIRST_NAME = REFERENCE_CHANGED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OTHER_FROM = REFERENCE_CHANGED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Other From Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OTHER_FROM_NAME = REFERENCE_CHANGED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Other To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OTHER_TO = REFERENCE_CHANGED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Other To Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OTHER_TO_NAME = REFERENCE_CHANGED_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Reference Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP_FEATURE_COUNT = REFERENCE_CHANGED_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Reference Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP_OPERATION_COUNT = REFERENCE_CHANGED_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link appliedMutations.impl.ReferenceAttImpl <em>Reference Att</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ReferenceAttImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceAtt()
	 * @generated
	 */
	int REFERENCE_ATT = 12;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__DEF = REFERENCE_CHANGED__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__OBJECT = REFERENCE_CHANGED__OBJECT;

	/**
	 * The feature id for the '<em><b>Src Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__SRC_REF_NAME = REFERENCE_CHANGED__SRC_REF_NAME;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__FROM = REFERENCE_CHANGED__FROM;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__REF_NAME = REFERENCE_CHANGED__REF_NAME;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__TO = REFERENCE_CHANGED__TO;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__ATT_NAME = REFERENCE_CHANGED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__OLD_VAL = REFERENCE_CHANGED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__NEW_VAL = REFERENCE_CHANGED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Reference Att</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT_FEATURE_COUNT = REFERENCE_CHANGED_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Reference Att</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT_OPERATION_COUNT = REFERENCE_CHANGED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link appliedMutations.impl.AttributeSwapImpl <em>Attribute Swap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.AttributeSwapImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAttributeSwap()
	 * @generated
	 */
	int ATTRIBUTE_SWAP = 13;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__DEF = ATTRIBUTE_CHANGED__DEF;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__ATT_NAME = ATTRIBUTE_CHANGED__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Old Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__OLD_VAL = ATTRIBUTE_CHANGED__OLD_VAL;

	/**
	 * The feature id for the '<em><b>New Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__NEW_VAL = ATTRIBUTE_CHANGED__NEW_VAL;

	/**
	 * The feature id for the '<em><b>Att Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__ATT_OBJECT = ATTRIBUTE_CHANGED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__FIRST_NAME = ATTRIBUTE_CHANGED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP_FEATURE_COUNT = ATTRIBUTE_CHANGED_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP_OPERATION_COUNT = ATTRIBUTE_CHANGED_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link appliedMutations.impl.CompositeMutationImpl <em>Composite Mutation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.CompositeMutationImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getCompositeMutation()
	 * @generated
	 */
	int COMPOSITE_MUTATION = 14;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATION__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATION__SIZE = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Muts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATION__MUTS = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite Mutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATION_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composite Mutation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATION_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link appliedMutations.impl.ObjectClonedImpl <em>Object Cloned</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ObjectClonedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectCloned()
	 * @generated
	 */
	int OBJECT_CLONED = 15;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLONED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLONED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object Cloned</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLONED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Object Cloned</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLONED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link appliedMutations.impl.ObjectRetypedImpl <em>Object Retyped</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see appliedMutations.impl.ObjectRetypedImpl
	 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectRetyped()
	 * @generated
	 */
	int OBJECT_RETYPED = 16;

	/**
	 * The feature id for the '<em><b>Def</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED__DEF = APP_MUTATION__DEF;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED__OBJECT = APP_MUTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Removed Object</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED__REMOVED_OBJECT = APP_MUTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED__TYPE = APP_MUTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED__NEW_TYPE = APP_MUTATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Object Retyped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED_FEATURE_COUNT = APP_MUTATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Object Retyped</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_RETYPED_OPERATION_COUNT = APP_MUTATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link appliedMutations.Mutations <em>Mutations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutations</em>'.
	 * @see appliedMutations.Mutations
	 * @generated
	 */
	EClass getMutations();

	/**
	 * Returns the meta object for the containment reference list '{@link appliedMutations.Mutations#getMuts <em>Muts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Muts</em>'.
	 * @see appliedMutations.Mutations#getMuts()
	 * @see #getMutations()
	 * @generated
	 */
	EReference getMutations_Muts();

	/**
	 * Returns the meta object for class '{@link appliedMutations.AppMutation <em>App Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>App Mutation</em>'.
	 * @see appliedMutations.AppMutation
	 * @generated
	 */
	EClass getAppMutation();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.AppMutation#getDef <em>Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Def</em>'.
	 * @see appliedMutations.AppMutation#getDef()
	 * @see #getAppMutation()
	 * @generated
	 */
	EReference getAppMutation_Def();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ObjectCreated <em>Object Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Created</em>'.
	 * @see appliedMutations.ObjectCreated
	 * @generated
	 */
	EClass getObjectCreated();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ObjectCreated#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ObjectCreated#getObject()
	 * @see #getObjectCreated()
	 * @generated
	 */
	EReference getObjectCreated_Object();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ObjectRemoved <em>Object Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Removed</em>'.
	 * @see appliedMutations.ObjectRemoved
	 * @generated
	 */
	EClass getObjectRemoved();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ObjectRemoved#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ObjectRemoved#getObject()
	 * @see #getObjectRemoved()
	 * @generated
	 */
	EReference getObjectRemoved_Object();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ObjectRemoved#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see appliedMutations.ObjectRemoved#getType()
	 * @see #getObjectRemoved()
	 * @generated
	 */
	EReference getObjectRemoved_Type();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ReferenceChanged <em>Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Changed</em>'.
	 * @see appliedMutations.ReferenceChanged
	 * @generated
	 */
	EClass getReferenceChanged();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ReferenceChanged#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ReferenceChanged#getObject()
	 * @see #getReferenceChanged()
	 * @generated
	 */
	EReference getReferenceChanged_Object();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceChanged#getSrcRefName <em>Src Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src Ref Name</em>'.
	 * @see appliedMutations.ReferenceChanged#getSrcRefName()
	 * @see #getReferenceChanged()
	 * @generated
	 */
	EAttribute getReferenceChanged_SrcRefName();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceChanged#getRefName <em>Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Name</em>'.
	 * @see appliedMutations.ReferenceChanged#getRefName()
	 * @see #getReferenceChanged()
	 * @generated
	 */
	EAttribute getReferenceChanged_RefName();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ReferenceChanged#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From</em>'.
	 * @see appliedMutations.ReferenceChanged#getFrom()
	 * @see #getReferenceChanged()
	 * @generated
	 */
	EReference getReferenceChanged_From();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ReferenceChanged#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see appliedMutations.ReferenceChanged#getTo()
	 * @see #getReferenceChanged()
	 * @generated
	 */
	EReference getReferenceChanged_To();

	/**
	 * Returns the meta object for class '{@link appliedMutations.SourceReferenceChanged <em>Source Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Reference Changed</em>'.
	 * @see appliedMutations.SourceReferenceChanged
	 * @generated
	 */
	EClass getSourceReferenceChanged();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.SourceReferenceChanged#getOldFrom <em>Old From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old From</em>'.
	 * @see appliedMutations.SourceReferenceChanged#getOldFrom()
	 * @see #getSourceReferenceChanged()
	 * @generated
	 */
	EReference getSourceReferenceChanged_OldFrom();

	/**
	 * Returns the meta object for class '{@link appliedMutations.TargetReferenceChanged <em>Target Reference Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Reference Changed</em>'.
	 * @see appliedMutations.TargetReferenceChanged
	 * @generated
	 */
	EClass getTargetReferenceChanged();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.TargetReferenceChanged#getOldTo <em>Old To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old To</em>'.
	 * @see appliedMutations.TargetReferenceChanged#getOldTo()
	 * @see #getTargetReferenceChanged()
	 * @generated
	 */
	EReference getTargetReferenceChanged_OldTo();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ReferenceCreated <em>Reference Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Created</em>'.
	 * @see appliedMutations.ReferenceCreated
	 * @generated
	 */
	EClass getReferenceCreated();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ReferenceCreated#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ReferenceCreated#getObject()
	 * @see #getReferenceCreated()
	 * @generated
	 */
	EReference getReferenceCreated_Object();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ReferenceCreated#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref</em>'.
	 * @see appliedMutations.ReferenceCreated#getRef()
	 * @see #getReferenceCreated()
	 * @generated
	 */
	EReference getReferenceCreated_Ref();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceCreated#getRefName <em>Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Name</em>'.
	 * @see appliedMutations.ReferenceCreated#getRefName()
	 * @see #getReferenceCreated()
	 * @generated
	 */
	EAttribute getReferenceCreated_RefName();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ReferenceRemoved <em>Reference Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Removed</em>'.
	 * @see appliedMutations.ReferenceRemoved
	 * @generated
	 */
	EClass getReferenceRemoved();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ReferenceRemoved#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ReferenceRemoved#getObject()
	 * @see #getReferenceRemoved()
	 * @generated
	 */
	EReference getReferenceRemoved_Object();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ReferenceRemoved#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref</em>'.
	 * @see appliedMutations.ReferenceRemoved#getRef()
	 * @see #getReferenceRemoved()
	 * @generated
	 */
	EReference getReferenceRemoved_Ref();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceRemoved#getRefName <em>Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref Name</em>'.
	 * @see appliedMutations.ReferenceRemoved#getRefName()
	 * @see #getReferenceRemoved()
	 * @generated
	 */
	EAttribute getReferenceRemoved_RefName();

	/**
	 * Returns the meta object for class '{@link appliedMutations.InformationChanged <em>Information Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information Changed</em>'.
	 * @see appliedMutations.InformationChanged
	 * @generated
	 */
	EClass getInformationChanged();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.InformationChanged#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see appliedMutations.InformationChanged#getObject()
	 * @see #getInformationChanged()
	 * @generated
	 */
	EReference getInformationChanged_Object();

	/**
	 * Returns the meta object for the containment reference list '{@link appliedMutations.InformationChanged#getAttChanges <em>Att Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Att Changes</em>'.
	 * @see appliedMutations.InformationChanged#getAttChanges()
	 * @see #getInformationChanged()
	 * @generated
	 */
	EReference getInformationChanged_AttChanges();

	/**
	 * Returns the meta object for the containment reference list '{@link appliedMutations.InformationChanged#getRefChanges <em>Ref Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ref Changes</em>'.
	 * @see appliedMutations.InformationChanged#getRefChanges()
	 * @see #getInformationChanged()
	 * @generated
	 */
	EReference getInformationChanged_RefChanges();

	/**
	 * Returns the meta object for class '{@link appliedMutations.AttributeChanged <em>Attribute Changed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Changed</em>'.
	 * @see appliedMutations.AttributeChanged
	 * @generated
	 */
	EClass getAttributeChanged();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.AttributeChanged#getAttName <em>Att Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Att Name</em>'.
	 * @see appliedMutations.AttributeChanged#getAttName()
	 * @see #getAttributeChanged()
	 * @generated
	 */
	EAttribute getAttributeChanged_AttName();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.AttributeChanged#getOldVal <em>Old Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Val</em>'.
	 * @see appliedMutations.AttributeChanged#getOldVal()
	 * @see #getAttributeChanged()
	 * @generated
	 */
	EAttribute getAttributeChanged_OldVal();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.AttributeChanged#getNewVal <em>New Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Val</em>'.
	 * @see appliedMutations.AttributeChanged#getNewVal()
	 * @see #getAttributeChanged()
	 * @generated
	 */
	EAttribute getAttributeChanged_NewVal();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ReferenceSwap <em>Reference Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Swap</em>'.
	 * @see appliedMutations.ReferenceSwap
	 * @generated
	 */
	EClass getReferenceSwap();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ReferenceSwap#getRefObject <em>Ref Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Object</em>'.
	 * @see appliedMutations.ReferenceSwap#getRefObject()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EReference getReferenceSwap_RefObject();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceSwap#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see appliedMutations.ReferenceSwap#getFirstName()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EAttribute getReferenceSwap_FirstName();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ReferenceSwap#getOtherFrom <em>Other From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other From</em>'.
	 * @see appliedMutations.ReferenceSwap#getOtherFrom()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EReference getReferenceSwap_OtherFrom();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceSwap#getOtherFromName <em>Other From Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other From Name</em>'.
	 * @see appliedMutations.ReferenceSwap#getOtherFromName()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EAttribute getReferenceSwap_OtherFromName();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ReferenceSwap#getOtherTo <em>Other To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other To</em>'.
	 * @see appliedMutations.ReferenceSwap#getOtherTo()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EReference getReferenceSwap_OtherTo();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceSwap#getOtherToName <em>Other To Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other To Name</em>'.
	 * @see appliedMutations.ReferenceSwap#getOtherToName()
	 * @see #getReferenceSwap()
	 * @generated
	 */
	EAttribute getReferenceSwap_OtherToName();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ReferenceAtt <em>Reference Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Att</em>'.
	 * @see appliedMutations.ReferenceAtt
	 * @generated
	 */
	EClass getReferenceAtt();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceAtt#getAttName <em>Att Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Att Name</em>'.
	 * @see appliedMutations.ReferenceAtt#getAttName()
	 * @see #getReferenceAtt()
	 * @generated
	 */
	EAttribute getReferenceAtt_AttName();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceAtt#getOldVal <em>Old Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Val</em>'.
	 * @see appliedMutations.ReferenceAtt#getOldVal()
	 * @see #getReferenceAtt()
	 * @generated
	 */
	EAttribute getReferenceAtt_OldVal();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.ReferenceAtt#getNewVal <em>New Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Val</em>'.
	 * @see appliedMutations.ReferenceAtt#getNewVal()
	 * @see #getReferenceAtt()
	 * @generated
	 */
	EAttribute getReferenceAtt_NewVal();

	/**
	 * Returns the meta object for class '{@link appliedMutations.AttributeSwap <em>Attribute Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Swap</em>'.
	 * @see appliedMutations.AttributeSwap
	 * @generated
	 */
	EClass getAttributeSwap();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.AttributeSwap#getAttObject <em>Att Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att Object</em>'.
	 * @see appliedMutations.AttributeSwap#getAttObject()
	 * @see #getAttributeSwap()
	 * @generated
	 */
	EReference getAttributeSwap_AttObject();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.AttributeSwap#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see appliedMutations.AttributeSwap#getFirstName()
	 * @see #getAttributeSwap()
	 * @generated
	 */
	EAttribute getAttributeSwap_FirstName();

	/**
	 * Returns the meta object for class '{@link appliedMutations.CompositeMutation <em>Composite Mutation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Mutation</em>'.
	 * @see appliedMutations.CompositeMutation
	 * @generated
	 */
	EClass getCompositeMutation();

	/**
	 * Returns the meta object for the attribute '{@link appliedMutations.CompositeMutation#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see appliedMutations.CompositeMutation#getSize()
	 * @see #getCompositeMutation()
	 * @generated
	 */
	EAttribute getCompositeMutation_Size();

	/**
	 * Returns the meta object for the containment reference list '{@link appliedMutations.CompositeMutation#getMuts <em>Muts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Muts</em>'.
	 * @see appliedMutations.CompositeMutation#getMuts()
	 * @see #getCompositeMutation()
	 * @generated
	 */
	EReference getCompositeMutation_Muts();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ObjectCloned <em>Object Cloned</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Cloned</em>'.
	 * @see appliedMutations.ObjectCloned
	 * @generated
	 */
	EClass getObjectCloned();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ObjectCloned#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ObjectCloned#getObject()
	 * @see #getObjectCloned()
	 * @generated
	 */
	EReference getObjectCloned_Object();

	/**
	 * Returns the meta object for class '{@link appliedMutations.ObjectRetyped <em>Object Retyped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Retyped</em>'.
	 * @see appliedMutations.ObjectRetyped
	 * @generated
	 */
	EClass getObjectRetyped();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ObjectRetyped#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Object</em>'.
	 * @see appliedMutations.ObjectRetyped#getObject()
	 * @see #getObjectRetyped()
	 * @generated
	 */
	EReference getObjectRetyped_Object();

	/**
	 * Returns the meta object for the reference list '{@link appliedMutations.ObjectRetyped#getRemovedObject <em>Removed Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Removed Object</em>'.
	 * @see appliedMutations.ObjectRetyped#getRemovedObject()
	 * @see #getObjectRetyped()
	 * @generated
	 */
	EReference getObjectRetyped_RemovedObject();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ObjectRetyped#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see appliedMutations.ObjectRetyped#getType()
	 * @see #getObjectRetyped()
	 * @generated
	 */
	EReference getObjectRetyped_Type();

	/**
	 * Returns the meta object for the reference '{@link appliedMutations.ObjectRetyped#getNewType <em>New Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Type</em>'.
	 * @see appliedMutations.ObjectRetyped#getNewType()
	 * @see #getObjectRetyped()
	 * @generated
	 */
	EReference getObjectRetyped_NewType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AppliedMutationsFactory getAppliedMutationsFactory();

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
		 * The meta object literal for the '{@link appliedMutations.impl.MutationsImpl <em>Mutations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.MutationsImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getMutations()
		 * @generated
		 */
		EClass MUTATIONS = eINSTANCE.getMutations();

		/**
		 * The meta object literal for the '<em><b>Muts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATIONS__MUTS = eINSTANCE.getMutations_Muts();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.AppMutationImpl <em>App Mutation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.AppMutationImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAppMutation()
		 * @generated
		 */
		EClass APP_MUTATION = eINSTANCE.getAppMutation();

		/**
		 * The meta object literal for the '<em><b>Def</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APP_MUTATION__DEF = eINSTANCE.getAppMutation_Def();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ObjectCreatedImpl <em>Object Created</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ObjectCreatedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectCreated()
		 * @generated
		 */
		EClass OBJECT_CREATED = eINSTANCE.getObjectCreated();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_CREATED__OBJECT = eINSTANCE.getObjectCreated_Object();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ObjectRemovedImpl <em>Object Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ObjectRemovedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectRemoved()
		 * @generated
		 */
		EClass OBJECT_REMOVED = eINSTANCE.getObjectRemoved();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REMOVED__OBJECT = eINSTANCE.getObjectRemoved_Object();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REMOVED__TYPE = eINSTANCE.getObjectRemoved_Type();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ReferenceChangedImpl <em>Reference Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ReferenceChangedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceChanged()
		 * @generated
		 */
		EClass REFERENCE_CHANGED = eINSTANCE.getReferenceChanged();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CHANGED__OBJECT = eINSTANCE.getReferenceChanged_Object();

		/**
		 * The meta object literal for the '<em><b>Src Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_CHANGED__SRC_REF_NAME = eINSTANCE.getReferenceChanged_SrcRefName();

		/**
		 * The meta object literal for the '<em><b>Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_CHANGED__REF_NAME = eINSTANCE.getReferenceChanged_RefName();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CHANGED__FROM = eINSTANCE.getReferenceChanged_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CHANGED__TO = eINSTANCE.getReferenceChanged_To();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.SourceReferenceChangedImpl <em>Source Reference Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.SourceReferenceChangedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getSourceReferenceChanged()
		 * @generated
		 */
		EClass SOURCE_REFERENCE_CHANGED = eINSTANCE.getSourceReferenceChanged();

		/**
		 * The meta object literal for the '<em><b>Old From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_REFERENCE_CHANGED__OLD_FROM = eINSTANCE.getSourceReferenceChanged_OldFrom();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.TargetReferenceChangedImpl <em>Target Reference Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.TargetReferenceChangedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getTargetReferenceChanged()
		 * @generated
		 */
		EClass TARGET_REFERENCE_CHANGED = eINSTANCE.getTargetReferenceChanged();

		/**
		 * The meta object literal for the '<em><b>Old To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_REFERENCE_CHANGED__OLD_TO = eINSTANCE.getTargetReferenceChanged_OldTo();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ReferenceCreatedImpl <em>Reference Created</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ReferenceCreatedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceCreated()
		 * @generated
		 */
		EClass REFERENCE_CREATED = eINSTANCE.getReferenceCreated();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CREATED__OBJECT = eINSTANCE.getReferenceCreated_Object();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_CREATED__REF = eINSTANCE.getReferenceCreated_Ref();

		/**
		 * The meta object literal for the '<em><b>Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_CREATED__REF_NAME = eINSTANCE.getReferenceCreated_RefName();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ReferenceRemovedImpl <em>Reference Removed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ReferenceRemovedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceRemoved()
		 * @generated
		 */
		EClass REFERENCE_REMOVED = eINSTANCE.getReferenceRemoved();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_REMOVED__OBJECT = eINSTANCE.getReferenceRemoved_Object();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_REMOVED__REF = eINSTANCE.getReferenceRemoved_Ref();

		/**
		 * The meta object literal for the '<em><b>Ref Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REMOVED__REF_NAME = eINSTANCE.getReferenceRemoved_RefName();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.InformationChangedImpl <em>Information Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.InformationChangedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getInformationChanged()
		 * @generated
		 */
		EClass INFORMATION_CHANGED = eINSTANCE.getInformationChanged();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFORMATION_CHANGED__OBJECT = eINSTANCE.getInformationChanged_Object();

		/**
		 * The meta object literal for the '<em><b>Att Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFORMATION_CHANGED__ATT_CHANGES = eINSTANCE.getInformationChanged_AttChanges();

		/**
		 * The meta object literal for the '<em><b>Ref Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFORMATION_CHANGED__REF_CHANGES = eINSTANCE.getInformationChanged_RefChanges();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.AttributeChangedImpl <em>Attribute Changed</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.AttributeChangedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAttributeChanged()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGED = eINSTANCE.getAttributeChanged();

		/**
		 * The meta object literal for the '<em><b>Att Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_CHANGED__ATT_NAME = eINSTANCE.getAttributeChanged_AttName();

		/**
		 * The meta object literal for the '<em><b>Old Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_CHANGED__OLD_VAL = eINSTANCE.getAttributeChanged_OldVal();

		/**
		 * The meta object literal for the '<em><b>New Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_CHANGED__NEW_VAL = eINSTANCE.getAttributeChanged_NewVal();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ReferenceSwapImpl <em>Reference Swap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ReferenceSwapImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceSwap()
		 * @generated
		 */
		EClass REFERENCE_SWAP = eINSTANCE.getReferenceSwap();

		/**
		 * The meta object literal for the '<em><b>Ref Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SWAP__REF_OBJECT = eINSTANCE.getReferenceSwap_RefObject();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_SWAP__FIRST_NAME = eINSTANCE.getReferenceSwap_FirstName();

		/**
		 * The meta object literal for the '<em><b>Other From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SWAP__OTHER_FROM = eINSTANCE.getReferenceSwap_OtherFrom();

		/**
		 * The meta object literal for the '<em><b>Other From Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_SWAP__OTHER_FROM_NAME = eINSTANCE.getReferenceSwap_OtherFromName();

		/**
		 * The meta object literal for the '<em><b>Other To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SWAP__OTHER_TO = eINSTANCE.getReferenceSwap_OtherTo();

		/**
		 * The meta object literal for the '<em><b>Other To Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_SWAP__OTHER_TO_NAME = eINSTANCE.getReferenceSwap_OtherToName();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ReferenceAttImpl <em>Reference Att</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ReferenceAttImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getReferenceAtt()
		 * @generated
		 */
		EClass REFERENCE_ATT = eINSTANCE.getReferenceAtt();

		/**
		 * The meta object literal for the '<em><b>Att Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ATT__ATT_NAME = eINSTANCE.getReferenceAtt_AttName();

		/**
		 * The meta object literal for the '<em><b>Old Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ATT__OLD_VAL = eINSTANCE.getReferenceAtt_OldVal();

		/**
		 * The meta object literal for the '<em><b>New Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_ATT__NEW_VAL = eINSTANCE.getReferenceAtt_NewVal();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.AttributeSwapImpl <em>Attribute Swap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.AttributeSwapImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getAttributeSwap()
		 * @generated
		 */
		EClass ATTRIBUTE_SWAP = eINSTANCE.getAttributeSwap();

		/**
		 * The meta object literal for the '<em><b>Att Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_SWAP__ATT_OBJECT = eINSTANCE.getAttributeSwap_AttObject();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_SWAP__FIRST_NAME = eINSTANCE.getAttributeSwap_FirstName();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.CompositeMutationImpl <em>Composite Mutation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.CompositeMutationImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getCompositeMutation()
		 * @generated
		 */
		EClass COMPOSITE_MUTATION = eINSTANCE.getCompositeMutation();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_MUTATION__SIZE = eINSTANCE.getCompositeMutation_Size();

		/**
		 * The meta object literal for the '<em><b>Muts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_MUTATION__MUTS = eINSTANCE.getCompositeMutation_Muts();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ObjectClonedImpl <em>Object Cloned</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ObjectClonedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectCloned()
		 * @generated
		 */
		EClass OBJECT_CLONED = eINSTANCE.getObjectCloned();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_CLONED__OBJECT = eINSTANCE.getObjectCloned_Object();

		/**
		 * The meta object literal for the '{@link appliedMutations.impl.ObjectRetypedImpl <em>Object Retyped</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see appliedMutations.impl.ObjectRetypedImpl
		 * @see appliedMutations.impl.AppliedMutationsPackageImpl#getObjectRetyped()
		 * @generated
		 */
		EClass OBJECT_RETYPED = eINSTANCE.getObjectRetyped();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_RETYPED__OBJECT = eINSTANCE.getObjectRetyped_Object();

		/**
		 * The meta object literal for the '<em><b>Removed Object</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_RETYPED__REMOVED_OBJECT = eINSTANCE.getObjectRetyped_RemovedObject();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_RETYPED__TYPE = eINSTANCE.getObjectRetyped_Type();

		/**
		 * The meta object literal for the '<em><b>New Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_RETYPED__NEW_TYPE = eINSTANCE.getObjectRetyped_NewType();

	}

} //AppliedMutationsPackage
