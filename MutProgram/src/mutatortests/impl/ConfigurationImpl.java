/**
 */
package mutatortests.impl;

import mutatortests.Configuration;
import mutatortests.MutatortestsPackage;
import mutatortests.Parameter;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatortests.impl.ConfigurationImpl#getRetry <em>Retry</em>}</li>
 *   <li>{@link mutatortests.impl.ConfigurationImpl#getShowall <em>Showall</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * The default value of the '{@link #getRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetry()
	 * @generated
	 * @ordered
	 */
	protected static final Parameter RETRY_EDEFAULT = Parameter.NO;

	/**
	 * The cached value of the '{@link #getRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetry()
	 * @generated
	 * @ordered
	 */
	protected Parameter retry = RETRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowall() <em>Showall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowall()
	 * @generated
	 * @ordered
	 */
	protected static final Parameter SHOWALL_EDEFAULT = Parameter.NO;

	/**
	 * The cached value of the '{@link #getShowall() <em>Showall</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShowall()
	 * @generated
	 * @ordered
	 */
	protected Parameter showall = SHOWALL_EDEFAULT;

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
		return MutatortestsPackage.Literals.CONFIGURATION;
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
	public void setRetry(Parameter newRetry) {
		Parameter oldRetry = retry;
		retry = newRetry == null ? RETRY_EDEFAULT : newRetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatortestsPackage.CONFIGURATION__RETRY, oldRetry, retry));
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
	public void setShowall(Parameter newShowall) {
		Parameter oldShowall = showall;
		showall = newShowall == null ? SHOWALL_EDEFAULT : newShowall;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatortestsPackage.CONFIGURATION__SHOWALL, oldShowall, showall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatortestsPackage.CONFIGURATION__RETRY:
				return getRetry();
			case MutatortestsPackage.CONFIGURATION__SHOWALL:
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
			case MutatortestsPackage.CONFIGURATION__RETRY:
				setRetry((Parameter)newValue);
				return;
			case MutatortestsPackage.CONFIGURATION__SHOWALL:
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
			case MutatortestsPackage.CONFIGURATION__RETRY:
				setRetry(RETRY_EDEFAULT);
				return;
			case MutatortestsPackage.CONFIGURATION__SHOWALL:
				setShowall(SHOWALL_EDEFAULT);
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
			case MutatortestsPackage.CONFIGURATION__RETRY:
				return retry != RETRY_EDEFAULT;
			case MutatortestsPackage.CONFIGURATION__SHOWALL:
				return showall != SHOWALL_EDEFAULT;
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
		result.append(" (retry: ");
		result.append(retry);
		result.append(", showall: ");
		result.append(showall);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
