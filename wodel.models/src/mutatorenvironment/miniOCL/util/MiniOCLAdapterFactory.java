/**
 */
package mutatorenvironment.miniOCL.util;

import mutatorenvironment.miniOCL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.miniOCL.MiniOCLPackage
 * @generated
 */
public class MiniOCLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MiniOCLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniOCLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MiniOCLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MiniOCLSwitch<Adapter> modelSwitch =
		new MiniOCLSwitch<Adapter>() {
			@Override
			public Adapter caseRootCS(RootCS object) {
				return createRootCSAdapter();
			}
			@Override
			public Adapter casePackageCS(PackageCS object) {
				return createPackageCSAdapter();
			}
			@Override
			public Adapter caseClassCS(ClassCS object) {
				return createClassCSAdapter();
			}
			@Override
			public Adapter casePropertyCS(PropertyCS object) {
				return createPropertyCSAdapter();
			}
			@Override
			public Adapter caseOperationCS(OperationCS object) {
				return createOperationCSAdapter();
			}
			@Override
			public Adapter caseParameterCS(ParameterCS object) {
				return createParameterCSAdapter();
			}
			@Override
			public Adapter caseConstraintCS(ConstraintCS object) {
				return createConstraintCSAdapter();
			}
			@Override
			public Adapter caseInvariantCS(InvariantCS object) {
				return createInvariantCSAdapter();
			}
			@Override
			public Adapter caseExpCS(ExpCS object) {
				return createExpCSAdapter();
			}
			@Override
			public Adapter caseLogicExpCS(LogicExpCS object) {
				return createLogicExpCSAdapter();
			}
			@Override
			public Adapter caseCallExpCS(CallExpCS object) {
				return createCallExpCSAdapter();
			}
			@Override
			public Adapter casePrimaryExpCS(PrimaryExpCS object) {
				return createPrimaryExpCSAdapter();
			}
			@Override
			public Adapter caseNavigationExpCS(NavigationExpCS object) {
				return createNavigationExpCSAdapter();
			}
			@Override
			public Adapter caseNameExpCS(NameExpCS object) {
				return createNameExpCSAdapter();
			}
			@Override
			public Adapter caseLoopExpCS(LoopExpCS object) {
				return createLoopExpCSAdapter();
			}
			@Override
			public Adapter caseCollectExpCS(CollectExpCS object) {
				return createCollectExpCSAdapter();
			}
			@Override
			public Adapter caseIteratorVarCS(IteratorVarCS object) {
				return createIteratorVarCSAdapter();
			}
			@Override
			public Adapter caseIterateExpCS(IterateExpCS object) {
				return createIterateExpCSAdapter();
			}
			@Override
			public Adapter caseAccVarCS(AccVarCS object) {
				return createAccVarCSAdapter();
			}
			@Override
			public Adapter caseRoundedBracketClauseCS(RoundedBracketClauseCS object) {
				return createRoundedBracketClauseCSAdapter();
			}
			@Override
			public Adapter caseLiteralExpCS(LiteralExpCS object) {
				return createLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseIntLiteralExpCS(IntLiteralExpCS object) {
				return createIntLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseStringLiteralExpCS(StringLiteralExpCS object) {
				return createStringLiteralExpCSAdapter();
			}
			@Override
			public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
				return createBooleanLiteralExpCSAdapter();
			}
			@Override
			public Adapter casePathNameCS(PathNameCS object) {
				return createPathNameCSAdapter();
			}
			@Override
			public Adapter casePathCS(PathCS object) {
				return createPathCSAdapter();
			}
			@Override
			public Adapter casePathVariableCS(PathVariableCS object) {
				return createPathVariableCSAdapter();
			}
			@Override
			public Adapter casePathElementCS(PathElementCS object) {
				return createPathElementCSAdapter();
			}
			@Override
			public Adapter caseBooleanExpCS(BooleanExpCS object) {
				return createBooleanExpCSAdapter();
			}
			@Override
			public Adapter caseExistsExpCS(ExistsExpCS object) {
				return createExistsExpCSAdapter();
			}
			@Override
			public Adapter caseNavigationNameExpCS(NavigationNameExpCS object) {
				return createNavigationNameExpCSAdapter();
			}
			@Override
			public Adapter caseNavigationPathNameCS(NavigationPathNameCS object) {
				return createNavigationPathNameCSAdapter();
			}
			@Override
			public Adapter caseNavigationPathCS(NavigationPathCS object) {
				return createNavigationPathCSAdapter();
			}
			@Override
			public Adapter caseNavigationPathVariableCS(NavigationPathVariableCS object) {
				return createNavigationPathVariableCSAdapter();
			}
			@Override
			public Adapter caseNavigationPathElementCS(NavigationPathElementCS object) {
				return createNavigationPathElementCSAdapter();
			}
			@Override
			public Adapter caseForAllExpCS(ForAllExpCS object) {
				return createForAllExpCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.RootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.RootCS
	 * @generated
	 */
	public Adapter createRootCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PackageCS
	 * @generated
	 */
	public Adapter createPackageCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ClassCS
	 * @generated
	 */
	public Adapter createClassCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PropertyCS <em>Property CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PropertyCS
	 * @generated
	 */
	public Adapter createPropertyCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.OperationCS <em>Operation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.OperationCS
	 * @generated
	 */
	public Adapter createOperationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ParameterCS <em>Parameter CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ParameterCS
	 * @generated
	 */
	public Adapter createParameterCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ConstraintCS <em>Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ConstraintCS
	 * @generated
	 */
	public Adapter createConstraintCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.InvariantCS <em>Invariant CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.InvariantCS
	 * @generated
	 */
	public Adapter createInvariantCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ExpCS
	 * @generated
	 */
	public Adapter createExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.LogicExpCS <em>Logic Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.LogicExpCS
	 * @generated
	 */
	public Adapter createLogicExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.CallExpCS
	 * @generated
	 */
	public Adapter createCallExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PrimaryExpCS <em>Primary Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PrimaryExpCS
	 * @generated
	 */
	public Adapter createPrimaryExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationExpCS <em>Navigation Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationExpCS
	 * @generated
	 */
	public Adapter createNavigationExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NameExpCS
	 * @generated
	 */
	public Adapter createNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.LoopExpCS <em>Loop Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.LoopExpCS
	 * @generated
	 */
	public Adapter createLoopExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.CollectExpCS <em>Collect Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.CollectExpCS
	 * @generated
	 */
	public Adapter createCollectExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.IteratorVarCS <em>Iterator Var CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.IteratorVarCS
	 * @generated
	 */
	public Adapter createIteratorVarCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.IterateExpCS <em>Iterate Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.IterateExpCS
	 * @generated
	 */
	public Adapter createIterateExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.AccVarCS <em>Acc Var CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.AccVarCS
	 * @generated
	 */
	public Adapter createAccVarCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.RoundedBracketClauseCS <em>Rounded Bracket Clause CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.RoundedBracketClauseCS
	 * @generated
	 */
	public Adapter createRoundedBracketClauseCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.LiteralExpCS
	 * @generated
	 */
	public Adapter createLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.IntLiteralExpCS <em>Int Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.IntLiteralExpCS
	 * @generated
	 */
	public Adapter createIntLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.StringLiteralExpCS
	 * @generated
	 */
	public Adapter createStringLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.BooleanLiteralExpCS
	 * @generated
	 */
	public Adapter createBooleanLiteralExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PathNameCS
	 * @generated
	 */
	public Adapter createPathNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PathCS <em>Path CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PathCS
	 * @generated
	 */
	public Adapter createPathCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PathVariableCS <em>Path Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PathVariableCS
	 * @generated
	 */
	public Adapter createPathVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.PathElementCS <em>Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.PathElementCS
	 * @generated
	 */
	public Adapter createPathElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.BooleanExpCS <em>Boolean Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.BooleanExpCS
	 * @generated
	 */
	public Adapter createBooleanExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ExistsExpCS <em>Exists Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ExistsExpCS
	 * @generated
	 */
	public Adapter createExistsExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationNameExpCS <em>Navigation Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationNameExpCS
	 * @generated
	 */
	public Adapter createNavigationNameExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationPathNameCS <em>Navigation Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationPathNameCS
	 * @generated
	 */
	public Adapter createNavigationPathNameCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationPathCS <em>Navigation Path CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationPathCS
	 * @generated
	 */
	public Adapter createNavigationPathCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationPathVariableCS <em>Navigation Path Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationPathVariableCS
	 * @generated
	 */
	public Adapter createNavigationPathVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.NavigationPathElementCS <em>Navigation Path Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.NavigationPathElementCS
	 * @generated
	 */
	public Adapter createNavigationPathElementCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.miniOCL.ForAllExpCS <em>For All Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.miniOCL.ForAllExpCS
	 * @generated
	 */
	public Adapter createForAllExpCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MiniOCLAdapterFactory
