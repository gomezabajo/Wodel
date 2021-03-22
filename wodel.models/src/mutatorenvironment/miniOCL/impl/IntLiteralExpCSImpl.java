/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.IntLiteralExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Int Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.IntLiteralExpCSImpl#getIntSymbol <em>Int Symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntLiteralExpCSImpl extends LiteralExpCSImpl implements IntLiteralExpCS {
	/**
	 * The default value of the '{@link #getIntSymbol() <em>Int Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final int INT_SYMBOL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntSymbol() <em>Int Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntSymbol()
	 * @generated
	 * @ordered
	 */
	protected int intSymbol = INT_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntLiteralExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.INT_LITERAL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIntSymbol() {
		return intSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIntSymbol(int newIntSymbol) {
		int oldIntSymbol = intSymbol;
		intSymbol = newIntSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.INT_LITERAL_EXP_CS__INT_SYMBOL, oldIntSymbol, intSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniOCLPackage.INT_LITERAL_EXP_CS__INT_SYMBOL:
				return getIntSymbol();
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
			case MiniOCLPackage.INT_LITERAL_EXP_CS__INT_SYMBOL:
				setIntSymbol((Integer)newValue);
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
			case MiniOCLPackage.INT_LITERAL_EXP_CS__INT_SYMBOL:
				setIntSymbol(INT_SYMBOL_EDEFAULT);
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
			case MiniOCLPackage.INT_LITERAL_EXP_CS__INT_SYMBOL:
				return intSymbol != INT_SYMBOL_EDEFAULT;
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
		result.append(" (intSymbol: ");
		result.append(intSymbol);
		result.append(')');
		return result.toString();
	}

} //IntLiteralExpCSImpl
