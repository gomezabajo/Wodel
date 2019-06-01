/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ReplaceStringType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Replace String Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ReplaceStringTypeImpl#getOldstring <em>Oldstring</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReplaceStringTypeImpl#getNewstring <em>Newstring</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReplaceStringTypeImpl extends StringTypeImpl implements ReplaceStringType {
	/**
	 * The default value of the '{@link #getOldstring() <em>Oldstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldstring()
	 * @generated
	 * @ordered
	 */
	protected static final String OLDSTRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldstring() <em>Oldstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldstring()
	 * @generated
	 * @ordered
	 */
	protected String oldstring = OLDSTRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewstring() <em>Newstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewstring()
	 * @generated
	 * @ordered
	 */
	protected static final String NEWSTRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewstring() <em>Newstring</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewstring()
	 * @generated
	 * @ordered
	 */
	protected String newstring = NEWSTRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReplaceStringTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.REPLACE_STRING_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldstring() {
		return oldstring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldstring(String newOldstring) {
		String oldOldstring = oldstring;
		oldstring = newOldstring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REPLACE_STRING_TYPE__OLDSTRING, oldOldstring, oldstring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewstring() {
		return newstring;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewstring(String newNewstring) {
		String oldNewstring = newstring;
		newstring = newNewstring;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REPLACE_STRING_TYPE__NEWSTRING, oldNewstring, newstring));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__OLDSTRING:
				return getOldstring();
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__NEWSTRING:
				return getNewstring();
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
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__OLDSTRING:
				setOldstring((String)newValue);
				return;
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__NEWSTRING:
				setNewstring((String)newValue);
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
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__OLDSTRING:
				setOldstring(OLDSTRING_EDEFAULT);
				return;
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__NEWSTRING:
				setNewstring(NEWSTRING_EDEFAULT);
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
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__OLDSTRING:
				return OLDSTRING_EDEFAULT == null ? oldstring != null : !OLDSTRING_EDEFAULT.equals(oldstring);
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE__NEWSTRING:
				return NEWSTRING_EDEFAULT == null ? newstring != null : !NEWSTRING_EDEFAULT.equals(newstring);
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
		result.append(" (oldstring: ");
		result.append(oldstring);
		result.append(", newstring: ");
		result.append(newstring);
		result.append(')');
		return result.toString();
	}

} //ReplaceStringTypeImpl
