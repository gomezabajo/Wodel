/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.SourceReferenceChanged;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link appliedMutations.impl.SourceReferenceChangedImpl#getOldFrom <em>Old From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceReferenceChangedImpl extends ReferenceChangedImpl implements SourceReferenceChanged {
	/**
	 * The cached value of the '{@link #getOldFrom() <em>Old From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldFrom()
	 * @generated
	 * @ordered
	 */
	protected EObject oldFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceReferenceChangedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.SOURCE_REFERENCE_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOldFrom() {
		if (oldFrom != null && oldFrom.eIsProxy()) {
			InternalEObject oldOldFrom = (InternalEObject)oldFrom;
			oldFrom = eResolveProxy(oldOldFrom);
			if (oldFrom != oldOldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM, oldOldFrom, oldFrom));
			}
		}
		return oldFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOldFrom() {
		return oldFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldFrom(EObject newOldFrom) {
		EObject oldOldFrom = oldFrom;
		oldFrom = newOldFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM, oldOldFrom, oldFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM:
				if (resolve) return getOldFrom();
				return basicGetOldFrom();
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
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM:
				setOldFrom((EObject)newValue);
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
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM:
				setOldFrom((EObject)null);
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
			case AppliedMutationsPackage.SOURCE_REFERENCE_CHANGED__OLD_FROM:
				return oldFrom != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceReferenceChangedImpl
