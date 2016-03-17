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
 * <ul>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getRefObject <em>Ref Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceSwapImpl#getFirstName <em>First Name</em>}</li>
 * </ul>
 * </p>
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.REFERENCE_SWAP__REF_OBJECT:
				if (resolve) return getRefObject();
				return basicGetRefObject();
			case AppliedMutationsPackage.REFERENCE_SWAP__FIRST_NAME:
				return getFirstName();
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
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(')');
		return result.toString();
	}

} //ReferenceSwapImpl
