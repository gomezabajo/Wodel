/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.AttributeSet;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.RetypeObjectMutator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Retype Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.RetypeObjectMutatorImpl#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RetypeObjectMutatorImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RetypeObjectMutatorImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RetypeObjectMutatorImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RetypeObjectMutatorImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RetypeObjectMutatorImpl extends MutatorImpl implements RetypeObjectMutator {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy object;

	/**
	 * The cached value of the '{@link #getContainer() <em>Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainer()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy container;

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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeSet> attributes;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferenceSet> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RetypeObjectMutatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.RETYPE_OBJECT_MUTATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObject(ObSelectionStrategy newObject, NotificationChain msgs) {
		ObSelectionStrategy oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT, oldObject, newObject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(ObSelectionStrategy newObject) {
		if (newObject != object) {
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject) object).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT, null, msgs);
			if (newObject != null)
				msgs = ((InternalEObject) newObject).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT, null, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT, newObject, newObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer(ObSelectionStrategy newContainer, NotificationChain msgs) {
		ObSelectionStrategy oldContainer = container;
		container = newContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER, oldContainer, newContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(ObSelectionStrategy newContainer) {
		if (newContainer != container) {
			NotificationChain msgs = null;
			if (container != null)
				msgs = ((InternalEObject) container).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER, null,
						msgs);
			if (newContainer != null)
				msgs = ((InternalEObject) newContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER, null,
						msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefType() {
		if (refType != null && refType.eIsProxy()) {
			InternalEObject oldRefType = (InternalEObject) refType;
			refType = (EReference) eResolveProxy(oldRefType);
			if (refType != oldRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE, oldRefType, refType));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeSet> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<AttributeSet>(AttributeSet.class, this,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceSet> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<ReferenceSet>(ReferenceSet.class, this,
					MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT:
			return basicSetObject(null, msgs);
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER:
			return basicSetContainer(null, msgs);
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES:
			return ((InternalEList<?>) getReferences()).basicRemove(otherEnd, msgs);
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
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT:
			return getObject();
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER:
			return getContainer();
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE:
			if (resolve)
				return getRefType();
			return basicGetRefType();
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES:
			return getAttributes();
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES:
			return getReferences();
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
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT:
			setObject((ObSelectionStrategy) newValue);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER:
			setContainer((ObSelectionStrategy) newValue);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE:
			setRefType((EReference) newValue);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends AttributeSet>) newValue);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES:
			getReferences().clear();
			getReferences().addAll((Collection<? extends ReferenceSet>) newValue);
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
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT:
			setObject((ObSelectionStrategy) null);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER:
			setContainer((ObSelectionStrategy) null);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE:
			setRefType((EReference) null);
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES:
			getAttributes().clear();
			return;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES:
			getReferences().clear();
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
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__OBJECT:
			return object != null;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__CONTAINER:
			return container != null;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REF_TYPE:
			return refType != null;
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR__REFERENCES:
			return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RetypeObjectMutatorImpl
