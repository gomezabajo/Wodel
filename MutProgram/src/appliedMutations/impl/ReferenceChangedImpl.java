/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.ReferenceChanged;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Changed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link appliedMutations.impl.ReferenceChangedImpl#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceChangedImpl#getSrcRefName <em>Src Ref Name</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceChangedImpl#getFrom <em>From</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceChangedImpl#getRefName <em>Ref Name</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceChangedImpl#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceChangedImpl extends AppMutationImpl implements ReferenceChanged {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> object;

	/**
	 * The default value of the '{@link #getSrcRefName() <em>Src Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcRefName()
	 * @generated
	 * @ordered
	 */
	protected static final String SRC_REF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSrcRefName() <em>Src Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcRefName()
	 * @generated
	 * @ordered
	 */
	protected String srcRefName = SRC_REF_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected EObject from;

	/**
	 * The default value of the '{@link #getRefName() <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefName()
	 * @generated
	 * @ordered
	 */
	protected static final String REF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRefName() <em>Ref Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefName()
	 * @generated
	 * @ordered
	 */
	protected String refName = REF_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected EObject to;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceChangedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.REFERENCE_CHANGED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getObject() {
		if (object == null) {
			object = new EObjectResolvingEList<EObject>(EObject.class, this, AppliedMutationsPackage.REFERENCE_CHANGED__OBJECT);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSrcRefName() {
		return srcRefName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrcRefName(String newSrcRefName) {
		String oldSrcRefName = srcRefName;
		srcRefName = newSrcRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_CHANGED__SRC_REF_NAME, oldSrcRefName, srcRefName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefName() {
		return refName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefName(String newRefName) {
		String oldRefName = refName;
		refName = newRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_CHANGED__REF_NAME, oldRefName, refName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.REFERENCE_CHANGED__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(EObject newFrom) {
		EObject oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_CHANGED__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject)to;
			to = eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.REFERENCE_CHANGED__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(EObject newTo) {
		EObject oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_CHANGED__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.REFERENCE_CHANGED__OBJECT:
				return getObject();
			case AppliedMutationsPackage.REFERENCE_CHANGED__SRC_REF_NAME:
				return getSrcRefName();
			case AppliedMutationsPackage.REFERENCE_CHANGED__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case AppliedMutationsPackage.REFERENCE_CHANGED__REF_NAME:
				return getRefName();
			case AppliedMutationsPackage.REFERENCE_CHANGED__TO:
				if (resolve) return getTo();
				return basicGetTo();
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
			case AppliedMutationsPackage.REFERENCE_CHANGED__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends EObject>)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__SRC_REF_NAME:
				setSrcRefName((String)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__FROM:
				setFrom((EObject)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__REF_NAME:
				setRefName((String)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__TO:
				setTo((EObject)newValue);
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
			case AppliedMutationsPackage.REFERENCE_CHANGED__OBJECT:
				getObject().clear();
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__SRC_REF_NAME:
				setSrcRefName(SRC_REF_NAME_EDEFAULT);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__FROM:
				setFrom((EObject)null);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__REF_NAME:
				setRefName(REF_NAME_EDEFAULT);
				return;
			case AppliedMutationsPackage.REFERENCE_CHANGED__TO:
				setTo((EObject)null);
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
			case AppliedMutationsPackage.REFERENCE_CHANGED__OBJECT:
				return object != null && !object.isEmpty();
			case AppliedMutationsPackage.REFERENCE_CHANGED__SRC_REF_NAME:
				return SRC_REF_NAME_EDEFAULT == null ? srcRefName != null : !SRC_REF_NAME_EDEFAULT.equals(srcRefName);
			case AppliedMutationsPackage.REFERENCE_CHANGED__FROM:
				return from != null;
			case AppliedMutationsPackage.REFERENCE_CHANGED__REF_NAME:
				return REF_NAME_EDEFAULT == null ? refName != null : !REF_NAME_EDEFAULT.equals(refName);
			case AppliedMutationsPackage.REFERENCE_CHANGED__TO:
				return to != null;
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
		result.append(" (srcRefName: ");
		result.append(srcRefName);
		result.append(", refName: ");
		result.append(refName);
		result.append(')');
		return result.toString();
	}

} //ReferenceChangedImpl
