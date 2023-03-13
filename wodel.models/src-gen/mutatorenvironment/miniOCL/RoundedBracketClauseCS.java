/**
 */
package mutatorenvironment.miniOCL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rounded Bracket Clause CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.RoundedBracketClauseCS#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getRoundedBracketClauseCS()
 * @model
 * @generated
 */
public interface RoundedBracketClauseCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.miniOCL.ExpCS}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getRoundedBracketClauseCS_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpCS> getArgs();

} // RoundedBracketClauseCS
