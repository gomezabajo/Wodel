/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.IteratorVarCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.PathNameCS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Var CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.IteratorVarCSImpl#getItName <em>It Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.IteratorVarCSImpl#getItType <em>It Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IteratorVarCSImpl extends MinimalEObjectImpl.Container implements IteratorVarCS {
	/**
	 * The default value of the '{@link #getItName() <em>It Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItName()
	 * @generated
	 * @ordered
	 */
	protected static final String IT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getItName() <em>It Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItName()
	 * @generated
	 * @ordered
	 */
	protected String itName = IT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItType() <em>It Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItType()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS itType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorVarCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.ITERATOR_VAR_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getItName() {
		return itName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItName(String newItName) {
		String oldItName = itName;
		itName = newItName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ITERATOR_VAR_CS__IT_NAME, oldItName, itName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getItType() {
		return itType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItType(PathNameCS newItType, NotificationChain msgs) {
		PathNameCS oldItType = itType;
		itType = newItType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE, oldItType, newItType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItType(PathNameCS newItType) {
		if (newItType != itType) {
			NotificationChain msgs = null;
			if (itType != null)
				msgs = ((InternalEObject)itType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE, null, msgs);
			if (newItType != null)
				msgs = ((InternalEObject)newItType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE, null, msgs);
			msgs = basicSetItType(newItType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE, newItType, newItType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE:
				return basicSetItType(null, msgs);
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
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_NAME:
				return getItName();
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE:
				return getItType();
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
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_NAME:
				setItName((String)newValue);
				return;
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE:
				setItType((PathNameCS)newValue);
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
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_NAME:
				setItName(IT_NAME_EDEFAULT);
				return;
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE:
				setItType((PathNameCS)null);
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
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_NAME:
				return IT_NAME_EDEFAULT == null ? itName != null : !IT_NAME_EDEFAULT.equals(itName);
			case MiniOCLPackage.ITERATOR_VAR_CS__IT_TYPE:
				return itType != null;
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
		result.append(" (itName: ");
		result.append(itName);
		result.append(')');
		return result.toString();
	}

} //IteratorVarCSImpl
