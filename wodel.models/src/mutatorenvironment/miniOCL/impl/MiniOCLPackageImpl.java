/**
 */
package mutatorenvironment.miniOCL.impl;

import edutest.EdutestPackage;
import edutest.impl.EdutestPackageImpl;
import mutatorenvironment.MutatorenvironmentPackage;

import mutatorenvironment.impl.MutatorenvironmentPackageImpl;

import mutatorenvironment.miniOCL.AccVarCS;
import mutatorenvironment.miniOCL.BooleanExpCS;
import mutatorenvironment.miniOCL.BooleanLiteralExpCS;
import mutatorenvironment.miniOCL.CallExpCS;
import mutatorenvironment.miniOCL.ClassCS;
import mutatorenvironment.miniOCL.CollectExpCS;
import mutatorenvironment.miniOCL.ConstraintCS;
import mutatorenvironment.miniOCL.ExistsExpCS;
import mutatorenvironment.miniOCL.ExpCS;
import mutatorenvironment.miniOCL.ForAllExpCS;
import mutatorenvironment.miniOCL.IntLiteralExpCS;
import mutatorenvironment.miniOCL.InvariantCS;
import mutatorenvironment.miniOCL.IterateExpCS;
import mutatorenvironment.miniOCL.IteratorVarCS;
import mutatorenvironment.miniOCL.LiteralExpCS;
import mutatorenvironment.miniOCL.LogicExpCS;
import mutatorenvironment.miniOCL.LoopExpCS;
import mutatorenvironment.miniOCL.MiniOCLFactory;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.NameExpCS;
import mutatorenvironment.miniOCL.NavigationExpCS;
import mutatorenvironment.miniOCL.NavigationNameExpCS;
import mutatorenvironment.miniOCL.NavigationPathCS;
import mutatorenvironment.miniOCL.NavigationPathElementCS;
import mutatorenvironment.miniOCL.NavigationPathNameCS;
import mutatorenvironment.miniOCL.NavigationPathVariableCS;
import mutatorenvironment.miniOCL.OperationCS;
import mutatorenvironment.miniOCL.PackageCS;
import mutatorenvironment.miniOCL.ParameterCS;
import mutatorenvironment.miniOCL.PathCS;
import mutatorenvironment.miniOCL.PathElementCS;
import mutatorenvironment.miniOCL.PathNameCS;
import mutatorenvironment.miniOCL.PathVariableCS;
import mutatorenvironment.miniOCL.PrimaryExpCS;
import mutatorenvironment.miniOCL.PropertyCS;
import mutatorenvironment.miniOCL.RootCS;
import mutatorenvironment.miniOCL.RoundedBracketClauseCS;
import mutatorenvironment.miniOCL.StringLiteralExpCS;

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
public class MiniOCLPackageImpl extends EPackageImpl implements MiniOCLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invariantCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorVarCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accVarCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundedBracketClauseCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationNameExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationPathNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationPathCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationPathVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationPathElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forAllExpCSEClass = null;

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
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MiniOCLPackageImpl() {
		super(eNS_URI, MiniOCLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MiniOCLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MiniOCLPackage init() {
		if (isInited) return (MiniOCLPackage)EPackage.Registry.INSTANCE.getEPackage(MiniOCLPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMiniOCLPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MiniOCLPackageImpl theMiniOCLPackage = registeredMiniOCLPackage instanceof MiniOCLPackageImpl ? (MiniOCLPackageImpl)registeredMiniOCLPackage : new MiniOCLPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EdutestPackage.eNS_URI);
		EdutestPackageImpl theEdutestPackage = (EdutestPackageImpl)(registeredPackage instanceof EdutestPackageImpl ? registeredPackage : EdutestPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MutatorenvironmentPackage.eNS_URI);
		MutatorenvironmentPackageImpl theMutatorenvironmentPackage = (MutatorenvironmentPackageImpl)(registeredPackage instanceof MutatorenvironmentPackageImpl ? registeredPackage : MutatorenvironmentPackage.eINSTANCE);

		// Create package meta-data objects
		theMiniOCLPackage.createPackageContents();
		theEdutestPackage.createPackageContents();
		theMutatorenvironmentPackage.createPackageContents();

		// Initialize created meta-data
		theMiniOCLPackage.initializePackageContents();
		theEdutestPackage.initializePackageContents();
		theMutatorenvironmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMiniOCLPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MiniOCLPackage.eNS_URI, theMiniOCLPackage);
		return theMiniOCLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRootCS() {
		return rootCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootCS_Packages() {
		return (EReference)rootCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootCS_Contraints() {
		return (EReference)rootCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPackageCS() {
		return packageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPackageCS_Name() {
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPackageCS_Packages() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPackageCS_Classes() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassCS() {
		return classCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClassCS_Name() {
		return (EAttribute)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassCS_Extends() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassCS_Properties() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassCS_Operations() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyCS() {
		return propertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPropertyCS_Name() {
		return (EAttribute)propertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyCS_TypeRef() {
		return (EReference)propertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOperationCS() {
		return operationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOperationCS_Name() {
		return (EAttribute)operationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationCS_Params() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationCS_ResultRef() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOperationCS_Body() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterCS() {
		return parameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameterCS_Name() {
		return (EAttribute)parameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterCS_TypeRef() {
		return (EReference)parameterCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraintCS() {
		return constraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraintCS_TypeRef() {
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraintCS_Invariants() {
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInvariantCS() {
		return invariantCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInvariantCS_Exp() {
		return (EReference)invariantCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExpCS() {
		return expCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLogicExpCS() {
		return logicExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLogicExpCS_Left() {
		return (EReference)logicExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLogicExpCS_Op() {
		return (EAttribute)logicExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLogicExpCS_Right() {
		return (EReference)logicExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCallExpCS() {
		return callExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpCS_Source() {
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallExpCS_NavExp() {
		return (EReference)callExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimaryExpCS() {
		return primaryExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationExpCS() {
		return navigationExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNameExpCS() {
		return nameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNameExpCS_ExpName() {
		return (EReference)nameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNameExpCS_RoundedBrackets() {
		return (EReference)nameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNameExpCS_CallExp() {
		return (EReference)nameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoopExpCS() {
		return loopExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoopExpCS_ItVar() {
		return (EReference)loopExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLoopExpCS_LogicOp() {
		return (EAttribute)loopExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoopExpCS_Exp() {
		return (EReference)loopExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectExpCS() {
		return collectExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratorVarCS() {
		return iteratorVarCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteratorVarCS_ItName() {
		return (EAttribute)iteratorVarCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorVarCS_ItType() {
		return (EReference)iteratorVarCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIterateExpCS() {
		return iterateExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIterateExpCS_AccVar() {
		return (EReference)iterateExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccVarCS() {
		return accVarCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAccVarCS_AccVarName() {
		return (EAttribute)accVarCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccVarCS_AccType() {
		return (EReference)accVarCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAccVarCS_AccInitExp() {
		return (EReference)accVarCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoundedBracketClauseCS() {
		return roundedBracketClauseCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoundedBracketClauseCS_Args() {
		return (EReference)roundedBracketClauseCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralExpCS() {
		return literalExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntLiteralExpCS() {
		return intLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntLiteralExpCS_IntSymbol() {
		return (EAttribute)intLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteralExpCS() {
		return stringLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringLiteralExpCS_StringSymbol() {
		return (EAttribute)stringLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanLiteralExpCS() {
		return booleanLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathNameCS() {
		return pathNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPathNameCS_Path() {
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathCS() {
		return pathCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathVariableCS() {
		return pathVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPathVariableCS_VarName() {
		return (EAttribute)pathVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathElementCS() {
		return pathElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPathElementCS_PathName() {
		return (EReference)pathElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanExpCS() {
		return booleanExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanExpCS_BoolSymbol() {
		return (EAttribute)booleanExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExistsExpCS() {
		return existsExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getExistsExpCS_AccVars() {
		return (EReference)existsExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationNameExpCS() {
		return navigationNameExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationNameExpCS_ExpName() {
		return (EReference)navigationNameExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationNameExpCS_RoundedBrackets() {
		return (EReference)navigationNameExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationNameExpCS_CallExp() {
		return (EReference)navigationNameExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationPathNameCS() {
		return navigationPathNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationPathNameCS_Path() {
		return (EReference)navigationPathNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationPathCS() {
		return navigationPathCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationPathVariableCS() {
		return navigationPathVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNavigationPathVariableCS_VarName() {
		return (EAttribute)navigationPathVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavigationPathElementCS() {
		return navigationPathElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNavigationPathElementCS_PathName() {
		return (EReference)navigationPathElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForAllExpCS() {
		return forAllExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForAllExpCS_AccVars() {
		return (EReference)forAllExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MiniOCLFactory getMiniOCLFactory() {
		return (MiniOCLFactory)getEFactoryInstance();
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
		rootCSEClass = createEClass(ROOT_CS);
		createEReference(rootCSEClass, ROOT_CS__PACKAGES);
		createEReference(rootCSEClass, ROOT_CS__CONTRAINTS);

		packageCSEClass = createEClass(PACKAGE_CS);
		createEAttribute(packageCSEClass, PACKAGE_CS__NAME);
		createEReference(packageCSEClass, PACKAGE_CS__PACKAGES);
		createEReference(packageCSEClass, PACKAGE_CS__CLASSES);

		classCSEClass = createEClass(CLASS_CS);
		createEAttribute(classCSEClass, CLASS_CS__NAME);
		createEReference(classCSEClass, CLASS_CS__EXTENDS);
		createEReference(classCSEClass, CLASS_CS__PROPERTIES);
		createEReference(classCSEClass, CLASS_CS__OPERATIONS);

		propertyCSEClass = createEClass(PROPERTY_CS);
		createEAttribute(propertyCSEClass, PROPERTY_CS__NAME);
		createEReference(propertyCSEClass, PROPERTY_CS__TYPE_REF);

		operationCSEClass = createEClass(OPERATION_CS);
		createEAttribute(operationCSEClass, OPERATION_CS__NAME);
		createEReference(operationCSEClass, OPERATION_CS__PARAMS);
		createEReference(operationCSEClass, OPERATION_CS__RESULT_REF);
		createEReference(operationCSEClass, OPERATION_CS__BODY);

		parameterCSEClass = createEClass(PARAMETER_CS);
		createEAttribute(parameterCSEClass, PARAMETER_CS__NAME);
		createEReference(parameterCSEClass, PARAMETER_CS__TYPE_REF);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEReference(constraintCSEClass, CONSTRAINT_CS__TYPE_REF);
		createEReference(constraintCSEClass, CONSTRAINT_CS__INVARIANTS);

		invariantCSEClass = createEClass(INVARIANT_CS);
		createEReference(invariantCSEClass, INVARIANT_CS__EXP);

		expCSEClass = createEClass(EXP_CS);

		logicExpCSEClass = createEClass(LOGIC_EXP_CS);
		createEReference(logicExpCSEClass, LOGIC_EXP_CS__LEFT);
		createEAttribute(logicExpCSEClass, LOGIC_EXP_CS__OP);
		createEReference(logicExpCSEClass, LOGIC_EXP_CS__RIGHT);

		callExpCSEClass = createEClass(CALL_EXP_CS);
		createEReference(callExpCSEClass, CALL_EXP_CS__SOURCE);
		createEReference(callExpCSEClass, CALL_EXP_CS__NAV_EXP);

		primaryExpCSEClass = createEClass(PRIMARY_EXP_CS);

		navigationExpCSEClass = createEClass(NAVIGATION_EXP_CS);

		nameExpCSEClass = createEClass(NAME_EXP_CS);
		createEReference(nameExpCSEClass, NAME_EXP_CS__EXP_NAME);
		createEReference(nameExpCSEClass, NAME_EXP_CS__ROUNDED_BRACKETS);
		createEReference(nameExpCSEClass, NAME_EXP_CS__CALL_EXP);

		loopExpCSEClass = createEClass(LOOP_EXP_CS);
		createEReference(loopExpCSEClass, LOOP_EXP_CS__IT_VAR);
		createEAttribute(loopExpCSEClass, LOOP_EXP_CS__LOGIC_OP);
		createEReference(loopExpCSEClass, LOOP_EXP_CS__EXP);

		collectExpCSEClass = createEClass(COLLECT_EXP_CS);

		iteratorVarCSEClass = createEClass(ITERATOR_VAR_CS);
		createEAttribute(iteratorVarCSEClass, ITERATOR_VAR_CS__IT_NAME);
		createEReference(iteratorVarCSEClass, ITERATOR_VAR_CS__IT_TYPE);

		iterateExpCSEClass = createEClass(ITERATE_EXP_CS);
		createEReference(iterateExpCSEClass, ITERATE_EXP_CS__ACC_VAR);

		accVarCSEClass = createEClass(ACC_VAR_CS);
		createEAttribute(accVarCSEClass, ACC_VAR_CS__ACC_VAR_NAME);
		createEReference(accVarCSEClass, ACC_VAR_CS__ACC_TYPE);
		createEReference(accVarCSEClass, ACC_VAR_CS__ACC_INIT_EXP);

		roundedBracketClauseCSEClass = createEClass(ROUNDED_BRACKET_CLAUSE_CS);
		createEReference(roundedBracketClauseCSEClass, ROUNDED_BRACKET_CLAUSE_CS__ARGS);

		literalExpCSEClass = createEClass(LITERAL_EXP_CS);

		intLiteralExpCSEClass = createEClass(INT_LITERAL_EXP_CS);
		createEAttribute(intLiteralExpCSEClass, INT_LITERAL_EXP_CS__INT_SYMBOL);

		stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
		createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__STRING_SYMBOL);

		booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);

		pathNameCSEClass = createEClass(PATH_NAME_CS);
		createEReference(pathNameCSEClass, PATH_NAME_CS__PATH);

		pathCSEClass = createEClass(PATH_CS);

		pathVariableCSEClass = createEClass(PATH_VARIABLE_CS);
		createEAttribute(pathVariableCSEClass, PATH_VARIABLE_CS__VAR_NAME);

		pathElementCSEClass = createEClass(PATH_ELEMENT_CS);
		createEReference(pathElementCSEClass, PATH_ELEMENT_CS__PATH_NAME);

		booleanExpCSEClass = createEClass(BOOLEAN_EXP_CS);
		createEAttribute(booleanExpCSEClass, BOOLEAN_EXP_CS__BOOL_SYMBOL);

		existsExpCSEClass = createEClass(EXISTS_EXP_CS);
		createEReference(existsExpCSEClass, EXISTS_EXP_CS__ACC_VARS);

		navigationNameExpCSEClass = createEClass(NAVIGATION_NAME_EXP_CS);
		createEReference(navigationNameExpCSEClass, NAVIGATION_NAME_EXP_CS__EXP_NAME);
		createEReference(navigationNameExpCSEClass, NAVIGATION_NAME_EXP_CS__ROUNDED_BRACKETS);
		createEReference(navigationNameExpCSEClass, NAVIGATION_NAME_EXP_CS__CALL_EXP);

		navigationPathNameCSEClass = createEClass(NAVIGATION_PATH_NAME_CS);
		createEReference(navigationPathNameCSEClass, NAVIGATION_PATH_NAME_CS__PATH);

		navigationPathCSEClass = createEClass(NAVIGATION_PATH_CS);

		navigationPathVariableCSEClass = createEClass(NAVIGATION_PATH_VARIABLE_CS);
		createEAttribute(navigationPathVariableCSEClass, NAVIGATION_PATH_VARIABLE_CS__VAR_NAME);

		navigationPathElementCSEClass = createEClass(NAVIGATION_PATH_ELEMENT_CS);
		createEReference(navigationPathElementCSEClass, NAVIGATION_PATH_ELEMENT_CS__PATH_NAME);

		forAllExpCSEClass = createEClass(FOR_ALL_EXP_CS);
		createEReference(forAllExpCSEClass, FOR_ALL_EXP_CS__ACC_VARS);
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
		logicExpCSEClass.getESuperTypes().add(this.getExpCS());
		callExpCSEClass.getESuperTypes().add(this.getLogicExpCS());
		primaryExpCSEClass.getESuperTypes().add(this.getCallExpCS());
		navigationExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
		nameExpCSEClass.getESuperTypes().add(this.getNavigationExpCS());
		loopExpCSEClass.getESuperTypes().add(this.getNavigationExpCS());
		collectExpCSEClass.getESuperTypes().add(this.getLoopExpCS());
		iterateExpCSEClass.getESuperTypes().add(this.getLoopExpCS());
		literalExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
		intLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		stringLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		booleanLiteralExpCSEClass.getESuperTypes().add(this.getLiteralExpCS());
		pathVariableCSEClass.getESuperTypes().add(this.getPathCS());
		pathElementCSEClass.getESuperTypes().add(this.getPathCS());
		booleanExpCSEClass.getESuperTypes().add(this.getBooleanLiteralExpCS());
		existsExpCSEClass.getESuperTypes().add(this.getLoopExpCS());
		navigationNameExpCSEClass.getESuperTypes().add(this.getNavigationExpCS());
		navigationPathVariableCSEClass.getESuperTypes().add(this.getNavigationPathCS());
		navigationPathElementCSEClass.getESuperTypes().add(this.getNavigationPathCS());
		forAllExpCSEClass.getESuperTypes().add(this.getLoopExpCS());

		// Initialize classes, features, and operations; add parameters
		initEClass(rootCSEClass, RootCS.class, "RootCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootCS_Packages(), this.getPackageCS(), null, "packages", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRootCS_Contraints(), this.getConstraintCS(), null, "contraints", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageCS_Packages(), this.getPackageCS(), null, "packages", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageCS_Classes(), this.getClassCS(), null, "classes", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS_Extends(), this.getPathNameCS(), null, "extends", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS_Properties(), this.getPropertyCS(), null, "properties", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS_Operations(), this.getOperationCS(), null, "operations", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyCSEClass, PropertyCS.class, "PropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, PropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyCS_TypeRef(), this.getPathNameCS(), null, "typeRef", null, 0, 1, PropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_Params(), this.getParameterCS(), null, "params", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_ResultRef(), this.getPathNameCS(), null, "resultRef", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_Body(), this.getExpCS(), null, "body", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterCS_TypeRef(), this.getPathNameCS(), null, "typeRef", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintCS_TypeRef(), this.getPathNameCS(), null, "typeRef", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintCS_Invariants(), this.getInvariantCS(), null, "invariants", null, 0, -1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invariantCSEClass, InvariantCS.class, "InvariantCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvariantCS_Exp(), this.getExpCS(), null, "exp", null, 0, 1, InvariantCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expCSEClass, ExpCS.class, "ExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicExpCSEClass, LogicExpCS.class, "LogicExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicExpCS_Left(), this.getLogicExpCS(), null, "left", null, 0, 1, LogicExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLogicExpCS_Op(), ecorePackage.getEString(), "op", null, 0, 1, LogicExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogicExpCS_Right(), this.getCallExpCS(), null, "right", null, 0, 1, LogicExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callExpCSEClass, CallExpCS.class, "CallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallExpCS_Source(), this.getCallExpCS(), null, "source", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallExpCS_NavExp(), this.getNavigationExpCS(), null, "navExp", null, 0, 1, CallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primaryExpCSEClass, PrimaryExpCS.class, "PrimaryExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(navigationExpCSEClass, NavigationExpCS.class, "NavigationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNameExpCS_ExpName(), this.getPathNameCS(), null, "expName", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNameExpCS_RoundedBrackets(), this.getRoundedBracketClauseCS(), null, "roundedBrackets", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNameExpCS_CallExp(), this.getCallExpCS(), null, "callExp", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopExpCSEClass, LoopExpCS.class, "LoopExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopExpCS_ItVar(), this.getIteratorVarCS(), null, "itVar", null, 0, 1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoopExpCS_LogicOp(), ecorePackage.getEString(), "logicOp", null, 0, -1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExpCS_Exp(), this.getExpCS(), null, "exp", null, 0, -1, LoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectExpCSEClass, CollectExpCS.class, "CollectExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iteratorVarCSEClass, IteratorVarCS.class, "IteratorVarCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIteratorVarCS_ItName(), ecorePackage.getEString(), "itName", null, 0, 1, IteratorVarCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorVarCS_ItType(), this.getPathNameCS(), null, "itType", null, 0, 1, IteratorVarCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterateExpCSEClass, IterateExpCS.class, "IterateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterateExpCS_AccVar(), this.getAccVarCS(), null, "accVar", null, 0, 1, IterateExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accVarCSEClass, AccVarCS.class, "AccVarCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccVarCS_AccVarName(), ecorePackage.getEString(), "accVarName", null, 0, 1, AccVarCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccVarCS_AccType(), this.getPathNameCS(), null, "accType", null, 0, 1, AccVarCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAccVarCS_AccInitExp(), this.getExpCS(), null, "accInitExp", null, 0, 1, AccVarCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roundedBracketClauseCSEClass, RoundedBracketClauseCS.class, "RoundedBracketClauseCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoundedBracketClauseCS_Args(), this.getExpCS(), null, "args", null, 0, -1, RoundedBracketClauseCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalExpCSEClass, LiteralExpCS.class, "LiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intLiteralExpCSEClass, IntLiteralExpCS.class, "IntLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntLiteralExpCS_IntSymbol(), ecorePackage.getEInt(), "intSymbol", null, 1, 1, IntLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExpCS_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 0, 1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathNameCS_Path(), this.getPathCS(), null, "path", null, 0, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathCSEClass, PathCS.class, "PathCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pathVariableCSEClass, PathVariableCS.class, "PathVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathVariableCS_VarName(), ecorePackage.getEString(), "varName", null, 0, 1, PathVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathElementCSEClass, PathElementCS.class, "PathElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathElementCS_PathName(), ecorePackage.getEStructuralFeature(), null, "pathName", null, 0, 1, PathElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanExpCSEClass, BooleanExpCS.class, "BooleanExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanExpCS_BoolSymbol(), ecorePackage.getEBoolean(), "boolSymbol", null, 1, 1, BooleanExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(existsExpCSEClass, ExistsExpCS.class, "ExistsExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExistsExpCS_AccVars(), this.getAccVarCS(), null, "accVars", null, 0, -1, ExistsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationNameExpCSEClass, NavigationNameExpCS.class, "NavigationNameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationNameExpCS_ExpName(), this.getNavigationPathNameCS(), null, "expName", null, 0, 1, NavigationNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigationNameExpCS_RoundedBrackets(), this.getRoundedBracketClauseCS(), null, "roundedBrackets", null, 0, 1, NavigationNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNavigationNameExpCS_CallExp(), this.getCallExpCS(), null, "callExp", null, 0, 1, NavigationNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationPathNameCSEClass, NavigationPathNameCS.class, "NavigationPathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationPathNameCS_Path(), this.getNavigationPathCS(), null, "path", null, 0, -1, NavigationPathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationPathCSEClass, NavigationPathCS.class, "NavigationPathCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(navigationPathVariableCSEClass, NavigationPathVariableCS.class, "NavigationPathVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNavigationPathVariableCS_VarName(), ecorePackage.getEString(), "varName", null, 0, 1, NavigationPathVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(navigationPathElementCSEClass, NavigationPathElementCS.class, "NavigationPathElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationPathElementCS_PathName(), ecorePackage.getEStructuralFeature(), null, "pathName", null, 0, 1, NavigationPathElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forAllExpCSEClass, ForAllExpCS.class, "ForAllExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForAllExpCS_AccVars(), this.getAccVarCS(), null, "accVars", null, 0, -1, ForAllExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";
		addAnnotation
		  (getBooleanExpCS_BoolSymbol(),
		   source,
		   new String[] {
			   "body", "ExistsExpCS"
		   });
	}

} //MiniOCLPackageImpl
