/**
 */
package mutatorgraph;

import org.eclipse.emf.ecore.EAttribute;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorgraph.Node#getNegation <em>Negation</em>}</li>
 *   <li>{@link mutatorgraph.Node#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link mutatorgraph.Node#getType <em>Type</em>}</li>
 *   <li>{@link mutatorgraph.Node#getShape <em>Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorgraph.MutatorgraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Item {
	/**
	 * Returns the value of the '<em><b>Negation</b></em>' attribute.
	 * The default value is <code>"yes"</code>.
	 * The literals are from the enumeration {@link mutatorgraph.Negation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Negation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negation</em>' attribute.
	 * @see mutatorgraph.Negation
	 * @see #setNegation(Negation)
	 * @see mutatorgraph.MutatorgraphPackage#getNode_Negation()
	 * @model default="yes"
	 * @generated
	 */
	Negation getNegation();

	/**
	 * Sets the value of the '{@link mutatorgraph.Node#getNegation <em>Negation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negation</em>' attribute.
	 * @see mutatorgraph.Negation
	 * @see #getNegation()
	 * @generated
	 */
	void setNegation(Negation value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(EAttribute)
	 * @see mutatorgraph.MutatorgraphPackage#getNode_Attribute()
	 * @model
	 * @generated
	 */
	EAttribute getAttribute();

	/**
	 * Sets the value of the '{@link mutatorgraph.Node#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorgraph.NodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see mutatorgraph.NodeType
	 * @see #setType(NodeType)
	 * @see mutatorgraph.MutatorgraphPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link mutatorgraph.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see mutatorgraph.NodeType
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Shape</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorgraph.NodeShape}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' attribute.
	 * @see mutatorgraph.NodeShape
	 * @see #setShape(NodeShape)
	 * @see mutatorgraph.MutatorgraphPackage#getNode_Shape()
	 * @model
	 * @generated
	 */
	NodeShape getShape();

	/**
	 * Sets the value of the '{@link mutatorgraph.Node#getShape <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' attribute.
	 * @see mutatorgraph.NodeShape
	 * @see #getShape()
	 * @generated
	 */
	void setShape(NodeShape value);

} // Node
