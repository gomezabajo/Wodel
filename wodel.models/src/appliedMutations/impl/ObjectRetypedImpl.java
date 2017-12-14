/**
 */
package appliedMutations.impl;

import appliedMutations.AppliedMutationsPackage;
import appliedMutations.ObjectRetyped;

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
 * An implementation of the model object '<em><b>Object Retyped</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link appliedMutations.impl.ObjectRetypedImpl#getObject <em>Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ObjectRetypedImpl#getRemovedObject <em>Removed Object</em>}</li>
 *   <li>{@link appliedMutations.impl.ObjectRetypedImpl#getType <em>Type</em>}</li>
 *   <li>{@link appliedMutations.impl.ObjectRetypedImpl#getNewType <em>New Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectRetypedImpl extends AppMutationImpl implements ObjectRetyped {
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
	 * The cached value of the '{@link #getRemovedObject() <em>Removed Object</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemovedObject()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> removedObject;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getNewType() <em>New Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewType()
	 * @generated
	 * @ordered
	 */
	protected EClass newType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectRetypedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.OBJECT_RETYPED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getObject() {
		if (object == null) {
			object = new EObjectResolvingEList<EObject>(EObject.class, this, AppliedMutationsPackage.OBJECT_RETYPED__OBJECT);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getRemovedObject() {
		if (removedObject == null) {
			removedObject = new EObjectResolvingEList<EObject>(EObject.class, this, AppliedMutationsPackage.OBJECT_RETYPED__REMOVED_OBJECT);
		}
		return removedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.OBJECT_RETYPED__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.OBJECT_RETYPED__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewType() {
		if (newType != null && newType.eIsProxy()) {
			InternalEObject oldNewType = (InternalEObject)newType;
			newType = (EClass)eResolveProxy(oldNewType);
			if (newType != oldNewType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE, oldNewType, newType));
			}
		}
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetNewType() {
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewType(EClass newNewType) {
		EClass oldNewType = newType;
		newType = newNewType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE, oldNewType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AppliedMutationsPackage.OBJECT_RETYPED__OBJECT:
				return getObject();
			case AppliedMutationsPackage.OBJECT_RETYPED__REMOVED_OBJECT:
				return getRemovedObject();
			case AppliedMutationsPackage.OBJECT_RETYPED__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE:
				if (resolve) return getNewType();
				return basicGetNewType();
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
			case AppliedMutationsPackage.OBJECT_RETYPED__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends EObject>)newValue);
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__REMOVED_OBJECT:
				getRemovedObject().clear();
				getRemovedObject().addAll((Collection<? extends EObject>)newValue);
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__TYPE:
				setType((EClass)newValue);
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE:
				setNewType((EClass)newValue);
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
			case AppliedMutationsPackage.OBJECT_RETYPED__OBJECT:
				getObject().clear();
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__REMOVED_OBJECT:
				getRemovedObject().clear();
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__TYPE:
				setType((EClass)null);
				return;
			case AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE:
				setNewType((EClass)null);
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
			case AppliedMutationsPackage.OBJECT_RETYPED__OBJECT:
				return object != null && !object.isEmpty();
			case AppliedMutationsPackage.OBJECT_RETYPED__REMOVED_OBJECT:
				return removedObject != null && !removedObject.isEmpty();
			case AppliedMutationsPackage.OBJECT_RETYPED__TYPE:
				return type != null;
			case AppliedMutationsPackage.OBJECT_RETYPED__NEW_TYPE:
				return newType != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectRetypedImpl
