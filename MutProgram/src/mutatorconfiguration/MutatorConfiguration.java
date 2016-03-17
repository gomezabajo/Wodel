/**
 */
package mutatorconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorconfiguration.MutatorConfiguration#getConfig <em>Config</em>}</li>
 *   <li>{@link mutatorconfiguration.MutatorConfiguration#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorconfiguration.MutatorConfiguration#getQuestion <em>Question</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorconfiguration.MutatorconfigurationPackage#getMutatorConfiguration()
 * @model
 * @generated
 */
public interface MutatorConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Config</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' containment reference.
	 * @see #setConfig(Configuration)
	 * @see mutatorconfiguration.MutatorconfigurationPackage#getMutatorConfiguration_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configuration getConfig();

	/**
	 * Sets the value of the '{@link mutatorconfiguration.MutatorConfiguration#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(Configuration value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute list.
	 * @see mutatorconfiguration.MutatorconfigurationPackage#getMutatorConfiguration_Source()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getSource();

	/**
	 * Returns the value of the '<em><b>Question</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Question</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Question</em>' attribute list.
	 * @see mutatorconfiguration.MutatorconfigurationPackage#getMutatorConfiguration_Question()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getQuestion();

} // MutatorConfiguration
