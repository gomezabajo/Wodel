/**
 */
package mutatormetrics.impl;

import mutatormetrics.MutatormetricsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.impl.ObjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link mutatormetrics.impl.ObjectImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link mutatormetrics.impl.ObjectImpl#getModified <em>Modified</em>}</li>
 *   <li>{@link mutatormetrics.impl.ObjectImpl#getRemoved <em>Removed</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ObjectImpl extends MinimalEObjectImpl.Container implements mutatormetrics.Object {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected static final int CREATED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCreated() <em>Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreated()
	 * @generated
	 * @ordered
	 */
	protected int created = CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected static final int MODIFIED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModified()
	 * @generated
	 * @ordered
	 */
	protected int modified = MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoved() <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoved()
	 * @generated
	 * @ordered
	 */
	protected static final int REMOVED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRemoved() <em>Removed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoved()
	 * @generated
	 * @ordered
	 */
	protected int removed = REMOVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatormetricsPackage.Literals.OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.OBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCreated() {
		return created;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(int newCreated) {
		int oldCreated = created;
		created = newCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.OBJECT__CREATED, oldCreated, created));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getModified() {
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModified(int newModified) {
		int oldModified = modified;
		modified = newModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.OBJECT__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRemoved() {
		return removed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoved(int newRemoved) {
		int oldRemoved = removed;
		removed = newRemoved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.OBJECT__REMOVED, oldRemoved, removed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatormetricsPackage.OBJECT__NAME:
				return getName();
			case MutatormetricsPackage.OBJECT__CREATED:
				return getCreated();
			case MutatormetricsPackage.OBJECT__MODIFIED:
				return getModified();
			case MutatormetricsPackage.OBJECT__REMOVED:
				return getRemoved();
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
			case MutatormetricsPackage.OBJECT__NAME:
				setName((String)newValue);
				return;
			case MutatormetricsPackage.OBJECT__CREATED:
				setCreated((Integer)newValue);
				return;
			case MutatormetricsPackage.OBJECT__MODIFIED:
				setModified((Integer)newValue);
				return;
			case MutatormetricsPackage.OBJECT__REMOVED:
				setRemoved((Integer)newValue);
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
			case MutatormetricsPackage.OBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MutatormetricsPackage.OBJECT__CREATED:
				setCreated(CREATED_EDEFAULT);
				return;
			case MutatormetricsPackage.OBJECT__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
			case MutatormetricsPackage.OBJECT__REMOVED:
				setRemoved(REMOVED_EDEFAULT);
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
			case MutatormetricsPackage.OBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MutatormetricsPackage.OBJECT__CREATED:
				return created != CREATED_EDEFAULT;
			case MutatormetricsPackage.OBJECT__MODIFIED:
				return modified != MODIFIED_EDEFAULT;
			case MutatormetricsPackage.OBJECT__REMOVED:
				return removed != REMOVED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", created: ");
		result.append(created);
		result.append(", modified: ");
		result.append(modified);
		result.append(", removed: ");
		result.append(removed);
		result.append(')');
		return result.toString();
	}

} //ObjectImpl
