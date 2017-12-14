/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.ModifySourceReferenceMutator;
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
 * An implementation of the model object '<em><b>Modify Source Reference Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ModifySourceReferenceMutatorImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifySourceReferenceMutatorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifySourceReferenceMutatorImpl#getNewSource <em>New Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModifySourceReferenceMutatorImpl extends MutatorImpl implements ModifySourceReferenceMutator {
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
	 * The cached value of the '{@link #getNewSource() <em>New Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSource()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy newSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifySourceReferenceMutatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.MODIFY_SOURCE_REFERENCE_MUTATOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE, oldRefType, refType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE, oldRefType, refType));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getNewSource() {
		return newSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewSource(ObSelectionStrategy newNewSource, NotificationChain msgs) {
		ObSelectionStrategy oldNewSource = newSource;
		newSource = newNewSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE, oldNewSource, newNewSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewSource(ObSelectionStrategy newNewSource) {
		if (newNewSource != newSource) {
			NotificationChain msgs = null;
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE, null, msgs);
			if (newNewSource != null)
				msgs = ((InternalEObject)newNewSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE, null, msgs);
			msgs = basicSetNewSource(newNewSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE, newNewSource, newNewSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE:
				return basicSetSource(null, msgs);
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE:
				return basicSetNewSource(null, msgs);
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
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE:
				if (resolve) return getRefType();
				return basicGetRefType();
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE:
				return getSource();
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE:
				return getNewSource();
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
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE:
				setRefType((EReference)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE:
				setSource((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE:
				setNewSource((ObSelectionStrategy)newValue);
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
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE:
				setRefType((EReference)null);
				return;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE:
				setSource((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE:
				setNewSource((ObSelectionStrategy)null);
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
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE:
				return refType != null;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE:
				return source != null;
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE:
				return newSource != null;
		}
		return super.eIsSet(featureID);
	}

} //ModifySourceReferenceMutatorImpl
