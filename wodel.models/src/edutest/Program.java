/**
 */
package edutest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edutest.Program#getConfig <em>Config</em>}</li>
 *   <li>{@link edutest.Program#getExercises <em>Exercises</em>}</li>
 * </ul>
 * </p>
 *
 * @see edutest.EdutestPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(ProgramConfiguration)
	 * @see edutest.EdutestPackage#getProgram_Config()
	 * @model containment="true"
	 * @generated
	 */
	ProgramConfiguration getConfig();

	/**
	 * Sets the value of the '{@link edutest.Program#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(ProgramConfiguration value);

	/**
	 * Returns the value of the '<em><b>Exercises</b></em>' containment reference list.
	 * The list contents are of type {@link edutest.MutatorTests}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exercises</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exercises</em>' containment reference list.
	 * @see edutest.EdutestPackage#getProgram_Exercises()
	 * @model containment="true"
	 * @generated
	 */
	EList<MutatorTests> getExercises();

} // Program
