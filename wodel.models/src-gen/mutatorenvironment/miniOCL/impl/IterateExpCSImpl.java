/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.AccVarCS;
import mutatorenvironment.miniOCL.IterateExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterate Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.IterateExpCSImpl#getAccVar <em>Acc Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterateExpCSImpl extends LoopExpCSImpl implements IterateExpCS {
	/**
	 * The cached value of the '{@link #getAccVar() <em>Acc Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccVar()
	 * @generated
	 * @ordered
	 */
	protected AccVarCS accVar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterateExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.ITERATE_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccVarCS getAccVar() {
		return accVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccVar(AccVarCS newAccVar, NotificationChain msgs) {
		AccVarCS oldAccVar = accVar;
		accVar = newAccVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR, oldAccVar, newAccVar);
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
	public void setAccVar(AccVarCS newAccVar) {
		if (newAccVar != accVar) {
			NotificationChain msgs = null;
			if (accVar != null)
				msgs = ((InternalEObject) accVar).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR, null, msgs);
			if (newAccVar != null)
				msgs = ((InternalEObject) newAccVar).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR, null, msgs);
			msgs = basicSetAccVar(newAccVar, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR, newAccVar,
					newAccVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR:
			return basicSetAccVar(null, msgs);
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
		case MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR:
			return getAccVar();
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
		case MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR:
			setAccVar((AccVarCS) newValue);
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
		case MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR:
			setAccVar((AccVarCS) null);
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
		case MiniOCLPackage.ITERATE_EXP_CS__ACC_VAR:
			return accVar != null;
		}
		return super.eIsSet(featureID);
	}

} //IterateExpCSImpl
