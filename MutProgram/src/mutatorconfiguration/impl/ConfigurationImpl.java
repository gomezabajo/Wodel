/**
 */
package mutatorconfiguration.impl;

import mutatorconfiguration.Configuration;
import mutatorconfiguration.MutatorconfigurationPackage;

import mutatorconfiguration.Parameter;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorconfiguration.impl.ConfigurationImpl#getRetry <em>Retry</em>}</li>
 *   <li>{@link mutatorconfiguration.impl.ConfigurationImpl#getShowall <em>Showall</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * The cached value of the '{@link #getRetry() <em>Retry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetry()
	 * @generated
	 * @ordered
	 */
	protected Parameter retry;

	/**
	 * The cached value of the '{@link #getShowall() <em>Showall</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowall()
	 * @generated
	 * @ordered
	 */
	protected Parameter showall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorconfigurationPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getRetry() {
		return retry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRetry(Parameter newRetry, NotificationChain msgs) {
		Parameter oldRetry = retry;
		retry = newRetry;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.CONFIGURATION__RETRY, oldRetry, newRetry);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetry(Parameter newRetry) {
		if (newRetry != retry) {
			NotificationChain msgs = null;
			if (retry != null)
				msgs = ((InternalEObject)retry).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.CONFIGURATION__RETRY, null, msgs);
			if (newRetry != null)
				msgs = ((InternalEObject)newRetry).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.CONFIGURATION__RETRY, null, msgs);
			msgs = basicSetRetry(newRetry, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.CONFIGURATION__RETRY, newRetry, newRetry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getShowall() {
		return showall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShowall(Parameter newShowall, NotificationChain msgs) {
		Parameter oldShowall = showall;
		showall = newShowall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.CONFIGURATION__SHOWALL, oldShowall, newShowall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShowall(Parameter newShowall) {
		if (newShowall != showall) {
			NotificationChain msgs = null;
			if (showall != null)
				msgs = ((InternalEObject)showall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.CONFIGURATION__SHOWALL, null, msgs);
			if (newShowall != null)
				msgs = ((InternalEObject)newShowall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.CONFIGURATION__SHOWALL, null, msgs);
			msgs = basicSetShowall(newShowall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.CONFIGURATION__SHOWALL, newShowall, newShowall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorconfigurationPackage.CONFIGURATION__RETRY:
				return basicSetRetry(null, msgs);
			case MutatorconfigurationPackage.CONFIGURATION__SHOWALL:
				return basicSetShowall(null, msgs);
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
			case MutatorconfigurationPackage.CONFIGURATION__RETRY:
				return getRetry();
			case MutatorconfigurationPackage.CONFIGURATION__SHOWALL:
				return getShowall();
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
			case MutatorconfigurationPackage.CONFIGURATION__RETRY:
				setRetry((Parameter)newValue);
				return;
			case MutatorconfigurationPackage.CONFIGURATION__SHOWALL:
				setShowall((Parameter)newValue);
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
			case MutatorconfigurationPackage.CONFIGURATION__RETRY:
				setRetry((Parameter)null);
				return;
			case MutatorconfigurationPackage.CONFIGURATION__SHOWALL:
				setShowall((Parameter)null);
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
			case MutatorconfigurationPackage.CONFIGURATION__RETRY:
				return retry != null;
			case MutatorconfigurationPackage.CONFIGURATION__SHOWALL:
				return showall != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationImpl
