/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.AccVarCS;
import mutatorenvironment.miniOCL.ExpCS;
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
 * An implementation of the model object '<em><b>Acc Var CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.AccVarCSImpl#getAccVarName <em>Acc Var Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.AccVarCSImpl#getAccType <em>Acc Type</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.AccVarCSImpl#getAccInitExp <em>Acc Init Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AccVarCSImpl extends MinimalEObjectImpl.Container implements AccVarCS {
	/**
	 * The default value of the '{@link #getAccVarName() <em>Acc Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccVarName()
	 * @generated
	 * @ordered
	 */
	protected static final String ACC_VAR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccVarName() <em>Acc Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccVarName()
	 * @generated
	 * @ordered
	 */
	protected String accVarName = ACC_VAR_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAccType() <em>Acc Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccType()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS accType;

	/**
	 * The cached value of the '{@link #getAccInitExp() <em>Acc Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccInitExp()
	 * @generated
	 * @ordered
	 */
	protected ExpCS accInitExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccVarCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.ACC_VAR_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAccVarName() {
		return accVarName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccVarName(String newAccVarName) {
		String oldAccVarName = accVarName;
		accVarName = newAccVarName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ACC_VAR_CS__ACC_VAR_NAME, oldAccVarName, accVarName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getAccType() {
		return accType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccType(PathNameCS newAccType, NotificationChain msgs) {
		PathNameCS oldAccType = accType;
		accType = newAccType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ACC_VAR_CS__ACC_TYPE, oldAccType, newAccType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccType(PathNameCS newAccType) {
		if (newAccType != accType) {
			NotificationChain msgs = null;
			if (accType != null)
				msgs = ((InternalEObject)accType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ACC_VAR_CS__ACC_TYPE, null, msgs);
			if (newAccType != null)
				msgs = ((InternalEObject)newAccType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ACC_VAR_CS__ACC_TYPE, null, msgs);
			msgs = basicSetAccType(newAccType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ACC_VAR_CS__ACC_TYPE, newAccType, newAccType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getAccInitExp() {
		return accInitExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccInitExp(ExpCS newAccInitExp, NotificationChain msgs) {
		ExpCS oldAccInitExp = accInitExp;
		accInitExp = newAccInitExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP, oldAccInitExp, newAccInitExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAccInitExp(ExpCS newAccInitExp) {
		if (newAccInitExp != accInitExp) {
			NotificationChain msgs = null;
			if (accInitExp != null)
				msgs = ((InternalEObject)accInitExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP, null, msgs);
			if (newAccInitExp != null)
				msgs = ((InternalEObject)newAccInitExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP, null, msgs);
			msgs = basicSetAccInitExp(newAccInitExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP, newAccInitExp, newAccInitExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.ACC_VAR_CS__ACC_TYPE:
				return basicSetAccType(null, msgs);
			case MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP:
				return basicSetAccInitExp(null, msgs);
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
			case MiniOCLPackage.ACC_VAR_CS__ACC_VAR_NAME:
				return getAccVarName();
			case MiniOCLPackage.ACC_VAR_CS__ACC_TYPE:
				return getAccType();
			case MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP:
				return getAccInitExp();
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
			case MiniOCLPackage.ACC_VAR_CS__ACC_VAR_NAME:
				setAccVarName((String)newValue);
				return;
			case MiniOCLPackage.ACC_VAR_CS__ACC_TYPE:
				setAccType((PathNameCS)newValue);
				return;
			case MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP:
				setAccInitExp((ExpCS)newValue);
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
			case MiniOCLPackage.ACC_VAR_CS__ACC_VAR_NAME:
				setAccVarName(ACC_VAR_NAME_EDEFAULT);
				return;
			case MiniOCLPackage.ACC_VAR_CS__ACC_TYPE:
				setAccType((PathNameCS)null);
				return;
			case MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP:
				setAccInitExp((ExpCS)null);
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
			case MiniOCLPackage.ACC_VAR_CS__ACC_VAR_NAME:
				return ACC_VAR_NAME_EDEFAULT == null ? accVarName != null : !ACC_VAR_NAME_EDEFAULT.equals(accVarName);
			case MiniOCLPackage.ACC_VAR_CS__ACC_TYPE:
				return accType != null;
			case MiniOCLPackage.ACC_VAR_CS__ACC_INIT_EXP:
				return accInitExp != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (accVarName: ");
		result.append(accVarName);
		result.append(')');
		return result.toString();
	}

} //AccVarCSImpl
