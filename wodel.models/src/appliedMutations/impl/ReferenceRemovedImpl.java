/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.ReferenceRemoved;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Removed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.ReferenceRemovedImpl#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceRemovedImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link appliedMutations.impl.ReferenceRemovedImpl#getRefName <em>Ref Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceRemovedImpl extends AppMutationImpl implements ReferenceRemoved {
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
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> ref;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceRemovedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.REFERENCE_REMOVED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getObject() {
		if (object == null) {
			object = new EObjectResolvingEList<EObject>(EObject.class, this, AppliedMutationsPackage.REFERENCE_REMOVED__OBJECT);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getRef() {
		if (ref == null) {
			ref = new EObjectResolvingEList<EReference>(EReference.class, this, AppliedMutationsPackage.REFERENCE_REMOVED__REF);
		}
		return ref;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.REFERENCE_REMOVED__REF_NAME, oldRefName, refName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.REFERENCE_REMOVED__OBJECT:
				return getObject();
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF:
				return getRef();
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF_NAME:
				return getRefName();
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
			case AppliedMutationsPackage.REFERENCE_REMOVED__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends EObject>)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF:
				getRef().clear();
				getRef().addAll((Collection<? extends EReference>)newValue);
				return;
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF_NAME:
				setRefName((String)newValue);
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
			case AppliedMutationsPackage.REFERENCE_REMOVED__OBJECT:
				getObject().clear();
				return;
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF:
				getRef().clear();
				return;
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF_NAME:
				setRefName(REF_NAME_EDEFAULT);
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
			case AppliedMutationsPackage.REFERENCE_REMOVED__OBJECT:
				return object != null && !object.isEmpty();
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF:
				return ref != null && !ref.isEmpty();
			case AppliedMutationsPackage.REFERENCE_REMOVED__REF_NAME:
				return REF_NAME_EDEFAULT == null ? refName != null : !REF_NAME_EDEFAULT.equals(refName);
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
		result.append(" (refName: ");
		result.append(refName);
		result.append(')');
		return result.toString();
	}

} //ReferenceRemovedImpl
