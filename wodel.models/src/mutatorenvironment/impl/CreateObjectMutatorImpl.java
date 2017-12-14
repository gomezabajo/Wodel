/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.AttributeSet;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ReferenceSet;

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
 * An implementation of the model object '<em><b>Create Object Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.CreateObjectMutatorImpl#getContainer <em>Container</em>}</li>
 *   <li>{@link mutatorenvironment.impl.CreateObjectMutatorImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.impl.CreateObjectMutatorImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CreateObjectMutatorImpl extends MutatorImpl implements CreateObjectMutator {
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
	protected CreateObjectMutatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.CREATE_OBJECT_MUTATOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER, oldContainer, newContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
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
				msgs = ((InternalEObject)container).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER, null, msgs);
			if (newContainer != null)
				msgs = ((InternalEObject)newContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER, null, msgs);
			msgs = basicSetContainer(newContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER, newContainer, newContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeSet> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<AttributeSet>(AttributeSet.class, this, MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES);
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
			references = new EObjectContainmentEList<ReferenceSet>(ReferenceSet.class, this, MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES);
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
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
				return basicSetContainer(null, msgs);
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
				return getContainer();
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
				return getAttributes();
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
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
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
				setContainer((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributeSet>)newValue);
				return;
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends ReferenceSet>)newValue);
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
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
				setContainer((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
				getAttributes().clear();
				return;
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
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
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__CONTAINER:
				return container != null;
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CreateObjectMutatorImpl
