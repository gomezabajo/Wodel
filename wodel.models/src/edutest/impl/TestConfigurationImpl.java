/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.TestConfiguration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edutest.impl.TestConfigurationImpl#isRetry <em>Retry</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestConfigurationImpl extends ConfigurationImpl implements TestConfiguration {
	/**
	 * The default value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETRY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
	protected boolean retry = RETRY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdutestPackage.Literals.TEST_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRetry() {
		return retry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRetry(boolean newRetry) {
		boolean oldRetry = retry;
		retry = newRetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.TEST_CONFIGURATION__RETRY, oldRetry, retry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdutestPackage.TEST_CONFIGURATION__RETRY:
				return isRetry();
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
			case EdutestPackage.TEST_CONFIGURATION__RETRY:
				setRetry((Boolean)newValue);
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
			case EdutestPackage.TEST_CONFIGURATION__RETRY:
				setRetry(RETRY_EDEFAULT);
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
			case EdutestPackage.TEST_CONFIGURATION__RETRY:
				return retry != RETRY_EDEFAULT;
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
		result.append(" (retry: ");
		result.append(retry);
		result.append(')');
		return result.toString();
	}

} //TestConfigurationImpl
