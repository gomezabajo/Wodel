/**
 */
package mutatortests.impl;

import mutatortests.MutatortestsPackage;
import mutatortests.Navigation;
import mutatortests.ProgramConfiguration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatortests.impl.ProgramConfigurationImpl#getNavigation <em>Navigation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProgramConfigurationImpl extends ConfigurationImpl implements ProgramConfiguration {
	/**
	 * The default value of the '{@link #getNavigation() <em>Navigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigation()
	 * @generated
	 * @ordered
	 */
	protected static final Navigation NAVIGATION_EDEFAULT = Navigation.FREE;

	/**
	 * The cached value of the '{@link #getNavigation() <em>Navigation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigation()
	 * @generated
	 * @ordered
	 */
	protected Navigation navigation = NAVIGATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatortestsPackage.Literals.PROGRAM_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Navigation getNavigation() {
		return navigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigation(Navigation newNavigation) {
		Navigation oldNavigation = navigation;
		navigation = newNavigation == null ? NAVIGATION_EDEFAULT : newNavigation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatortestsPackage.PROGRAM_CONFIGURATION__NAVIGATION, oldNavigation, navigation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatortestsPackage.PROGRAM_CONFIGURATION__NAVIGATION:
				return getNavigation();
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
			case MutatortestsPackage.PROGRAM_CONFIGURATION__NAVIGATION:
				setNavigation((Navigation)newValue);
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
			case MutatortestsPackage.PROGRAM_CONFIGURATION__NAVIGATION:
				setNavigation(NAVIGATION_EDEFAULT);
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
			case MutatortestsPackage.PROGRAM_CONFIGURATION__NAVIGATION:
				return navigation != NAVIGATION_EDEFAULT;
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
		result.append(" (navigation: ");
		result.append(navigation);
		result.append(')');
		return result.toString();
	}

} //ProgramConfigurationImpl
