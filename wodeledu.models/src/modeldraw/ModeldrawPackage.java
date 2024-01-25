/**
 */
package modeldraw;

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
 * @see modeldraw.ModeldrawFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ModeldrawPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modeldraw";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://modeldraw/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "modeldraw";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModeldrawPackage eINSTANCE = modeldraw.impl.ModeldrawPackageImpl.init();

	/**
	 * The meta object id for the '{@link modeldraw.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.ItemImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getItem()
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
	 * The meta object id for the '{@link modeldraw.impl.MutatorDrawImpl <em>Mutator Draw</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.MutatorDrawImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getMutatorDraw()
	 * @generated
	 */
	int MUTATOR_DRAW = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_DRAW__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_DRAW__METAMODEL = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_DRAW__INSTANCES = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mutator Draw</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_DRAW_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mutator Draw</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_DRAW_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.MutatorInstanceImpl <em>Mutator Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.MutatorInstanceImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getMutatorInstance()
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
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__TYPE = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__NODES = ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__RELATIONS = ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE__CONTENTS = ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mutator Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE_FEATURE_COUNT = ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Mutator Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_INSTANCE_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.NamedItemImpl <em>Named Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.NamedItemImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNamedItem()
	 * @generated
	 */
	int NAMED_ITEM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ITEM__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ITEM__ATT_NAME = ITEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ITEM_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.ValuedFeatureImpl <em>Valued Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.ValuedFeatureImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getValuedFeature()
	 * @generated
	 */
	int VALUED_FEATURE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Negation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__NEGATION = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__FEAT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__REF_FEATURE = ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE__VALUE = ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Valued Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE_FEATURE_COUNT = ITEM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Valued Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUED_FEATURE_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.NodeImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = NAMED_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ATT_NAME = NAMED_ITEM__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__FEATURE = NAMED_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REFERENCE = NAMED_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = NAMED_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SHAPE = NAMED_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COLOR = NAMED_ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__STYLE = NAMED_ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Path Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PATH_SHAPE = NAMED_ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TARGET_NODE = NAMED_ITEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TARGET_FEATURE = NAMED_ITEM_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = NAMED_ITEM_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = NAMED_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.RelationImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = NAMED_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ATT_NAME = NAMED_ITEM__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__REFERENCE = NAMED_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__REF_TYPE = NAMED_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__LABEL = NAMED_ITEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Src decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SRC_DECORATION = NAMED_ITEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Src label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__SRC_LABEL = NAMED_ITEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Tar decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TAR_DECORATION = NAMED_ITEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Tar label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TAR_LABEL = NAMED_ITEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__FEATURE = NAMED_ITEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_NODE = NAMED_ITEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_FEATURE = NAMED_ITEM_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = NAMED_ITEM_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = NAMED_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.EdgeImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ATT_NAME = RELATION__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__REFERENCE = RELATION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__REF_TYPE = RELATION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__LABEL = RELATION__LABEL;

	/**
	 * The feature id for the '<em><b>Src decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SRC_DECORATION = RELATION__SRC_DECORATION;

	/**
	 * The feature id for the '<em><b>Src label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SRC_LABEL = RELATION__SRC_LABEL;

	/**
	 * The feature id for the '<em><b>Tar decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TAR_DECORATION = RELATION__TAR_DECORATION;

	/**
	 * The feature id for the '<em><b>Tar label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TAR_LABEL = RELATION__TAR_LABEL;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__FEATURE = RELATION__FEATURE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET_NODE = RELATION__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET_FEATURE = RELATION__TARGET_FEATURE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.LevelImpl <em>Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.LevelImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getLevel()
	 * @generated
	 */
	int LEVEL = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__NAME = RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__ATT_NAME = RELATION__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__REFERENCE = RELATION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__REF_TYPE = RELATION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__LABEL = RELATION__LABEL;

	/**
	 * The feature id for the '<em><b>Src decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__SRC_DECORATION = RELATION__SRC_DECORATION;

	/**
	 * The feature id for the '<em><b>Src label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__SRC_LABEL = RELATION__SRC_LABEL;

	/**
	 * The feature id for the '<em><b>Tar decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__TAR_DECORATION = RELATION__TAR_DECORATION;

	/**
	 * The feature id for the '<em><b>Tar label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__TAR_LABEL = RELATION__TAR_LABEL;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__FEATURE = RELATION__FEATURE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__TARGET_NODE = RELATION__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__TARGET_FEATURE = RELATION__TARGET_FEATURE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL__UPPER = RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_FEATURE_COUNT = RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OPERATION_COUNT = RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.NodeEnumeratorImpl <em>Node Enumerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.NodeEnumeratorImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeEnumerator()
	 * @generated
	 */
	int NODE_ENUMERATOR = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ENUMERATOR__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Att</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ENUMERATOR__ATT = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enumerator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ENUMERATOR__ENUMERATOR = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ENUMERATOR_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ENUMERATOR_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.EnumeratorImpl <em>Enumerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.EnumeratorImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getEnumerator()
	 * @generated
	 */
	int ENUMERATOR = 10;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__LITERAL = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Enumerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.InformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.InformationImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getInformation()
	 * @generated
	 */
	int INFORMATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__NAME = ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__TYPE = ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Att</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION__ATT = ITEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_FEATURE_COUNT = ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFORMATION_OPERATION_COUNT = ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.impl.ContentImpl <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.impl.ContentImpl
	 * @see modeldraw.impl.ModeldrawPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__NAME = NAMED_ITEM__NAME;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__ATT_NAME = NAMED_ITEM__ATT_NAME;

	/**
	 * The feature id for the '<em><b>Nodenum</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__NODENUM = NAMED_ITEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Info</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__INFO = NAMED_ITEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT__SYMBOL = NAMED_ITEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = NAMED_ITEM_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OPERATION_COUNT = NAMED_ITEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modeldraw.DrawType <em>Draw Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.DrawType
	 * @see modeldraw.impl.ModeldrawPackageImpl#getDrawType()
	 * @generated
	 */
	int DRAW_TYPE = 13;

	/**
	 * The meta object id for the '{@link modeldraw.NodeType <em>Node Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.NodeType
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeType()
	 * @generated
	 */
	int NODE_TYPE = 14;

	/**
	 * The meta object id for the '{@link modeldraw.NodeShape <em>Node Shape</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.NodeShape
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeShape()
	 * @generated
	 */
	int NODE_SHAPE = 15;

	/**
	 * The meta object id for the '{@link modeldraw.NodeColor <em>Node Color</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.NodeColor
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeColor()
	 * @generated
	 */
	int NODE_COLOR = 16;

	/**
	 * The meta object id for the '{@link modeldraw.Decoration <em>Decoration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.Decoration
	 * @see modeldraw.impl.ModeldrawPackageImpl#getDecoration()
	 * @generated
	 */
	int DECORATION = 17;

	/**
	 * The meta object id for the '{@link modeldraw.NodeStyle <em>Node Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modeldraw.NodeStyle
	 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeStyle()
	 * @generated
	 */
	int NODE_STYLE = 18;


	/**
	 * Returns the meta object for class '{@link modeldraw.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see modeldraw.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Item#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see modeldraw.Item#getName()
	 * @see #getItem()
	 * @generated
	 */
	EReference getItem_Name();

	/**
	 * Returns the meta object for class '{@link modeldraw.MutatorDraw <em>Mutator Draw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Draw</em>'.
	 * @see modeldraw.MutatorDraw
	 * @generated
	 */
	EClass getMutatorDraw();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.MutatorDraw#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel</em>'.
	 * @see modeldraw.MutatorDraw#getMetamodel()
	 * @see #getMutatorDraw()
	 * @generated
	 */
	EAttribute getMutatorDraw_Metamodel();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.MutatorDraw#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see modeldraw.MutatorDraw#getInstances()
	 * @see #getMutatorDraw()
	 * @generated
	 */
	EReference getMutatorDraw_Instances();

	/**
	 * Returns the meta object for class '{@link modeldraw.MutatorInstance <em>Mutator Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Instance</em>'.
	 * @see modeldraw.MutatorInstance
	 * @generated
	 */
	EClass getMutatorInstance();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.MutatorInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see modeldraw.MutatorInstance#getType()
	 * @see #getMutatorInstance()
	 * @generated
	 */
	EAttribute getMutatorInstance_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.MutatorInstance#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see modeldraw.MutatorInstance#getNodes()
	 * @see #getMutatorInstance()
	 * @generated
	 */
	EReference getMutatorInstance_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.MutatorInstance#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see modeldraw.MutatorInstance#getRelations()
	 * @see #getMutatorInstance()
	 * @generated
	 */
	EReference getMutatorInstance_Relations();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.MutatorInstance#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see modeldraw.MutatorInstance#getContents()
	 * @see #getMutatorInstance()
	 * @generated
	 */
	EReference getMutatorInstance_Contents();

	/**
	 * Returns the meta object for class '{@link modeldraw.NamedItem <em>Named Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Item</em>'.
	 * @see modeldraw.NamedItem
	 * @generated
	 */
	EClass getNamedItem();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.NamedItem#getAttName <em>Att Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att Name</em>'.
	 * @see modeldraw.NamedItem#getAttName()
	 * @see #getNamedItem()
	 * @generated
	 */
	EReference getNamedItem_AttName();

	/**
	 * Returns the meta object for class '{@link modeldraw.ValuedFeature <em>Valued Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valued Feature</em>'.
	 * @see modeldraw.ValuedFeature
	 * @generated
	 */
	EClass getValuedFeature();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.ValuedFeature#isNegation <em>Negation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Negation</em>'.
	 * @see modeldraw.ValuedFeature#isNegation()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EAttribute getValuedFeature_Negation();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.ValuedFeature#getFeat <em>Feat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feat</em>'.
	 * @see modeldraw.ValuedFeature#getFeat()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EReference getValuedFeature_Feat();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.ValuedFeature#getRefFeature <em>Ref Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Feature</em>'.
	 * @see modeldraw.ValuedFeature#getRefFeature()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EReference getValuedFeature_RefFeature();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.ValuedFeature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see modeldraw.ValuedFeature#getValue()
	 * @see #getValuedFeature()
	 * @generated
	 */
	EAttribute getValuedFeature_Value();

	/**
	 * Returns the meta object for class '{@link modeldraw.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see modeldraw.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Node#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature</em>'.
	 * @see modeldraw.Node#getFeature()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Feature();

	/**
	 * Returns the meta object for the reference list '{@link modeldraw.Node#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see modeldraw.Node#getReference()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Reference();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see modeldraw.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Type();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Node#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see modeldraw.Node#getShape()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Shape();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Node#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see modeldraw.Node#getColor()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Color();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Node#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see modeldraw.Node#getStyle()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Style();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Node#getPathShape <em>Path Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Shape</em>'.
	 * @see modeldraw.Node#getPathShape()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_PathShape();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Node#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see modeldraw.Node#getTargetNode()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_TargetNode();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Node#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Feature</em>'.
	 * @see modeldraw.Node#getTargetFeature()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_TargetFeature();

	/**
	 * Returns the meta object for class '{@link modeldraw.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see modeldraw.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the reference list '{@link modeldraw.Relation#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see modeldraw.Relation#getReference()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Reference();

	/**
	 * Returns the meta object for the reference list '{@link modeldraw.Relation#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref Type</em>'.
	 * @see modeldraw.Relation#getRefType()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_RefType();

	/**
	 * Returns the meta object for the reference list '{@link modeldraw.Relation#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Label</em>'.
	 * @see modeldraw.Relation#getLabel()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Label();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Relation#getSrc_decoration <em>Src decoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src decoration</em>'.
	 * @see modeldraw.Relation#getSrc_decoration()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Src_decoration();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Relation#getSrc_label <em>Src label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Src label</em>'.
	 * @see modeldraw.Relation#getSrc_label()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Src_label();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Relation#getTar_decoration <em>Tar decoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tar decoration</em>'.
	 * @see modeldraw.Relation#getTar_decoration()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Tar_decoration();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Relation#getTar_label <em>Tar label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tar label</em>'.
	 * @see modeldraw.Relation#getTar_label()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Tar_label();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Relation#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature</em>'.
	 * @see modeldraw.Relation#getFeature()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Feature();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Relation#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see modeldraw.Relation#getTargetNode()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_TargetNode();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Relation#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Feature</em>'.
	 * @see modeldraw.Relation#getTargetFeature()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_TargetFeature();

	/**
	 * Returns the meta object for class '{@link modeldraw.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see modeldraw.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see modeldraw.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see modeldraw.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for class '{@link modeldraw.Level <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level</em>'.
	 * @see modeldraw.Level
	 * @generated
	 */
	EClass getLevel();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Level#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper</em>'.
	 * @see modeldraw.Level#getUpper()
	 * @see #getLevel()
	 * @generated
	 */
	EReference getLevel_Upper();

	/**
	 * Returns the meta object for class '{@link modeldraw.NodeEnumerator <em>Node Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Enumerator</em>'.
	 * @see modeldraw.NodeEnumerator
	 * @generated
	 */
	EClass getNodeEnumerator();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.NodeEnumerator#getAtt <em>Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att</em>'.
	 * @see modeldraw.NodeEnumerator#getAtt()
	 * @see #getNodeEnumerator()
	 * @generated
	 */
	EReference getNodeEnumerator_Att();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.NodeEnumerator#getEnumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enumerator</em>'.
	 * @see modeldraw.NodeEnumerator#getEnumerator()
	 * @see #getNodeEnumerator()
	 * @generated
	 */
	EReference getNodeEnumerator_Enumerator();

	/**
	 * Returns the meta object for class '{@link modeldraw.Enumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerator</em>'.
	 * @see modeldraw.Enumerator
	 * @generated
	 */
	EClass getEnumerator();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Enumerator#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see modeldraw.Enumerator#getLiteral()
	 * @see #getEnumerator()
	 * @generated
	 */
	EReference getEnumerator_Literal();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Enumerator#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see modeldraw.Enumerator#getValue()
	 * @see #getEnumerator()
	 * @generated
	 */
	EAttribute getEnumerator_Value();

	/**
	 * Returns the meta object for class '{@link modeldraw.Information <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see modeldraw.Information
	 * @generated
	 */
	EClass getInformation();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Information#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see modeldraw.Information#getType()
	 * @see #getInformation()
	 * @generated
	 */
	EReference getInformation_Type();

	/**
	 * Returns the meta object for the reference '{@link modeldraw.Information#getAtt <em>Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att</em>'.
	 * @see modeldraw.Information#getAtt()
	 * @see #getInformation()
	 * @generated
	 */
	EReference getInformation_Att();

	/**
	 * Returns the meta object for class '{@link modeldraw.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see modeldraw.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Content#getNodenum <em>Nodenum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodenum</em>'.
	 * @see modeldraw.Content#getNodenum()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Nodenum();

	/**
	 * Returns the meta object for the containment reference list '{@link modeldraw.Content#getInfo <em>Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Info</em>'.
	 * @see modeldraw.Content#getInfo()
	 * @see #getContent()
	 * @generated
	 */
	EReference getContent_Info();

	/**
	 * Returns the meta object for the attribute '{@link modeldraw.Content#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see modeldraw.Content#getSymbol()
	 * @see #getContent()
	 * @generated
	 */
	EAttribute getContent_Symbol();

	/**
	 * Returns the meta object for enum '{@link modeldraw.DrawType <em>Draw Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Draw Type</em>'.
	 * @see modeldraw.DrawType
	 * @generated
	 */
	EEnum getDrawType();

	/**
	 * Returns the meta object for enum '{@link modeldraw.NodeType <em>Node Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Type</em>'.
	 * @see modeldraw.NodeType
	 * @generated
	 */
	EEnum getNodeType();

	/**
	 * Returns the meta object for enum '{@link modeldraw.NodeShape <em>Node Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Shape</em>'.
	 * @see modeldraw.NodeShape
	 * @generated
	 */
	EEnum getNodeShape();

	/**
	 * Returns the meta object for enum '{@link modeldraw.NodeColor <em>Node Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Color</em>'.
	 * @see modeldraw.NodeColor
	 * @generated
	 */
	EEnum getNodeColor();

	/**
	 * Returns the meta object for enum '{@link modeldraw.Decoration <em>Decoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Decoration</em>'.
	 * @see modeldraw.Decoration
	 * @generated
	 */
	EEnum getDecoration();

	/**
	 * Returns the meta object for enum '{@link modeldraw.NodeStyle <em>Node Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Node Style</em>'.
	 * @see modeldraw.NodeStyle
	 * @generated
	 */
	EEnum getNodeStyle();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModeldrawFactory getModeldrawFactory();

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
		 * The meta object literal for the '{@link modeldraw.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.ItemImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getItem()
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
		 * The meta object literal for the '{@link modeldraw.impl.MutatorDrawImpl <em>Mutator Draw</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.MutatorDrawImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getMutatorDraw()
		 * @generated
		 */
		EClass MUTATOR_DRAW = eINSTANCE.getMutatorDraw();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR_DRAW__METAMODEL = eINSTANCE.getMutatorDraw_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_DRAW__INSTANCES = eINSTANCE.getMutatorDraw_Instances();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.MutatorInstanceImpl <em>Mutator Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.MutatorInstanceImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getMutatorInstance()
		 * @generated
		 */
		EClass MUTATOR_INSTANCE = eINSTANCE.getMutatorInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR_INSTANCE__TYPE = eINSTANCE.getMutatorInstance_Type();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_INSTANCE__NODES = eINSTANCE.getMutatorInstance_Nodes();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_INSTANCE__RELATIONS = eINSTANCE.getMutatorInstance_Relations();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_INSTANCE__CONTENTS = eINSTANCE.getMutatorInstance_Contents();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.NamedItemImpl <em>Named Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.NamedItemImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNamedItem()
		 * @generated
		 */
		EClass NAMED_ITEM = eINSTANCE.getNamedItem();

		/**
		 * The meta object literal for the '<em><b>Att Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ITEM__ATT_NAME = eINSTANCE.getNamedItem_AttName();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.ValuedFeatureImpl <em>Valued Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.ValuedFeatureImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getValuedFeature()
		 * @generated
		 */
		EClass VALUED_FEATURE = eINSTANCE.getValuedFeature();

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
		 * The meta object literal for the '{@link modeldraw.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.NodeImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__FEATURE = eINSTANCE.getNode_Feature();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__REFERENCE = eINSTANCE.getNode_Reference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__TYPE = eINSTANCE.getNode_Type();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__SHAPE = eINSTANCE.getNode_Shape();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__COLOR = eINSTANCE.getNode_Color();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__STYLE = eINSTANCE.getNode_Style();

		/**
		 * The meta object literal for the '<em><b>Path Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__PATH_SHAPE = eINSTANCE.getNode_PathShape();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TARGET_NODE = eINSTANCE.getNode_TargetNode();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TARGET_FEATURE = eINSTANCE.getNode_TargetFeature();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.RelationImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__REFERENCE = eINSTANCE.getRelation_Reference();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__REF_TYPE = eINSTANCE.getRelation_RefType();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__LABEL = eINSTANCE.getRelation_Label();

		/**
		 * The meta object literal for the '<em><b>Src decoration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__SRC_DECORATION = eINSTANCE.getRelation_Src_decoration();

		/**
		 * The meta object literal for the '<em><b>Src label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__SRC_LABEL = eINSTANCE.getRelation_Src_label();

		/**
		 * The meta object literal for the '<em><b>Tar decoration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TAR_DECORATION = eINSTANCE.getRelation_Tar_decoration();

		/**
		 * The meta object literal for the '<em><b>Tar label</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TAR_LABEL = eINSTANCE.getRelation_Tar_label();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__FEATURE = eINSTANCE.getRelation_Feature();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TARGET_NODE = eINSTANCE.getRelation_TargetNode();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__TARGET_FEATURE = eINSTANCE.getRelation_TargetFeature();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.EdgeImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.LevelImpl <em>Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.LevelImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getLevel()
		 * @generated
		 */
		EClass LEVEL = eINSTANCE.getLevel();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL__UPPER = eINSTANCE.getLevel_Upper();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.NodeEnumeratorImpl <em>Node Enumerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.NodeEnumeratorImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeEnumerator()
		 * @generated
		 */
		EClass NODE_ENUMERATOR = eINSTANCE.getNodeEnumerator();

		/**
		 * The meta object literal for the '<em><b>Att</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_ENUMERATOR__ATT = eINSTANCE.getNodeEnumerator_Att();

		/**
		 * The meta object literal for the '<em><b>Enumerator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_ENUMERATOR__ENUMERATOR = eINSTANCE.getNodeEnumerator_Enumerator();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.EnumeratorImpl <em>Enumerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.EnumeratorImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getEnumerator()
		 * @generated
		 */
		EClass ENUMERATOR = eINSTANCE.getEnumerator();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATOR__LITERAL = eINSTANCE.getEnumerator_Literal();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATOR__VALUE = eINSTANCE.getEnumerator_Value();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.InformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.InformationImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getInformation()
		 * @generated
		 */
		EClass INFORMATION = eINSTANCE.getInformation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFORMATION__TYPE = eINSTANCE.getInformation_Type();

		/**
		 * The meta object literal for the '<em><b>Att</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFORMATION__ATT = eINSTANCE.getInformation_Att();

		/**
		 * The meta object literal for the '{@link modeldraw.impl.ContentImpl <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.impl.ContentImpl
		 * @see modeldraw.impl.ModeldrawPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '<em><b>Nodenum</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__NODENUM = eINSTANCE.getContent_Nodenum();

		/**
		 * The meta object literal for the '<em><b>Info</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTENT__INFO = eINSTANCE.getContent_Info();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENT__SYMBOL = eINSTANCE.getContent_Symbol();

		/**
		 * The meta object literal for the '{@link modeldraw.DrawType <em>Draw Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.DrawType
		 * @see modeldraw.impl.ModeldrawPackageImpl#getDrawType()
		 * @generated
		 */
		EEnum DRAW_TYPE = eINSTANCE.getDrawType();

		/**
		 * The meta object literal for the '{@link modeldraw.NodeType <em>Node Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.NodeType
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeType()
		 * @generated
		 */
		EEnum NODE_TYPE = eINSTANCE.getNodeType();

		/**
		 * The meta object literal for the '{@link modeldraw.NodeShape <em>Node Shape</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.NodeShape
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeShape()
		 * @generated
		 */
		EEnum NODE_SHAPE = eINSTANCE.getNodeShape();

		/**
		 * The meta object literal for the '{@link modeldraw.NodeColor <em>Node Color</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.NodeColor
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeColor()
		 * @generated
		 */
		EEnum NODE_COLOR = eINSTANCE.getNodeColor();

		/**
		 * The meta object literal for the '{@link modeldraw.Decoration <em>Decoration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.Decoration
		 * @see modeldraw.impl.ModeldrawPackageImpl#getDecoration()
		 * @generated
		 */
		EEnum DECORATION = eINSTANCE.getDecoration();

		/**
		 * The meta object literal for the '{@link modeldraw.NodeStyle <em>Node Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modeldraw.NodeStyle
		 * @see modeldraw.impl.ModeldrawPackageImpl#getNodeStyle()
		 * @generated
		 */
		EEnum NODE_STYLE = eINSTANCE.getNodeStyle();

	}

} //ModeldrawPackage
