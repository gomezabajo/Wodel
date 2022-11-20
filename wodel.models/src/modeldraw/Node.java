/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.Node#getFeature <em>Feature</em>}</li>
 *   <li>{@link modeldraw.Node#getReference <em>Reference</em>}</li>
 *   <li>{@link modeldraw.Node#getType <em>Type</em>}</li>
 *   <li>{@link modeldraw.Node#getShape <em>Shape</em>}</li>
 *   <li>{@link modeldraw.Node#getColor <em>Color</em>}</li>
 *   <li>{@link modeldraw.Node#getStyle <em>Style</em>}</li>
 *   <li>{@link modeldraw.Node#getPathShape <em>Path Shape</em>}</li>
 *   <li>{@link modeldraw.Node#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link modeldraw.Node#getTargetFeature <em>Target Feature</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends NamedItem {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.ValuedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getNode_Feature()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValuedFeature> getFeature();

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see modeldraw.ModeldrawPackage#getNode_Reference()
	 * @model
	 * @generated
	 */
	EList<EReference> getReference();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see modeldraw.NodeType
	 * @see #setType(NodeType)
	 * @see modeldraw.ModeldrawPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see modeldraw.NodeType
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

	/**
	 * Returns the value of the '<em><b>Shape</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.NodeShape}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape</em>' attribute.
	 * @see modeldraw.NodeShape
	 * @see #setShape(NodeShape)
	 * @see modeldraw.ModeldrawPackage#getNode_Shape()
	 * @model
	 * @generated
	 */
	NodeShape getShape();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getShape <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shape</em>' attribute.
	 * @see modeldraw.NodeShape
	 * @see #getShape()
	 * @generated
	 */
	void setShape(NodeShape value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.NodeColor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see modeldraw.NodeColor
	 * @see #setColor(NodeColor)
	 * @see modeldraw.ModeldrawPackage#getNode_Color()
	 * @model
	 * @generated
	 */
	NodeColor getColor();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see modeldraw.NodeColor
	 * @see #getColor()
	 * @generated
	 */
	void setColor(NodeColor value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.NodeStyle}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see modeldraw.NodeStyle
	 * @see #setStyle(NodeStyle)
	 * @see modeldraw.ModeldrawPackage#getNode_Style()
	 * @model
	 * @generated
	 */
	NodeStyle getStyle();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getStyle <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see modeldraw.NodeStyle
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(NodeStyle value);

	/**
	 * Returns the value of the '<em><b>Path Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Shape</em>' attribute.
	 * @see #setPathShape(String)
	 * @see modeldraw.ModeldrawPackage#getNode_PathShape()
	 * @model
	 * @generated
	 */
	String getPathShape();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getPathShape <em>Path Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Shape</em>' attribute.
	 * @see #getPathShape()
	 * @generated
	 */
	void setPathShape(String value);

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(EClass)
	 * @see modeldraw.ModeldrawPackage#getNode_TargetNode()
	 * @model
	 * @generated
	 */
	EClass getTargetNode();

	/**
	 * Sets the value of the '{@link modeldraw.Node#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(EClass value);

	/**
	 * Returns the value of the '<em><b>Target Feature</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.ValuedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Feature</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getNode_TargetFeature()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValuedFeature> getTargetFeature();

} // Node
