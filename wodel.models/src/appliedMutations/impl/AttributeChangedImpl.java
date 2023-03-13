/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.AttributeChanged;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.AttributeChangedImpl#getAttName <em>Att Name</em>}</li>
 *   <li>{@link appliedMutations.impl.AttributeChangedImpl#getOldVal <em>Old Val</em>}</li>
 *   <li>{@link appliedMutations.impl.AttributeChangedImpl#getNewVal <em>New Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeChangedImpl extends AppMutationImpl implements AttributeChanged {
	/**
	 * The default value of the '{@link #getAttName() <em>Att Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttName() <em>Att Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttName()
	 * @generated
	 * @ordered
	 */
	protected String attName = ATT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldVal() <em>Old Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldVal()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_VAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldVal() <em>Old Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldVal()
	 * @generated
	 * @ordered
	 */
	protected String oldVal = OLD_VAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewVal() <em>New Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewVal()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_VAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewVal() <em>New Val</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewVal()
	 * @generated
	 * @ordered
	 */
	protected String newVal = NEW_VAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeChangedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.ATTRIBUTE_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttName() {
		return attName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttName(String newAttName) {
		String oldAttName = attName;
		attName = newAttName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.ATTRIBUTE_CHANGED__ATT_NAME, oldAttName, attName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldVal() {
		return oldVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldVal(String newOldVal) {
		String oldOldVal = oldVal;
		oldVal = newOldVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.ATTRIBUTE_CHANGED__OLD_VAL, oldOldVal, oldVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewVal() {
		return newVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewVal(String newNewVal) {
		String oldNewVal = newVal;
		newVal = newNewVal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.ATTRIBUTE_CHANGED__NEW_VAL, oldNewVal, newVal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__ATT_NAME:
				return getAttName();
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__OLD_VAL:
				return getOldVal();
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__NEW_VAL:
				return getNewVal();
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
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__ATT_NAME:
				setAttName((String)newValue);
				return;
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__OLD_VAL:
				setOldVal((String)newValue);
				return;
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__NEW_VAL:
				setNewVal((String)newValue);
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
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__ATT_NAME:
				setAttName(ATT_NAME_EDEFAULT);
				return;
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__OLD_VAL:
				setOldVal(OLD_VAL_EDEFAULT);
				return;
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__NEW_VAL:
				setNewVal(NEW_VAL_EDEFAULT);
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
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__ATT_NAME:
				return ATT_NAME_EDEFAULT == null ? attName != null : !ATT_NAME_EDEFAULT.equals(attName);
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__OLD_VAL:
				return OLD_VAL_EDEFAULT == null ? oldVal != null : !OLD_VAL_EDEFAULT.equals(oldVal);
			case AppliedMutationsPackage.ATTRIBUTE_CHANGED__NEW_VAL:
				return NEW_VAL_EDEFAULT == null ? newVal != null : !NEW_VAL_EDEFAULT.equals(newVal);
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
		result.append(" (attName: ");
		result.append(attName);
		result.append(", oldVal: ");
		result.append(oldVal);
		result.append(", newVal: ");
		result.append(newVal);
		result.append(')');
		return result.toString();
	}

} //AttributeChangedImpl
