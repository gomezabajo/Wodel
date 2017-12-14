/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.CompositeMutator#getCommands <em>Commands</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getCompositeMutator()
 * @model
 * @generated
 */
public interface CompositeMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Mutator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getCompositeMutator_Commands()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Mutator> getCommands();

} // CompositeMutator
