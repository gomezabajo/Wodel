/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.RandomNumberType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Number Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.RandomNumberTypeImpl#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RandomNumberTypeImpl#getMax <em>Max</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RandomNumberTypeImpl extends NumberTypeImpl implements RandomNumberType {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy object;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected EAttribute max;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomNumberTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.RANDOM_NUMBER_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObSelectionStrategy getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObject(ObSelectionStrategy newObject, NotificationChain msgs) {
		ObSelectionStrategy oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT, oldObject, newObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObject(ObSelectionStrategy newObject) {
		if (newObject != object) {
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT, null, msgs);
			if (newObject != null)
				msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT, null, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT, newObject, newObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMax() {
		if (max != null && max.eIsProxy()) {
			InternalEObject oldMax = (InternalEObject)max;
			max = (EAttribute)eResolveProxy(oldMax);
			if (max != oldMax) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX, oldMax, max));
			}
		}
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMax(EAttribute newMax) {
		EAttribute oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT:
				return basicSetObject(null, msgs);
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
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT:
				return getObject();
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX:
				if (resolve) return getMax();
				return basicGetMax();
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
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT:
				setObject((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX:
				setMax((EAttribute)newValue);
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
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT:
				setObject((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX:
				setMax((EAttribute)null);
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
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__OBJECT:
				return object != null;
			case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE__MAX:
				return max != null;
		}
		return super.eIsSet(featureID);
	}

} //RandomNumberTypeImpl
