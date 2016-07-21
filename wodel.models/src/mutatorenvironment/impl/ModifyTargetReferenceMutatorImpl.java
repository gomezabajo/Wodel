/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modify Target Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifyTargetReferenceMutatorImpl#getNewTarget <em>New Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifyTargetReferenceMutatorImpl extends MutatorImpl implements ModifyTargetReferenceMutator {
	/**
	 * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefType()
	 * @generated
	 * @ordered
	 */
	protected EReference refType;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy source;

	/**
	 * The cached value of the '{@link #getNewTarget() <em>New Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewTarget()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy newTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifyTargetReferenceMutatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.MODIFY_TARGET_REFERENCE_MUTATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefType() {
		if (refType != null && refType.eIsProxy()) {
			InternalEObject oldRefType = (InternalEObject)refType;
			refType = (EReference)eResolveProxy(oldRefType);
			if (refType != oldRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE, oldRefType, refType));
			}
		}
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefType() {
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefType(EReference newRefType) {
		EReference oldRefType = refType;
		refType = newRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ObSelectionStrategy newSource, NotificationChain msgs) {
		ObSelectionStrategy oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ObSelectionStrategy newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getNewTarget() {
		return newTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewTarget(ObSelectionStrategy newNewTarget, NotificationChain msgs) {
		ObSelectionStrategy oldNewTarget = newTarget;
		newTarget = newNewTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET, oldNewTarget, newNewTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewTarget(ObSelectionStrategy newNewTarget) {
		if (newNewTarget != newTarget) {
			NotificationChain msgs = null;
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET, null, msgs);
			if (newNewTarget != null)
				msgs = ((InternalEObject)newNewTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET, null, msgs);
			msgs = basicSetNewTarget(newNewTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET, newNewTarget, newNewTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE:
				return basicSetSource(null, msgs);
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET:
				return basicSetNewTarget(null, msgs);
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
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE:
				if (resolve) return getRefType();
				return basicGetRefType();
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE:
				return getSource();
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET:
				return getNewTarget();
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
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE:
				setRefType((EReference)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE:
				setSource((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET:
				setNewTarget((ObSelectionStrategy)newValue);
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
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE:
				setRefType((EReference)null);
				return;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE:
				setSource((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET:
				setNewTarget((ObSelectionStrategy)null);
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
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE:
				return refType != null;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE:
				return source != null;
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET:
				return newTarget != null;
		}
		return super.eIsSet(featureID);
	}

} //ModifyTargetReferenceMutatorImpl
