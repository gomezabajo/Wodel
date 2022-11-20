/**
 */
package modeldraw.impl;

import java.util.Collection;

import modeldraw.Enumerator;
import modeldraw.ModeldrawPackage;
import modeldraw.NodeEnumerator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node Enumerator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.NodeEnumeratorImpl#getAtt <em>Att</em>}</li>
 *   <li>{@link modeldraw.impl.NodeEnumeratorImpl#getEnumerator <em>Enumerator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeEnumeratorImpl extends ItemImpl implements NodeEnumerator {
	/**
	 * The cached value of the '{@link #getAtt() <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtt()
	 * @generated
	 * @ordered
	 */
	protected EAttribute att;

	/**
	 * The cached value of the '{@link #getEnumerator() <em>Enumerator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerator()
	 * @generated
	 * @ordered
	 */
	protected EList<Enumerator> enumerator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeEnumeratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.NODE_ENUMERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAtt() {
		if (att != null && att.eIsProxy()) {
			InternalEObject oldAtt = (InternalEObject)att;
			att = (EAttribute)eResolveProxy(oldAtt);
			if (att != oldAtt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.NODE_ENUMERATOR__ATT, oldAtt, att));
			}
		}
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAtt() {
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtt(EAttribute newAtt) {
		EAttribute oldAtt = att;
		att = newAtt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.NODE_ENUMERATOR__ATT, oldAtt, att));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Enumerator> getEnumerator() {
		if (enumerator == null) {
			enumerator = new EObjectContainmentEList<Enumerator>(Enumerator.class, this, ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR);
		}
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR:
				return ((InternalEList<?>)getEnumerator()).basicRemove(otherEnd, msgs);
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
			case ModeldrawPackage.NODE_ENUMERATOR__ATT:
				if (resolve) return getAtt();
				return basicGetAtt();
			case ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR:
				return getEnumerator();
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
			case ModeldrawPackage.NODE_ENUMERATOR__ATT:
				setAtt((EAttribute)newValue);
				return;
			case ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR:
				getEnumerator().clear();
				getEnumerator().addAll((Collection<? extends Enumerator>)newValue);
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
			case ModeldrawPackage.NODE_ENUMERATOR__ATT:
				setAtt((EAttribute)null);
				return;
			case ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR:
				getEnumerator().clear();
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
			case ModeldrawPackage.NODE_ENUMERATOR__ATT:
				return att != null;
			case ModeldrawPackage.NODE_ENUMERATOR__ENUMERATOR:
				return enumerator != null && !enumerator.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeEnumeratorImpl
