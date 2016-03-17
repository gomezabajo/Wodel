/**
 */
package mutatortests;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Tests</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatortests.MutatorTests#getConfig <em>Config</em>}</li>
 *   <li>{@link mutatortests.MutatorTests#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatortests.MutatortestsPackage#getMutatorTests()
 * @model
 * @generated
 */
public interface MutatorTests extends EObject {
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
	 * @see mutatortests.MutatortestsPackage#getMutatorTests_Config()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configuration getConfig();

	/**
	 * Sets the value of the '{@link mutatortests.MutatorTests#getConfig <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' containment reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(Configuration value);

	/**
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link mutatortests.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see mutatortests.MutatortestsPackage#getMutatorTests_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Test> getTests();

} // MutatorTests
