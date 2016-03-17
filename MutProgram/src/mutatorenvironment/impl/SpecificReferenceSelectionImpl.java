/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.SpecificReferenceSelection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Reference Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.SpecificReferenceSelectionImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.SpecificReferenceSelectionImpl#getObjectEmitter <em>Object Emitter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificReferenceSelectionImpl extends SpecificSelectionImpl implements SpecificReferenceSelection {
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
	 * The cached value of the '{@link #getObjectEmitter() <em>Object Emitter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectEmitter()
	 * @generated
	 * @ordered
	 */
	protected ObjectEmitter objectEmitter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificReferenceSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.SPECIFIC_REFERENCE_SELECTION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE, oldRefType, refType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectEmitter getObjectEmitter() {
		return objectEmitter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectEmitter(ObjectEmitter newObjectEmitter, NotificationChain msgs) {
		ObjectEmitter oldObjectEmitter = objectEmitter;
		objectEmitter = newObjectEmitter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER, oldObjectEmitter, newObjectEmitter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectEmitter(ObjectEmitter newObjectEmitter) {
		if (newObjectEmitter != objectEmitter) {
			NotificationChain msgs = null;
			if (objectEmitter != null)
				msgs = ((InternalEObject)objectEmitter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER, null, msgs);
			if (newObjectEmitter != null)
				msgs = ((InternalEObject)newObjectEmitter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER, null, msgs);
			msgs = basicSetObjectEmitter(newObjectEmitter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER, newObjectEmitter, newObjectEmitter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER:
				return basicSetObjectEmitter(null, msgs);
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
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE:
				if (resolve) return getRefType();
				return basicGetRefType();
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER:
				return getObjectEmitter();
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
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE:
				setRefType((EReference)newValue);
				return;
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER:
				setObjectEmitter((ObjectEmitter)newValue);
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
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE:
				setRefType((EReference)null);
				return;
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER:
				setObjectEmitter((ObjectEmitter)null);
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
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__REF_TYPE:
				return refType != null;
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION__OBJECT_EMITTER:
				return objectEmitter != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificReferenceSelectionImpl
