/**
 */
package appliedMutations.impl;

import appliedMutations.AppMutation;
import appliedMutations.AppliedMutationsPackage;
import appliedMutations.CompositeMutation;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Mutation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link appliedMutations.impl.CompositeMutationImpl#getSize <em>Size</em>}</li>
 *   <li>{@link appliedMutations.impl.CompositeMutationImpl#getMuts <em>Muts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeMutationImpl extends AppMutationImpl implements CompositeMutation {
	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMuts() <em>Muts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMuts()
	 * @generated
	 * @ordered
	 */
	protected EList<AppMutation> muts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeMutationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AppliedMutationsPackage.Literals.COMPOSITE_MUTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AppliedMutationsPackage.COMPOSITE_MUTATION__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AppMutation> getMuts() {
		if (muts == null) {
			muts = new EObjectContainmentEList<AppMutation>(AppMutation.class, this, AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS);
		}
		return muts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS:
				return ((InternalEList<?>)getMuts()).basicRemove(otherEnd, msgs);
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
			case AppliedMutationsPackage.COMPOSITE_MUTATION__SIZE:
				return getSize();
			case AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS:
				return getMuts();
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
			case AppliedMutationsPackage.COMPOSITE_MUTATION__SIZE:
				setSize((Integer)newValue);
				return;
			case AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS:
				getMuts().clear();
				getMuts().addAll((Collection<? extends AppMutation>)newValue);
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
			case AppliedMutationsPackage.COMPOSITE_MUTATION__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS:
				getMuts().clear();
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
			case AppliedMutationsPackage.COMPOSITE_MUTATION__SIZE:
				return size != SIZE_EDEFAULT;
			case AppliedMutationsPackage.COMPOSITE_MUTATION__MUTS:
				return muts != null && !muts.isEmpty();
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
		result.append(" (size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //CompositeMutationImpl
