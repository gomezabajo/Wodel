/**
 */
package modelgraph.impl;

import modelgraph.Information;
import modelgraph.ModelgraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelgraph.impl.InformationImpl#getType <em>Type</em>}</li>
 *   <li>{@link modelgraph.impl.InformationImpl#getAtt <em>Att</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InformationImpl extends ItemImpl implements Information {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EReference type;

	/**
	 * The cached value of the '{@link #getAtt() <em>Att</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtt()
	 * @generated
	 * @ordered
	 */
	protected EAttribute att;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelgraphPackage.Literals.INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EReference)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.INFORMATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EReference newType) {
		EReference oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.INFORMATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAtt() {
		if (att != null && att.eIsProxy()) {
			InternalEObject oldAtt = (InternalEObject)att;
			att = (EAttribute)eResolveProxy(oldAtt);
			if (att != oldAtt) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.INFORMATION__ATT, oldAtt, att));
			}
		}
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAtt() {
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtt(EAttribute newAtt) {
		EAttribute oldAtt = att;
		att = newAtt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.INFORMATION__ATT, oldAtt, att));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelgraphPackage.INFORMATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ModelgraphPackage.INFORMATION__ATT:
				if (resolve) return getAtt();
				return basicGetAtt();
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
			case ModelgraphPackage.INFORMATION__TYPE:
				setType((EReference)newValue);
				return;
			case ModelgraphPackage.INFORMATION__ATT:
				setAtt((EAttribute)newValue);
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
			case ModelgraphPackage.INFORMATION__TYPE:
				setType((EReference)null);
				return;
			case ModelgraphPackage.INFORMATION__ATT:
				setAtt((EAttribute)null);
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
			case ModelgraphPackage.INFORMATION__TYPE:
				return type != null;
			case ModelgraphPackage.INFORMATION__ATT:
				return att != null;
		}
		return super.eIsSet(featureID);
	}

} //InformationImpl
