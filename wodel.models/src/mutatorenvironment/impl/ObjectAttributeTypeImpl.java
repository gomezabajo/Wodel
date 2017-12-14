/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Operator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Attribute Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ObjectAttributeTypeImpl#getObjSel <em>Obj Sel</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObjectAttributeTypeImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObjectAttributeTypeImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectAttributeTypeImpl extends AttributeEvaluationTypeImpl implements ObjectAttributeType {
	/**
	 * The cached value of the '{@link #getObjSel() <em>Obj Sel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjSel()
	 * @generated
	 * @ordered
	 */
	protected ObjectEmitter objSel;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attribute;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final Operator OPERATOR_EDEFAULT = Operator.EQUALS;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator = OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectAttributeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.OBJECT_ATTRIBUTE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectEmitter getObjSel() {
		if (objSel != null && objSel.eIsProxy()) {
			InternalEObject oldObjSel = (InternalEObject)objSel;
			objSel = (ObjectEmitter)eResolveProxy(oldObjSel);
			if (objSel != oldObjSel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL, oldObjSel, objSel));
			}
		}
		return objSel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectEmitter basicGetObjSel() {
		return objSel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjSel(ObjectEmitter newObjSel) {
		ObjectEmitter oldObjSel = objSel;
		objSel = newObjSel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL, oldObjSel, objSel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute() {
		if (attribute != null && attribute.eIsProxy()) {
			InternalEObject oldAttribute = (InternalEObject)attribute;
			attribute = (EAttribute)eResolveProxy(oldAttribute);
			if (attribute != oldAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE, oldAttribute, attribute));
			}
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(EAttribute newAttribute) {
		EAttribute oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		Operator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL:
				if (resolve) return getObjSel();
				return basicGetObjSel();
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE:
				if (resolve) return getAttribute();
				return basicGetAttribute();
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OPERATOR:
				return getOperator();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL:
				setObjSel((ObjectEmitter)newValue);
				return;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE:
				setAttribute((EAttribute)newValue);
				return;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OPERATOR:
				setOperator((Operator)newValue);
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
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL:
				setObjSel((ObjectEmitter)null);
				return;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE:
				setAttribute((EAttribute)null);
				return;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
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
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OBJ_SEL:
				return objSel != null;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE:
				return attribute != null;
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //ObjectAttributeTypeImpl
