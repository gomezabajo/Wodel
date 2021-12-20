/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.ReferenceSwap;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Swap</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getRefObject <em>Ref Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getOtherFrom <em>Other From</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getOtherFromName <em>Other From Name</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getOtherTo <em>Other To</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getOtherToName <em>Other To Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceSwapImpl extends ReferenceChangedImpl implements ReferenceSwap {
	/**
	 * The cached value of the '{@link #getRefObject() <em>Ref Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefObject()
	 * @generated
	 * @ordered
	 */
	protected EObject refObject;

	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOtherFrom() <em>Other From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherFrom()
	 * @generated
	 * @ordered
	 */
	protected EObject otherFrom;

	/**
	 * The default value of the '{@link #getOtherFromName() <em>Other From Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherFromName()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_FROM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherFromName() <em>Other From Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherFromName()
	 * @generated
	 * @ordered
	 */
	protected String otherFromName = OTHER_FROM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOtherTo() <em>Other To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherTo()
	 * @generated
	 * @ordered
	 */
	protected EObject otherTo;

	/**
	 * The default value of the '{@link #getOtherToName() <em>Other To Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherToName()
	 * @generated
	 * @ordered
	 */
	protected static final String OTHER_TO_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOtherToName() <em>Other To Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherToName()
	 * @generated
	 * @ordered
	 */
	protected String otherToName = OTHER_TO_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceSwapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.REFERENCE_SWAP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getRefObject() {
		if (refObject != null && refObject.eIsProxy()) {
			InternalEObject oldRefObject = (InternalEObject)refObject;
			refObject = eResolveProxy(oldRefObject);
			if (refObject != oldRefObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT, oldRefObject, refObject));
			}
		}
		return refObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRefObject() {
		return refObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefObject(EObject newRefObject) {
		EObject oldRefObject = refObject;
		refObject = newRefObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT, oldRefObject, refObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getOtherFrom() {
		if (otherFrom != null && otherFrom.eIsProxy()) {
			InternalEObject oldOtherFrom = (InternalEObject)otherFrom;
			otherFrom = eResolveProxy(oldOtherFrom);
			if (otherFrom != oldOtherFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM, oldOtherFrom, otherFrom));
			}
		}
		return otherFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOtherFrom() {
		return otherFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOtherFrom(EObject newOtherFrom) {
		EObject oldOtherFrom = otherFrom;
		otherFrom = newOtherFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM, oldOtherFrom, otherFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOtherFromName() {
		return otherFromName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOtherFromName(String newOtherFromName) {
		String oldOtherFromName = otherFromName;
		otherFromName = newOtherFromName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM_NAME, oldOtherFromName, otherFromName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getOtherTo() {
		if (otherTo != null && otherTo.eIsProxy()) {
			InternalEObject oldOtherTo = (InternalEObject)otherTo;
			otherTo = eResolveProxy(oldOtherTo);
			if (otherTo != oldOtherTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO, oldOtherTo, otherTo));
			}
		}
		return otherTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOtherTo() {
		return otherTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOtherTo(EObject newOtherTo) {
		EObject oldOtherTo = otherTo;
		otherTo = newOtherTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO, oldOtherTo, otherTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getOtherToName() {
		return otherToName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOtherToName(String newOtherToName) {
		String oldOtherToName = otherToName;
		otherToName = newOtherToName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO_NAME, oldOtherToName, otherToName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT:
				if (resolve) return getRefObject();
				return basicGetRefObject();
			case AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME:
				return getFirstName();
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM:
				if (resolve) return getOtherFrom();
				return basicGetOtherFrom();
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM_NAME:
				return getOtherFromName();
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO:
				if (resolve) return getOtherTo();
				return basicGetOtherTo();
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO_NAME:
				return getOtherToName();
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
			case AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT:
				setRefObject((EObject)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME:
				setFirstName((String)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM:
				setOtherFrom((EObject)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM_NAME:
				setOtherFromName((String)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO:
				setOtherTo((EObject)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO_NAME:
				setOtherToName((String)newValue);
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
			case AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT:
				setRefObject((EObject)null);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM:
				setOtherFrom((EObject)null);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM_NAME:
				setOtherFromName(OTHER_FROM_NAME_EDEFAULT);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO:
				setOtherTo((EObject)null);
				return;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO_NAME:
				setOtherToName(OTHER_TO_NAME_EDEFAULT);
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
			case AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT:
				return refObject != null;
			case AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM:
				return otherFrom != null;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_FROM_NAME:
				return OTHER_FROM_NAME_EDEFAULT == null ? otherFromName != null : !OTHER_FROM_NAME_EDEFAULT.equals(otherFromName);
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO:
				return otherTo != null;
			case AppliedMutationsPackage.REFERENCE_SWAP__OTHER_TO_NAME:
				return OTHER_TO_NAME_EDEFAULT == null ? otherToName != null : !OTHER_TO_NAME_EDEFAULT.equals(otherToName);
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(", otherFromName: ");
		result.append(otherFromName);
		result.append(", otherToName: ");
		result.append(otherToName);
		result.append(')');
		return result.toString();
	}

} //ReferenceSwapImpl
