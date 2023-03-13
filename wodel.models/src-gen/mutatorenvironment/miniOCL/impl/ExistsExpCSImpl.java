/**
 */
package mutatorenvironment.miniOCL.impl;

import java.util.Collection;

import mutatorenvironment.miniOCL.AccVarCS;
import mutatorenvironment.miniOCL.ExistsExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exists Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.ExistsExpCSImpl#getAccVars <em>Acc Vars</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExistsExpCSImpl extends LoopExpCSImpl implements ExistsExpCS {
	/**
	 * The cached value of the '{@link #getAccVars() <em>Acc Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccVars()
	 * @generated
	 * @ordered
	 */
	protected EList<AccVarCS> accVars;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistsExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.EXISTS_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AccVarCS> getAccVars() {
		if (accVars == null) {
			accVars = new EObjectContainmentEList<AccVarCS>(AccVarCS.class, this,
					MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS);
		}
		return accVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS:
			return ((InternalEList<?>) getAccVars()).basicRemove(otherEnd, msgs);
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
		case MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS:
			return getAccVars();
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
		case MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS:
			getAccVars().clear();
			getAccVars().addAll((Collection<? extends AccVarCS>) newValue);
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
		case MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS:
			getAccVars().clear();
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
		case MiniOCLPackage.EXISTS_EXP_CS__ACC_VARS:
			return accVars != null && !accVars.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExistsExpCSImpl
