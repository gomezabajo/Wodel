/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.miniOCL.MiniOCLPackage
 * @generated
 */
public interface MiniOCLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MiniOCLFactory eINSTANCE = mutatorenvironment.miniOCL.impl.MiniOCLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root CS</em>'.
	 * @generated
	 */
	RootCS createRootCS();

	/**
	 * Returns a new object of class '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package CS</em>'.
	 * @generated
	 */
	PackageCS createPackageCS();

	/**
	 * Returns a new object of class '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class CS</em>'.
	 * @generated
	 */
	ClassCS createClassCS();

	/**
	 * Returns a new object of class '<em>Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property CS</em>'.
	 * @generated
	 */
	PropertyCS createPropertyCS();

	/**
	 * Returns a new object of class '<em>Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation CS</em>'.
	 * @generated
	 */
	OperationCS createOperationCS();

	/**
	 * Returns a new object of class '<em>Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter CS</em>'.
	 * @generated
	 */
	ParameterCS createParameterCS();

	/**
	 * Returns a new object of class '<em>Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint CS</em>'.
	 * @generated
	 */
	ConstraintCS createConstraintCS();

	/**
	 * Returns a new object of class '<em>Invariant CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invariant CS</em>'.
	 * @generated
	 */
	InvariantCS createInvariantCS();

	/**
	 * Returns a new object of class '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exp CS</em>'.
	 * @generated
	 */
	ExpCS createExpCS();

	/**
	 * Returns a new object of class '<em>Logic Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logic Exp CS</em>'.
	 * @generated
	 */
	LogicExpCS createLogicExpCS();

	/**
	 * Returns a new object of class '<em>Call Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Exp CS</em>'.
	 * @generated
	 */
	CallExpCS createCallExpCS();

	/**
	 * Returns a new object of class '<em>Primary Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primary Exp CS</em>'.
	 * @generated
	 */
	PrimaryExpCS createPrimaryExpCS();

	/**
	 * Returns a new object of class '<em>Navigation Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Exp CS</em>'.
	 * @generated
	 */
	NavigationExpCS createNavigationExpCS();

	/**
	 * Returns a new object of class '<em>Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Exp CS</em>'.
	 * @generated
	 */
	NameExpCS createNameExpCS();

	/**
	 * Returns a new object of class '<em>Loop Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Exp CS</em>'.
	 * @generated
	 */
	LoopExpCS createLoopExpCS();

	/**
	 * Returns a new object of class '<em>Collect Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collect Exp CS</em>'.
	 * @generated
	 */
	CollectExpCS createCollectExpCS();

	/**
	 * Returns a new object of class '<em>Iterator Var CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Var CS</em>'.
	 * @generated
	 */
	IteratorVarCS createIteratorVarCS();

	/**
	 * Returns a new object of class '<em>Iterate Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Exp CS</em>'.
	 * @generated
	 */
	IterateExpCS createIterateExpCS();

	/**
	 * Returns a new object of class '<em>Acc Var CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acc Var CS</em>'.
	 * @generated
	 */
	AccVarCS createAccVarCS();

	/**
	 * Returns a new object of class '<em>Rounded Bracket Clause CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rounded Bracket Clause CS</em>'.
	 * @generated
	 */
	RoundedBracketClauseCS createRoundedBracketClauseCS();

	/**
	 * Returns a new object of class '<em>Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Exp CS</em>'.
	 * @generated
	 */
	LiteralExpCS createLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Int Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Literal Exp CS</em>'.
	 * @generated
	 */
	IntLiteralExpCS createIntLiteralExpCS();

	/**
	 * Returns a new object of class '<em>String Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Exp CS</em>'.
	 * @generated
	 */
	StringLiteralExpCS createStringLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp CS</em>'.
	 * @generated
	 */
	BooleanLiteralExpCS createBooleanLiteralExpCS();

	/**
	 * Returns a new object of class '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Name CS</em>'.
	 * @generated
	 */
	PathNameCS createPathNameCS();

	/**
	 * Returns a new object of class '<em>Path CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path CS</em>'.
	 * @generated
	 */
	PathCS createPathCS();

	/**
	 * Returns a new object of class '<em>Path Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Variable CS</em>'.
	 * @generated
	 */
	PathVariableCS createPathVariableCS();

	/**
	 * Returns a new object of class '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Element CS</em>'.
	 * @generated
	 */
	PathElementCS createPathElementCS();

	/**
	 * Returns a new object of class '<em>Boolean Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Exp CS</em>'.
	 * @generated
	 */
	BooleanExpCS createBooleanExpCS();

	/**
	 * Returns a new object of class '<em>Exists Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists Exp CS</em>'.
	 * @generated
	 */
	ExistsExpCS createExistsExpCS();

	/**
	 * Returns a new object of class '<em>Navigation Name Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Name Exp CS</em>'.
	 * @generated
	 */
	NavigationNameExpCS createNavigationNameExpCS();

	/**
	 * Returns a new object of class '<em>Navigation Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Path Name CS</em>'.
	 * @generated
	 */
	NavigationPathNameCS createNavigationPathNameCS();

	/**
	 * Returns a new object of class '<em>Navigation Path CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Path CS</em>'.
	 * @generated
	 */
	NavigationPathCS createNavigationPathCS();

	/**
	 * Returns a new object of class '<em>Navigation Path Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Path Variable CS</em>'.
	 * @generated
	 */
	NavigationPathVariableCS createNavigationPathVariableCS();

	/**
	 * Returns a new object of class '<em>Navigation Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Path Element CS</em>'.
	 * @generated
	 */
	NavigationPathElementCS createNavigationPathElementCS();

	/**
	 * Returns a new object of class '<em>For All Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For All Exp CS</em>'.
	 * @generated
	 */
	ForAllExpCS createForAllExpCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MiniOCLPackage getMiniOCLPackage();

} //MiniOCLFactory
