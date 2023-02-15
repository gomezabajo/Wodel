/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.MutatorEnvironment#getDefinition <em>Definition</em>}</li>
 *   <li>{@link mutatorenvironment.MutatorEnvironment#getCommands <em>Commands</em>}</li>
 *   <li>{@link mutatorenvironment.MutatorEnvironment#getLoad <em>Load</em>}</li>
 *   <li>{@link mutatorenvironment.MutatorEnvironment#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link mutatorenvironment.MutatorEnvironment#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment()
 * @model
 * @generated
 */
public interface MutatorEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(Definition)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment_Definition()
	 * @model containment="true"
	 * @generated
	 */
	Definition getDefinition();

	/**
	 * Sets the value of the '{@link mutatorenvironment.MutatorEnvironment#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Definition value);

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Mutator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mutator> getCommands();

	/**
	 * Returns the value of the '<em><b>Load</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Load}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment_Load()
	 * @model containment="true"
	 * @generated
	 */
	EList<Load> getLoad();

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Block}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment_Blocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Block> getBlocks();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Constraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getMutatorEnvironment_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

} // MutatorEnvironment
