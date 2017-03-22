/**
 */
package modelgraph.impl;

import modelgraph.ModelgraphPackage;
import modelgraph.NamedItem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelgraph.impl.NamedItemImpl#getAttName <em>Att Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedItemImpl extends ItemImpl implements NamedItem {
	/**
	 * The cached value of the '{@link #getAttName() <em>Att Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttName()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelgraphPackage.Literals.NAMED_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttName() {
		if (attName != null && attName.eIsProxy()) {
			InternalEObject oldAttName = (InternalEObject)attName;
			attName = (EAttribute)eResolveProxy(oldAttName);
			if (attName != oldAttName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.NAMED_ITEM__ATT_NAME, oldAttName, attName));
			}
		}
		return attName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttName() {
		return attName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttName(EAttribute newAttName) {
		EAttribute oldAttName = attName;
		attName = newAttName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.NAMED_ITEM__ATT_NAME, oldAttName, attName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelgraphPackage.NAMED_ITEM__ATT_NAME:
				if (resolve) return getAttName();
				return basicGetAttName();
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
			case ModelgraphPackage.NAMED_ITEM__ATT_NAME:
				setAttName((EAttribute)newValue);
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
			case ModelgraphPackage.NAMED_ITEM__ATT_NAME:
				setAttName((EAttribute)null);
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
			case ModelgraphPackage.NAMED_ITEM__ATT_NAME:
				return attName != null;
		}
		return super.eIsSet(featureID);
	}

} //NamedItemImpl
