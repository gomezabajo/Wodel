/**
 */
package mutatormetrics;

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
 * @see mutatormetrics.MutatormetricsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface MutatormetricsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mutatormetrics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mutatormetrics/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mutatormetrics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatormetricsPackage eINSTANCE = mutatormetrics.impl.MutatormetricsPackageImpl.init();

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.MutatorMetricsImpl <em>Mutator Metrics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.MutatorMetricsImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getMutatorMetrics()
	 * @generated
	 */
	int MUTATOR_METRICS = 0;

	/**
	 * The feature id for the '<em><b>Trees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_METRICS__TREES = 0;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_METRICS__CLASSES = 1;

	/**
	 * The number of structural features of the '<em>Mutator Metrics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_METRICS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Mutator Metrics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_METRICS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.TreeImpl <em>Tree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.TreeImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getTree()
	 * @generated
	 */
	int TREE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Mutants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__MUTANTS = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__CLASSES = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE__PATH = 3;

	/**
	 * The number of structural features of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.FolderImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = TREE__NAME;

	/**
	 * The feature id for the '<em><b>Mutants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__MUTANTS = TREE__MUTANTS;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__CLASSES = TREE__CLASSES;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__PATH = TREE__PATH;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = TREE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = TREE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.MutantImpl <em>Mutant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.MutantImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getMutant()
	 * @generated
	 */
	int MUTANT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT__NAME = FOLDER__NAME;

	/**
	 * The feature id for the '<em><b>Mutants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT__MUTANTS = FOLDER__MUTANTS;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT__CLASSES = FOLDER__CLASSES;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT__PATH = FOLDER__PATH;

	/**
	 * The number of structural features of the '<em>Mutant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT_FEATURE_COUNT = FOLDER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mutant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTANT_OPERATION_COUNT = FOLDER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.ObjectImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__CREATED = 1;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__MODIFIED = 2;

	/**
	 * The feature id for the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__REMOVED = 3;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.ClassImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CREATED = OBJECT__CREATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MODIFIED = OBJECT__MODIFIED;

	/**
	 * The feature id for the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REMOVED = OBJECT__REMOVED;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFERENCES = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ccreated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CCREATED = OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Cmodified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CMODIFIED = OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Cremoved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CREMOVED = OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.ReferenceImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__CREATED = OBJECT__CREATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__MODIFIED = OBJECT__MODIFIED;

	/**
	 * The feature id for the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__REMOVED = OBJECT__REMOVED;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatormetrics.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatormetrics.impl.AttributeImpl
	 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__CREATED = OBJECT__CREATED;

	/**
	 * The feature id for the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MODIFIED = OBJECT__MODIFIED;

	/**
	 * The feature id for the '<em><b>Removed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__REMOVED = OBJECT__REMOVED;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link mutatormetrics.MutatorMetrics <em>Mutator Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Metrics</em>'.
	 * @see mutatormetrics.MutatorMetrics
	 * @generated
	 */
	EClass getMutatorMetrics();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.MutatorMetrics#getTrees <em>Trees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Trees</em>'.
	 * @see mutatormetrics.MutatorMetrics#getTrees()
	 * @see #getMutatorMetrics()
	 * @generated
	 */
	EReference getMutatorMetrics_Trees();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.MutatorMetrics#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see mutatormetrics.MutatorMetrics#getClasses()
	 * @see #getMutatorMetrics()
	 * @generated
	 */
	EReference getMutatorMetrics_Classes();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Tree <em>Tree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree</em>'.
	 * @see mutatormetrics.Tree
	 * @generated
	 */
	EClass getTree();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Tree#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatormetrics.Tree#getName()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.Tree#getMutants <em>Mutants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mutants</em>'.
	 * @see mutatormetrics.Tree#getMutants()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Mutants();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.Tree#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see mutatormetrics.Tree#getClasses()
	 * @see #getTree()
	 * @generated
	 */
	EReference getTree_Classes();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Tree#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see mutatormetrics.Tree#getPath()
	 * @see #getTree()
	 * @generated
	 */
	EAttribute getTree_Path();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see mutatormetrics.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Mutant <em>Mutant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutant</em>'.
	 * @see mutatormetrics.Mutant
	 * @generated
	 */
	EClass getMutant();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see mutatormetrics.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Object#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatormetrics.Object#getName()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Object#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see mutatormetrics.Object#getCreated()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Created();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Object#getModified <em>Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modified</em>'.
	 * @see mutatormetrics.Object#getModified()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Modified();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Object#getRemoved <em>Removed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Removed</em>'.
	 * @see mutatormetrics.Object#getRemoved()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Removed();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see mutatormetrics.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see mutatormetrics.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatormetrics.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see mutatormetrics.Class#getReferences()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_References();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Class#getCcreated <em>Ccreated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ccreated</em>'.
	 * @see mutatormetrics.Class#getCcreated()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Ccreated();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Class#getCmodified <em>Cmodified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cmodified</em>'.
	 * @see mutatormetrics.Class#getCmodified()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Cmodified();

	/**
	 * Returns the meta object for the attribute '{@link mutatormetrics.Class#getCremoved <em>Cremoved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cremoved</em>'.
	 * @see mutatormetrics.Class#getCremoved()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Cremoved();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see mutatormetrics.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for class '{@link mutatormetrics.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see mutatormetrics.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MutatormetricsFactory getMutatormetricsFactory();

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
		 * The meta object literal for the '{@link mutatormetrics.impl.MutatorMetricsImpl <em>Mutator Metrics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.MutatorMetricsImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getMutatorMetrics()
		 * @generated
		 */
		EClass MUTATOR_METRICS = eINSTANCE.getMutatorMetrics();

		/**
		 * The meta object literal for the '<em><b>Trees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_METRICS__TREES = eINSTANCE.getMutatorMetrics_Trees();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_METRICS__CLASSES = eINSTANCE.getMutatorMetrics_Classes();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.TreeImpl <em>Tree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.TreeImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getTree()
		 * @generated
		 */
		EClass TREE = eINSTANCE.getTree();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__NAME = eINSTANCE.getTree_Name();

		/**
		 * The meta object literal for the '<em><b>Mutants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__MUTANTS = eINSTANCE.getTree_Mutants();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREE__CLASSES = eINSTANCE.getTree_Classes();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREE__PATH = eINSTANCE.getTree_Path();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.FolderImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.MutantImpl <em>Mutant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.MutantImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getMutant()
		 * @generated
		 */
		EClass MUTANT = eINSTANCE.getMutant();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.ObjectImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__NAME = eINSTANCE.getObject_Name();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__CREATED = eINSTANCE.getObject_Created();

		/**
		 * The meta object literal for the '<em><b>Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__MODIFIED = eINSTANCE.getObject_Modified();

		/**
		 * The meta object literal for the '<em><b>Removed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__REMOVED = eINSTANCE.getObject_Removed();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.ClassImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REFERENCES = eINSTANCE.getClass_References();

		/**
		 * The meta object literal for the '<em><b>Ccreated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__CCREATED = eINSTANCE.getClass_Ccreated();

		/**
		 * The meta object literal for the '<em><b>Cmodified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__CMODIFIED = eINSTANCE.getClass_Cmodified();

		/**
		 * The meta object literal for the '<em><b>Cremoved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__CREMOVED = eINSTANCE.getClass_Cremoved();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.ReferenceImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '{@link mutatormetrics.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatormetrics.impl.AttributeImpl
		 * @see mutatormetrics.impl.MutatormetricsPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

	}

} //MutatormetricsPackage
