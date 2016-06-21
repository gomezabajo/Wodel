/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.AttributeSet;
import mutatorenvironment.ModifyInformationMutator;
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
 * An implementation of the model object '<em><b>Modify Information Mutator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ModifyInformationMutatorImpl#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifyInformationMutatorImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ModifyInformationMutatorImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModifyInformationMutatorImpl extends MutatorImpl implements ModifyInformationMutator
{
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
	protected ModifyInformationMutatorImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return MutatorenvironmentPackage.Literals.MODIFY_INFORMATION_MUTATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getObject()
	{
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObject(ObSelectionStrategy newObject, NotificationChain msgs)
	{
		ObSelectionStrategy oldObject = object;
		object = newObject;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT, oldObject, newObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(ObSelectionStrategy newObject)
	{
		if (newObject != object)
		{
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject)object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT, null, msgs);
			if (newObject != null)
				msgs = ((InternalEObject)newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT, null, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT, newObject, newObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeSet> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new EObjectContainmentEList<AttributeSet>(AttributeSet.class, this, MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferenceSet> getReferences()
	{
		if (references == null)
		{
			references = new EObjectContainmentEList<ReferenceSet>(ReferenceSet.class, this, MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
				return basicSetObject(null, msgs);
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
				return getObject();
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
				return getAttributes();
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
				setObject((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributeSet>)newValue);
				return;
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
				setObject((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
				getAttributes().clear();
				return;
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__OBJECT:
				return object != null;
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModifyInformationMutatorImpl
