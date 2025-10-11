/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.BooleanExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.BooleanExpCSImpl#isBoolSymbol <em>Bool Symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanExpCSImpl extends BooleanLiteralExpCSImpl implements BooleanExpCS {
	/**
	 * The default value of the '{@link #isBoolSymbol() <em>Bool Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOL_SYMBOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBoolSymbol() <em>Bool Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoolSymbol()
	 * @generated
	 * @ordered
	 */
	protected boolean boolSymbol = BOOL_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.BOOLEAN_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBoolSymbol() {
		return boolSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoolSymbol(boolean newBoolSymbol) {
		boolean oldBoolSymbol = boolSymbol;
		boolSymbol = newBoolSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.BOOLEAN_EXP_CS__BOOL_SYMBOL, oldBoolSymbol, boolSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniOCLPackage.BOOLEAN_EXP_CS__BOOL_SYMBOL:
				return isBoolSymbol();
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
			case MiniOCLPackage.BOOLEAN_EXP_CS__BOOL_SYMBOL:
				setBoolSymbol((Boolean)newValue);
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
			case MiniOCLPackage.BOOLEAN_EXP_CS__BOOL_SYMBOL:
				setBoolSymbol(BOOL_SYMBOL_EDEFAULT);
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
			case MiniOCLPackage.BOOLEAN_EXP_CS__BOOL_SYMBOL:
				return boolSymbol != BOOL_SYMBOL_EDEFAULT;
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
		result.append(" (boolSymbol: ");
		result.append(boolSymbol);
		result.append(')');
		return result.toString();
	}

} //BooleanExpCSImpl
