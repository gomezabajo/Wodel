/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.*;

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
public class MiniOCLFactoryImpl extends EFactoryImpl implements MiniOCLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MiniOCLFactory init() {
		try {
			MiniOCLFactory theMiniOCLFactory = (MiniOCLFactory) EPackage.Registry.INSTANCE
					.getEFactory(MiniOCLPackage.eNS_URI);
			if (theMiniOCLFactory != null) {
				return theMiniOCLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MiniOCLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniOCLFactoryImpl() {
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
		case MiniOCLPackage.ROOT_CS:
			return createRootCS();
		case MiniOCLPackage.PACKAGE_CS:
			return createPackageCS();
		case MiniOCLPackage.CLASS_CS:
			return createClassCS();
		case MiniOCLPackage.PROPERTY_CS:
			return createPropertyCS();
		case MiniOCLPackage.OPERATION_CS:
			return createOperationCS();
		case MiniOCLPackage.PARAMETER_CS:
			return createParameterCS();
		case MiniOCLPackage.CONSTRAINT_CS:
			return createConstraintCS();
		case MiniOCLPackage.INVARIANT_CS:
			return createInvariantCS();
		case MiniOCLPackage.EXP_CS:
			return createExpCS();
		case MiniOCLPackage.LOGIC_EXP_CS:
			return createLogicExpCS();
		case MiniOCLPackage.CALL_EXP_CS:
			return createCallExpCS();
		case MiniOCLPackage.PRIMARY_EXP_CS:
			return createPrimaryExpCS();
		case MiniOCLPackage.NAVIGATION_EXP_CS:
			return createNavigationExpCS();
		case MiniOCLPackage.NAME_EXP_CS:
			return createNameExpCS();
		case MiniOCLPackage.LOOP_EXP_CS:
			return createLoopExpCS();
		case MiniOCLPackage.COLLECT_EXP_CS:
			return createCollectExpCS();
		case MiniOCLPackage.ITERATOR_VAR_CS:
			return createIteratorVarCS();
		case MiniOCLPackage.ITERATE_EXP_CS:
			return createIterateExpCS();
		case MiniOCLPackage.ACC_VAR_CS:
			return createAccVarCS();
		case MiniOCLPackage.ROUNDED_BRACKET_CLAUSE_CS:
			return createRoundedBracketClauseCS();
		case MiniOCLPackage.LITERAL_EXP_CS:
			return createLiteralExpCS();
		case MiniOCLPackage.INT_LITERAL_EXP_CS:
			return createIntLiteralExpCS();
		case MiniOCLPackage.STRING_LITERAL_EXP_CS:
			return createStringLiteralExpCS();
		case MiniOCLPackage.BOOLEAN_LITERAL_EXP_CS:
			return createBooleanLiteralExpCS();
		case MiniOCLPackage.PATH_NAME_CS:
			return createPathNameCS();
		case MiniOCLPackage.PATH_CS:
			return createPathCS();
		case MiniOCLPackage.PATH_VARIABLE_CS:
			return createPathVariableCS();
		case MiniOCLPackage.PATH_ELEMENT_CS:
			return createPathElementCS();
		case MiniOCLPackage.BOOLEAN_EXP_CS:
			return createBooleanExpCS();
		case MiniOCLPackage.EXISTS_EXP_CS:
			return createExistsExpCS();
		case MiniOCLPackage.NAVIGATION_NAME_EXP_CS:
			return createNavigationNameExpCS();
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS:
			return createNavigationPathNameCS();
		case MiniOCLPackage.NAVIGATION_PATH_CS:
			return createNavigationPathCS();
		case MiniOCLPackage.NAVIGATION_PATH_VARIABLE_CS:
			return createNavigationPathVariableCS();
		case MiniOCLPackage.NAVIGATION_PATH_ELEMENT_CS:
			return createNavigationPathElementCS();
		case MiniOCLPackage.FOR_ALL_EXP_CS:
			return createForAllExpCS();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootCS createRootCS() {
		RootCSImpl rootCS = new RootCSImpl();
		return rootCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageCS createPackageCS() {
		PackageCSImpl packageCS = new PackageCSImpl();
		return packageCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassCS createClassCS() {
		ClassCSImpl classCS = new ClassCSImpl();
		return classCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyCS createPropertyCS() {
		PropertyCSImpl propertyCS = new PropertyCSImpl();
		return propertyCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS createOperationCS() {
		OperationCSImpl operationCS = new OperationCSImpl();
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterCS createParameterCS() {
		ParameterCSImpl parameterCS = new ParameterCSImpl();
		return parameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintCS createConstraintCS() {
		ConstraintCSImpl constraintCS = new ConstraintCSImpl();
		return constraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantCS createInvariantCS() {
		InvariantCSImpl invariantCS = new InvariantCSImpl();
		return invariantCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS createExpCS() {
		ExpCSImpl expCS = new ExpCSImpl();
		return expCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicExpCS createLogicExpCS() {
		LogicExpCSImpl logicExpCS = new LogicExpCSImpl();
		return logicExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallExpCS createCallExpCS() {
		CallExpCSImpl callExpCS = new CallExpCSImpl();
		return callExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryExpCS createPrimaryExpCS() {
		PrimaryExpCSImpl primaryExpCS = new PrimaryExpCSImpl();
		return primaryExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationExpCS createNavigationExpCS() {
		NavigationExpCSImpl navigationExpCS = new NavigationExpCSImpl();
		return navigationExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS createNameExpCS() {
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopExpCS createLoopExpCS() {
		LoopExpCSImpl loopExpCS = new LoopExpCSImpl();
		return loopExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectExpCS createCollectExpCS() {
		CollectExpCSImpl collectExpCS = new CollectExpCSImpl();
		return collectExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorVarCS createIteratorVarCS() {
		IteratorVarCSImpl iteratorVarCS = new IteratorVarCSImpl();
		return iteratorVarCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExpCS createIterateExpCS() {
		IterateExpCSImpl iterateExpCS = new IterateExpCSImpl();
		return iterateExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccVarCS createAccVarCS() {
		AccVarCSImpl accVarCS = new AccVarCSImpl();
		return accVarCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundedBracketClauseCS createRoundedBracketClauseCS() {
		RoundedBracketClauseCSImpl roundedBracketClauseCS = new RoundedBracketClauseCSImpl();
		return roundedBracketClauseCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralExpCS createLiteralExpCS() {
		LiteralExpCSImpl literalExpCS = new LiteralExpCSImpl();
		return literalExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntLiteralExpCS createIntLiteralExpCS() {
		IntLiteralExpCSImpl intLiteralExpCS = new IntLiteralExpCSImpl();
		return intLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS createStringLiteralExpCS() {
		StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
		return stringLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpCS createBooleanLiteralExpCS() {
		BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
		return booleanLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS createPathNameCS() {
		PathNameCSImpl pathNameCS = new PathNameCSImpl();
		return pathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathCS createPathCS() {
		PathCSImpl pathCS = new PathCSImpl();
		return pathCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathVariableCS createPathVariableCS() {
		PathVariableCSImpl pathVariableCS = new PathVariableCSImpl();
		return pathVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathElementCS createPathElementCS() {
		PathElementCSImpl pathElementCS = new PathElementCSImpl();
		return pathElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanExpCS createBooleanExpCS() {
		BooleanExpCSImpl booleanExpCS = new BooleanExpCSImpl();
		return booleanExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsExpCS createExistsExpCS() {
		ExistsExpCSImpl existsExpCS = new ExistsExpCSImpl();
		return existsExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationNameExpCS createNavigationNameExpCS() {
		NavigationNameExpCSImpl navigationNameExpCS = new NavigationNameExpCSImpl();
		return navigationNameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationPathNameCS createNavigationPathNameCS() {
		NavigationPathNameCSImpl navigationPathNameCS = new NavigationPathNameCSImpl();
		return navigationPathNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationPathCS createNavigationPathCS() {
		NavigationPathCSImpl navigationPathCS = new NavigationPathCSImpl();
		return navigationPathCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationPathVariableCS createNavigationPathVariableCS() {
		NavigationPathVariableCSImpl navigationPathVariableCS = new NavigationPathVariableCSImpl();
		return navigationPathVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationPathElementCS createNavigationPathElementCS() {
		NavigationPathElementCSImpl navigationPathElementCS = new NavigationPathElementCSImpl();
		return navigationPathElementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForAllExpCS createForAllExpCS() {
		ForAllExpCSImpl forAllExpCS = new ForAllExpCSImpl();
		return forAllExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniOCLPackage getMiniOCLPackage() {
		return (MiniOCLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MiniOCLPackage getPackage() {
		return MiniOCLPackage.eINSTANCE;
	}

} //MiniOCLFactoryImpl
