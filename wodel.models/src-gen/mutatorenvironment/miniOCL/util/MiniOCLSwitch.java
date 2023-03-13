/**
 */
package mutatorenvironment.miniOCL.util;

import mutatorenvironment.miniOCL.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.miniOCL.MiniOCLPackage
 * @generated
 */
public class MiniOCLSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MiniOCLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiniOCLSwitch() {
		if (modelPackage == null) {
			modelPackage = MiniOCLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MiniOCLPackage.ROOT_CS: {
			RootCS rootCS = (RootCS) theEObject;
			T result = caseRootCS(rootCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PACKAGE_CS: {
			PackageCS packageCS = (PackageCS) theEObject;
			T result = casePackageCS(packageCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.CLASS_CS: {
			ClassCS classCS = (ClassCS) theEObject;
			T result = caseClassCS(classCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PROPERTY_CS: {
			PropertyCS propertyCS = (PropertyCS) theEObject;
			T result = casePropertyCS(propertyCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.OPERATION_CS: {
			OperationCS operationCS = (OperationCS) theEObject;
			T result = caseOperationCS(operationCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PARAMETER_CS: {
			ParameterCS parameterCS = (ParameterCS) theEObject;
			T result = caseParameterCS(parameterCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.CONSTRAINT_CS: {
			ConstraintCS constraintCS = (ConstraintCS) theEObject;
			T result = caseConstraintCS(constraintCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.INVARIANT_CS: {
			InvariantCS invariantCS = (InvariantCS) theEObject;
			T result = caseInvariantCS(invariantCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.EXP_CS: {
			ExpCS expCS = (ExpCS) theEObject;
			T result = caseExpCS(expCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.LOGIC_EXP_CS: {
			LogicExpCS logicExpCS = (LogicExpCS) theEObject;
			T result = caseLogicExpCS(logicExpCS);
			if (result == null)
				result = caseExpCS(logicExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.CALL_EXP_CS: {
			CallExpCS callExpCS = (CallExpCS) theEObject;
			T result = caseCallExpCS(callExpCS);
			if (result == null)
				result = caseLogicExpCS(callExpCS);
			if (result == null)
				result = caseExpCS(callExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PRIMARY_EXP_CS: {
			PrimaryExpCS primaryExpCS = (PrimaryExpCS) theEObject;
			T result = casePrimaryExpCS(primaryExpCS);
			if (result == null)
				result = caseCallExpCS(primaryExpCS);
			if (result == null)
				result = caseLogicExpCS(primaryExpCS);
			if (result == null)
				result = caseExpCS(primaryExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_EXP_CS: {
			NavigationExpCS navigationExpCS = (NavigationExpCS) theEObject;
			T result = caseNavigationExpCS(navigationExpCS);
			if (result == null)
				result = casePrimaryExpCS(navigationExpCS);
			if (result == null)
				result = caseCallExpCS(navigationExpCS);
			if (result == null)
				result = caseLogicExpCS(navigationExpCS);
			if (result == null)
				result = caseExpCS(navigationExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAME_EXP_CS: {
			NameExpCS nameExpCS = (NameExpCS) theEObject;
			T result = caseNameExpCS(nameExpCS);
			if (result == null)
				result = caseNavigationExpCS(nameExpCS);
			if (result == null)
				result = casePrimaryExpCS(nameExpCS);
			if (result == null)
				result = caseCallExpCS(nameExpCS);
			if (result == null)
				result = caseLogicExpCS(nameExpCS);
			if (result == null)
				result = caseExpCS(nameExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.LOOP_EXP_CS: {
			LoopExpCS loopExpCS = (LoopExpCS) theEObject;
			T result = caseLoopExpCS(loopExpCS);
			if (result == null)
				result = caseNavigationExpCS(loopExpCS);
			if (result == null)
				result = casePrimaryExpCS(loopExpCS);
			if (result == null)
				result = caseCallExpCS(loopExpCS);
			if (result == null)
				result = caseLogicExpCS(loopExpCS);
			if (result == null)
				result = caseExpCS(loopExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.COLLECT_EXP_CS: {
			CollectExpCS collectExpCS = (CollectExpCS) theEObject;
			T result = caseCollectExpCS(collectExpCS);
			if (result == null)
				result = caseLoopExpCS(collectExpCS);
			if (result == null)
				result = caseNavigationExpCS(collectExpCS);
			if (result == null)
				result = casePrimaryExpCS(collectExpCS);
			if (result == null)
				result = caseCallExpCS(collectExpCS);
			if (result == null)
				result = caseLogicExpCS(collectExpCS);
			if (result == null)
				result = caseExpCS(collectExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.ITERATOR_VAR_CS: {
			IteratorVarCS iteratorVarCS = (IteratorVarCS) theEObject;
			T result = caseIteratorVarCS(iteratorVarCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.ITERATE_EXP_CS: {
			IterateExpCS iterateExpCS = (IterateExpCS) theEObject;
			T result = caseIterateExpCS(iterateExpCS);
			if (result == null)
				result = caseLoopExpCS(iterateExpCS);
			if (result == null)
				result = caseNavigationExpCS(iterateExpCS);
			if (result == null)
				result = casePrimaryExpCS(iterateExpCS);
			if (result == null)
				result = caseCallExpCS(iterateExpCS);
			if (result == null)
				result = caseLogicExpCS(iterateExpCS);
			if (result == null)
				result = caseExpCS(iterateExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.ACC_VAR_CS: {
			AccVarCS accVarCS = (AccVarCS) theEObject;
			T result = caseAccVarCS(accVarCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.ROUNDED_BRACKET_CLAUSE_CS: {
			RoundedBracketClauseCS roundedBracketClauseCS = (RoundedBracketClauseCS) theEObject;
			T result = caseRoundedBracketClauseCS(roundedBracketClauseCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.LITERAL_EXP_CS: {
			LiteralExpCS literalExpCS = (LiteralExpCS) theEObject;
			T result = caseLiteralExpCS(literalExpCS);
			if (result == null)
				result = casePrimaryExpCS(literalExpCS);
			if (result == null)
				result = caseCallExpCS(literalExpCS);
			if (result == null)
				result = caseLogicExpCS(literalExpCS);
			if (result == null)
				result = caseExpCS(literalExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.INT_LITERAL_EXP_CS: {
			IntLiteralExpCS intLiteralExpCS = (IntLiteralExpCS) theEObject;
			T result = caseIntLiteralExpCS(intLiteralExpCS);
			if (result == null)
				result = caseLiteralExpCS(intLiteralExpCS);
			if (result == null)
				result = casePrimaryExpCS(intLiteralExpCS);
			if (result == null)
				result = caseCallExpCS(intLiteralExpCS);
			if (result == null)
				result = caseLogicExpCS(intLiteralExpCS);
			if (result == null)
				result = caseExpCS(intLiteralExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.STRING_LITERAL_EXP_CS: {
			StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS) theEObject;
			T result = caseStringLiteralExpCS(stringLiteralExpCS);
			if (result == null)
				result = caseLiteralExpCS(stringLiteralExpCS);
			if (result == null)
				result = casePrimaryExpCS(stringLiteralExpCS);
			if (result == null)
				result = caseCallExpCS(stringLiteralExpCS);
			if (result == null)
				result = caseLogicExpCS(stringLiteralExpCS);
			if (result == null)
				result = caseExpCS(stringLiteralExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.BOOLEAN_LITERAL_EXP_CS: {
			BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS) theEObject;
			T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
			if (result == null)
				result = caseLiteralExpCS(booleanLiteralExpCS);
			if (result == null)
				result = casePrimaryExpCS(booleanLiteralExpCS);
			if (result == null)
				result = caseCallExpCS(booleanLiteralExpCS);
			if (result == null)
				result = caseLogicExpCS(booleanLiteralExpCS);
			if (result == null)
				result = caseExpCS(booleanLiteralExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PATH_NAME_CS: {
			PathNameCS pathNameCS = (PathNameCS) theEObject;
			T result = casePathNameCS(pathNameCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PATH_CS: {
			PathCS pathCS = (PathCS) theEObject;
			T result = casePathCS(pathCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PATH_VARIABLE_CS: {
			PathVariableCS pathVariableCS = (PathVariableCS) theEObject;
			T result = casePathVariableCS(pathVariableCS);
			if (result == null)
				result = casePathCS(pathVariableCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.PATH_ELEMENT_CS: {
			PathElementCS pathElementCS = (PathElementCS) theEObject;
			T result = casePathElementCS(pathElementCS);
			if (result == null)
				result = casePathCS(pathElementCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.BOOLEAN_EXP_CS: {
			BooleanExpCS booleanExpCS = (BooleanExpCS) theEObject;
			T result = caseBooleanExpCS(booleanExpCS);
			if (result == null)
				result = caseBooleanLiteralExpCS(booleanExpCS);
			if (result == null)
				result = caseLiteralExpCS(booleanExpCS);
			if (result == null)
				result = casePrimaryExpCS(booleanExpCS);
			if (result == null)
				result = caseCallExpCS(booleanExpCS);
			if (result == null)
				result = caseLogicExpCS(booleanExpCS);
			if (result == null)
				result = caseExpCS(booleanExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.EXISTS_EXP_CS: {
			ExistsExpCS existsExpCS = (ExistsExpCS) theEObject;
			T result = caseExistsExpCS(existsExpCS);
			if (result == null)
				result = caseLoopExpCS(existsExpCS);
			if (result == null)
				result = caseNavigationExpCS(existsExpCS);
			if (result == null)
				result = casePrimaryExpCS(existsExpCS);
			if (result == null)
				result = caseCallExpCS(existsExpCS);
			if (result == null)
				result = caseLogicExpCS(existsExpCS);
			if (result == null)
				result = caseExpCS(existsExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_NAME_EXP_CS: {
			NavigationNameExpCS navigationNameExpCS = (NavigationNameExpCS) theEObject;
			T result = caseNavigationNameExpCS(navigationNameExpCS);
			if (result == null)
				result = caseNavigationExpCS(navigationNameExpCS);
			if (result == null)
				result = casePrimaryExpCS(navigationNameExpCS);
			if (result == null)
				result = caseCallExpCS(navigationNameExpCS);
			if (result == null)
				result = caseLogicExpCS(navigationNameExpCS);
			if (result == null)
				result = caseExpCS(navigationNameExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS: {
			NavigationPathNameCS navigationPathNameCS = (NavigationPathNameCS) theEObject;
			T result = caseNavigationPathNameCS(navigationPathNameCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_PATH_CS: {
			NavigationPathCS navigationPathCS = (NavigationPathCS) theEObject;
			T result = caseNavigationPathCS(navigationPathCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_PATH_VARIABLE_CS: {
			NavigationPathVariableCS navigationPathVariableCS = (NavigationPathVariableCS) theEObject;
			T result = caseNavigationPathVariableCS(navigationPathVariableCS);
			if (result == null)
				result = caseNavigationPathCS(navigationPathVariableCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.NAVIGATION_PATH_ELEMENT_CS: {
			NavigationPathElementCS navigationPathElementCS = (NavigationPathElementCS) theEObject;
			T result = caseNavigationPathElementCS(navigationPathElementCS);
			if (result == null)
				result = caseNavigationPathCS(navigationPathElementCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MiniOCLPackage.FOR_ALL_EXP_CS: {
			ForAllExpCS forAllExpCS = (ForAllExpCS) theEObject;
			T result = caseForAllExpCS(forAllExpCS);
			if (result == null)
				result = caseLoopExpCS(forAllExpCS);
			if (result == null)
				result = caseNavigationExpCS(forAllExpCS);
			if (result == null)
				result = casePrimaryExpCS(forAllExpCS);
			if (result == null)
				result = caseCallExpCS(forAllExpCS);
			if (result == null)
				result = caseLogicExpCS(forAllExpCS);
			if (result == null)
				result = caseExpCS(forAllExpCS);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassCS(ClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCS(PropertyCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCS(OperationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterCS(ParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraintCS(ConstraintCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invariant CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invariant CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvariantCS(InvariantCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logic Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logic Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicExpCS(LogicExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallExpCS(CallExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryExpCS(PrimaryExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationExpCS(NavigationExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameExpCS(NameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExpCS(LoopExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collect Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collect Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectExpCS(CollectExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Var CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Var CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorVarCS(IteratorVarCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterate Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterateExpCS(IterateExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Acc Var CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Acc Var CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccVarCS(AccVarCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rounded Bracket Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rounded Bracket Clause CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoundedBracketClauseCS(RoundedBracketClauseCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExpCS(LiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntLiteralExpCS(IntLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpCS(StringLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathNameCS(PathNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathCS(PathCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathVariableCS(PathVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathElementCS(PathElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpCS(BooleanExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsExpCS(ExistsExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Name Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationNameExpCS(NavigationNameExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationPathNameCS(NavigationPathNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Path CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Path CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationPathCS(NavigationPathCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Path Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Path Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationPathVariableCS(NavigationPathVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Path Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationPathElementCS(NavigationPathElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For All Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For All Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForAllExpCS(ForAllExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MiniOCLSwitch
