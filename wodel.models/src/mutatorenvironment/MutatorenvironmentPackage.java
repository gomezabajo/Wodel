/**
 */
package mutatorenvironment;

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
 * @see mutatorenvironment.MutatorenvironmentFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface MutatorenvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mutatorenvironment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://mutatorenvironment/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mutatorenvironment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MutatorenvironmentPackage eINSTANCE = mutatorenvironment.impl.MutatorenvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.MutatorEnvironmentImpl <em>Mutator Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.MutatorEnvironmentImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMutatorEnvironment()
	 * @generated
	 */
	int MUTATOR_ENVIRONMENT = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT__COMMANDS = 1;

	/**
	 * The feature id for the '<em><b>Load</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT__LOAD = 2;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT__BLOCKS = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT__CONSTRAINTS = 4;

	/**
	 * The number of structural features of the '<em>Mutator Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Mutator Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_ENVIRONMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.DefinitionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__METAMODEL = 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.LibraryImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 2;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__METAMODEL = DEFINITION__METAMODEL;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ProgramImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 3;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__METAMODEL = DEFINITION__METAMODEL;

	/**
	 * The feature id for the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__OUTPUT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__NUM = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__SOURCE = DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__DESCRIPTION = DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exhaustive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__EXHAUSTIVE = DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__RESOURCES = DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ObjectEmitterImpl <em>Object Emitter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ObjectEmitterImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObjectEmitter()
	 * @generated
	 */
	int OBJECT_EMITTER = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EMITTER__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EMITTER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EMITTER__TYPES = 2;

	/**
	 * The number of structural features of the '<em>Object Emitter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EMITTER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Object Emitter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_EMITTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.MutatorImpl <em>Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.MutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMutator()
	 * @generated
	 */
	int MUTATOR = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__TYPE = OBJECT_EMITTER__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__NAME = OBJECT_EMITTER__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__TYPES = OBJECT_EMITTER__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__MIN = OBJECT_EMITTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__MAX = OBJECT_EMITTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR__FIXED = OBJECT_EMITTER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_FEATURE_COUNT = OBJECT_EMITTER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATOR_OPERATION_COUNT = OBJECT_EMITTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CompositeMutatorImpl <em>Composite Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CompositeMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompositeMutator()
	 * @generated
	 */
	int COMPOSITE_MUTATOR = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR__COMMANDS = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.LoadImpl <em>Load</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.LoadImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLoad()
	 * @generated
	 */
	int LOAD = 7;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD__FILE = 0;

	/**
	 * The number of structural features of the '<em>Load</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Load</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CreateObjectMutatorImpl <em>Create Object Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CreateObjectMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCreateObjectMutator()
	 * @generated
	 */
	int CREATE_OBJECT_MUTATOR = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__CONTAINER = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__ATTRIBUTES = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR__REFERENCES = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Create Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_OBJECT_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ObSelectionStrategyImpl <em>Ob Selection Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ObSelectionStrategyImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObSelectionStrategy()
	 * @generated
	 */
	int OB_SELECTION_STRATEGY = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__TYPE = OBJECT_EMITTER__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__NAME = OBJECT_EMITTER__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__TYPES = OBJECT_EMITTER__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__REF_TYPE = OBJECT_EMITTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__EXPRESSION = OBJECT_EMITTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__RESOURCE = OBJECT_EMITTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__REF_REF_TYPE = OBJECT_EMITTER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY__REF_REF_REF_TYPE = OBJECT_EMITTER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Ob Selection Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY_FEATURE_COUNT = OBJECT_EMITTER_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Ob Selection Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OB_SELECTION_STRATEGY_OPERATION_COUNT = OBJECT_EMITTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomSelectionImpl <em>Random Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomSelection()
	 * @generated
	 */
	int RANDOM_SELECTION = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__TYPE = OB_SELECTION_STRATEGY__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__NAME = OB_SELECTION_STRATEGY__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__TYPES = OB_SELECTION_STRATEGY__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__REF_TYPE = OB_SELECTION_STRATEGY__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__EXPRESSION = OB_SELECTION_STRATEGY__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__RESOURCE = OB_SELECTION_STRATEGY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION__REF_REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Random Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION_FEATURE_COUNT = OB_SELECTION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_SELECTION_OPERATION_COUNT = OB_SELECTION_STRATEGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomTypeSelectionImpl <em>Random Type Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomTypeSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomTypeSelection()
	 * @generated
	 */
	int RANDOM_TYPE_SELECTION = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__TYPE = RANDOM_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__NAME = RANDOM_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__TYPES = RANDOM_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__REF_TYPE = RANDOM_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__EXPRESSION = RANDOM_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__RESOURCE = RANDOM_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__REF_REF_TYPE = RANDOM_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION__REF_REF_REF_TYPE = RANDOM_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Random Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION_FEATURE_COUNT = RANDOM_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_SELECTION_OPERATION_COUNT = RANDOM_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificSelectionImpl <em>Specific Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificSelection()
	 * @generated
	 */
	int SPECIFIC_SELECTION = 28;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__TYPE = OB_SELECTION_STRATEGY__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__NAME = OB_SELECTION_STRATEGY__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__TYPES = OB_SELECTION_STRATEGY__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__REF_TYPE = OB_SELECTION_STRATEGY__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__EXPRESSION = OB_SELECTION_STRATEGY__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__RESOURCE = OB_SELECTION_STRATEGY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION__REF_REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Specific Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_FEATURE_COUNT = OB_SELECTION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Specific Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_SELECTION_OPERATION_COUNT = OB_SELECTION_STRATEGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificObjectSelectionImpl <em>Specific Object Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificObjectSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificObjectSelection()
	 * @generated
	 */
	int SPECIFIC_OBJECT_SELECTION = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__TYPE = SPECIFIC_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__NAME = SPECIFIC_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__TYPES = SPECIFIC_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__REF_TYPE = SPECIFIC_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__EXPRESSION = SPECIFIC_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__RESOURCE = SPECIFIC_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__REF_REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION__OBJ_SEL = SPECIFIC_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Object Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION_FEATURE_COUNT = SPECIFIC_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Object Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_OBJECT_SELECTION_OPERATION_COUNT = SPECIFIC_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeSetImpl <em>Attribute Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeSetImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeSet()
	 * @generated
	 */
	int ATTRIBUTE_SET = 41;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET__ATTRIBUTE = 0;

	/**
	 * The number of structural features of the '<em>Attribute Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Attribute Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeScalarImpl <em>Attribute Scalar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeScalarImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeScalar()
	 * @generated
	 */
	int ATTRIBUTE_SCALAR = 13;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SCALAR__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SCALAR__VALUE = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SCALAR_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Scalar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SCALAR_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeEvaluationTypeImpl <em>Attribute Evaluation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeEvaluationTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeEvaluationType()
	 * @generated
	 */
	int ATTRIBUTE_EVALUATION_TYPE = 70;

	/**
	 * The number of structural features of the '<em>Attribute Evaluation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Attribute Evaluation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeType()
	 * @generated
	 */
	int ATTRIBUTE_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE__OPERATOR = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE_FEATURE_COUNT = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_TYPE_OPERATION_COUNT = ATTRIBUTE_EVALUATION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.BooleanTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificBooleanTypeImpl <em>Specific Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificBooleanTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificBooleanType()
	 * @generated
	 */
	int SPECIFIC_BOOLEAN_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_BOOLEAN_TYPE__OPERATOR = BOOLEAN_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_BOOLEAN_TYPE__VALUE = BOOLEAN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_BOOLEAN_TYPE_FEATURE_COUNT = BOOLEAN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_BOOLEAN_TYPE_OPERATION_COUNT = BOOLEAN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomBooleanTypeImpl <em>Random Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomBooleanTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomBooleanType()
	 * @generated
	 */
	int RANDOM_BOOLEAN_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_BOOLEAN_TYPE__OPERATOR = BOOLEAN_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_BOOLEAN_TYPE__ALLOWS_NULL = BOOLEAN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_BOOLEAN_TYPE_FEATURE_COUNT = BOOLEAN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Random Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_BOOLEAN_TYPE_OPERATION_COUNT = BOOLEAN_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.StringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificStringTypeImpl <em>Specific String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificStringType()
	 * @generated
	 */
	int SPECIFIC_STRING_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STRING_TYPE__VALUE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomStringTypeImpl <em>Random String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomStringType()
	 * @generated
	 */
	int RANDOM_STRING_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE__MIN = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE__MAX = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE__ALLOWS_NULL = STRING_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Random String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Random String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.NumberTypeImpl <em>Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.NumberTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getNumberType()
	 * @generated
	 */
	int NUMBER_TYPE = 73;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.IntegerTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 21;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__OPERATOR = NUMBER_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_OPERATION_COUNT = NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificIntegerTypeImpl <em>Specific Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificIntegerTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificIntegerType()
	 * @generated
	 */
	int SPECIFIC_INTEGER_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_INTEGER_TYPE__OPERATOR = INTEGER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_INTEGER_TYPE__VALUE = INTEGER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_INTEGER_TYPE_FEATURE_COUNT = INTEGER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_INTEGER_TYPE_OPERATION_COUNT = INTEGER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomIntegerTypeImpl <em>Random Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomIntegerTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomIntegerType()
	 * @generated
	 */
	int RANDOM_INTEGER_TYPE = 23;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE__OPERATOR = INTEGER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE__MIN = INTEGER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE__MAX = INTEGER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE__ALLOWS_NULL = INTEGER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Random Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE_FEATURE_COUNT = INTEGER_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Random Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_TYPE_OPERATION_COUNT = INTEGER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.DoubleTypeImpl <em>Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.DoubleTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getDoubleType()
	 * @generated
	 */
	int DOUBLE_TYPE = 24;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__OPERATOR = NUMBER_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_FEATURE_COUNT = NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_OPERATION_COUNT = NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificDoubleTypeImpl <em>Specific Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificDoubleTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificDoubleType()
	 * @generated
	 */
	int SPECIFIC_DOUBLE_TYPE = 25;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DOUBLE_TYPE__OPERATOR = DOUBLE_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DOUBLE_TYPE__VALUE = DOUBLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DOUBLE_TYPE_FEATURE_COUNT = DOUBLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DOUBLE_TYPE_OPERATION_COUNT = DOUBLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomDoubleTypeImpl <em>Random Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomDoubleTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomDoubleType()
	 * @generated
	 */
	int RANDOM_DOUBLE_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE__OPERATOR = DOUBLE_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE__MIN = DOUBLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE__MAX = DOUBLE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE__ALLOWS_NULL = DOUBLE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Random Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE_FEATURE_COUNT = DOUBLE_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Random Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_TYPE_OPERATION_COUNT = DOUBLE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ModifySourceReferenceMutatorImpl <em>Modify Source Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ModifySourceReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifySourceReferenceMutator()
	 * @generated
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR = 27;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Modify Source Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Modify Source Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_SOURCE_REFERENCE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificReferenceSelectionImpl <em>Specific Reference Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificReferenceSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificReferenceSelection()
	 * @generated
	 */
	int SPECIFIC_REFERENCE_SELECTION = 29;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__TYPE = SPECIFIC_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__NAME = SPECIFIC_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__TYPES = SPECIFIC_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__REF_TYPE = SPECIFIC_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__EXPRESSION = SPECIFIC_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__RESOURCE = SPECIFIC_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__REF_REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION__OBJ_SEL = SPECIFIC_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Reference Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION_FEATURE_COUNT = SPECIFIC_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Reference Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_REFERENCE_SELECTION_OPERATION_COUNT = SPECIFIC_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl <em>Modify Target Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifyTargetReferenceMutator()
	 * @generated
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR = 30;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Modify Target Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Modify Target Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_TARGET_REFERENCE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CreateReferenceMutatorImpl <em>Create Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CreateReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCreateReferenceMutator()
	 * @generated
	 */
	int CREATE_REFERENCE_MUTATOR = 31;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__SOURCE = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__TARGET = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR__REF_TYPE = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Create Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_REFERENCE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RemoveObjectMutatorImpl <em>Remove Object Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RemoveObjectMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveObjectMutator()
	 * @generated
	 */
	int REMOVE_OBJECT_MUTATOR = 32;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR__CONTAINER = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remove Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Remove Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_OBJECT_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RemoveReferenceMutatorImpl <em>Remove Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RemoveReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveReferenceMutator()
	 * @generated
	 */
	int REMOVE_REFERENCE_MUTATOR = 33;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The number of structural features of the '<em>Remove Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Remove Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_REFERENCE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ModifyInformationMutatorImpl <em>Modify Information Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ModifyInformationMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifyInformationMutator()
	 * @generated
	 */
	int MODIFY_INFORMATION_MUTATOR = 34;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__ATTRIBUTES = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR__REFERENCES = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Modify Information Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Modify Information Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFY_INFORMATION_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.UpperStringTypeImpl <em>Upper String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.UpperStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getUpperStringType()
	 * @generated
	 */
	int UPPER_STRING_TYPE = 35;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_STRING_TYPE__VALUE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Upper String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Upper String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPPER_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.LowerStringTypeImpl <em>Lower String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.LowerStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLowerStringType()
	 * @generated
	 */
	int LOWER_STRING_TYPE = 36;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_STRING_TYPE__VALUE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Lower String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Lower String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOWER_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ListStringTypeImpl <em>List String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ListStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getListStringType()
	 * @generated
	 */
	int LIST_STRING_TYPE = 37;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_STRING_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_STRING_TYPE__VALUE = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_STRING_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>List String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_STRING_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CatStartStringTypeImpl <em>Cat Start String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CatStartStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCatStartStringType()
	 * @generated
	 */
	int CAT_START_STRING_TYPE = 38;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_START_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_START_STRING_TYPE__VALUE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cat Start String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_START_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cat Start String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_START_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CatEndStringTypeImpl <em>Cat End String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CatEndStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCatEndStringType()
	 * @generated
	 */
	int CAT_END_STRING_TYPE = 39;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_END_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_END_STRING_TYPE__VALUE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cat End String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_END_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cat End String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAT_END_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeUnsetImpl <em>Attribute Unset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeUnsetImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeUnset()
	 * @generated
	 */
	int ATTRIBUTE_UNSET = 40;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Attribute Unset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Unset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_UNSET_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeSwapImpl <em>Attribute Swap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeSwapImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeSwap()
	 * @generated
	 */
	int ATTRIBUTE_SWAP = 42;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP__OBJECT = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_SWAP_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReplaceStringTypeImpl <em>Replace String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReplaceStringTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReplaceStringType()
	 * @generated
	 */
	int REPLACE_STRING_TYPE = 43;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_STRING_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Oldstring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_STRING_TYPE__OLDSTRING = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Newstring</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_STRING_TYPE__NEWSTRING = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Replace String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_STRING_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Replace String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLACE_STRING_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeCopyImpl <em>Attribute Copy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeCopyImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeCopy()
	 * @generated
	 */
	int ATTRIBUTE_COPY = 44;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COPY__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COPY__OBJECT = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Copy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COPY_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Copy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COPY_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RemoveRandomReferenceMutatorImpl <em>Remove Random Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RemoveRandomReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveRandomReferenceMutator()
	 * @generated
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR = 45;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__TYPE = REMOVE_REFERENCE_MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__NAME = REMOVE_REFERENCE_MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__TYPES = REMOVE_REFERENCE_MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__MIN = REMOVE_REFERENCE_MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__MAX = REMOVE_REFERENCE_MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__FIXED = REMOVE_REFERENCE_MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR__REF_TYPE = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Random Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR_FEATURE_COUNT = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Remove Random Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_RANDOM_REFERENCE_MUTATOR_OPERATION_COUNT = REMOVE_REFERENCE_MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RemoveSpecificReferenceMutatorImpl <em>Remove Specific Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RemoveSpecificReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveSpecificReferenceMutator()
	 * @generated
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR = 46;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__TYPE = REMOVE_REFERENCE_MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__NAME = REMOVE_REFERENCE_MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__TYPES = REMOVE_REFERENCE_MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__MIN = REMOVE_REFERENCE_MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__MAX = REMOVE_REFERENCE_MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__FIXED = REMOVE_REFERENCE_MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__REF_TYPE = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR__CONTAINER = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remove Specific Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR_FEATURE_COUNT = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Remove Specific Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_SPECIFIC_REFERENCE_MUTATOR_OPERATION_COUNT = REMOVE_REFERENCE_MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CompleteSelectionImpl <em>Complete Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CompleteSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompleteSelection()
	 * @generated
	 */
	int COMPLETE_SELECTION = 47;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__TYPE = OB_SELECTION_STRATEGY__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__NAME = OB_SELECTION_STRATEGY__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__TYPES = OB_SELECTION_STRATEGY__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__REF_TYPE = OB_SELECTION_STRATEGY__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__EXPRESSION = OB_SELECTION_STRATEGY__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__RESOURCE = OB_SELECTION_STRATEGY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION__REF_REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Complete Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION_FEATURE_COUNT = OB_SELECTION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complete Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_SELECTION_OPERATION_COUNT = OB_SELECTION_STRATEGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CompleteTypeSelectionImpl <em>Complete Type Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CompleteTypeSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompleteTypeSelection()
	 * @generated
	 */
	int COMPLETE_TYPE_SELECTION = 48;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__TYPE = COMPLETE_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__NAME = COMPLETE_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__TYPES = COMPLETE_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__REF_TYPE = COMPLETE_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__EXPRESSION = COMPLETE_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__RESOURCE = COMPLETE_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__REF_REF_TYPE = COMPLETE_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION__REF_REF_REF_TYPE = COMPLETE_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Complete Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION_FEATURE_COUNT = COMPLETE_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complete Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TYPE_SELECTION_OPERATION_COUNT = COMPLETE_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RemoveCompleteReferenceMutatorImpl <em>Remove Complete Reference Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RemoveCompleteReferenceMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveCompleteReferenceMutator()
	 * @generated
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR = 49;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__TYPE = REMOVE_REFERENCE_MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__NAME = REMOVE_REFERENCE_MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__TYPES = REMOVE_REFERENCE_MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__MIN = REMOVE_REFERENCE_MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__MAX = REMOVE_REFERENCE_MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__FIXED = REMOVE_REFERENCE_MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR__REF_TYPE = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Remove Complete Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR_FEATURE_COUNT = REMOVE_REFERENCE_MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Remove Complete Reference Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_COMPLETE_REFERENCE_MUTATOR_OPERATION_COUNT = REMOVE_REFERENCE_MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SourceImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSource()
	 * @generated
	 */
	int SOURCE = 50;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE__PATH = 0;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.OtherSelectionImpl <em>Other Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.OtherSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOtherSelection()
	 * @generated
	 */
	int OTHER_SELECTION = 51;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__TYPE = OB_SELECTION_STRATEGY__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__NAME = OB_SELECTION_STRATEGY__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__TYPES = OB_SELECTION_STRATEGY__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__REF_TYPE = OB_SELECTION_STRATEGY__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__EXPRESSION = OB_SELECTION_STRATEGY__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__RESOURCE = OB_SELECTION_STRATEGY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION__REF_REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Other Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION_FEATURE_COUNT = OB_SELECTION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Other Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_SELECTION_OPERATION_COUNT = OB_SELECTION_STRATEGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.OtherTypeSelectionImpl <em>Other Type Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.OtherTypeSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOtherTypeSelection()
	 * @generated
	 */
	int OTHER_TYPE_SELECTION = 52;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__TYPE = OTHER_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__NAME = OTHER_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__TYPES = OTHER_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__REF_TYPE = OTHER_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__EXPRESSION = OTHER_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__RESOURCE = OTHER_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__REF_REF_TYPE = OTHER_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION__REF_REF_REF_TYPE = OTHER_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Other Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION_FEATURE_COUNT = OTHER_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Other Type Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_TYPE_SELECTION_OPERATION_COUNT = OTHER_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SelectObjectMutatorImpl <em>Select Object Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SelectObjectMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSelectObjectMutator()
	 * @generated
	 */
	int SELECT_OBJECT_MUTATOR = 53;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__CONTAINER = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Select Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Select Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OBJECT_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.EvaluationImpl <em>Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.EvaluationImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getEvaluation()
	 * @generated
	 */
	int EVALUATION = 62;

	/**
	 * The number of structural features of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVALUATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeEvaluationImpl <em>Attribute Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeEvaluationImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeEvaluation()
	 * @generated
	 */
	int ATTRIBUTE_EVALUATION = 54;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION__NAME = EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION__VALUE = EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION_FEATURE_COUNT = EVALUATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_EVALUATION_OPERATION_COUNT = EVALUATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeReverseImpl <em>Attribute Reverse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeReverseImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeReverse()
	 * @generated
	 */
	int ATTRIBUTE_REVERSE = 55;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REVERSE__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The number of structural features of the '<em>Attribute Reverse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REVERSE_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Reverse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_REVERSE_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceSetImpl <em>Reference Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceSetImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceSet()
	 * @generated
	 */
	int REFERENCE_SET = 56;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET__REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET__OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Reference Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Reference Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceInitImpl <em>Reference Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceInitImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceInit()
	 * @generated
	 */
	int REFERENCE_INIT = 57;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INIT__REFERENCE = REFERENCE_SET__REFERENCE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INIT__OBJECT = REFERENCE_SET__OBJECT;

	/**
	 * The number of structural features of the '<em>Reference Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INIT_FEATURE_COUNT = REFERENCE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_INIT_OPERATION_COUNT = REFERENCE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceAttImpl <em>Reference Att</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceAttImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceAtt()
	 * @generated
	 */
	int REFERENCE_ATT = 58;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__REFERENCE = REFERENCE_SET__REFERENCE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__OBJECT = REFERENCE_SET__OBJECT;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__ATTRIBUTE = REFERENCE_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT__VALUE = REFERENCE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Att</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT_FEATURE_COUNT = REFERENCE_SET_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Reference Att</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ATT_OPERATION_COUNT = REFERENCE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceEvaluationImpl <em>Reference Evaluation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceEvaluationImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceEvaluation()
	 * @generated
	 */
	int REFERENCE_EVALUATION = 59;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__NAME = EVALUATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ref Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__REF_NAME = EVALUATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Ref Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__REF_REF_NAME = EVALUATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__OPERATOR = EVALUATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__VALUE = EVALUATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__REF_TYPE = EVALUATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Att Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__ATT_NAME = EVALUATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Att Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__ATT_VALUE = EVALUATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION__CONTAINER = EVALUATION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Reference Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION_FEATURE_COUNT = EVALUATION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Reference Evaluation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_EVALUATION_OPERATION_COUNT = EVALUATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ExpressionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 60;

	/**
	 * The feature id for the '<em><b>First</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__FIRST = 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Second</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__SECOND = 2;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceSwapImpl <em>Reference Swap</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceSwapImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceSwap()
	 * @generated
	 */
	int REFERENCE_SWAP = 61;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__REFERENCE = REFERENCE_SET__REFERENCE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP__OBJECT = REFERENCE_SET__OBJECT;

	/**
	 * The number of structural features of the '<em>Reference Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP_FEATURE_COUNT = REFERENCE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Swap</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SWAP_OPERATION_COUNT = REFERENCE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.BinaryOperatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBinaryOperator()
	 * @generated
	 */
	int BINARY_OPERATOR = 63;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Binary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Binary Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.BlockImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 64;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__COMMANDS = 1;

	/**
	 * The feature id for the '<em><b>From</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__FROM = 2;

	/**
	 * The feature id for the '<em><b>Repeat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__REPEAT = 3;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__MIN = 4;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__MAX = 5;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__FIXED = 6;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__DESCRIPTION = 7;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ConstraintImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 65;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__EXPRESSIONS = 2;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__RULES = 3;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomTypeImpl <em>Random Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomType()
	 * @generated
	 */
	int RANDOM_TYPE = 66;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The number of structural features of the '<em>Random Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Random Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.CloneObjectMutatorImpl <em>Clone Object Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.CloneObjectMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCloneObjectMutator()
	 * @generated
	 */
	int CLONE_OBJECT_MUTATOR = 67;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__CONTENTS = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__CONTAINER = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__REF_TYPE = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__ATTRIBUTES = MUTATOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR__REFERENCES = MUTATOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Clone Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Clone Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLONE_OBJECT_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ListTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getListType()
	 * @generated
	 */
	int LIST_TYPE = 68;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__OPERATOR = ATTRIBUTE_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__VALUE = ATTRIBUTE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_FEATURE_COUNT = ATTRIBUTE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_OPERATION_COUNT = ATTRIBUTE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ObjectAttributeTypeImpl <em>Object Attribute Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ObjectAttributeTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObjectAttributeType()
	 * @generated
	 */
	int OBJECT_ATTRIBUTE_TYPE = 69;

	/**
	 * The feature id for the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ATTRIBUTE_TYPE__OBJ_SEL = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ATTRIBUTE_TYPE__OPERATOR = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Object Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ATTRIBUTE_TYPE_FEATURE_COUNT = ATTRIBUTE_EVALUATION_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Object Attribute Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_ATTRIBUTE_TYPE_OPERATION_COUNT = ATTRIBUTE_EVALUATION_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.MinValueTypeImpl <em>Min Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.MinValueTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMinValueType()
	 * @generated
	 */
	int MIN_VALUE_TYPE = 71;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_VALUE_TYPE__OPERATOR = NUMBER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_VALUE_TYPE__ATTRIBUTE = NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Min Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_VALUE_TYPE_FEATURE_COUNT = NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Min Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIN_VALUE_TYPE_OPERATION_COUNT = NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.MaxValueTypeImpl <em>Max Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.MaxValueTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMaxValueType()
	 * @generated
	 */
	int MAX_VALUE_TYPE = 72;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_VALUE_TYPE__OPERATOR = NUMBER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_VALUE_TYPE__ATTRIBUTE = NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Max Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_VALUE_TYPE_FEATURE_COUNT = NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Max Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAX_VALUE_TYPE_OPERATION_COUNT = NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.AttributeOperationImpl <em>Attribute Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.AttributeOperationImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeOperation()
	 * @generated
	 */
	int ATTRIBUTE_OPERATION = 74;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__ATTRIBUTE = ATTRIBUTE_SET__ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__OPERATOR = ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__VALUE = ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_FEATURE_COUNT = ATTRIBUTE_SET_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_OPERATION_COUNT = ATTRIBUTE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomNumberTypeImpl <em>Random Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomNumberTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomNumberType()
	 * @generated
	 */
	int RANDOM_NUMBER_TYPE = 75;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_TYPE__OPERATOR = NUMBER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_TYPE__OBJECT = NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_TYPE__MAX = NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Random Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_TYPE_FEATURE_COUNT = NUMBER_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Random Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_NUMBER_TYPE_OPERATION_COUNT = NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomDoubleNumberTypeImpl <em>Random Double Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomDoubleNumberTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomDoubleNumberType()
	 * @generated
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE = 76;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE__OPERATOR = RANDOM_NUMBER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE__OBJECT = RANDOM_NUMBER_TYPE__OBJECT;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE__MAX = RANDOM_NUMBER_TYPE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE__MIN = RANDOM_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Double Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE_FEATURE_COUNT = RANDOM_NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Random Double Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_DOUBLE_NUMBER_TYPE_OPERATION_COUNT = RANDOM_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomIntegerNumberTypeImpl <em>Random Integer Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomIntegerNumberTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomIntegerNumberType()
	 * @generated
	 */
	int RANDOM_INTEGER_NUMBER_TYPE = 77;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE__OPERATOR = RANDOM_NUMBER_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE__OBJECT = RANDOM_NUMBER_TYPE__OBJECT;

	/**
	 * The feature id for the '<em><b>Max</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE__MAX = RANDOM_NUMBER_TYPE__MAX;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE__MIN = RANDOM_NUMBER_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Integer Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE_FEATURE_COUNT = RANDOM_NUMBER_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Random Integer Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_INTEGER_NUMBER_TYPE_OPERATION_COUNT = RANDOM_NUMBER_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SpecificClosureSelectionImpl <em>Specific Closure Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SpecificClosureSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificClosureSelection()
	 * @generated
	 */
	int SPECIFIC_CLOSURE_SELECTION = 78;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__TYPE = SPECIFIC_SELECTION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__NAME = SPECIFIC_SELECTION__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__TYPES = SPECIFIC_SELECTION__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__REF_TYPE = SPECIFIC_SELECTION__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__EXPRESSION = SPECIFIC_SELECTION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__RESOURCE = SPECIFIC_SELECTION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__REF_REF_REF_TYPE = SPECIFIC_SELECTION__REF_REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Obj Sel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION__OBJ_SEL = SPECIFIC_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Closure Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION_FEATURE_COUNT = SPECIFIC_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Specific Closure Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_CLOSURE_SELECTION_OPERATION_COUNT = SPECIFIC_SELECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.SelectSampleMutatorImpl <em>Select Sample Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.SelectSampleMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSelectSampleMutator()
	 * @generated
	 */
	int SELECT_SAMPLE_MUTATOR = 79;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__CLAUSE = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR__FEATURES = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Select Sample Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Select Sample Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_SAMPLE_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceAddImpl <em>Reference Add</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceAddImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceAdd()
	 * @generated
	 */
	int REFERENCE_ADD = 80;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ADD__REFERENCE = REFERENCE_SET__REFERENCE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ADD__OBJECT = REFERENCE_SET__OBJECT;

	/**
	 * The number of structural features of the '<em>Reference Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ADD_FEATURE_COUNT = REFERENCE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Add</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ADD_OPERATION_COUNT = REFERENCE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ReferenceRemoveImpl <em>Reference Remove</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ReferenceRemoveImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceRemove()
	 * @generated
	 */
	int REFERENCE_REMOVE = 81;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVE__REFERENCE = REFERENCE_SET__REFERENCE;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVE__OBJECT = REFERENCE_SET__OBJECT;

	/**
	 * The number of structural features of the '<em>Reference Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVE_FEATURE_COUNT = REFERENCE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REMOVE_OPERATION_COUNT = REFERENCE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RetypeObjectMutatorImpl <em>Retype Object Mutator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RetypeObjectMutatorImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRetypeObjectMutator()
	 * @generated
	 */
	int RETYPE_OBJECT_MUTATOR = 82;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__TYPE = MUTATOR__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__NAME = MUTATOR__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__TYPES = MUTATOR__TYPES;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__MIN = MUTATOR__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__MAX = MUTATOR__MAX;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__FIXED = MUTATOR__FIXED;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__OBJECT = MUTATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__CONTAINER = MUTATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__REF_TYPE = MUTATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__ATTRIBUTES = MUTATOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR__REFERENCES = MUTATOR_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Retype Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR_FEATURE_COUNT = MUTATOR_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Retype Object Mutator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETYPE_OBJECT_MUTATOR_OPERATION_COUNT = MUTATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.TypedSelectionImpl <em>Typed Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.TypedSelectionImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getTypedSelection()
	 * @generated
	 */
	int TYPED_SELECTION = 83;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__TYPE = OB_SELECTION_STRATEGY__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__NAME = OB_SELECTION_STRATEGY__NAME;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__TYPES = OB_SELECTION_STRATEGY__TYPES;

	/**
	 * The feature id for the '<em><b>Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__REF_TYPE = OB_SELECTION_STRATEGY__REF_TYPE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__EXPRESSION = OB_SELECTION_STRATEGY__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__RESOURCE = OB_SELECTION_STRATEGY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_TYPE;

	/**
	 * The feature id for the '<em><b>Ref Ref Ref Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION__REF_REF_REF_TYPE = OB_SELECTION_STRATEGY__REF_REF_REF_TYPE;

	/**
	 * The number of structural features of the '<em>Typed Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION_FEATURE_COUNT = OB_SELECTION_STRATEGY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Typed Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_SELECTION_OPERATION_COUNT = OB_SELECTION_STRATEGY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.RandomStringNumberTypeImpl <em>Random String Number Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.RandomStringNumberTypeImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomStringNumberType()
	 * @generated
	 */
	int RANDOM_STRING_NUMBER_TYPE = 84;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE__OPERATOR = STRING_TYPE__OPERATOR;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE__MIN = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE__MAX = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows Null</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE__ALLOWS_NULL = STRING_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Random String Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Random String Number Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_STRING_NUMBER_TYPE_OPERATION_COUNT = STRING_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.impl.ResourceImpl
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 85;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__METAMODEL = DEFINITION__METAMODEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PATH = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.LogicOperator <em>Logic Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.LogicOperator
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLogicOperator()
	 * @generated
	 */
	int LOGIC_OPERATOR = 86;

	/**
	 * The meta object id for the '{@link mutatorenvironment.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.Operator
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 87;

	/**
	 * The meta object id for the '{@link mutatorenvironment.Repeat <em>Repeat</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.Repeat
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRepeat()
	 * @generated
	 */
	int REPEAT = 88;

	/**
	 * The meta object id for the '{@link mutatorenvironment.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.ArithmeticOperator
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getArithmeticOperator()
	 * @generated
	 */
	int ARITHMETIC_OPERATOR = 89;

	/**
	 * The meta object id for the '{@link mutatorenvironment.SampleClause <em>Sample Clause</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.SampleClause
	 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSampleClause()
	 * @generated
	 */
	int SAMPLE_CLAUSE = 90;


	/**
	 * Returns the meta object for class '{@link mutatorenvironment.MutatorEnvironment <em>Mutator Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator Environment</em>'.
	 * @see mutatorenvironment.MutatorEnvironment
	 * @generated
	 */
	EClass getMutatorEnvironment();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.MutatorEnvironment#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see mutatorenvironment.MutatorEnvironment#getDefinition()
	 * @see #getMutatorEnvironment()
	 * @generated
	 */
	EReference getMutatorEnvironment_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.MutatorEnvironment#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see mutatorenvironment.MutatorEnvironment#getCommands()
	 * @see #getMutatorEnvironment()
	 * @generated
	 */
	EReference getMutatorEnvironment_Commands();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.MutatorEnvironment#getLoad <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Load</em>'.
	 * @see mutatorenvironment.MutatorEnvironment#getLoad()
	 * @see #getMutatorEnvironment()
	 * @generated
	 */
	EReference getMutatorEnvironment_Load();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.MutatorEnvironment#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see mutatorenvironment.MutatorEnvironment#getBlocks()
	 * @see #getMutatorEnvironment()
	 * @generated
	 */
	EReference getMutatorEnvironment_Blocks();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.MutatorEnvironment#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see mutatorenvironment.MutatorEnvironment#getConstraints()
	 * @see #getMutatorEnvironment()
	 * @generated
	 */
	EReference getMutatorEnvironment_Constraints();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see mutatorenvironment.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Definition#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel</em>'.
	 * @see mutatorenvironment.Definition#getMetamodel()
	 * @see #getDefinition()
	 * @generated
	 */
	EAttribute getDefinition_Metamodel();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see mutatorenvironment.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see mutatorenvironment.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Program#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see mutatorenvironment.Program#getOutput()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Output();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Program#getNum <em>Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num</em>'.
	 * @see mutatorenvironment.Program#getNum()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Num();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.Program#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see mutatorenvironment.Program#getSource()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Source();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Program#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see mutatorenvironment.Program#getDescription()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Description();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Program#isExhaustive <em>Exhaustive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exhaustive</em>'.
	 * @see mutatorenvironment.Program#isExhaustive()
	 * @see #getProgram()
	 * @generated
	 */
	EAttribute getProgram_Exhaustive();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.Program#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see mutatorenvironment.Program#getResources()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Resources();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ObjectEmitter <em>Object Emitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Emitter</em>'.
	 * @see mutatorenvironment.ObjectEmitter
	 * @generated
	 */
	EClass getObjectEmitter();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObjectEmitter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see mutatorenvironment.ObjectEmitter#getType()
	 * @see #getObjectEmitter()
	 * @generated
	 */
	EReference getObjectEmitter_Type();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ObjectEmitter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.ObjectEmitter#getName()
	 * @see #getObjectEmitter()
	 * @generated
	 */
	EAttribute getObjectEmitter_Name();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.ObjectEmitter#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see mutatorenvironment.ObjectEmitter#getTypes()
	 * @see #getObjectEmitter()
	 * @generated
	 */
	EReference getObjectEmitter_Types();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Mutator <em>Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutator</em>'.
	 * @see mutatorenvironment.Mutator
	 * @generated
	 */
	EClass getMutator();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Mutator#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.Mutator#getMin()
	 * @see #getMutator()
	 * @generated
	 */
	EAttribute getMutator_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Mutator#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.Mutator#getMax()
	 * @see #getMutator()
	 * @generated
	 */
	EAttribute getMutator_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Mutator#getFixed <em>Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed</em>'.
	 * @see mutatorenvironment.Mutator#getFixed()
	 * @see #getMutator()
	 * @generated
	 */
	EAttribute getMutator_Fixed();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CompositeMutator <em>Composite Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Mutator</em>'.
	 * @see mutatorenvironment.CompositeMutator
	 * @generated
	 */
	EClass getCompositeMutator();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.CompositeMutator#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see mutatorenvironment.CompositeMutator#getCommands()
	 * @see #getCompositeMutator()
	 * @generated
	 */
	EReference getCompositeMutator_Commands();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Load <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load</em>'.
	 * @see mutatorenvironment.Load
	 * @generated
	 */
	EClass getLoad();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Load#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see mutatorenvironment.Load#getFile()
	 * @see #getLoad()
	 * @generated
	 */
	EAttribute getLoad_File();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CreateObjectMutator <em>Create Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Object Mutator</em>'.
	 * @see mutatorenvironment.CreateObjectMutator
	 * @generated
	 */
	EClass getCreateObjectMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.CreateObjectMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.CreateObjectMutator#getContainer()
	 * @see #getCreateObjectMutator()
	 * @generated
	 */
	EReference getCreateObjectMutator_Container();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.CreateObjectMutator#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see mutatorenvironment.CreateObjectMutator#getAttributes()
	 * @see #getCreateObjectMutator()
	 * @generated
	 */
	EReference getCreateObjectMutator_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.CreateObjectMutator#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see mutatorenvironment.CreateObjectMutator#getReferences()
	 * @see #getCreateObjectMutator()
	 * @generated
	 */
	EReference getCreateObjectMutator_References();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ObSelectionStrategy <em>Ob Selection Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ob Selection Strategy</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy
	 * @generated
	 */
	EClass getObSelectionStrategy();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObSelectionStrategy#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy#getRefType()
	 * @see #getObSelectionStrategy()
	 * @generated
	 */
	EReference getObSelectionStrategy_RefType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ObSelectionStrategy#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy#getExpression()
	 * @see #getObSelectionStrategy()
	 * @generated
	 */
	EReference getObSelectionStrategy_Expression();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ObSelectionStrategy#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy#getResource()
	 * @see #getObSelectionStrategy()
	 * @generated
	 */
	EAttribute getObSelectionStrategy_Resource();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObSelectionStrategy#getRefRefType <em>Ref Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Ref Type</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy#getRefRefType()
	 * @see #getObSelectionStrategy()
	 * @generated
	 */
	EReference getObSelectionStrategy_RefRefType();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObSelectionStrategy#getRefRefRefType <em>Ref Ref Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Ref Ref Type</em>'.
	 * @see mutatorenvironment.ObSelectionStrategy#getRefRefRefType()
	 * @see #getObSelectionStrategy()
	 * @generated
	 */
	EReference getObSelectionStrategy_RefRefRefType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomSelection <em>Random Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Selection</em>'.
	 * @see mutatorenvironment.RandomSelection
	 * @generated
	 */
	EClass getRandomSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomTypeSelection <em>Random Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Type Selection</em>'.
	 * @see mutatorenvironment.RandomTypeSelection
	 * @generated
	 */
	EClass getRandomTypeSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificObjectSelection <em>Specific Object Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Object Selection</em>'.
	 * @see mutatorenvironment.SpecificObjectSelection
	 * @generated
	 */
	EClass getSpecificObjectSelection();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.SpecificObjectSelection#getObjSel <em>Obj Sel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Sel</em>'.
	 * @see mutatorenvironment.SpecificObjectSelection#getObjSel()
	 * @see #getSpecificObjectSelection()
	 * @generated
	 */
	EReference getSpecificObjectSelection_ObjSel();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeScalar <em>Attribute Scalar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Scalar</em>'.
	 * @see mutatorenvironment.AttributeScalar
	 * @generated
	 */
	EClass getAttributeScalar();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.AttributeScalar#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see mutatorenvironment.AttributeScalar#getValue()
	 * @see #getAttributeScalar()
	 * @generated
	 */
	EReference getAttributeScalar_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Type</em>'.
	 * @see mutatorenvironment.AttributeType
	 * @generated
	 */
	EClass getAttributeType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.AttributeType#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see mutatorenvironment.AttributeType#getOperator()
	 * @see #getAttributeType()
	 * @generated
	 */
	EAttribute getAttributeType_Operator();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see mutatorenvironment.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificBooleanType <em>Specific Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Boolean Type</em>'.
	 * @see mutatorenvironment.SpecificBooleanType
	 * @generated
	 */
	EClass getSpecificBooleanType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.SpecificBooleanType#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.SpecificBooleanType#isValue()
	 * @see #getSpecificBooleanType()
	 * @generated
	 */
	EAttribute getSpecificBooleanType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomBooleanType <em>Random Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Boolean Type</em>'.
	 * @see mutatorenvironment.RandomBooleanType
	 * @generated
	 */
	EClass getRandomBooleanType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomBooleanType#isAllowsNull <em>Allows Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allows Null</em>'.
	 * @see mutatorenvironment.RandomBooleanType#isAllowsNull()
	 * @see #getRandomBooleanType()
	 * @generated
	 */
	EAttribute getRandomBooleanType_AllowsNull();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see mutatorenvironment.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificStringType <em>Specific String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific String Type</em>'.
	 * @see mutatorenvironment.SpecificStringType
	 * @generated
	 */
	EClass getSpecificStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.SpecificStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.SpecificStringType#getValue()
	 * @see #getSpecificStringType()
	 * @generated
	 */
	EAttribute getSpecificStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomStringType <em>Random String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random String Type</em>'.
	 * @see mutatorenvironment.RandomStringType
	 * @generated
	 */
	EClass getRandomStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomStringType#getMin()
	 * @see #getRandomStringType()
	 * @generated
	 */
	EAttribute getRandomStringType_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.RandomStringType#getMax()
	 * @see #getRandomStringType()
	 * @generated
	 */
	EAttribute getRandomStringType_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringType#isAllowsNull <em>Allows Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allows Null</em>'.
	 * @see mutatorenvironment.RandomStringType#isAllowsNull()
	 * @see #getRandomStringType()
	 * @generated
	 */
	EAttribute getRandomStringType_AllowsNull();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see mutatorenvironment.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificIntegerType <em>Specific Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Integer Type</em>'.
	 * @see mutatorenvironment.SpecificIntegerType
	 * @generated
	 */
	EClass getSpecificIntegerType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.SpecificIntegerType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.SpecificIntegerType#getValue()
	 * @see #getSpecificIntegerType()
	 * @generated
	 */
	EAttribute getSpecificIntegerType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomIntegerType <em>Random Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Integer Type</em>'.
	 * @see mutatorenvironment.RandomIntegerType
	 * @generated
	 */
	EClass getRandomIntegerType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomIntegerType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomIntegerType#getMin()
	 * @see #getRandomIntegerType()
	 * @generated
	 */
	EAttribute getRandomIntegerType_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomIntegerType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.RandomIntegerType#getMax()
	 * @see #getRandomIntegerType()
	 * @generated
	 */
	EAttribute getRandomIntegerType_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomIntegerType#isAllowsNull <em>Allows Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allows Null</em>'.
	 * @see mutatorenvironment.RandomIntegerType#isAllowsNull()
	 * @see #getRandomIntegerType()
	 * @generated
	 */
	EAttribute getRandomIntegerType_AllowsNull();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Type</em>'.
	 * @see mutatorenvironment.DoubleType
	 * @generated
	 */
	EClass getDoubleType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificDoubleType <em>Specific Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Double Type</em>'.
	 * @see mutatorenvironment.SpecificDoubleType
	 * @generated
	 */
	EClass getSpecificDoubleType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.SpecificDoubleType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.SpecificDoubleType#getValue()
	 * @see #getSpecificDoubleType()
	 * @generated
	 */
	EAttribute getSpecificDoubleType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomDoubleType <em>Random Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Double Type</em>'.
	 * @see mutatorenvironment.RandomDoubleType
	 * @generated
	 */
	EClass getRandomDoubleType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomDoubleType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomDoubleType#getMin()
	 * @see #getRandomDoubleType()
	 * @generated
	 */
	EAttribute getRandomDoubleType_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomDoubleType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.RandomDoubleType#getMax()
	 * @see #getRandomDoubleType()
	 * @generated
	 */
	EAttribute getRandomDoubleType_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomDoubleType#isAllowsNull <em>Allows Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allows Null</em>'.
	 * @see mutatorenvironment.RandomDoubleType#isAllowsNull()
	 * @see #getRandomDoubleType()
	 * @generated
	 */
	EAttribute getRandomDoubleType_AllowsNull();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ModifySourceReferenceMutator <em>Modify Source Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modify Source Reference Mutator</em>'.
	 * @see mutatorenvironment.ModifySourceReferenceMutator
	 * @generated
	 */
	EClass getModifySourceReferenceMutator();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ModifySourceReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.ModifySourceReferenceMutator#getRefType()
	 * @see #getModifySourceReferenceMutator()
	 * @generated
	 */
	EReference getModifySourceReferenceMutator_RefType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ModifySourceReferenceMutator#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see mutatorenvironment.ModifySourceReferenceMutator#getSource()
	 * @see #getModifySourceReferenceMutator()
	 * @generated
	 */
	EReference getModifySourceReferenceMutator_Source();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ModifySourceReferenceMutator#getNewSource <em>New Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Source</em>'.
	 * @see mutatorenvironment.ModifySourceReferenceMutator#getNewSource()
	 * @see #getModifySourceReferenceMutator()
	 * @generated
	 */
	EReference getModifySourceReferenceMutator_NewSource();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificSelection <em>Specific Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Selection</em>'.
	 * @see mutatorenvironment.SpecificSelection
	 * @generated
	 */
	EClass getSpecificSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificReferenceSelection <em>Specific Reference Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Reference Selection</em>'.
	 * @see mutatorenvironment.SpecificReferenceSelection
	 * @generated
	 */
	EClass getSpecificReferenceSelection();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.SpecificReferenceSelection#getObjSel <em>Obj Sel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Sel</em>'.
	 * @see mutatorenvironment.SpecificReferenceSelection#getObjSel()
	 * @see #getSpecificReferenceSelection()
	 * @generated
	 */
	EReference getSpecificReferenceSelection_ObjSel();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ModifyTargetReferenceMutator <em>Modify Target Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modify Target Reference Mutator</em>'.
	 * @see mutatorenvironment.ModifyTargetReferenceMutator
	 * @generated
	 */
	EClass getModifyTargetReferenceMutator();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ModifyTargetReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.ModifyTargetReferenceMutator#getRefType()
	 * @see #getModifyTargetReferenceMutator()
	 * @generated
	 */
	EReference getModifyTargetReferenceMutator_RefType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ModifyTargetReferenceMutator#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see mutatorenvironment.ModifyTargetReferenceMutator#getSource()
	 * @see #getModifyTargetReferenceMutator()
	 * @generated
	 */
	EReference getModifyTargetReferenceMutator_Source();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ModifyTargetReferenceMutator#getNewTarget <em>New Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Target</em>'.
	 * @see mutatorenvironment.ModifyTargetReferenceMutator#getNewTarget()
	 * @see #getModifyTargetReferenceMutator()
	 * @generated
	 */
	EReference getModifyTargetReferenceMutator_NewTarget();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CreateReferenceMutator <em>Create Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Reference Mutator</em>'.
	 * @see mutatorenvironment.CreateReferenceMutator
	 * @generated
	 */
	EClass getCreateReferenceMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.CreateReferenceMutator#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see mutatorenvironment.CreateReferenceMutator#getSource()
	 * @see #getCreateReferenceMutator()
	 * @generated
	 */
	EReference getCreateReferenceMutator_Source();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.CreateReferenceMutator#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see mutatorenvironment.CreateReferenceMutator#getTarget()
	 * @see #getCreateReferenceMutator()
	 * @generated
	 */
	EReference getCreateReferenceMutator_Target();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.CreateReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.CreateReferenceMutator#getRefType()
	 * @see #getCreateReferenceMutator()
	 * @generated
	 */
	EReference getCreateReferenceMutator_RefType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RemoveObjectMutator <em>Remove Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Object Mutator</em>'.
	 * @see mutatorenvironment.RemoveObjectMutator
	 * @generated
	 */
	EClass getRemoveObjectMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RemoveObjectMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.RemoveObjectMutator#getObject()
	 * @see #getRemoveObjectMutator()
	 * @generated
	 */
	EReference getRemoveObjectMutator_Object();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RemoveObjectMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.RemoveObjectMutator#getContainer()
	 * @see #getRemoveObjectMutator()
	 * @generated
	 */
	EReference getRemoveObjectMutator_Container();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RemoveReferenceMutator <em>Remove Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Reference Mutator</em>'.
	 * @see mutatorenvironment.RemoveReferenceMutator
	 * @generated
	 */
	EClass getRemoveReferenceMutator();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ModifyInformationMutator <em>Modify Information Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modify Information Mutator</em>'.
	 * @see mutatorenvironment.ModifyInformationMutator
	 * @generated
	 */
	EClass getModifyInformationMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ModifyInformationMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.ModifyInformationMutator#getObject()
	 * @see #getModifyInformationMutator()
	 * @generated
	 */
	EReference getModifyInformationMutator_Object();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.ModifyInformationMutator#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see mutatorenvironment.ModifyInformationMutator#getAttributes()
	 * @see #getModifyInformationMutator()
	 * @generated
	 */
	EReference getModifyInformationMutator_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.ModifyInformationMutator#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see mutatorenvironment.ModifyInformationMutator#getReferences()
	 * @see #getModifyInformationMutator()
	 * @generated
	 */
	EReference getModifyInformationMutator_References();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.UpperStringType <em>Upper String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upper String Type</em>'.
	 * @see mutatorenvironment.UpperStringType
	 * @generated
	 */
	EClass getUpperStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.UpperStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.UpperStringType#getValue()
	 * @see #getUpperStringType()
	 * @generated
	 */
	EAttribute getUpperStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.LowerStringType <em>Lower String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lower String Type</em>'.
	 * @see mutatorenvironment.LowerStringType
	 * @generated
	 */
	EClass getLowerStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.LowerStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.LowerStringType#getValue()
	 * @see #getLowerStringType()
	 * @generated
	 */
	EAttribute getLowerStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ListStringType <em>List String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List String Type</em>'.
	 * @see mutatorenvironment.ListStringType
	 * @generated
	 */
	EClass getListStringType();

	/**
	 * Returns the meta object for the attribute list '{@link mutatorenvironment.ListStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see mutatorenvironment.ListStringType#getValue()
	 * @see #getListStringType()
	 * @generated
	 */
	EAttribute getListStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CatStartStringType <em>Cat Start String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cat Start String Type</em>'.
	 * @see mutatorenvironment.CatStartStringType
	 * @generated
	 */
	EClass getCatStartStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.CatStartStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.CatStartStringType#getValue()
	 * @see #getCatStartStringType()
	 * @generated
	 */
	EAttribute getCatStartStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CatEndStringType <em>Cat End String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cat End String Type</em>'.
	 * @see mutatorenvironment.CatEndStringType
	 * @generated
	 */
	EClass getCatEndStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.CatEndStringType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see mutatorenvironment.CatEndStringType#getValue()
	 * @see #getCatEndStringType()
	 * @generated
	 */
	EAttribute getCatEndStringType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeUnset <em>Attribute Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Unset</em>'.
	 * @see mutatorenvironment.AttributeUnset
	 * @generated
	 */
	EClass getAttributeUnset();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeSet <em>Attribute Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Set</em>'.
	 * @see mutatorenvironment.AttributeSet
	 * @generated
	 */
	EClass getAttributeSet();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.AttributeSet#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute</em>'.
	 * @see mutatorenvironment.AttributeSet#getAttribute()
	 * @see #getAttributeSet()
	 * @generated
	 */
	EReference getAttributeSet_Attribute();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeSwap <em>Attribute Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Swap</em>'.
	 * @see mutatorenvironment.AttributeSwap
	 * @generated
	 */
	EClass getAttributeSwap();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.AttributeSwap#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.AttributeSwap#getObject()
	 * @see #getAttributeSwap()
	 * @generated
	 */
	EReference getAttributeSwap_Object();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReplaceStringType <em>Replace String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replace String Type</em>'.
	 * @see mutatorenvironment.ReplaceStringType
	 * @generated
	 */
	EClass getReplaceStringType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ReplaceStringType#getOldstring <em>Oldstring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Oldstring</em>'.
	 * @see mutatorenvironment.ReplaceStringType#getOldstring()
	 * @see #getReplaceStringType()
	 * @generated
	 */
	EAttribute getReplaceStringType_Oldstring();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ReplaceStringType#getNewstring <em>Newstring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Newstring</em>'.
	 * @see mutatorenvironment.ReplaceStringType#getNewstring()
	 * @see #getReplaceStringType()
	 * @generated
	 */
	EAttribute getReplaceStringType_Newstring();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeCopy <em>Attribute Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Copy</em>'.
	 * @see mutatorenvironment.AttributeCopy
	 * @generated
	 */
	EClass getAttributeCopy();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.AttributeCopy#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.AttributeCopy#getObject()
	 * @see #getAttributeCopy()
	 * @generated
	 */
	EReference getAttributeCopy_Object();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RemoveRandomReferenceMutator <em>Remove Random Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Random Reference Mutator</em>'.
	 * @see mutatorenvironment.RemoveRandomReferenceMutator
	 * @generated
	 */
	EClass getRemoveRandomReferenceMutator();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.RemoveRandomReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.RemoveRandomReferenceMutator#getRefType()
	 * @see #getRemoveRandomReferenceMutator()
	 * @generated
	 */
	EReference getRemoveRandomReferenceMutator_RefType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RemoveSpecificReferenceMutator <em>Remove Specific Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Specific Reference Mutator</em>'.
	 * @see mutatorenvironment.RemoveSpecificReferenceMutator
	 * @generated
	 */
	EClass getRemoveSpecificReferenceMutator();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.RemoveSpecificReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.RemoveSpecificReferenceMutator#getRefType()
	 * @see #getRemoveSpecificReferenceMutator()
	 * @generated
	 */
	EReference getRemoveSpecificReferenceMutator_RefType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RemoveSpecificReferenceMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.RemoveSpecificReferenceMutator#getContainer()
	 * @see #getRemoveSpecificReferenceMutator()
	 * @generated
	 */
	EReference getRemoveSpecificReferenceMutator_Container();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CompleteSelection <em>Complete Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Selection</em>'.
	 * @see mutatorenvironment.CompleteSelection
	 * @generated
	 */
	EClass getCompleteSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CompleteTypeSelection <em>Complete Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Type Selection</em>'.
	 * @see mutatorenvironment.CompleteTypeSelection
	 * @generated
	 */
	EClass getCompleteTypeSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RemoveCompleteReferenceMutator <em>Remove Complete Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Complete Reference Mutator</em>'.
	 * @see mutatorenvironment.RemoveCompleteReferenceMutator
	 * @generated
	 */
	EClass getRemoveCompleteReferenceMutator();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.RemoveCompleteReferenceMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.RemoveCompleteReferenceMutator#getRefType()
	 * @see #getRemoveCompleteReferenceMutator()
	 * @generated
	 */
	EReference getRemoveCompleteReferenceMutator_RefType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source</em>'.
	 * @see mutatorenvironment.Source
	 * @generated
	 */
	EClass getSource();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Source#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see mutatorenvironment.Source#getPath()
	 * @see #getSource()
	 * @generated
	 */
	EAttribute getSource_Path();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.OtherSelection <em>Other Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other Selection</em>'.
	 * @see mutatorenvironment.OtherSelection
	 * @generated
	 */
	EClass getOtherSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.OtherTypeSelection <em>Other Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other Type Selection</em>'.
	 * @see mutatorenvironment.OtherTypeSelection
	 * @generated
	 */
	EClass getOtherTypeSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SelectObjectMutator <em>Select Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Object Mutator</em>'.
	 * @see mutatorenvironment.SelectObjectMutator
	 * @generated
	 */
	EClass getSelectObjectMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.SelectObjectMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.SelectObjectMutator#getContainer()
	 * @see #getSelectObjectMutator()
	 * @generated
	 */
	EReference getSelectObjectMutator_Container();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.SelectObjectMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.SelectObjectMutator#getObject()
	 * @see #getSelectObjectMutator()
	 * @generated
	 */
	EReference getSelectObjectMutator_Object();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeEvaluation <em>Attribute Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Evaluation</em>'.
	 * @see mutatorenvironment.AttributeEvaluation
	 * @generated
	 */
	EClass getAttributeEvaluation();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.AttributeEvaluation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see mutatorenvironment.AttributeEvaluation#getName()
	 * @see #getAttributeEvaluation()
	 * @generated
	 */
	EReference getAttributeEvaluation_Name();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.AttributeEvaluation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see mutatorenvironment.AttributeEvaluation#getValue()
	 * @see #getAttributeEvaluation()
	 * @generated
	 */
	EReference getAttributeEvaluation_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeReverse <em>Attribute Reverse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Reverse</em>'.
	 * @see mutatorenvironment.AttributeReverse
	 * @generated
	 */
	EClass getAttributeReverse();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceSet <em>Reference Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Set</em>'.
	 * @see mutatorenvironment.ReferenceSet
	 * @generated
	 */
	EClass getReferenceSet();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.ReferenceSet#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Reference</em>'.
	 * @see mutatorenvironment.ReferenceSet#getReference()
	 * @see #getReferenceSet()
	 * @generated
	 */
	EReference getReferenceSet_Reference();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ReferenceSet#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.ReferenceSet#getObject()
	 * @see #getReferenceSet()
	 * @generated
	 */
	EReference getReferenceSet_Object();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceInit <em>Reference Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Init</em>'.
	 * @see mutatorenvironment.ReferenceInit
	 * @generated
	 */
	EClass getReferenceInit();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceAtt <em>Reference Att</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Att</em>'.
	 * @see mutatorenvironment.ReferenceAtt
	 * @generated
	 */
	EClass getReferenceAtt();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceAtt#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see mutatorenvironment.ReferenceAtt#getAttribute()
	 * @see #getReferenceAtt()
	 * @generated
	 */
	EReference getReferenceAtt_Attribute();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ReferenceAtt#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see mutatorenvironment.ReferenceAtt#getValue()
	 * @see #getReferenceAtt()
	 * @generated
	 */
	EReference getReferenceAtt_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceEvaluation <em>Reference Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Evaluation</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation
	 * @generated
	 */
	EClass getReferenceEvaluation();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceEvaluation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getName()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_Name();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceEvaluation#getRefName <em>Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Name</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getRefName()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_RefName();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceEvaluation#getRefRefName <em>Ref Ref Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Ref Name</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getRefRefName()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_RefRefName();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ReferenceEvaluation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getOperator()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EAttribute getReferenceEvaluation_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ReferenceEvaluation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getValue()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_Value();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceEvaluation#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getRefType()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_RefType();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ReferenceEvaluation#getAttName <em>Att Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Att Name</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getAttName()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_AttName();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.ReferenceEvaluation#getAttValue <em>Att Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Att Value</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#getAttValue()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EReference getReferenceEvaluation_AttValue();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ReferenceEvaluation#isContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container</em>'.
	 * @see mutatorenvironment.ReferenceEvaluation#isContainer()
	 * @see #getReferenceEvaluation()
	 * @generated
	 */
	EAttribute getReferenceEvaluation_Container();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see mutatorenvironment.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.Expression#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First</em>'.
	 * @see mutatorenvironment.Expression#getFirst()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_First();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.Expression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operator</em>'.
	 * @see mutatorenvironment.Expression#getOperator()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Operator();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.Expression#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Second</em>'.
	 * @see mutatorenvironment.Expression#getSecond()
	 * @see #getExpression()
	 * @generated
	 */
	EReference getExpression_Second();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceSwap <em>Reference Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Swap</em>'.
	 * @see mutatorenvironment.ReferenceSwap
	 * @generated
	 */
	EClass getReferenceSwap();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Evaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evaluation</em>'.
	 * @see mutatorenvironment.Evaluation
	 * @generated
	 */
	EClass getEvaluation();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator</em>'.
	 * @see mutatorenvironment.BinaryOperator
	 * @generated
	 */
	EClass getBinaryOperator();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.BinaryOperator#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see mutatorenvironment.BinaryOperator#getType()
	 * @see #getBinaryOperator()
	 * @generated
	 */
	EAttribute getBinaryOperator_Type();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see mutatorenvironment.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.Block#getName()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.Block#getCommands <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see mutatorenvironment.Block#getCommands()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Commands();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.Block#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>From</em>'.
	 * @see mutatorenvironment.Block#getFrom()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_From();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getRepeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeat</em>'.
	 * @see mutatorenvironment.Block#getRepeat()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Repeat();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.Block#getMin()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.Block#getMax()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getFixed <em>Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed</em>'.
	 * @see mutatorenvironment.Block#getFixed()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Fixed();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Block#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see mutatorenvironment.Block#getDescription()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_Description();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see mutatorenvironment.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Constraint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see mutatorenvironment.Constraint#getId()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Id();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.Constraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see mutatorenvironment.Constraint#getType()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.Constraint#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see mutatorenvironment.Constraint#getExpressions()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Expressions();

	/**
	 * Returns the meta object for the attribute list '{@link mutatorenvironment.Constraint#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Rules</em>'.
	 * @see mutatorenvironment.Constraint#getRules()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Rules();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomType <em>Random Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Type</em>'.
	 * @see mutatorenvironment.RandomType
	 * @generated
	 */
	EClass getRandomType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.CloneObjectMutator <em>Clone Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clone Object Mutator</em>'.
	 * @see mutatorenvironment.CloneObjectMutator
	 * @generated
	 */
	EClass getCloneObjectMutator();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.CloneObjectMutator#isContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Contents</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#isContents()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EAttribute getCloneObjectMutator_Contents();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.CloneObjectMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#getObject()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EReference getCloneObjectMutator_Object();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.CloneObjectMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#getContainer()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EReference getCloneObjectMutator_Container();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.CloneObjectMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#getRefType()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EReference getCloneObjectMutator_RefType();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.CloneObjectMutator#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#getAttributes()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EReference getCloneObjectMutator_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.CloneObjectMutator#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see mutatorenvironment.CloneObjectMutator#getReferences()
	 * @see #getCloneObjectMutator()
	 * @generated
	 */
	EReference getCloneObjectMutator_References();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see mutatorenvironment.ListType
	 * @generated
	 */
	EClass getListType();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.ListType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value</em>'.
	 * @see mutatorenvironment.ListType#getValue()
	 * @see #getListType()
	 * @generated
	 */
	EReference getListType_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ObjectAttributeType <em>Object Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Attribute Type</em>'.
	 * @see mutatorenvironment.ObjectAttributeType
	 * @generated
	 */
	EClass getObjectAttributeType();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObjectAttributeType#getObjSel <em>Obj Sel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Sel</em>'.
	 * @see mutatorenvironment.ObjectAttributeType#getObjSel()
	 * @see #getObjectAttributeType()
	 * @generated
	 */
	EReference getObjectAttributeType_ObjSel();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.ObjectAttributeType#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see mutatorenvironment.ObjectAttributeType#getAttribute()
	 * @see #getObjectAttributeType()
	 * @generated
	 */
	EReference getObjectAttributeType_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.ObjectAttributeType#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see mutatorenvironment.ObjectAttributeType#getOperator()
	 * @see #getObjectAttributeType()
	 * @generated
	 */
	EAttribute getObjectAttributeType_Operator();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeEvaluationType <em>Attribute Evaluation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Evaluation Type</em>'.
	 * @see mutatorenvironment.AttributeEvaluationType
	 * @generated
	 */
	EClass getAttributeEvaluationType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.MinValueType <em>Min Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Min Value Type</em>'.
	 * @see mutatorenvironment.MinValueType
	 * @generated
	 */
	EClass getMinValueType();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.MinValueType#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see mutatorenvironment.MinValueType#getAttribute()
	 * @see #getMinValueType()
	 * @generated
	 */
	EReference getMinValueType_Attribute();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.MaxValueType <em>Max Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Max Value Type</em>'.
	 * @see mutatorenvironment.MaxValueType
	 * @generated
	 */
	EClass getMaxValueType();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.MaxValueType#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see mutatorenvironment.MaxValueType#getAttribute()
	 * @see #getMaxValueType()
	 * @generated
	 */
	EReference getMaxValueType_Attribute();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.NumberType <em>Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Type</em>'.
	 * @see mutatorenvironment.NumberType
	 * @generated
	 */
	EClass getNumberType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.AttributeOperation <em>Attribute Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Operation</em>'.
	 * @see mutatorenvironment.AttributeOperation
	 * @generated
	 */
	EClass getAttributeOperation();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.AttributeOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see mutatorenvironment.AttributeOperation#getOperator()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EAttribute getAttributeOperation_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.AttributeOperation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see mutatorenvironment.AttributeOperation#getValue()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EReference getAttributeOperation_Value();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomNumberType <em>Random Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Number Type</em>'.
	 * @see mutatorenvironment.RandomNumberType
	 * @generated
	 */
	EClass getRandomNumberType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RandomNumberType#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.RandomNumberType#getObject()
	 * @see #getRandomNumberType()
	 * @generated
	 */
	EReference getRandomNumberType_Object();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.RandomNumberType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max</em>'.
	 * @see mutatorenvironment.RandomNumberType#getMax()
	 * @see #getRandomNumberType()
	 * @generated
	 */
	EReference getRandomNumberType_Max();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomDoubleNumberType <em>Random Double Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Double Number Type</em>'.
	 * @see mutatorenvironment.RandomDoubleNumberType
	 * @generated
	 */
	EClass getRandomDoubleNumberType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomDoubleNumberType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomDoubleNumberType#getMin()
	 * @see #getRandomDoubleNumberType()
	 * @generated
	 */
	EAttribute getRandomDoubleNumberType_Min();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomIntegerNumberType <em>Random Integer Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Integer Number Type</em>'.
	 * @see mutatorenvironment.RandomIntegerNumberType
	 * @generated
	 */
	EClass getRandomIntegerNumberType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomIntegerNumberType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomIntegerNumberType#getMin()
	 * @see #getRandomIntegerNumberType()
	 * @generated
	 */
	EAttribute getRandomIntegerNumberType_Min();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SpecificClosureSelection <em>Specific Closure Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Closure Selection</em>'.
	 * @see mutatorenvironment.SpecificClosureSelection
	 * @generated
	 */
	EClass getSpecificClosureSelection();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.SpecificClosureSelection#getObjSel <em>Obj Sel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Sel</em>'.
	 * @see mutatorenvironment.SpecificClosureSelection#getObjSel()
	 * @see #getSpecificClosureSelection()
	 * @generated
	 */
	EReference getSpecificClosureSelection_ObjSel();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.SelectSampleMutator <em>Select Sample Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select Sample Mutator</em>'.
	 * @see mutatorenvironment.SelectSampleMutator
	 * @generated
	 */
	EClass getSelectSampleMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.SelectSampleMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.SelectSampleMutator#getObject()
	 * @see #getSelectSampleMutator()
	 * @generated
	 */
	EReference getSelectSampleMutator_Object();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.SelectSampleMutator#getClause <em>Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Clause</em>'.
	 * @see mutatorenvironment.SelectSampleMutator#getClause()
	 * @see #getSelectSampleMutator()
	 * @generated
	 */
	EAttribute getSelectSampleMutator_Clause();

	/**
	 * Returns the meta object for the reference list '{@link mutatorenvironment.SelectSampleMutator#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see mutatorenvironment.SelectSampleMutator#getFeatures()
	 * @see #getSelectSampleMutator()
	 * @generated
	 */
	EReference getSelectSampleMutator_Features();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceAdd <em>Reference Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Add</em>'.
	 * @see mutatorenvironment.ReferenceAdd
	 * @generated
	 */
	EClass getReferenceAdd();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.ReferenceRemove <em>Reference Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Remove</em>'.
	 * @see mutatorenvironment.ReferenceRemove
	 * @generated
	 */
	EClass getReferenceRemove();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RetypeObjectMutator <em>Retype Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Retype Object Mutator</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator
	 * @generated
	 */
	EClass getRetypeObjectMutator();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RetypeObjectMutator#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator#getObject()
	 * @see #getRetypeObjectMutator()
	 * @generated
	 */
	EReference getRetypeObjectMutator_Object();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.RetypeObjectMutator#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator#getContainer()
	 * @see #getRetypeObjectMutator()
	 * @generated
	 */
	EReference getRetypeObjectMutator_Container();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.RetypeObjectMutator#getRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Type</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator#getRefType()
	 * @see #getRetypeObjectMutator()
	 * @generated
	 */
	EReference getRetypeObjectMutator_RefType();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.RetypeObjectMutator#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator#getAttributes()
	 * @see #getRetypeObjectMutator()
	 * @generated
	 */
	EReference getRetypeObjectMutator_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.RetypeObjectMutator#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see mutatorenvironment.RetypeObjectMutator#getReferences()
	 * @see #getRetypeObjectMutator()
	 * @generated
	 */
	EReference getRetypeObjectMutator_References();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.TypedSelection <em>Typed Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Selection</em>'.
	 * @see mutatorenvironment.TypedSelection
	 * @generated
	 */
	EClass getTypedSelection();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.RandomStringNumberType <em>Random String Number Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random String Number Type</em>'.
	 * @see mutatorenvironment.RandomStringNumberType
	 * @generated
	 */
	EClass getRandomStringNumberType();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringNumberType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see mutatorenvironment.RandomStringNumberType#getMin()
	 * @see #getRandomStringNumberType()
	 * @generated
	 */
	EAttribute getRandomStringNumberType_Min();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringNumberType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see mutatorenvironment.RandomStringNumberType#getMax()
	 * @see #getRandomStringNumberType()
	 * @generated
	 */
	EAttribute getRandomStringNumberType_Max();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.RandomStringNumberType#isAllowsNull <em>Allows Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allows Null</em>'.
	 * @see mutatorenvironment.RandomStringNumberType#isAllowsNull()
	 * @see #getRandomStringNumberType()
	 * @generated
	 */
	EAttribute getRandomStringNumberType_AllowsNull();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see mutatorenvironment.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.Resource#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path</em>'.
	 * @see mutatorenvironment.Resource#getPath()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Path();

	/**
	 * Returns the meta object for enum '{@link mutatorenvironment.LogicOperator <em>Logic Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Logic Operator</em>'.
	 * @see mutatorenvironment.LogicOperator
	 * @generated
	 */
	EEnum getLogicOperator();

	/**
	 * Returns the meta object for enum '{@link mutatorenvironment.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see mutatorenvironment.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the meta object for enum '{@link mutatorenvironment.Repeat <em>Repeat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Repeat</em>'.
	 * @see mutatorenvironment.Repeat
	 * @generated
	 */
	EEnum getRepeat();

	/**
	 * Returns the meta object for enum '{@link mutatorenvironment.ArithmeticOperator <em>Arithmetic Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Arithmetic Operator</em>'.
	 * @see mutatorenvironment.ArithmeticOperator
	 * @generated
	 */
	EEnum getArithmeticOperator();

	/**
	 * Returns the meta object for enum '{@link mutatorenvironment.SampleClause <em>Sample Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Sample Clause</em>'.
	 * @see mutatorenvironment.SampleClause
	 * @generated
	 */
	EEnum getSampleClause();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MutatorenvironmentFactory getMutatorenvironmentFactory();

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
		 * The meta object literal for the '{@link mutatorenvironment.impl.MutatorEnvironmentImpl <em>Mutator Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.MutatorEnvironmentImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMutatorEnvironment()
		 * @generated
		 */
		EClass MUTATOR_ENVIRONMENT = eINSTANCE.getMutatorEnvironment();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_ENVIRONMENT__DEFINITION = eINSTANCE.getMutatorEnvironment_Definition();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_ENVIRONMENT__COMMANDS = eINSTANCE.getMutatorEnvironment_Commands();

		/**
		 * The meta object literal for the '<em><b>Load</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_ENVIRONMENT__LOAD = eINSTANCE.getMutatorEnvironment_Load();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_ENVIRONMENT__BLOCKS = eINSTANCE.getMutatorEnvironment_Blocks();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATOR_ENVIRONMENT__CONSTRAINTS = eINSTANCE.getMutatorEnvironment_Constraints();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.DefinitionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION__METAMODEL = eINSTANCE.getDefinition_Metamodel();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.LibraryImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ProgramImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__OUTPUT = eINSTANCE.getProgram_Output();

		/**
		 * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__NUM = eINSTANCE.getProgram_Num();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__SOURCE = eINSTANCE.getProgram_Source();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__DESCRIPTION = eINSTANCE.getProgram_Description();

		/**
		 * The meta object literal for the '<em><b>Exhaustive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROGRAM__EXHAUSTIVE = eINSTANCE.getProgram_Exhaustive();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__RESOURCES = eINSTANCE.getProgram_Resources();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ObjectEmitterImpl <em>Object Emitter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ObjectEmitterImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObjectEmitter()
		 * @generated
		 */
		EClass OBJECT_EMITTER = eINSTANCE.getObjectEmitter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EMITTER__TYPE = eINSTANCE.getObjectEmitter_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_EMITTER__NAME = eINSTANCE.getObjectEmitter_Name();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_EMITTER__TYPES = eINSTANCE.getObjectEmitter_Types();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.MutatorImpl <em>Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.MutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMutator()
		 * @generated
		 */
		EClass MUTATOR = eINSTANCE.getMutator();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR__MIN = eINSTANCE.getMutator_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR__MAX = eINSTANCE.getMutator_Max();

		/**
		 * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTATOR__FIXED = eINSTANCE.getMutator_Fixed();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CompositeMutatorImpl <em>Composite Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CompositeMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompositeMutator()
		 * @generated
		 */
		EClass COMPOSITE_MUTATOR = eINSTANCE.getCompositeMutator();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_MUTATOR__COMMANDS = eINSTANCE.getCompositeMutator_Commands();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.LoadImpl <em>Load</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.LoadImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLoad()
		 * @generated
		 */
		EClass LOAD = eINSTANCE.getLoad();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD__FILE = eINSTANCE.getLoad_File();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CreateObjectMutatorImpl <em>Create Object Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CreateObjectMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCreateObjectMutator()
		 * @generated
		 */
		EClass CREATE_OBJECT_MUTATOR = eINSTANCE.getCreateObjectMutator();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_OBJECT_MUTATOR__CONTAINER = eINSTANCE.getCreateObjectMutator_Container();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_OBJECT_MUTATOR__ATTRIBUTES = eINSTANCE.getCreateObjectMutator_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_OBJECT_MUTATOR__REFERENCES = eINSTANCE.getCreateObjectMutator_References();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ObSelectionStrategyImpl <em>Ob Selection Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ObSelectionStrategyImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObSelectionStrategy()
		 * @generated
		 */
		EClass OB_SELECTION_STRATEGY = eINSTANCE.getObSelectionStrategy();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OB_SELECTION_STRATEGY__REF_TYPE = eINSTANCE.getObSelectionStrategy_RefType();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OB_SELECTION_STRATEGY__EXPRESSION = eINSTANCE.getObSelectionStrategy_Expression();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OB_SELECTION_STRATEGY__RESOURCE = eINSTANCE.getObSelectionStrategy_Resource();

		/**
		 * The meta object literal for the '<em><b>Ref Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OB_SELECTION_STRATEGY__REF_REF_TYPE = eINSTANCE.getObSelectionStrategy_RefRefType();

		/**
		 * The meta object literal for the '<em><b>Ref Ref Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OB_SELECTION_STRATEGY__REF_REF_REF_TYPE = eINSTANCE.getObSelectionStrategy_RefRefRefType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomSelectionImpl <em>Random Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomSelection()
		 * @generated
		 */
		EClass RANDOM_SELECTION = eINSTANCE.getRandomSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomTypeSelectionImpl <em>Random Type Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomTypeSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomTypeSelection()
		 * @generated
		 */
		EClass RANDOM_TYPE_SELECTION = eINSTANCE.getRandomTypeSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificObjectSelectionImpl <em>Specific Object Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificObjectSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificObjectSelection()
		 * @generated
		 */
		EClass SPECIFIC_OBJECT_SELECTION = eINSTANCE.getSpecificObjectSelection();

		/**
		 * The meta object literal for the '<em><b>Obj Sel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_OBJECT_SELECTION__OBJ_SEL = eINSTANCE.getSpecificObjectSelection_ObjSel();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeScalarImpl <em>Attribute Scalar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeScalarImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeScalar()
		 * @generated
		 */
		EClass ATTRIBUTE_SCALAR = eINSTANCE.getAttributeScalar();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_SCALAR__VALUE = eINSTANCE.getAttributeScalar_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeTypeImpl <em>Attribute Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeType()
		 * @generated
		 */
		EClass ATTRIBUTE_TYPE = eINSTANCE.getAttributeType();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_TYPE__OPERATOR = eINSTANCE.getAttributeType_Operator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.BooleanTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificBooleanTypeImpl <em>Specific Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificBooleanTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificBooleanType()
		 * @generated
		 */
		EClass SPECIFIC_BOOLEAN_TYPE = eINSTANCE.getSpecificBooleanType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_BOOLEAN_TYPE__VALUE = eINSTANCE.getSpecificBooleanType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomBooleanTypeImpl <em>Random Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomBooleanTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomBooleanType()
		 * @generated
		 */
		EClass RANDOM_BOOLEAN_TYPE = eINSTANCE.getRandomBooleanType();

		/**
		 * The meta object literal for the '<em><b>Allows Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_BOOLEAN_TYPE__ALLOWS_NULL = eINSTANCE.getRandomBooleanType_AllowsNull();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.StringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificStringTypeImpl <em>Specific String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificStringType()
		 * @generated
		 */
		EClass SPECIFIC_STRING_TYPE = eINSTANCE.getSpecificStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_STRING_TYPE__VALUE = eINSTANCE.getSpecificStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomStringTypeImpl <em>Random String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomStringType()
		 * @generated
		 */
		EClass RANDOM_STRING_TYPE = eINSTANCE.getRandomStringType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_TYPE__MIN = eINSTANCE.getRandomStringType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_TYPE__MAX = eINSTANCE.getRandomStringType_Max();

		/**
		 * The meta object literal for the '<em><b>Allows Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_TYPE__ALLOWS_NULL = eINSTANCE.getRandomStringType_AllowsNull();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.IntegerTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificIntegerTypeImpl <em>Specific Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificIntegerTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificIntegerType()
		 * @generated
		 */
		EClass SPECIFIC_INTEGER_TYPE = eINSTANCE.getSpecificIntegerType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_INTEGER_TYPE__VALUE = eINSTANCE.getSpecificIntegerType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomIntegerTypeImpl <em>Random Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomIntegerTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomIntegerType()
		 * @generated
		 */
		EClass RANDOM_INTEGER_TYPE = eINSTANCE.getRandomIntegerType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_INTEGER_TYPE__MIN = eINSTANCE.getRandomIntegerType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_INTEGER_TYPE__MAX = eINSTANCE.getRandomIntegerType_Max();

		/**
		 * The meta object literal for the '<em><b>Allows Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_INTEGER_TYPE__ALLOWS_NULL = eINSTANCE.getRandomIntegerType_AllowsNull();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.DoubleTypeImpl <em>Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.DoubleTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getDoubleType()
		 * @generated
		 */
		EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificDoubleTypeImpl <em>Specific Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificDoubleTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificDoubleType()
		 * @generated
		 */
		EClass SPECIFIC_DOUBLE_TYPE = eINSTANCE.getSpecificDoubleType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFIC_DOUBLE_TYPE__VALUE = eINSTANCE.getSpecificDoubleType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomDoubleTypeImpl <em>Random Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomDoubleTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomDoubleType()
		 * @generated
		 */
		EClass RANDOM_DOUBLE_TYPE = eINSTANCE.getRandomDoubleType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_DOUBLE_TYPE__MIN = eINSTANCE.getRandomDoubleType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_DOUBLE_TYPE__MAX = eINSTANCE.getRandomDoubleType_Max();

		/**
		 * The meta object literal for the '<em><b>Allows Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_DOUBLE_TYPE__ALLOWS_NULL = eINSTANCE.getRandomDoubleType_AllowsNull();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ModifySourceReferenceMutatorImpl <em>Modify Source Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ModifySourceReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifySourceReferenceMutator()
		 * @generated
		 */
		EClass MODIFY_SOURCE_REFERENCE_MUTATOR = eINSTANCE.getModifySourceReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getModifySourceReferenceMutator_RefType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE = eINSTANCE.getModifySourceReferenceMutator_Source();

		/**
		 * The meta object literal for the '<em><b>New Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE = eINSTANCE.getModifySourceReferenceMutator_NewSource();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificSelectionImpl <em>Specific Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificSelection()
		 * @generated
		 */
		EClass SPECIFIC_SELECTION = eINSTANCE.getSpecificSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificReferenceSelectionImpl <em>Specific Reference Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificReferenceSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificReferenceSelection()
		 * @generated
		 */
		EClass SPECIFIC_REFERENCE_SELECTION = eINSTANCE.getSpecificReferenceSelection();

		/**
		 * The meta object literal for the '<em><b>Obj Sel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_REFERENCE_SELECTION__OBJ_SEL = eINSTANCE.getSpecificReferenceSelection_ObjSel();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl <em>Modify Target Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifyTargetReferenceMutator()
		 * @generated
		 */
		EClass MODIFY_TARGET_REFERENCE_MUTATOR = eINSTANCE.getModifyTargetReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getModifyTargetReferenceMutator_RefType();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE = eINSTANCE.getModifyTargetReferenceMutator_Source();

		/**
		 * The meta object literal for the '<em><b>New Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET = eINSTANCE.getModifyTargetReferenceMutator_NewTarget();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CreateReferenceMutatorImpl <em>Create Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CreateReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCreateReferenceMutator()
		 * @generated
		 */
		EClass CREATE_REFERENCE_MUTATOR = eINSTANCE.getCreateReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_REFERENCE_MUTATOR__SOURCE = eINSTANCE.getCreateReferenceMutator_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_REFERENCE_MUTATOR__TARGET = eINSTANCE.getCreateReferenceMutator_Target();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getCreateReferenceMutator_RefType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RemoveObjectMutatorImpl <em>Remove Object Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RemoveObjectMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveObjectMutator()
		 * @generated
		 */
		EClass REMOVE_OBJECT_MUTATOR = eINSTANCE.getRemoveObjectMutator();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_OBJECT_MUTATOR__OBJECT = eINSTANCE.getRemoveObjectMutator_Object();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_OBJECT_MUTATOR__CONTAINER = eINSTANCE.getRemoveObjectMutator_Container();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RemoveReferenceMutatorImpl <em>Remove Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RemoveReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveReferenceMutator()
		 * @generated
		 */
		EClass REMOVE_REFERENCE_MUTATOR = eINSTANCE.getRemoveReferenceMutator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ModifyInformationMutatorImpl <em>Modify Information Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ModifyInformationMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getModifyInformationMutator()
		 * @generated
		 */
		EClass MODIFY_INFORMATION_MUTATOR = eINSTANCE.getModifyInformationMutator();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_INFORMATION_MUTATOR__OBJECT = eINSTANCE.getModifyInformationMutator_Object();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_INFORMATION_MUTATOR__ATTRIBUTES = eINSTANCE.getModifyInformationMutator_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFY_INFORMATION_MUTATOR__REFERENCES = eINSTANCE.getModifyInformationMutator_References();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.UpperStringTypeImpl <em>Upper String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.UpperStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getUpperStringType()
		 * @generated
		 */
		EClass UPPER_STRING_TYPE = eINSTANCE.getUpperStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UPPER_STRING_TYPE__VALUE = eINSTANCE.getUpperStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.LowerStringTypeImpl <em>Lower String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.LowerStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLowerStringType()
		 * @generated
		 */
		EClass LOWER_STRING_TYPE = eINSTANCE.getLowerStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOWER_STRING_TYPE__VALUE = eINSTANCE.getLowerStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ListStringTypeImpl <em>List String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ListStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getListStringType()
		 * @generated
		 */
		EClass LIST_STRING_TYPE = eINSTANCE.getListStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST_STRING_TYPE__VALUE = eINSTANCE.getListStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CatStartStringTypeImpl <em>Cat Start String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CatStartStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCatStartStringType()
		 * @generated
		 */
		EClass CAT_START_STRING_TYPE = eINSTANCE.getCatStartStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAT_START_STRING_TYPE__VALUE = eINSTANCE.getCatStartStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CatEndStringTypeImpl <em>Cat End String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CatEndStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCatEndStringType()
		 * @generated
		 */
		EClass CAT_END_STRING_TYPE = eINSTANCE.getCatEndStringType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAT_END_STRING_TYPE__VALUE = eINSTANCE.getCatEndStringType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeUnsetImpl <em>Attribute Unset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeUnsetImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeUnset()
		 * @generated
		 */
		EClass ATTRIBUTE_UNSET = eINSTANCE.getAttributeUnset();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeSetImpl <em>Attribute Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeSetImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeSet()
		 * @generated
		 */
		EClass ATTRIBUTE_SET = eINSTANCE.getAttributeSet();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_SET__ATTRIBUTE = eINSTANCE.getAttributeSet_Attribute();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeSwapImpl <em>Attribute Swap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeSwapImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeSwap()
		 * @generated
		 */
		EClass ATTRIBUTE_SWAP = eINSTANCE.getAttributeSwap();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_SWAP__OBJECT = eINSTANCE.getAttributeSwap_Object();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReplaceStringTypeImpl <em>Replace String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReplaceStringTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReplaceStringType()
		 * @generated
		 */
		EClass REPLACE_STRING_TYPE = eINSTANCE.getReplaceStringType();

		/**
		 * The meta object literal for the '<em><b>Oldstring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACE_STRING_TYPE__OLDSTRING = eINSTANCE.getReplaceStringType_Oldstring();

		/**
		 * The meta object literal for the '<em><b>Newstring</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLACE_STRING_TYPE__NEWSTRING = eINSTANCE.getReplaceStringType_Newstring();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeCopyImpl <em>Attribute Copy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeCopyImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeCopy()
		 * @generated
		 */
		EClass ATTRIBUTE_COPY = eINSTANCE.getAttributeCopy();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_COPY__OBJECT = eINSTANCE.getAttributeCopy_Object();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RemoveRandomReferenceMutatorImpl <em>Remove Random Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RemoveRandomReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveRandomReferenceMutator()
		 * @generated
		 */
		EClass REMOVE_RANDOM_REFERENCE_MUTATOR = eINSTANCE.getRemoveRandomReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_RANDOM_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getRemoveRandomReferenceMutator_RefType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RemoveSpecificReferenceMutatorImpl <em>Remove Specific Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RemoveSpecificReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveSpecificReferenceMutator()
		 * @generated
		 */
		EClass REMOVE_SPECIFIC_REFERENCE_MUTATOR = eINSTANCE.getRemoveSpecificReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_SPECIFIC_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getRemoveSpecificReferenceMutator_RefType();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_SPECIFIC_REFERENCE_MUTATOR__CONTAINER = eINSTANCE.getRemoveSpecificReferenceMutator_Container();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CompleteSelectionImpl <em>Complete Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CompleteSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompleteSelection()
		 * @generated
		 */
		EClass COMPLETE_SELECTION = eINSTANCE.getCompleteSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CompleteTypeSelectionImpl <em>Complete Type Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CompleteTypeSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCompleteTypeSelection()
		 * @generated
		 */
		EClass COMPLETE_TYPE_SELECTION = eINSTANCE.getCompleteTypeSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RemoveCompleteReferenceMutatorImpl <em>Remove Complete Reference Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RemoveCompleteReferenceMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRemoveCompleteReferenceMutator()
		 * @generated
		 */
		EClass REMOVE_COMPLETE_REFERENCE_MUTATOR = eINSTANCE.getRemoveCompleteReferenceMutator();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REMOVE_COMPLETE_REFERENCE_MUTATOR__REF_TYPE = eINSTANCE.getRemoveCompleteReferenceMutator_RefType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SourceImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSource()
		 * @generated
		 */
		EClass SOURCE = eINSTANCE.getSource();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE__PATH = eINSTANCE.getSource_Path();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.OtherSelectionImpl <em>Other Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.OtherSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOtherSelection()
		 * @generated
		 */
		EClass OTHER_SELECTION = eINSTANCE.getOtherSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.OtherTypeSelectionImpl <em>Other Type Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.OtherTypeSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOtherTypeSelection()
		 * @generated
		 */
		EClass OTHER_TYPE_SELECTION = eINSTANCE.getOtherTypeSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SelectObjectMutatorImpl <em>Select Object Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SelectObjectMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSelectObjectMutator()
		 * @generated
		 */
		EClass SELECT_OBJECT_MUTATOR = eINSTANCE.getSelectObjectMutator();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_OBJECT_MUTATOR__CONTAINER = eINSTANCE.getSelectObjectMutator_Container();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_OBJECT_MUTATOR__OBJECT = eINSTANCE.getSelectObjectMutator_Object();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeEvaluationImpl <em>Attribute Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeEvaluationImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeEvaluation()
		 * @generated
		 */
		EClass ATTRIBUTE_EVALUATION = eINSTANCE.getAttributeEvaluation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_EVALUATION__NAME = eINSTANCE.getAttributeEvaluation_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_EVALUATION__VALUE = eINSTANCE.getAttributeEvaluation_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeReverseImpl <em>Attribute Reverse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeReverseImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeReverse()
		 * @generated
		 */
		EClass ATTRIBUTE_REVERSE = eINSTANCE.getAttributeReverse();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceSetImpl <em>Reference Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceSetImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceSet()
		 * @generated
		 */
		EClass REFERENCE_SET = eINSTANCE.getReferenceSet();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SET__REFERENCE = eINSTANCE.getReferenceSet_Reference();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_SET__OBJECT = eINSTANCE.getReferenceSet_Object();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceInitImpl <em>Reference Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceInitImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceInit()
		 * @generated
		 */
		EClass REFERENCE_INIT = eINSTANCE.getReferenceInit();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceAttImpl <em>Reference Att</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceAttImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceAtt()
		 * @generated
		 */
		EClass REFERENCE_ATT = eINSTANCE.getReferenceAtt();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ATT__ATTRIBUTE = eINSTANCE.getReferenceAtt_Attribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ATT__VALUE = eINSTANCE.getReferenceAtt_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceEvaluationImpl <em>Reference Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceEvaluationImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceEvaluation()
		 * @generated
		 */
		EClass REFERENCE_EVALUATION = eINSTANCE.getReferenceEvaluation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__NAME = eINSTANCE.getReferenceEvaluation_Name();

		/**
		 * The meta object literal for the '<em><b>Ref Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__REF_NAME = eINSTANCE.getReferenceEvaluation_RefName();

		/**
		 * The meta object literal for the '<em><b>Ref Ref Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__REF_REF_NAME = eINSTANCE.getReferenceEvaluation_RefRefName();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_EVALUATION__OPERATOR = eINSTANCE.getReferenceEvaluation_Operator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__VALUE = eINSTANCE.getReferenceEvaluation_Value();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__REF_TYPE = eINSTANCE.getReferenceEvaluation_RefType();

		/**
		 * The meta object literal for the '<em><b>Att Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__ATT_NAME = eINSTANCE.getReferenceEvaluation_AttName();

		/**
		 * The meta object literal for the '<em><b>Att Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_EVALUATION__ATT_VALUE = eINSTANCE.getReferenceEvaluation_AttValue();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_EVALUATION__CONTAINER = eINSTANCE.getReferenceEvaluation_Container();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ExpressionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__FIRST = eINSTANCE.getExpression_First();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__OPERATOR = eINSTANCE.getExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION__SECOND = eINSTANCE.getExpression_Second();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceSwapImpl <em>Reference Swap</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceSwapImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceSwap()
		 * @generated
		 */
		EClass REFERENCE_SWAP = eINSTANCE.getReferenceSwap();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.EvaluationImpl <em>Evaluation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.EvaluationImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getEvaluation()
		 * @generated
		 */
		EClass EVALUATION = eINSTANCE.getEvaluation();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.BinaryOperatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBinaryOperator()
		 * @generated
		 */
		EClass BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_OPERATOR__TYPE = eINSTANCE.getBinaryOperator_Type();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.BlockImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__NAME = eINSTANCE.getBlock_Name();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__COMMANDS = eINSTANCE.getBlock_Commands();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__FROM = eINSTANCE.getBlock_From();

		/**
		 * The meta object literal for the '<em><b>Repeat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__REPEAT = eINSTANCE.getBlock_Repeat();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__MIN = eINSTANCE.getBlock_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__MAX = eINSTANCE.getBlock_Max();

		/**
		 * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__FIXED = eINSTANCE.getBlock_Fixed();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK__DESCRIPTION = eINSTANCE.getBlock_Description();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ConstraintImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__ID = eINSTANCE.getConstraint_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__TYPE = eINSTANCE.getConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__EXPRESSIONS = eINSTANCE.getConstraint_Expressions();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__RULES = eINSTANCE.getConstraint_Rules();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomTypeImpl <em>Random Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomType()
		 * @generated
		 */
		EClass RANDOM_TYPE = eINSTANCE.getRandomType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.CloneObjectMutatorImpl <em>Clone Object Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.CloneObjectMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getCloneObjectMutator()
		 * @generated
		 */
		EClass CLONE_OBJECT_MUTATOR = eINSTANCE.getCloneObjectMutator();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLONE_OBJECT_MUTATOR__CONTENTS = eINSTANCE.getCloneObjectMutator_Contents();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_OBJECT_MUTATOR__OBJECT = eINSTANCE.getCloneObjectMutator_Object();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_OBJECT_MUTATOR__CONTAINER = eINSTANCE.getCloneObjectMutator_Container();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_OBJECT_MUTATOR__REF_TYPE = eINSTANCE.getCloneObjectMutator_RefType();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_OBJECT_MUTATOR__ATTRIBUTES = eINSTANCE.getCloneObjectMutator_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLONE_OBJECT_MUTATOR__REFERENCES = eINSTANCE.getCloneObjectMutator_References();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ListTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getListType()
		 * @generated
		 */
		EClass LIST_TYPE = eINSTANCE.getListType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST_TYPE__VALUE = eINSTANCE.getListType_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ObjectAttributeTypeImpl <em>Object Attribute Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ObjectAttributeTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getObjectAttributeType()
		 * @generated
		 */
		EClass OBJECT_ATTRIBUTE_TYPE = eINSTANCE.getObjectAttributeType();

		/**
		 * The meta object literal for the '<em><b>Obj Sel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_ATTRIBUTE_TYPE__OBJ_SEL = eINSTANCE.getObjectAttributeType_ObjSel();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE = eINSTANCE.getObjectAttributeType_Attribute();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_ATTRIBUTE_TYPE__OPERATOR = eINSTANCE.getObjectAttributeType_Operator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeEvaluationTypeImpl <em>Attribute Evaluation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeEvaluationTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeEvaluationType()
		 * @generated
		 */
		EClass ATTRIBUTE_EVALUATION_TYPE = eINSTANCE.getAttributeEvaluationType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.MinValueTypeImpl <em>Min Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.MinValueTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMinValueType()
		 * @generated
		 */
		EClass MIN_VALUE_TYPE = eINSTANCE.getMinValueType();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIN_VALUE_TYPE__ATTRIBUTE = eINSTANCE.getMinValueType_Attribute();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.MaxValueTypeImpl <em>Max Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.MaxValueTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getMaxValueType()
		 * @generated
		 */
		EClass MAX_VALUE_TYPE = eINSTANCE.getMaxValueType();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAX_VALUE_TYPE__ATTRIBUTE = eINSTANCE.getMaxValueType_Attribute();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.NumberTypeImpl <em>Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.NumberTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getNumberType()
		 * @generated
		 */
		EClass NUMBER_TYPE = eINSTANCE.getNumberType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.AttributeOperationImpl <em>Attribute Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.AttributeOperationImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getAttributeOperation()
		 * @generated
		 */
		EClass ATTRIBUTE_OPERATION = eINSTANCE.getAttributeOperation();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPERATION__OPERATOR = eINSTANCE.getAttributeOperation_Operator();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_OPERATION__VALUE = eINSTANCE.getAttributeOperation_Value();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomNumberTypeImpl <em>Random Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomNumberTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomNumberType()
		 * @generated
		 */
		EClass RANDOM_NUMBER_TYPE = eINSTANCE.getRandomNumberType();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_NUMBER_TYPE__OBJECT = eINSTANCE.getRandomNumberType_Object();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANDOM_NUMBER_TYPE__MAX = eINSTANCE.getRandomNumberType_Max();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomDoubleNumberTypeImpl <em>Random Double Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomDoubleNumberTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomDoubleNumberType()
		 * @generated
		 */
		EClass RANDOM_DOUBLE_NUMBER_TYPE = eINSTANCE.getRandomDoubleNumberType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_DOUBLE_NUMBER_TYPE__MIN = eINSTANCE.getRandomDoubleNumberType_Min();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomIntegerNumberTypeImpl <em>Random Integer Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomIntegerNumberTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomIntegerNumberType()
		 * @generated
		 */
		EClass RANDOM_INTEGER_NUMBER_TYPE = eINSTANCE.getRandomIntegerNumberType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_INTEGER_NUMBER_TYPE__MIN = eINSTANCE.getRandomIntegerNumberType_Min();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SpecificClosureSelectionImpl <em>Specific Closure Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SpecificClosureSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSpecificClosureSelection()
		 * @generated
		 */
		EClass SPECIFIC_CLOSURE_SELECTION = eINSTANCE.getSpecificClosureSelection();

		/**
		 * The meta object literal for the '<em><b>Obj Sel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_CLOSURE_SELECTION__OBJ_SEL = eINSTANCE.getSpecificClosureSelection_ObjSel();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.SelectSampleMutatorImpl <em>Select Sample Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.SelectSampleMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSelectSampleMutator()
		 * @generated
		 */
		EClass SELECT_SAMPLE_MUTATOR = eINSTANCE.getSelectSampleMutator();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_SAMPLE_MUTATOR__OBJECT = eINSTANCE.getSelectSampleMutator_Object();

		/**
		 * The meta object literal for the '<em><b>Clause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT_SAMPLE_MUTATOR__CLAUSE = eINSTANCE.getSelectSampleMutator_Clause();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECT_SAMPLE_MUTATOR__FEATURES = eINSTANCE.getSelectSampleMutator_Features();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceAddImpl <em>Reference Add</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceAddImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceAdd()
		 * @generated
		 */
		EClass REFERENCE_ADD = eINSTANCE.getReferenceAdd();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ReferenceRemoveImpl <em>Reference Remove</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ReferenceRemoveImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getReferenceRemove()
		 * @generated
		 */
		EClass REFERENCE_REMOVE = eINSTANCE.getReferenceRemove();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RetypeObjectMutatorImpl <em>Retype Object Mutator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RetypeObjectMutatorImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRetypeObjectMutator()
		 * @generated
		 */
		EClass RETYPE_OBJECT_MUTATOR = eINSTANCE.getRetypeObjectMutator();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETYPE_OBJECT_MUTATOR__OBJECT = eINSTANCE.getRetypeObjectMutator_Object();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETYPE_OBJECT_MUTATOR__CONTAINER = eINSTANCE.getRetypeObjectMutator_Container();

		/**
		 * The meta object literal for the '<em><b>Ref Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETYPE_OBJECT_MUTATOR__REF_TYPE = eINSTANCE.getRetypeObjectMutator_RefType();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETYPE_OBJECT_MUTATOR__ATTRIBUTES = eINSTANCE.getRetypeObjectMutator_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETYPE_OBJECT_MUTATOR__REFERENCES = eINSTANCE.getRetypeObjectMutator_References();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.TypedSelectionImpl <em>Typed Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.TypedSelectionImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getTypedSelection()
		 * @generated
		 */
		EClass TYPED_SELECTION = eINSTANCE.getTypedSelection();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.RandomStringNumberTypeImpl <em>Random String Number Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.RandomStringNumberTypeImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRandomStringNumberType()
		 * @generated
		 */
		EClass RANDOM_STRING_NUMBER_TYPE = eINSTANCE.getRandomStringNumberType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_NUMBER_TYPE__MIN = eINSTANCE.getRandomStringNumberType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_NUMBER_TYPE__MAX = eINSTANCE.getRandomStringNumberType_Max();

		/**
		 * The meta object literal for the '<em><b>Allows Null</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_STRING_NUMBER_TYPE__ALLOWS_NULL = eINSTANCE.getRandomStringNumberType_AllowsNull();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.impl.ResourceImpl
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__PATH = eINSTANCE.getResource_Path();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.LogicOperator <em>Logic Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.LogicOperator
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getLogicOperator()
		 * @generated
		 */
		EEnum LOGIC_OPERATOR = eINSTANCE.getLogicOperator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.Operator
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.Repeat <em>Repeat</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.Repeat
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getRepeat()
		 * @generated
		 */
		EEnum REPEAT = eINSTANCE.getRepeat();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.ArithmeticOperator <em>Arithmetic Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.ArithmeticOperator
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getArithmeticOperator()
		 * @generated
		 */
		EEnum ARITHMETIC_OPERATOR = eINSTANCE.getArithmeticOperator();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.SampleClause <em>Sample Clause</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.SampleClause
		 * @see mutatorenvironment.impl.MutatorenvironmentPackageImpl#getSampleClause()
		 * @generated
		 */
		EEnum SAMPLE_CLAUSE = eINSTANCE.getSampleClause();

	}

} //MutatorenvironmentPackage
