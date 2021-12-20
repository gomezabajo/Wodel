/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.TargetReferenceChanged;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.TargetReferenceChangedImpl#getOldTo <em>Old To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetReferenceChangedImpl extends ReferenceChangedImpl implements TargetReferenceChanged {
	/**
	 * The cached value of the '{@link #getOldTo() <em>Old To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldTo()
	 * @generated
	 * @ordered
	 */
	protected EObject oldTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetReferenceChangedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.TARGET_REFERENCE_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getOldTo() {
		if (oldTo != null && oldTo.eIsProxy()) {
			InternalEObject oldOldTo = (InternalEObject)oldTo;
			oldTo = eResolveProxy(oldOldTo);
			if (oldTo != oldOldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO, oldOldTo, oldTo));
			}
		}
		return oldTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOldTo() {
		return oldTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOldTo(EObject newOldTo) {
		EObject oldOldTo = oldTo;
		oldTo = newOldTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO, oldOldTo, oldTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO:
				if (resolve) return getOldTo();
				return basicGetOldTo();
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
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO:
				setOldTo((EObject)newValue);
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
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO:
				setOldTo((EObject)null);
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
			case AppliedMutationsPackage.TARGET_REFERENCE_CHANGED__OLD_TO:
				return oldTo != null;
		}
		return super.eIsSet(featureID);
	}

} //TargetReferenceChangedImpl
