/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Draw</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.MutatorDraw#getType <em>Type</em>}</li>
 *   <li>{@link modeldraw.MutatorDraw#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modeldraw.MutatorDraw#getRelations <em>Relations</em>}</li>
 *   <li>{@link modeldraw.MutatorDraw#getContents <em>Contents</em>}</li>
 *   <li>{@link modeldraw.MutatorDraw#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getMutatorDraw()
 * @model
 * @generated
 */
public interface MutatorDraw extends Item {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.DrawType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see modeldraw.DrawType
	 * @see #setType(DrawType)
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Type()
	 * @model required="true"
	 * @generated
	 */
	DrawType getType();

	/**
	 * Sets the value of the '{@link modeldraw.MutatorDraw#getType <em>Type</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.Content}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<Content> getContents();

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see modeldraw.ModeldrawPackage#getMutatorDraw_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link modeldraw.MutatorDraw#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

} // MutatorDraw
