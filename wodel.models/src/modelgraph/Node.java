/**
 */
package modelgraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.Node#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link modelgraph.Node#getReference <em>Reference</em>}</li>
 *   <li>{@link modelgraph.Node#getType <em>Type</em>}</li>
 *   <li>{@link modelgraph.Node#getShape <em>Shape</em>}</li>
 *   <li>{@link modelgraph.Node#getColor <em>Color</em>}</li>
 *   <li>{@link modelgraph.Node#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends NamedItem {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link modelgraph.BooleanAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see modelgraph.ModelgraphPackage#getNode_Attribute()
	 * @model containment="true"
	 * @generated
	 */
	EList<BooleanAttribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see modelgraph.ModelgraphPackage#getNode_Reference()
	 * @model
	 * @generated
	 */
	EList<EReference> getReference();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link modelgraph.NodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see modelgraph.NodeType
	 * @see #setType(NodeType)
	 * @see modelgraph.ModelgraphPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link modelgraph.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see modelgraph.NodeType
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Shape</b></em>' attribute.
	 * The literals are from the enumeration {@link modelgraph.NodeShape}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' attribute.
	 * @see modelgraph.NodeShape
	 * @see #setShape(NodeShape)
	 * @see modelgraph.ModelgraphPackage#getNode_Shape()
	 * @model
	 * @generated
	 */
	NodeShape getShape();

	/**
	 * Sets the value of the '{@link modelgraph.Node#getShape <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' attribute.
	 * @see modelgraph.NodeShape
	 * @see #getShape()
	 * @generated
	 */
	void setShape(NodeShape value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The literals are from the enumeration {@link modelgraph.NodeColor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see modelgraph.NodeColor
	 * @see #setColor(NodeColor)
	 * @see modelgraph.ModelgraphPackage#getNode_Color()
	 * @model
	 * @generated
	 */
	NodeColor getColor();

	/**
	 * Sets the value of the '{@link modelgraph.Node#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see modelgraph.NodeColor
	 * @see #getColor()
	 * @generated
	 */
	void setColor(NodeColor value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * The literals are from the enumeration {@link modelgraph.NodeStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see modelgraph.NodeStyle
	 * @see #setStyle(NodeStyle)
	 * @see modelgraph.ModelgraphPackage#getNode_Style()
	 * @model
	 * @generated
	 */
	NodeStyle getStyle();

	/**
	 * Sets the value of the '{@link modelgraph.Node#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see modelgraph.NodeStyle
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(NodeStyle value);

} // Node
