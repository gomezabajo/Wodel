/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.CallExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.NameExpCS;
import mutatorenvironment.miniOCL.PathNameCS;
import mutatorenvironment.miniOCL.RoundedBracketClauseCS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.NameExpCSImpl#getExpName <em>Exp Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.NameExpCSImpl#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.NameExpCSImpl#getCallExp <em>Call Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameExpCSImpl extends NavigationExpCSImpl implements NameExpCS {
	/**
	 * The cached value of the '{@link #getExpName() <em>Exp Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS expName;

	/**
	 * The cached value of the '{@link #getRoundedBrackets() <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundedBrackets()
	 * @generated
	 * @ordered
	 */
	protected RoundedBracketClauseCS roundedBrackets;

	/**
	 * The cached value of the '{@link #getCallExp() <em>Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallExp()
	 * @generated
	 * @ordered
	 */
	protected CallExpCS callExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getExpName() {
		return expName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpName(PathNameCS newExpName, NotificationChain msgs) {
		PathNameCS oldExpName = expName;
		expName = newExpName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniOCLPackage.NAME_EXP_CS__EXP_NAME, oldExpName, newExpName);
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
	public void setExpName(PathNameCS newExpName) {
		if (newExpName != expName) {
			NotificationChain msgs = null;
			if (expName != null)
				msgs = ((InternalEObject) expName).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__EXP_NAME, null, msgs);
			if (newExpName != null)
				msgs = ((InternalEObject) newExpName).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__EXP_NAME, null, msgs);
			msgs = basicSetExpName(newExpName, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.NAME_EXP_CS__EXP_NAME, newExpName,
					newExpName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundedBracketClauseCS getRoundedBrackets() {
		return roundedBrackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoundedBrackets(RoundedBracketClauseCS newRoundedBrackets,
			NotificationChain msgs) {
		RoundedBracketClauseCS oldRoundedBrackets = roundedBrackets;
		roundedBrackets = newRoundedBrackets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS, oldRoundedBrackets, newRoundedBrackets);
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
	public void setRoundedBrackets(RoundedBracketClauseCS newRoundedBrackets) {
		if (newRoundedBrackets != roundedBrackets) {
			NotificationChain msgs = null;
			if (roundedBrackets != null)
				msgs = ((InternalEObject) roundedBrackets).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS, null, msgs);
			if (newRoundedBrackets != null)
				msgs = ((InternalEObject) newRoundedBrackets).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS, null, msgs);
			msgs = basicSetRoundedBrackets(newRoundedBrackets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS,
					newRoundedBrackets, newRoundedBrackets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallExpCS getCallExp() {
		return callExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallExp(CallExpCS newCallExp, NotificationChain msgs) {
		CallExpCS oldCallExp = callExp;
		callExp = newCallExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniOCLPackage.NAME_EXP_CS__CALL_EXP, oldCallExp, newCallExp);
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
	public void setCallExp(CallExpCS newCallExp) {
		if (newCallExp != callExp) {
			NotificationChain msgs = null;
			if (callExp != null)
				msgs = ((InternalEObject) callExp).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__CALL_EXP, null, msgs);
			if (newCallExp != null)
				msgs = ((InternalEObject) newCallExp).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.NAME_EXP_CS__CALL_EXP, null, msgs);
			msgs = basicSetCallExp(newCallExp, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.NAME_EXP_CS__CALL_EXP, newCallExp,
					newCallExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.NAME_EXP_CS__EXP_NAME:
			return basicSetExpName(null, msgs);
		case MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
			return basicSetRoundedBrackets(null, msgs);
		case MiniOCLPackage.NAME_EXP_CS__CALL_EXP:
			return basicSetCallExp(null, msgs);
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
		case MiniOCLPackage.NAME_EXP_CS__EXP_NAME:
			return getExpName();
		case MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
			return getRoundedBrackets();
		case MiniOCLPackage.NAME_EXP_CS__CALL_EXP:
			return getCallExp();
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
		case MiniOCLPackage.NAME_EXP_CS__EXP_NAME:
			setExpName((PathNameCS) newValue);
			return;
		case MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
			setRoundedBrackets((RoundedBracketClauseCS) newValue);
			return;
		case MiniOCLPackage.NAME_EXP_CS__CALL_EXP:
			setCallExp((CallExpCS) newValue);
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
		case MiniOCLPackage.NAME_EXP_CS__EXP_NAME:
			setExpName((PathNameCS) null);
			return;
		case MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
			setRoundedBrackets((RoundedBracketClauseCS) null);
			return;
		case MiniOCLPackage.NAME_EXP_CS__CALL_EXP:
			setCallExp((CallExpCS) null);
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
		case MiniOCLPackage.NAME_EXP_CS__EXP_NAME:
			return expName != null;
		case MiniOCLPackage.NAME_EXP_CS__ROUNDED_BRACKETS:
			return roundedBrackets != null;
		case MiniOCLPackage.NAME_EXP_CS__CALL_EXP:
			return callExp != null;
		}
		return super.eIsSet(featureID);
	}

} //NameExpCSImpl
