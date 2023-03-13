/**
 */
package mutatorenvironment.miniOCL.impl;

import java.util.Collection;

import mutatorenvironment.miniOCL.ExpCS;
import mutatorenvironment.miniOCL.IteratorVarCS;
import mutatorenvironment.miniOCL.LoopExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.LoopExpCSImpl#getItVar <em>It Var</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.LoopExpCSImpl#getLogicOp <em>Logic Op</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.LoopExpCSImpl#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoopExpCSImpl extends NavigationExpCSImpl implements LoopExpCS {
	/**
	 * The cached value of the '{@link #getItVar() <em>It Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItVar()
	 * @generated
	 * @ordered
	 */
	protected IteratorVarCS itVar;

	/**
	 * The cached value of the '{@link #getLogicOp() <em>Logic Op</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLogicOp()
	 * @generated
	 * @ordered
	 */
	protected EList<String> logicOp;

	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpCS> exp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.LOOP_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorVarCS getItVar() {
		return itVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetItVar(IteratorVarCS newItVar, NotificationChain msgs) {
		IteratorVarCS oldItVar = itVar;
		itVar = newItVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniOCLPackage.LOOP_EXP_CS__IT_VAR, oldItVar, newItVar);
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
	public void setItVar(IteratorVarCS newItVar) {
		if (newItVar != itVar) {
			NotificationChain msgs = null;
			if (itVar != null)
				msgs = ((InternalEObject) itVar).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.LOOP_EXP_CS__IT_VAR, null, msgs);
			if (newItVar != null)
				msgs = ((InternalEObject) newItVar).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniOCLPackage.LOOP_EXP_CS__IT_VAR, null, msgs);
			msgs = basicSetItVar(newItVar, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.LOOP_EXP_CS__IT_VAR, newItVar,
					newItVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLogicOp() {
		if (logicOp == null) {
			logicOp = new EDataTypeUniqueEList<String>(String.class, this, MiniOCLPackage.LOOP_EXP_CS__LOGIC_OP);
		}
		return logicOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpCS> getExp() {
		if (exp == null) {
			exp = new EObjectContainmentEList<ExpCS>(ExpCS.class, this, MiniOCLPackage.LOOP_EXP_CS__EXP);
		}
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.LOOP_EXP_CS__IT_VAR:
			return basicSetItVar(null, msgs);
		case MiniOCLPackage.LOOP_EXP_CS__EXP:
			return ((InternalEList<?>) getExp()).basicRemove(otherEnd, msgs);
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
		case MiniOCLPackage.LOOP_EXP_CS__IT_VAR:
			return getItVar();
		case MiniOCLPackage.LOOP_EXP_CS__LOGIC_OP:
			return getLogicOp();
		case MiniOCLPackage.LOOP_EXP_CS__EXP:
			return getExp();
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
		case MiniOCLPackage.LOOP_EXP_CS__IT_VAR:
			setItVar((IteratorVarCS) newValue);
			return;
		case MiniOCLPackage.LOOP_EXP_CS__LOGIC_OP:
			getLogicOp().clear();
			getLogicOp().addAll((Collection<? extends String>) newValue);
			return;
		case MiniOCLPackage.LOOP_EXP_CS__EXP:
			getExp().clear();
			getExp().addAll((Collection<? extends ExpCS>) newValue);
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
		case MiniOCLPackage.LOOP_EXP_CS__IT_VAR:
			setItVar((IteratorVarCS) null);
			return;
		case MiniOCLPackage.LOOP_EXP_CS__LOGIC_OP:
			getLogicOp().clear();
			return;
		case MiniOCLPackage.LOOP_EXP_CS__EXP:
			getExp().clear();
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
		case MiniOCLPackage.LOOP_EXP_CS__IT_VAR:
			return itVar != null;
		case MiniOCLPackage.LOOP_EXP_CS__LOGIC_OP:
			return logicOp != null && !logicOp.isEmpty();
		case MiniOCLPackage.LOOP_EXP_CS__EXP:
			return exp != null && !exp.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (logicOp: ");
		result.append(logicOp);
		result.append(')');
		return result.toString();
	}

} //LoopExpCSImpl
