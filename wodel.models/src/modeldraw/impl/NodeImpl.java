/**
 */
package modeldraw.impl;

import java.util.Collection;

import modeldraw.ModeldrawPackage;
import modeldraw.Node;
import modeldraw.NodeColor;
import modeldraw.NodeShape;
import modeldraw.NodeStyle;
import modeldraw.NodeType;
import modeldraw.ValuedFeature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.NodeImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getShape <em>Shape</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getColor <em>Color</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getPathShape <em>Path Shape</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link modeldraw.impl.NodeImpl#getTargetFeature <em>Target Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends NamedItemImpl implements Node {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<ValuedFeature> feature;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> reference;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final NodeType TYPE_EDEFAULT = NodeType.NODE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected NodeType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShape() <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected static final NodeShape SHAPE_EDEFAULT = NodeShape.CIRCLE;

	/**
	 * The cached value of the '{@link #getShape() <em>Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShape()
	 * @generated
	 * @ordered
	 */
	protected NodeShape shape = SHAPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final NodeColor COLOR_EDEFAULT = NodeColor.GRAY95;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected NodeColor color = COLOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected static final NodeStyle STYLE_EDEFAULT = NodeStyle.NONE;

	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected NodeStyle style = STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPathShape() <em>Path Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathShape()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_SHAPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathShape() <em>Path Shape</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathShape()
	 * @generated
	 * @ordered
	 */
	protected String pathShape = PATH_SHAPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected EClass targetNode;

	/**
	 * The cached value of the '{@link #getTargetFeature() <em>Target Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<ValuedFeature> targetFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValuedFeature> getFeature() {
		if (feature == null) {
			feature = new EObjectContainmentEList<ValuedFeature>(ValuedFeature.class, this, ModeldrawPackage.NODE__FEATURE);
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EReference> getReference() {
		if (reference == null) {
			reference = new EObjectResolvingEList<EReference>(EReference.class, this, ModeldrawPackage.NODE__REFERENCE);
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(NodeType newType) {
		NodeType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeShape getShape() {
		return shape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShape(NodeShape newShape) {
		NodeShape oldShape = shape;
		shape = newShape == null ? SHAPE_EDEFAULT : newShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__SHAPE, oldShape, shape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeColor getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColor(NodeColor newColor) {
		NodeColor oldColor = color;
		color = newColor == null ? COLOR_EDEFAULT : newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NodeStyle getStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStyle(NodeStyle newStyle) {
		NodeStyle oldStyle = style;
		style = newStyle == null ? STYLE_EDEFAULT : newStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__STYLE, oldStyle, style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPathShape() {
		return pathShape;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPathShape(String newPathShape) {
		String oldPathShape = pathShape;
		pathShape = newPathShape;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__PATH_SHAPE, oldPathShape, pathShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetNode() {
		if (targetNode != null && targetNode.eIsProxy()) {
			InternalEObject oldTargetNode = (InternalEObject)targetNode;
			targetNode = (EClass)eResolveProxy(oldTargetNode);
			if (targetNode != oldTargetNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.NODE__TARGET_NODE, oldTargetNode, targetNode));
			}
		}
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetNode(EClass newTargetNode) {
		EClass oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE__TARGET_NODE, oldTargetNode, targetNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValuedFeature> getTargetFeature() {
		if (targetFeature == null) {
			targetFeature = new EObjectContainmentEList<ValuedFeature>(ValuedFeature.class, this, ModeldrawPackage.NODE__TARGET_FEATURE);
		}
		return targetFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeldrawPackage.NODE__FEATURE:
				return ((InternalEList<?>)getFeature()).basicRemove(otherEnd, msgs);
			case ModeldrawPackage.NODE__TARGET_FEATURE:
				return ((InternalEList<?>)getTargetFeature()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModeldrawPackage.NODE__FEATURE:
				return getFeature();
			case ModeldrawPackage.NODE__REFERENCE:
				return getReference();
			case ModeldrawPackage.NODE__TYPE:
				return getType();
			case ModeldrawPackage.NODE__SHAPE:
				return getShape();
			case ModeldrawPackage.NODE__COLOR:
				return getColor();
			case ModeldrawPackage.NODE__STYLE:
				return getStyle();
			case ModeldrawPackage.NODE__PATH_SHAPE:
				return getPathShape();
			case ModeldrawPackage.NODE__TARGET_NODE:
				if (resolve) return getTargetNode();
				return basicGetTargetNode();
			case ModeldrawPackage.NODE__TARGET_FEATURE:
				return getTargetFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModeldrawPackage.NODE__FEATURE:
				getFeature().clear();
				getFeature().addAll((Collection<? extends ValuedFeature>)newValue);
				return;
			case ModeldrawPackage.NODE__REFERENCE:
				getReference().clear();
				getReference().addAll((Collection<? extends EReference>)newValue);
				return;
			case ModeldrawPackage.NODE__TYPE:
				setType((NodeType)newValue);
				return;
			case ModeldrawPackage.NODE__SHAPE:
				setShape((NodeShape)newValue);
				return;
			case ModeldrawPackage.NODE__COLOR:
				setColor((NodeColor)newValue);
				return;
			case ModeldrawPackage.NODE__STYLE:
				setStyle((NodeStyle)newValue);
				return;
			case ModeldrawPackage.NODE__PATH_SHAPE:
				setPathShape((String)newValue);
				return;
			case ModeldrawPackage.NODE__TARGET_NODE:
				setTargetNode((EClass)newValue);
				return;
			case ModeldrawPackage.NODE__TARGET_FEATURE:
				getTargetFeature().clear();
				getTargetFeature().addAll((Collection<? extends ValuedFeature>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModeldrawPackage.NODE__FEATURE:
				getFeature().clear();
				return;
			case ModeldrawPackage.NODE__REFERENCE:
				getReference().clear();
				return;
			case ModeldrawPackage.NODE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModeldrawPackage.NODE__SHAPE:
				setShape(SHAPE_EDEFAULT);
				return;
			case ModeldrawPackage.NODE__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case ModeldrawPackage.NODE__STYLE:
				setStyle(STYLE_EDEFAULT);
				return;
			case ModeldrawPackage.NODE__PATH_SHAPE:
				setPathShape(PATH_SHAPE_EDEFAULT);
				return;
			case ModeldrawPackage.NODE__TARGET_NODE:
				setTargetNode((EClass)null);
				return;
			case ModeldrawPackage.NODE__TARGET_FEATURE:
				getTargetFeature().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModeldrawPackage.NODE__FEATURE:
				return feature != null && !feature.isEmpty();
			case ModeldrawPackage.NODE__REFERENCE:
				return reference != null && !reference.isEmpty();
			case ModeldrawPackage.NODE__TYPE:
				return type != TYPE_EDEFAULT;
			case ModeldrawPackage.NODE__SHAPE:
				return shape != SHAPE_EDEFAULT;
			case ModeldrawPackage.NODE__COLOR:
				return color != COLOR_EDEFAULT;
			case ModeldrawPackage.NODE__STYLE:
				return style != STYLE_EDEFAULT;
			case ModeldrawPackage.NODE__PATH_SHAPE:
				return PATH_SHAPE_EDEFAULT == null ? pathShape != null : !PATH_SHAPE_EDEFAULT.equals(pathShape);
			case ModeldrawPackage.NODE__TARGET_NODE:
				return targetNode != null;
			case ModeldrawPackage.NODE__TARGET_FEATURE:
				return targetFeature != null && !targetFeature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", shape: ");
		result.append(shape);
		result.append(", color: ");
		result.append(color);
		result.append(", style: ");
		result.append(style);
		result.append(", pathShape: ");
		result.append(pathShape);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
