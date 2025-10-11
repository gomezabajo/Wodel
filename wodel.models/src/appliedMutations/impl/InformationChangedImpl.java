/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.AttributeChanged;
import appliedMutations.InformationChanged;
import appliedMutations.ReferenceChanged;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.InformationChangedImpl#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.impl.InformationChangedImpl#getAttChanges <em>Att Changes</em>}</li>
 *   <li>{@link appliedMutations.impl.InformationChangedImpl#getRefChanges <em>Ref Changes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InformationChangedImpl extends AppMutationImpl implements InformationChanged {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * The cached value of the '{@link #getAttChanges() <em>Att Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeChanged> attChanges;

	/**
	 * The cached value of the '{@link #getRefChanges() <em>Ref Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceChanged> refChanges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationChangedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.INFORMATION_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObject(EObject newObject) {
		EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeChanged> getAttChanges() {
		if (attChanges == null) {
			attChanges = new EObjectContainmentEList<AttributeChanged>(AttributeChanged.class, this, AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES);
		}
		return attChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ReferenceChanged> getRefChanges() {
		if (refChanges == null) {
			refChanges = new EObjectContainmentEList<ReferenceChanged>(ReferenceChanged.class, this, AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES);
		}
		return refChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES:
				return ((InternalEList<?>)getAttChanges()).basicRemove(otherEnd, msgs);
			case AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES:
				return ((InternalEList<?>)getRefChanges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES:
				return getAttChanges();
			case AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES:
				return getRefChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT:
				setObject((EObject)newValue);
				return;
			case AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES:
				getAttChanges().clear();
				getAttChanges().addAll((Collection<? extends AttributeChanged>)newValue);
				return;
			case AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES:
				getRefChanges().clear();
				getRefChanges().addAll((Collection<? extends ReferenceChanged>)newValue);
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
			case AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT:
				setObject((EObject)null);
				return;
			case AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES:
				getAttChanges().clear();
				return;
			case AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES:
				getRefChanges().clear();
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
			case AppliedMutationsPackage.INFORMATION_CHANGED__OBJECT:
				return object != null;
			case AppliedMutationsPackage.INFORMATION_CHANGED__ATT_CHANGES:
				return attChanges != null && !attChanges.isEmpty();
			case AppliedMutationsPackage.INFORMATION_CHANGED__REF_CHANGES:
				return refChanges != null && !refChanges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InformationChangedImpl
