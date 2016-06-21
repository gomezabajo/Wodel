/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.SpecificObjectSelection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Object Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.SpecificObjectSelectionImpl#getObjSel <em>Obj Sel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificObjectSelectionImpl extends SpecificSelectionImpl implements SpecificObjectSelection
{
	/**
	 * The cached value of the '{@link #getObjSel() <em>Obj Sel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjSel()
	 * @generated
	 * @ordered
	 */
	protected ObjectEmitter objSel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificObjectSelectionImpl()
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
		return MutatorenvironmentPackage.Literals.SPECIFIC_OBJECT_SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectEmitter getObjSel()
	{
		if (objSel != null && objSel.eIsProxy())
		{
			InternalEObject oldObjSel = (InternalEObject)objSel;
			objSel = (ObjectEmitter)eResolveProxy(oldObjSel);
			if (objSel != oldObjSel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL, oldObjSel, objSel));
			}
		}
		return objSel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectEmitter basicGetObjSel()
	{
		return objSel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjSel(ObjectEmitter newObjSel)
	{
		ObjectEmitter oldObjSel = objSel;
		objSel = newObjSel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL, oldObjSel, objSel));
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
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL:
				if (resolve) return getObjSel();
				return basicGetObjSel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL:
				setObjSel((ObjectEmitter)newValue);
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
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL:
				setObjSel((ObjectEmitter)null);
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
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION__OBJ_SEL:
				return objSel != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificObjectSelectionImpl
