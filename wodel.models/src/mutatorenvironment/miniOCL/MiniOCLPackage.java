/**
 */
package mutatorenvironment.miniOCL;

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
 * @see mutatorenvironment.miniOCL.MiniOCLFactory
 * @model kind="package"
 * @generated
 */
public interface MiniOCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "miniOCL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ac.uk/york/cs/miniocl/MiniOCLCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "miniOCL";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MiniOCLPackage eINSTANCE = mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl.init();

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.RootCSImpl <em>Root CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.RootCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getRootCS()
	 * @generated
	 */
	int ROOT_CS = 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__PACKAGES = 0;

	/**
	 * The feature id for the '<em><b>Contraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS__CONTRAINTS = 1;

	/**
	 * The number of structural features of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Root CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PackageCSImpl <em>Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PackageCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPackageCS()
	 * @generated
	 */
	int PACKAGE_CS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__PACKAGES = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS__CLASSES = 2;

	/**
	 * The number of structural features of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Package CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ClassCSImpl <em>Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ClassCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getClassCS()
	 * @generated
	 */
	int CLASS_CS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__EXTENDS = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__PROPERTIES = 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS__OPERATIONS = 3;

	/**
	 * The number of structural features of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Class CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PropertyCSImpl <em>Property CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PropertyCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPropertyCS()
	 * @generated
	 */
	int PROPERTY_CS = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CS__TYPE_REF = 1;

	/**
	 * The number of structural features of the '<em>Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.OperationCSImpl <em>Operation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.OperationCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getOperationCS()
	 * @generated
	 */
	int OPERATION_CS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__PARAMS = 1;

	/**
	 * The feature id for the '<em><b>Result Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__RESULT_REF = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS__BODY = 3;

	/**
	 * The number of structural features of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Operation CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ParameterCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getParameterCS()
	 * @generated
	 */
	int PARAMETER_CS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS__TYPE_REF = 1;

	/**
	 * The number of structural features of the '<em>Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Parameter CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ConstraintCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getConstraintCS()
	 * @generated
	 */
	int CONSTRAINT_CS = 6;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__TYPE_REF = 0;

	/**
	 * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS__INVARIANTS = 1;

	/**
	 * The number of structural features of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.InvariantCSImpl <em>Invariant CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.InvariantCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getInvariantCS()
	 * @generated
	 */
	int INVARIANT_CS = 7;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CS__EXP = 0;

	/**
	 * The number of structural features of the '<em>Invariant CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Invariant CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVARIANT_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ExpCSImpl <em>Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getExpCS()
	 * @generated
	 */
	int EXP_CS = 8;

	/**
	 * The number of structural features of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.LogicExpCSImpl <em>Logic Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.LogicExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLogicExpCS()
	 * @generated
	 */
	int LOGIC_EXP_CS = 9;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_EXP_CS__LEFT = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_EXP_CS__OP = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_EXP_CS__RIGHT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Logic Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Logic Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_EXP_CS_OPERATION_COUNT = EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.CallExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getCallExpCS()
	 * @generated
	 */
	int CALL_EXP_CS = 10;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__LEFT = LOGIC_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__OP = LOGIC_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__RIGHT = LOGIC_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__SOURCE = LOGIC_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__NAV_EXP = LOGIC_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS_FEATURE_COUNT = LOGIC_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS_OPERATION_COUNT = LOGIC_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PrimaryExpCSImpl <em>Primary Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PrimaryExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPrimaryExpCS()
	 * @generated
	 */
	int PRIMARY_EXP_CS = 11;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS__LEFT = CALL_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS__OP = CALL_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS__RIGHT = CALL_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS__SOURCE = CALL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS__NAV_EXP = CALL_EXP_CS__NAV_EXP;

	/**
	 * The number of structural features of the '<em>Primary Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS_FEATURE_COUNT = CALL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primary Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_CS_OPERATION_COUNT = CALL_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationExpCSImpl <em>Navigation Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationExpCS()
	 * @generated
	 */
	int NAVIGATION_EXP_CS = 12;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS__LEFT = PRIMARY_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS__OP = PRIMARY_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS__RIGHT = PRIMARY_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS__SOURCE = PRIMARY_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS__NAV_EXP = PRIMARY_EXP_CS__NAV_EXP;

	/**
	 * The number of structural features of the '<em>Navigation Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Navigation Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EXP_CS_OPERATION_COUNT = PRIMARY_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NameExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNameExpCS()
	 * @generated
	 */
	int NAME_EXP_CS = 13;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__LEFT = NAVIGATION_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OP = NAVIGATION_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__RIGHT = NAVIGATION_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__SOURCE = NAVIGATION_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__NAV_EXP = NAVIGATION_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>Exp Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__EXP_NAME = NAVIGATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rounded Brackets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__ROUNDED_BRACKETS = NAVIGATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__CALL_EXP = NAVIGATION_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS_FEATURE_COUNT = NAVIGATION_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS_OPERATION_COUNT = NAVIGATION_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.LoopExpCSImpl <em>Loop Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.LoopExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLoopExpCS()
	 * @generated
	 */
	int LOOP_EXP_CS = 14;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__LEFT = NAVIGATION_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__OP = NAVIGATION_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__RIGHT = NAVIGATION_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__SOURCE = NAVIGATION_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__NAV_EXP = NAVIGATION_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__IT_VAR = NAVIGATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__LOGIC_OP = NAVIGATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS__EXP = NAVIGATION_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS_FEATURE_COUNT = NAVIGATION_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Loop Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_CS_OPERATION_COUNT = NAVIGATION_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.CollectExpCSImpl <em>Collect Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.CollectExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getCollectExpCS()
	 * @generated
	 */
	int COLLECT_EXP_CS = 15;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__LEFT = LOOP_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__OP = LOOP_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__RIGHT = LOOP_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__NAV_EXP = LOOP_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__IT_VAR = LOOP_EXP_CS__IT_VAR;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__LOGIC_OP = LOOP_EXP_CS__LOGIC_OP;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS__EXP = LOOP_EXP_CS__EXP;

	/**
	 * The number of structural features of the '<em>Collect Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Collect Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECT_EXP_CS_OPERATION_COUNT = LOOP_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.IteratorVarCSImpl <em>Iterator Var CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.IteratorVarCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIteratorVarCS()
	 * @generated
	 */
	int ITERATOR_VAR_CS = 16;

	/**
	 * The feature id for the '<em><b>It Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VAR_CS__IT_NAME = 0;

	/**
	 * The feature id for the '<em><b>It Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VAR_CS__IT_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Iterator Var CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VAR_CS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Iterator Var CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_VAR_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.IterateExpCSImpl <em>Iterate Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.IterateExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIterateExpCS()
	 * @generated
	 */
	int ITERATE_EXP_CS = 17;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__LEFT = LOOP_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__OP = LOOP_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__RIGHT = LOOP_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__NAV_EXP = LOOP_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__IT_VAR = LOOP_EXP_CS__IT_VAR;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__LOGIC_OP = LOOP_EXP_CS__LOGIC_OP;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__EXP = LOOP_EXP_CS__EXP;

	/**
	 * The feature id for the '<em><b>Acc Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS__ACC_VAR = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterate Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Iterate Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_CS_OPERATION_COUNT = LOOP_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.AccVarCSImpl <em>Acc Var CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.AccVarCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getAccVarCS()
	 * @generated
	 */
	int ACC_VAR_CS = 18;

	/**
	 * The feature id for the '<em><b>Acc Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACC_VAR_CS__ACC_VAR_NAME = 0;

	/**
	 * The feature id for the '<em><b>Acc Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACC_VAR_CS__ACC_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Acc Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACC_VAR_CS__ACC_INIT_EXP = 2;

	/**
	 * The number of structural features of the '<em>Acc Var CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACC_VAR_CS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Acc Var CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACC_VAR_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.RoundedBracketClauseCSImpl <em>Rounded Bracket Clause CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.RoundedBracketClauseCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getRoundedBracketClauseCS()
	 * @generated
	 */
	int ROUNDED_BRACKET_CLAUSE_CS = 19;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_BRACKET_CLAUSE_CS__ARGS = 0;

	/**
	 * The number of structural features of the '<em>Rounded Bracket Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_BRACKET_CLAUSE_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Rounded Bracket Clause CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_BRACKET_CLAUSE_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.LiteralExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 20;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__LEFT = PRIMARY_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__OP = PRIMARY_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__RIGHT = PRIMARY_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__SOURCE = PRIMARY_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__NAV_EXP = PRIMARY_EXP_CS__NAV_EXP;

	/**
	 * The number of structural features of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_OPERATION_COUNT = PRIMARY_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.IntLiteralExpCSImpl <em>Int Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.IntLiteralExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIntLiteralExpCS()
	 * @generated
	 */
	int INT_LITERAL_EXP_CS = 21;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__LEFT = LITERAL_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__OP = LITERAL_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__RIGHT = LITERAL_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__SOURCE = LITERAL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__NAV_EXP = LITERAL_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>Int Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS__INT_SYMBOL = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Int Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_EXP_CS_OPERATION_COUNT = LITERAL_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.StringLiteralExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 22;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__LEFT = LITERAL_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__OP = LITERAL_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__RIGHT = LITERAL_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__SOURCE = LITERAL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__NAV_EXP = LITERAL_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__STRING_SYMBOL = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS_OPERATION_COUNT = LITERAL_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.BooleanLiteralExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 23;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__LEFT = LITERAL_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__OP = LITERAL_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__RIGHT = LITERAL_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__SOURCE = LITERAL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__NAV_EXP = LITERAL_EXP_CS__NAV_EXP;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS_OPERATION_COUNT = LITERAL_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PathNameCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathNameCS()
	 * @generated
	 */
	int PATH_NAME_CS = 24;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__PATH = 0;

	/**
	 * The number of structural features of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PathCSImpl <em>Path CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PathCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathCS()
	 * @generated
	 */
	int PATH_CS = 25;

	/**
	 * The number of structural features of the '<em>Path CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Path CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PathVariableCSImpl <em>Path Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PathVariableCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathVariableCS()
	 * @generated
	 */
	int PATH_VARIABLE_CS = 26;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_VARIABLE_CS__VAR_NAME = PATH_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_VARIABLE_CS_FEATURE_COUNT = PATH_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_VARIABLE_CS_OPERATION_COUNT = PATH_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.PathElementCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathElementCS()
	 * @generated
	 */
	int PATH_ELEMENT_CS = 27;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS__PATH_NAME = PATH_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS_FEATURE_COUNT = PATH_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_ELEMENT_CS_OPERATION_COUNT = PATH_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.BooleanExpCSImpl <em>Boolean Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.BooleanExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getBooleanExpCS()
	 * @generated
	 */
	int BOOLEAN_EXP_CS = 28;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__LEFT = BOOLEAN_LITERAL_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__OP = BOOLEAN_LITERAL_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__RIGHT = BOOLEAN_LITERAL_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__SOURCE = BOOLEAN_LITERAL_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__NAV_EXP = BOOLEAN_LITERAL_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>Bool Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS__BOOL_SYMBOL = BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS_FEATURE_COUNT = BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_EXP_CS_OPERATION_COUNT = BOOLEAN_LITERAL_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ExistsExpCSImpl <em>Exists Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ExistsExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getExistsExpCS()
	 * @generated
	 */
	int EXISTS_EXP_CS = 29;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__LEFT = LOOP_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__OP = LOOP_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__RIGHT = LOOP_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__NAV_EXP = LOOP_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__IT_VAR = LOOP_EXP_CS__IT_VAR;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__LOGIC_OP = LOOP_EXP_CS__LOGIC_OP;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__EXP = LOOP_EXP_CS__EXP;

	/**
	 * The feature id for the '<em><b>Acc Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS__ACC_VARS = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exists Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Exists Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_EXP_CS_OPERATION_COUNT = LOOP_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationNameExpCSImpl <em>Navigation Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationNameExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationNameExpCS()
	 * @generated
	 */
	int NAVIGATION_NAME_EXP_CS = 30;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__LEFT = NAVIGATION_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__OP = NAVIGATION_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__RIGHT = NAVIGATION_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__SOURCE = NAVIGATION_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__NAV_EXP = NAVIGATION_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>Exp Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__EXP_NAME = NAVIGATION_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rounded Brackets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__ROUNDED_BRACKETS = NAVIGATION_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS__CALL_EXP = NAVIGATION_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Navigation Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS_FEATURE_COUNT = NAVIGATION_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Navigation Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_NAME_EXP_CS_OPERATION_COUNT = NAVIGATION_EXP_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathNameCSImpl <em>Navigation Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationPathNameCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathNameCS()
	 * @generated
	 */
	int NAVIGATION_PATH_NAME_CS = 31;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_NAME_CS__PATH = 0;

	/**
	 * The number of structural features of the '<em>Navigation Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_NAME_CS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Navigation Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_NAME_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathCSImpl <em>Navigation Path CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationPathCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathCS()
	 * @generated
	 */
	int NAVIGATION_PATH_CS = 32;

	/**
	 * The number of structural features of the '<em>Navigation Path CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_CS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Navigation Path CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_CS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathVariableCSImpl <em>Navigation Path Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationPathVariableCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathVariableCS()
	 * @generated
	 */
	int NAVIGATION_PATH_VARIABLE_CS = 33;

	/**
	 * The feature id for the '<em><b>Var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_VARIABLE_CS__VAR_NAME = NAVIGATION_PATH_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Navigation Path Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_VARIABLE_CS_FEATURE_COUNT = NAVIGATION_PATH_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Navigation Path Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_VARIABLE_CS_OPERATION_COUNT = NAVIGATION_PATH_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathElementCSImpl <em>Navigation Path Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.NavigationPathElementCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathElementCS()
	 * @generated
	 */
	int NAVIGATION_PATH_ELEMENT_CS = 34;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_ELEMENT_CS__PATH_NAME = NAVIGATION_PATH_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Navigation Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_ELEMENT_CS_FEATURE_COUNT = NAVIGATION_PATH_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Navigation Path Element CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_PATH_ELEMENT_CS_OPERATION_COUNT = NAVIGATION_PATH_CS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link mutatorenvironment.miniOCL.impl.ForAllExpCSImpl <em>For All Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see mutatorenvironment.miniOCL.impl.ForAllExpCSImpl
	 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getForAllExpCS()
	 * @generated
	 */
	int FOR_ALL_EXP_CS = 35;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__LEFT = LOOP_EXP_CS__LEFT;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__OP = LOOP_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__RIGHT = LOOP_EXP_CS__RIGHT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__SOURCE = LOOP_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Nav Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__NAV_EXP = LOOP_EXP_CS__NAV_EXP;

	/**
	 * The feature id for the '<em><b>It Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__IT_VAR = LOOP_EXP_CS__IT_VAR;

	/**
	 * The feature id for the '<em><b>Logic Op</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__LOGIC_OP = LOOP_EXP_CS__LOGIC_OP;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__EXP = LOOP_EXP_CS__EXP;

	/**
	 * The feature id for the '<em><b>Acc Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS__ACC_VARS = LOOP_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For All Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS_FEATURE_COUNT = LOOP_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>For All Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_ALL_EXP_CS_OPERATION_COUNT = LOOP_EXP_CS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS</em>'.
	 * @see mutatorenvironment.miniOCL.RootCS
	 * @generated
	 */
	EClass getRootCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.RootCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see mutatorenvironment.miniOCL.RootCS#getPackages()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.RootCS#getContraints <em>Contraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contraints</em>'.
	 * @see mutatorenvironment.miniOCL.RootCS#getContraints()
	 * @see #getRootCS()
	 * @generated
	 */
	EReference getRootCS_Contraints();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS</em>'.
	 * @see mutatorenvironment.miniOCL.PackageCS
	 * @generated
	 */
	EClass getPackageCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.PackageCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.miniOCL.PackageCS#getName()
	 * @see #getPackageCS()
	 * @generated
	 */
	EAttribute getPackageCS_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.PackageCS#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packages</em>'.
	 * @see mutatorenvironment.miniOCL.PackageCS#getPackages()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.PackageCS#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see mutatorenvironment.miniOCL.PackageCS#getClasses()
	 * @see #getPackageCS()
	 * @generated
	 */
	EReference getPackageCS_Classes();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS</em>'.
	 * @see mutatorenvironment.miniOCL.ClassCS
	 * @generated
	 */
	EClass getClassCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.ClassCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.miniOCL.ClassCS#getName()
	 * @see #getClassCS()
	 * @generated
	 */
	EAttribute getClassCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.ClassCS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see mutatorenvironment.miniOCL.ClassCS#getExtends()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.ClassCS#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see mutatorenvironment.miniOCL.ClassCS#getProperties()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.ClassCS#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see mutatorenvironment.miniOCL.ClassCS#getOperations()
	 * @see #getClassCS()
	 * @generated
	 */
	EReference getClassCS_Operations();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PropertyCS <em>Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property CS</em>'.
	 * @see mutatorenvironment.miniOCL.PropertyCS
	 * @generated
	 */
	EClass getPropertyCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.PropertyCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.miniOCL.PropertyCS#getName()
	 * @see #getPropertyCS()
	 * @generated
	 */
	EAttribute getPropertyCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.PropertyCS#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see mutatorenvironment.miniOCL.PropertyCS#getTypeRef()
	 * @see #getPropertyCS()
	 * @generated
	 */
	EReference getPropertyCS_TypeRef();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation CS</em>'.
	 * @see mutatorenvironment.miniOCL.OperationCS
	 * @generated
	 */
	EClass getOperationCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.OperationCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.miniOCL.OperationCS#getName()
	 * @see #getOperationCS()
	 * @generated
	 */
	EAttribute getOperationCS_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.OperationCS#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see mutatorenvironment.miniOCL.OperationCS#getParams()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Params();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.OperationCS#getResultRef <em>Result Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Ref</em>'.
	 * @see mutatorenvironment.miniOCL.OperationCS#getResultRef()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_ResultRef();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.OperationCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see mutatorenvironment.miniOCL.OperationCS#getBody()
	 * @see #getOperationCS()
	 * @generated
	 */
	EReference getOperationCS_Body();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter CS</em>'.
	 * @see mutatorenvironment.miniOCL.ParameterCS
	 * @generated
	 */
	EClass getParameterCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.ParameterCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see mutatorenvironment.miniOCL.ParameterCS#getName()
	 * @see #getParameterCS()
	 * @generated
	 */
	EAttribute getParameterCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.ParameterCS#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see mutatorenvironment.miniOCL.ParameterCS#getTypeRef()
	 * @see #getParameterCS()
	 * @generated
	 */
	EReference getParameterCS_TypeRef();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint CS</em>'.
	 * @see mutatorenvironment.miniOCL.ConstraintCS
	 * @generated
	 */
	EClass getConstraintCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.ConstraintCS#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see mutatorenvironment.miniOCL.ConstraintCS#getTypeRef()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_TypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.ConstraintCS#getInvariants <em>Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invariants</em>'.
	 * @see mutatorenvironment.miniOCL.ConstraintCS#getInvariants()
	 * @see #getConstraintCS()
	 * @generated
	 */
	EReference getConstraintCS_Invariants();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.InvariantCS <em>Invariant CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invariant CS</em>'.
	 * @see mutatorenvironment.miniOCL.InvariantCS
	 * @generated
	 */
	EClass getInvariantCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.InvariantCS#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp</em>'.
	 * @see mutatorenvironment.miniOCL.InvariantCS#getExp()
	 * @see #getInvariantCS()
	 * @generated
	 */
	EReference getInvariantCS_Exp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.ExpCS
	 * @generated
	 */
	EClass getExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.LogicExpCS <em>Logic Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logic Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.LogicExpCS
	 * @generated
	 */
	EClass getLogicExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.LogicExpCS#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see mutatorenvironment.miniOCL.LogicExpCS#getLeft()
	 * @see #getLogicExpCS()
	 * @generated
	 */
	EReference getLogicExpCS_Left();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.LogicExpCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see mutatorenvironment.miniOCL.LogicExpCS#getOp()
	 * @see #getLogicExpCS()
	 * @generated
	 */
	EAttribute getLogicExpCS_Op();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.LogicExpCS#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see mutatorenvironment.miniOCL.LogicExpCS#getRight()
	 * @see #getLogicExpCS()
	 * @generated
	 */
	EReference getLogicExpCS_Right();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.CallExpCS
	 * @generated
	 */
	EClass getCallExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.CallExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see mutatorenvironment.miniOCL.CallExpCS#getSource()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_Source();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.CallExpCS#getNavExp <em>Nav Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Nav Exp</em>'.
	 * @see mutatorenvironment.miniOCL.CallExpCS#getNavExp()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_NavExp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PrimaryExpCS <em>Primary Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.PrimaryExpCS
	 * @generated
	 */
	EClass getPrimaryExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationExpCS <em>Navigation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationExpCS
	 * @generated
	 */
	EClass getNavigationExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.NameExpCS
	 * @generated
	 */
	EClass getNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NameExpCS#getExpName <em>Exp Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp Name</em>'.
	 * @see mutatorenvironment.miniOCL.NameExpCS#getExpName()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_ExpName();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rounded Brackets</em>'.
	 * @see mutatorenvironment.miniOCL.NameExpCS#getRoundedBrackets()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_RoundedBrackets();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NameExpCS#getCallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Exp</em>'.
	 * @see mutatorenvironment.miniOCL.NameExpCS#getCallExp()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_CallExp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.LoopExpCS <em>Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.LoopExpCS
	 * @generated
	 */
	EClass getLoopExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.LoopExpCS#getItVar <em>It Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>It Var</em>'.
	 * @see mutatorenvironment.miniOCL.LoopExpCS#getItVar()
	 * @see #getLoopExpCS()
	 * @generated
	 */
	EReference getLoopExpCS_ItVar();

	/**
	 * Returns the meta object for the attribute list '{@link mutatorenvironment.miniOCL.LoopExpCS#getLogicOp <em>Logic Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Logic Op</em>'.
	 * @see mutatorenvironment.miniOCL.LoopExpCS#getLogicOp()
	 * @see #getLoopExpCS()
	 * @generated
	 */
	EAttribute getLoopExpCS_LogicOp();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.LoopExpCS#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exp</em>'.
	 * @see mutatorenvironment.miniOCL.LoopExpCS#getExp()
	 * @see #getLoopExpCS()
	 * @generated
	 */
	EReference getLoopExpCS_Exp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.CollectExpCS <em>Collect Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collect Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.CollectExpCS
	 * @generated
	 */
	EClass getCollectExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.IteratorVarCS <em>Iterator Var CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Var CS</em>'.
	 * @see mutatorenvironment.miniOCL.IteratorVarCS
	 * @generated
	 */
	EClass getIteratorVarCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.IteratorVarCS#getItName <em>It Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>It Name</em>'.
	 * @see mutatorenvironment.miniOCL.IteratorVarCS#getItName()
	 * @see #getIteratorVarCS()
	 * @generated
	 */
	EAttribute getIteratorVarCS_ItName();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.IteratorVarCS#getItType <em>It Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>It Type</em>'.
	 * @see mutatorenvironment.miniOCL.IteratorVarCS#getItType()
	 * @see #getIteratorVarCS()
	 * @generated
	 */
	EReference getIteratorVarCS_ItType();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.IterateExpCS <em>Iterate Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.IterateExpCS
	 * @generated
	 */
	EClass getIterateExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.IterateExpCS#getAccVar <em>Acc Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acc Var</em>'.
	 * @see mutatorenvironment.miniOCL.IterateExpCS#getAccVar()
	 * @see #getIterateExpCS()
	 * @generated
	 */
	EReference getIterateExpCS_AccVar();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.AccVarCS <em>Acc Var CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acc Var CS</em>'.
	 * @see mutatorenvironment.miniOCL.AccVarCS
	 * @generated
	 */
	EClass getAccVarCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.AccVarCS#getAccVarName <em>Acc Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Acc Var Name</em>'.
	 * @see mutatorenvironment.miniOCL.AccVarCS#getAccVarName()
	 * @see #getAccVarCS()
	 * @generated
	 */
	EAttribute getAccVarCS_AccVarName();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.AccVarCS#getAccType <em>Acc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acc Type</em>'.
	 * @see mutatorenvironment.miniOCL.AccVarCS#getAccType()
	 * @see #getAccVarCS()
	 * @generated
	 */
	EReference getAccVarCS_AccType();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.AccVarCS#getAccInitExp <em>Acc Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Acc Init Exp</em>'.
	 * @see mutatorenvironment.miniOCL.AccVarCS#getAccInitExp()
	 * @see #getAccVarCS()
	 * @generated
	 */
	EReference getAccVarCS_AccInitExp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.RoundedBracketClauseCS <em>Rounded Bracket Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rounded Bracket Clause CS</em>'.
	 * @see mutatorenvironment.miniOCL.RoundedBracketClauseCS
	 * @generated
	 */
	EClass getRoundedBracketClauseCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.RoundedBracketClauseCS#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see mutatorenvironment.miniOCL.RoundedBracketClauseCS#getArgs()
	 * @see #getRoundedBracketClauseCS()
	 * @generated
	 */
	EReference getRoundedBracketClauseCS_Args();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.LiteralExpCS
	 * @generated
	 */
	EClass getLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.IntLiteralExpCS <em>Int Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.IntLiteralExpCS
	 * @generated
	 */
	EClass getIntLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.IntLiteralExpCS#getIntSymbol <em>Int Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Int Symbol</em>'.
	 * @see mutatorenvironment.miniOCL.IntLiteralExpCS#getIntSymbol()
	 * @see #getIntLiteralExpCS()
	 * @generated
	 */
	EAttribute getIntLiteralExpCS_IntSymbol();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.StringLiteralExpCS
	 * @generated
	 */
	EClass getStringLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.StringLiteralExpCS#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see mutatorenvironment.miniOCL.StringLiteralExpCS#getStringSymbol()
	 * @see #getStringLiteralExpCS()
	 * @generated
	 */
	EAttribute getStringLiteralExpCS_StringSymbol();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.BooleanLiteralExpCS
	 * @generated
	 */
	EClass getBooleanLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name CS</em>'.
	 * @see mutatorenvironment.miniOCL.PathNameCS
	 * @generated
	 */
	EClass getPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.PathNameCS#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see mutatorenvironment.miniOCL.PathNameCS#getPath()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_Path();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PathCS <em>Path CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path CS</em>'.
	 * @see mutatorenvironment.miniOCL.PathCS
	 * @generated
	 */
	EClass getPathCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PathVariableCS <em>Path Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Variable CS</em>'.
	 * @see mutatorenvironment.miniOCL.PathVariableCS
	 * @generated
	 */
	EClass getPathVariableCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.PathVariableCS#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see mutatorenvironment.miniOCL.PathVariableCS#getVarName()
	 * @see #getPathVariableCS()
	 * @generated
	 */
	EAttribute getPathVariableCS_VarName();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Element CS</em>'.
	 * @see mutatorenvironment.miniOCL.PathElementCS
	 * @generated
	 */
	EClass getPathElementCS();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.miniOCL.PathElementCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Path Name</em>'.
	 * @see mutatorenvironment.miniOCL.PathElementCS#getPathName()
	 * @see #getPathElementCS()
	 * @generated
	 */
	EReference getPathElementCS_PathName();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.BooleanExpCS <em>Boolean Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.BooleanExpCS
	 * @generated
	 */
	EClass getBooleanExpCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.BooleanExpCS#isBoolSymbol <em>Bool Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bool Symbol</em>'.
	 * @see mutatorenvironment.miniOCL.BooleanExpCS#isBoolSymbol()
	 * @see #getBooleanExpCS()
	 * @generated
	 */
	EAttribute getBooleanExpCS_BoolSymbol();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ExistsExpCS <em>Exists Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.ExistsExpCS
	 * @generated
	 */
	EClass getExistsExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.ExistsExpCS#getAccVars <em>Acc Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Acc Vars</em>'.
	 * @see mutatorenvironment.miniOCL.ExistsExpCS#getAccVars()
	 * @see #getExistsExpCS()
	 * @generated
	 */
	EReference getExistsExpCS_AccVars();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationNameExpCS <em>Navigation Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Name Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationNameExpCS
	 * @generated
	 */
	EClass getNavigationNameExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NavigationNameExpCS#getExpName <em>Exp Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exp Name</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationNameExpCS#getExpName()
	 * @see #getNavigationNameExpCS()
	 * @generated
	 */
	EReference getNavigationNameExpCS_ExpName();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NavigationNameExpCS#getRoundedBrackets <em>Rounded Brackets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rounded Brackets</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationNameExpCS#getRoundedBrackets()
	 * @see #getNavigationNameExpCS()
	 * @generated
	 */
	EReference getNavigationNameExpCS_RoundedBrackets();

	/**
	 * Returns the meta object for the containment reference '{@link mutatorenvironment.miniOCL.NavigationNameExpCS#getCallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call Exp</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationNameExpCS#getCallExp()
	 * @see #getNavigationNameExpCS()
	 * @generated
	 */
	EReference getNavigationNameExpCS_CallExp();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationPathNameCS <em>Navigation Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Path Name CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathNameCS
	 * @generated
	 */
	EClass getNavigationPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.NavigationPathNameCS#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathNameCS#getPath()
	 * @see #getNavigationPathNameCS()
	 * @generated
	 */
	EReference getNavigationPathNameCS_Path();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationPathCS <em>Navigation Path CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Path CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathCS
	 * @generated
	 */
	EClass getNavigationPathCS();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationPathVariableCS <em>Navigation Path Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Path Variable CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathVariableCS
	 * @generated
	 */
	EClass getNavigationPathVariableCS();

	/**
	 * Returns the meta object for the attribute '{@link mutatorenvironment.miniOCL.NavigationPathVariableCS#getVarName <em>Var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Name</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathVariableCS#getVarName()
	 * @see #getNavigationPathVariableCS()
	 * @generated
	 */
	EAttribute getNavigationPathVariableCS_VarName();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.NavigationPathElementCS <em>Navigation Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Path Element CS</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathElementCS
	 * @generated
	 */
	EClass getNavigationPathElementCS();

	/**
	 * Returns the meta object for the reference '{@link mutatorenvironment.miniOCL.NavigationPathElementCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Path Name</em>'.
	 * @see mutatorenvironment.miniOCL.NavigationPathElementCS#getPathName()
	 * @see #getNavigationPathElementCS()
	 * @generated
	 */
	EReference getNavigationPathElementCS_PathName();

	/**
	 * Returns the meta object for class '{@link mutatorenvironment.miniOCL.ForAllExpCS <em>For All Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For All Exp CS</em>'.
	 * @see mutatorenvironment.miniOCL.ForAllExpCS
	 * @generated
	 */
	EClass getForAllExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link mutatorenvironment.miniOCL.ForAllExpCS#getAccVars <em>Acc Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Acc Vars</em>'.
	 * @see mutatorenvironment.miniOCL.ForAllExpCS#getAccVars()
	 * @see #getForAllExpCS()
	 * @generated
	 */
	EReference getForAllExpCS_AccVars();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MiniOCLFactory getMiniOCLFactory();

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
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.RootCSImpl <em>Root CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.RootCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getRootCS()
		 * @generated
		 */
		EClass ROOT_CS = eINSTANCE.getRootCS();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__PACKAGES = eINSTANCE.getRootCS_Packages();

		/**
		 * The meta object literal for the '<em><b>Contraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS__CONTRAINTS = eINSTANCE.getRootCS_Contraints();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PackageCSImpl <em>Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PackageCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPackageCS()
		 * @generated
		 */
		EClass PACKAGE_CS = eINSTANCE.getPackageCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_CS__NAME = eINSTANCE.getPackageCS_Name();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__PACKAGES = eINSTANCE.getPackageCS_Packages();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS__CLASSES = eINSTANCE.getPackageCS_Classes();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ClassCSImpl <em>Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ClassCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getClassCS()
		 * @generated
		 */
		EClass CLASS_CS = eINSTANCE.getClassCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_CS__NAME = eINSTANCE.getClassCS_Name();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__EXTENDS = eINSTANCE.getClassCS_Extends();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__PROPERTIES = eINSTANCE.getClassCS_Properties();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS__OPERATIONS = eINSTANCE.getClassCS_Operations();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PropertyCSImpl <em>Property CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PropertyCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPropertyCS()
		 * @generated
		 */
		EClass PROPERTY_CS = eINSTANCE.getPropertyCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_CS__NAME = eINSTANCE.getPropertyCS_Name();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CS__TYPE_REF = eINSTANCE.getPropertyCS_TypeRef();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.OperationCSImpl <em>Operation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.OperationCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getOperationCS()
		 * @generated
		 */
		EClass OPERATION_CS = eINSTANCE.getOperationCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_CS__NAME = eINSTANCE.getOperationCS_Name();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__PARAMS = eINSTANCE.getOperationCS_Params();

		/**
		 * The meta object literal for the '<em><b>Result Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__RESULT_REF = eINSTANCE.getOperationCS_ResultRef();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CS__BODY = eINSTANCE.getOperationCS_Body();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ParameterCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getParameterCS()
		 * @generated
		 */
		EClass PARAMETER_CS = eINSTANCE.getParameterCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_CS__NAME = eINSTANCE.getParameterCS_Name();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_CS__TYPE_REF = eINSTANCE.getParameterCS_TypeRef();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ConstraintCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getConstraintCS()
		 * @generated
		 */
		EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__TYPE_REF = eINSTANCE.getConstraintCS_TypeRef();

		/**
		 * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT_CS__INVARIANTS = eINSTANCE.getConstraintCS_Invariants();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.InvariantCSImpl <em>Invariant CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.InvariantCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getInvariantCS()
		 * @generated
		 */
		EClass INVARIANT_CS = eINSTANCE.getInvariantCS();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVARIANT_CS__EXP = eINSTANCE.getInvariantCS_Exp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ExpCSImpl <em>Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getExpCS()
		 * @generated
		 */
		EClass EXP_CS = eINSTANCE.getExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.LogicExpCSImpl <em>Logic Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.LogicExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLogicExpCS()
		 * @generated
		 */
		EClass LOGIC_EXP_CS = eINSTANCE.getLogicExpCS();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIC_EXP_CS__LEFT = eINSTANCE.getLogicExpCS_Left();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_EXP_CS__OP = eINSTANCE.getLogicExpCS_Op();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIC_EXP_CS__RIGHT = eINSTANCE.getLogicExpCS_Right();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.CallExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getCallExpCS()
		 * @generated
		 */
		EClass CALL_EXP_CS = eINSTANCE.getCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__SOURCE = eINSTANCE.getCallExpCS_Source();

		/**
		 * The meta object literal for the '<em><b>Nav Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__NAV_EXP = eINSTANCE.getCallExpCS_NavExp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PrimaryExpCSImpl <em>Primary Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PrimaryExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPrimaryExpCS()
		 * @generated
		 */
		EClass PRIMARY_EXP_CS = eINSTANCE.getPrimaryExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationExpCSImpl <em>Navigation Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationExpCS()
		 * @generated
		 */
		EClass NAVIGATION_EXP_CS = eINSTANCE.getNavigationExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NameExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNameExpCS()
		 * @generated
		 */
		EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Exp Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__EXP_NAME = eINSTANCE.getNameExpCS_ExpName();

		/**
		 * The meta object literal for the '<em><b>Rounded Brackets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__ROUNDED_BRACKETS = eINSTANCE.getNameExpCS_RoundedBrackets();

		/**
		 * The meta object literal for the '<em><b>Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__CALL_EXP = eINSTANCE.getNameExpCS_CallExp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.LoopExpCSImpl <em>Loop Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.LoopExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLoopExpCS()
		 * @generated
		 */
		EClass LOOP_EXP_CS = eINSTANCE.getLoopExpCS();

		/**
		 * The meta object literal for the '<em><b>It Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_CS__IT_VAR = eINSTANCE.getLoopExpCS_ItVar();

		/**
		 * The meta object literal for the '<em><b>Logic Op</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_EXP_CS__LOGIC_OP = eINSTANCE.getLoopExpCS_LogicOp();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_CS__EXP = eINSTANCE.getLoopExpCS_Exp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.CollectExpCSImpl <em>Collect Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.CollectExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getCollectExpCS()
		 * @generated
		 */
		EClass COLLECT_EXP_CS = eINSTANCE.getCollectExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.IteratorVarCSImpl <em>Iterator Var CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.IteratorVarCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIteratorVarCS()
		 * @generated
		 */
		EClass ITERATOR_VAR_CS = eINSTANCE.getIteratorVarCS();

		/**
		 * The meta object literal for the '<em><b>It Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR_VAR_CS__IT_NAME = eINSTANCE.getIteratorVarCS_ItName();

		/**
		 * The meta object literal for the '<em><b>It Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_VAR_CS__IT_TYPE = eINSTANCE.getIteratorVarCS_ItType();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.IterateExpCSImpl <em>Iterate Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.IterateExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIterateExpCS()
		 * @generated
		 */
		EClass ITERATE_EXP_CS = eINSTANCE.getIterateExpCS();

		/**
		 * The meta object literal for the '<em><b>Acc Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_EXP_CS__ACC_VAR = eINSTANCE.getIterateExpCS_AccVar();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.AccVarCSImpl <em>Acc Var CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.AccVarCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getAccVarCS()
		 * @generated
		 */
		EClass ACC_VAR_CS = eINSTANCE.getAccVarCS();

		/**
		 * The meta object literal for the '<em><b>Acc Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACC_VAR_CS__ACC_VAR_NAME = eINSTANCE.getAccVarCS_AccVarName();

		/**
		 * The meta object literal for the '<em><b>Acc Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACC_VAR_CS__ACC_TYPE = eINSTANCE.getAccVarCS_AccType();

		/**
		 * The meta object literal for the '<em><b>Acc Init Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACC_VAR_CS__ACC_INIT_EXP = eINSTANCE.getAccVarCS_AccInitExp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.RoundedBracketClauseCSImpl <em>Rounded Bracket Clause CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.RoundedBracketClauseCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getRoundedBracketClauseCS()
		 * @generated
		 */
		EClass ROUNDED_BRACKET_CLAUSE_CS = eINSTANCE.getRoundedBracketClauseCS();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUNDED_BRACKET_CLAUSE_CS__ARGS = eINSTANCE.getRoundedBracketClauseCS_Args();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.LiteralExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getLiteralExpCS()
		 * @generated
		 */
		EClass LITERAL_EXP_CS = eINSTANCE.getLiteralExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.IntLiteralExpCSImpl <em>Int Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.IntLiteralExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getIntLiteralExpCS()
		 * @generated
		 */
		EClass INT_LITERAL_EXP_CS = eINSTANCE.getIntLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Int Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_LITERAL_EXP_CS__INT_SYMBOL = eINSTANCE.getIntLiteralExpCS_IntSymbol();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.StringLiteralExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getStringLiteralExpCS()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_CS__STRING_SYMBOL = eINSTANCE.getStringLiteralExpCS_StringSymbol();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.BooleanLiteralExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getBooleanLiteralExpCS()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PathNameCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathNameCS()
		 * @generated
		 */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__PATH = eINSTANCE.getPathNameCS_Path();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PathCSImpl <em>Path CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PathCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathCS()
		 * @generated
		 */
		EClass PATH_CS = eINSTANCE.getPathCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PathVariableCSImpl <em>Path Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PathVariableCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathVariableCS()
		 * @generated
		 */
		EClass PATH_VARIABLE_CS = eINSTANCE.getPathVariableCS();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_VARIABLE_CS__VAR_NAME = eINSTANCE.getPathVariableCS_VarName();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.PathElementCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getPathElementCS()
		 * @generated
		 */
		EClass PATH_ELEMENT_CS = eINSTANCE.getPathElementCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_ELEMENT_CS__PATH_NAME = eINSTANCE.getPathElementCS_PathName();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.BooleanExpCSImpl <em>Boolean Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.BooleanExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getBooleanExpCS()
		 * @generated
		 */
		EClass BOOLEAN_EXP_CS = eINSTANCE.getBooleanExpCS();

		/**
		 * The meta object literal for the '<em><b>Bool Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_EXP_CS__BOOL_SYMBOL = eINSTANCE.getBooleanExpCS_BoolSymbol();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ExistsExpCSImpl <em>Exists Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ExistsExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getExistsExpCS()
		 * @generated
		 */
		EClass EXISTS_EXP_CS = eINSTANCE.getExistsExpCS();

		/**
		 * The meta object literal for the '<em><b>Acc Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXISTS_EXP_CS__ACC_VARS = eINSTANCE.getExistsExpCS_AccVars();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationNameExpCSImpl <em>Navigation Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationNameExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationNameExpCS()
		 * @generated
		 */
		EClass NAVIGATION_NAME_EXP_CS = eINSTANCE.getNavigationNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Exp Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_NAME_EXP_CS__EXP_NAME = eINSTANCE.getNavigationNameExpCS_ExpName();

		/**
		 * The meta object literal for the '<em><b>Rounded Brackets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_NAME_EXP_CS__ROUNDED_BRACKETS = eINSTANCE.getNavigationNameExpCS_RoundedBrackets();

		/**
		 * The meta object literal for the '<em><b>Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_NAME_EXP_CS__CALL_EXP = eINSTANCE.getNavigationNameExpCS_CallExp();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathNameCSImpl <em>Navigation Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationPathNameCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathNameCS()
		 * @generated
		 */
		EClass NAVIGATION_PATH_NAME_CS = eINSTANCE.getNavigationPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_PATH_NAME_CS__PATH = eINSTANCE.getNavigationPathNameCS_Path();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathCSImpl <em>Navigation Path CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationPathCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathCS()
		 * @generated
		 */
		EClass NAVIGATION_PATH_CS = eINSTANCE.getNavigationPathCS();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathVariableCSImpl <em>Navigation Path Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationPathVariableCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathVariableCS()
		 * @generated
		 */
		EClass NAVIGATION_PATH_VARIABLE_CS = eINSTANCE.getNavigationPathVariableCS();

		/**
		 * The meta object literal for the '<em><b>Var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_PATH_VARIABLE_CS__VAR_NAME = eINSTANCE.getNavigationPathVariableCS_VarName();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.NavigationPathElementCSImpl <em>Navigation Path Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.NavigationPathElementCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getNavigationPathElementCS()
		 * @generated
		 */
		EClass NAVIGATION_PATH_ELEMENT_CS = eINSTANCE.getNavigationPathElementCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_PATH_ELEMENT_CS__PATH_NAME = eINSTANCE.getNavigationPathElementCS_PathName();

		/**
		 * The meta object literal for the '{@link mutatorenvironment.miniOCL.impl.ForAllExpCSImpl <em>For All Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see mutatorenvironment.miniOCL.impl.ForAllExpCSImpl
		 * @see mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl#getForAllExpCS()
		 * @generated
		 */
		EClass FOR_ALL_EXP_CS = eINSTANCE.getForAllExpCS();

		/**
		 * The meta object literal for the '<em><b>Acc Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_ALL_EXP_CS__ACC_VARS = eINSTANCE.getForAllExpCS_AccVars();

	}

} //MiniOCLPackage
