/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.MutatorInstance#getType <em>Type</em>}</li>
 *   <li>{@link modeldraw.MutatorInstance#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modeldraw.MutatorInstance#getRelations <em>Relations</em>}</li>
 *   <li>{@link modeldraw.MutatorInstance#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getMutatorInstance()
 * @model
 * @generated
 */
public interface MutatorInstance extends Item {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.DrawType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see modeldraw.DrawType
	 * @see #setType(DrawType)
	 * @see modeldraw.ModeldrawPackage#getMutatorInstance_Type()
	 * @model required="true"
	 * @generated
	 */
	DrawType getType();

	/**
	 * Sets the value of the '{@link modeldraw.MutatorInstance#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see modeldraw.DrawType
	 * @see #getType()
	 * @generated
	 */
	void setType(DrawType value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorInstance_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Relation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorInstance_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Content}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorInstance_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<Content> getContents();

} // MutatorInstance
