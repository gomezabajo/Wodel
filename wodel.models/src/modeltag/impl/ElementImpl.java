/**
 */
package modeltag.impl;

import java.util.Collection;

import modeltag.Attribute;
import modeltag.Element;
import modeltag.ModeltagPackage;
import modeltag.Tag;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeltag.impl.ElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link modeltag.impl.ElementImpl#getAtt <em>Att</em>}</li>
 *   <li>{@link modeltag.impl.ElementImpl#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getAtt() <em>Att</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtt()
	 * @generated
	 * @ordered
	 */
	protected Attribute att;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeltagPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeltagPackage.ELEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltagPackage.ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAtt() {
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAtt(Attribute newAtt, NotificationChain msgs) {
		Attribute oldAtt = att;
		att = newAtt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModeltagPackage.ELEMENT__ATT, oldAtt, newAtt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtt(Attribute newAtt) {
		if (newAtt != att) {
			NotificationChain msgs = null;
			if (att != null)
				msgs = ((InternalEObject)att).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModeltagPackage.ELEMENT__ATT, null, msgs);
			if (newAtt != null)
				msgs = ((InternalEObject)newAtt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModeltagPackage.ELEMENT__ATT, null, msgs);
			msgs = basicSetAtt(newAtt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltagPackage.ELEMENT__ATT, newAtt, newAtt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList<Tag>(Tag.class, this, ModeltagPackage.ELEMENT__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeltagPackage.ELEMENT__ATT:
				return basicSetAtt(null, msgs);
			case ModeltagPackage.ELEMENT__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
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
			case ModeltagPackage.ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ModeltagPackage.ELEMENT__ATT:
				return getAtt();
			case ModeltagPackage.ELEMENT__TAGS:
				return getTags();
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
			case ModeltagPackage.ELEMENT__TYPE:
				setType((EClass)newValue);
				return;
			case ModeltagPackage.ELEMENT__ATT:
				setAtt((Attribute)newValue);
				return;
			case ModeltagPackage.ELEMENT__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends Tag>)newValue);
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
			case ModeltagPackage.ELEMENT__TYPE:
				setType((EClass)null);
				return;
			case ModeltagPackage.ELEMENT__ATT:
				setAtt((Attribute)null);
				return;
			case ModeltagPackage.ELEMENT__TAGS:
				getTags().clear();
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
			case ModeltagPackage.ELEMENT__TYPE:
				return type != null;
			case ModeltagPackage.ELEMENT__ATT:
				return att != null;
			case ModeltagPackage.ELEMENT__TAGS:
				return tags != null && !tags.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
