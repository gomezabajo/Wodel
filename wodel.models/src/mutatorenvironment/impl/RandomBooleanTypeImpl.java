/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.RandomBooleanType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Boolean Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.RandomBooleanTypeImpl#isAllowsNull <em>Allows Null</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RandomBooleanTypeImpl extends BooleanTypeImpl implements RandomBooleanType {
	/**
	 * The default value of the '{@link #isAllowsNull() <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowsNull()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOWS_NULL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowsNull() <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowsNull()
	 * @generated
	 * @ordered
	 */
	protected boolean allowsNull = ALLOWS_NULL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomBooleanTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.RANDOM_BOOLEAN_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowsNull() {
		return allowsNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowsNull(boolean newAllowsNull) {
		boolean oldAllowsNull = allowsNull;
		allowsNull = newAllowsNull;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE__ALLOWS_NULL, oldAllowsNull, allowsNull));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE__ALLOWS_NULL:
				return isAllowsNull();
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
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE__ALLOWS_NULL:
				setAllowsNull((Boolean)newValue);
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
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE__ALLOWS_NULL:
				setAllowsNull(ALLOWS_NULL_EDEFAULT);
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
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE__ALLOWS_NULL:
				return allowsNull != ALLOWS_NULL_EDEFAULT;
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
		result.append(" (allowsNull: ");
		result.append(allowsNull);
		result.append(')');
		return result.toString();
	}

} //RandomBooleanTypeImpl
