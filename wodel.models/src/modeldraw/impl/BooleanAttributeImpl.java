/**
 */
package modeldraw.impl;

import modeldraw.BooleanAttribute;
import modeldraw.ModeldrawPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.BooleanAttributeImpl#isNegation <em>Negation</em>}</li>
 *   <li>{@link modeldraw.impl.BooleanAttributeImpl#getAtt <em>Att</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanAttributeImpl extends ItemImpl implements BooleanAttribute {
	/**
	 * The default value of the '{@link #isNegation() <em>Negation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEGATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNegation() <em>Negation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNegation()
	 * @generated
	 * @ordered
	 */
	protected boolean negation = NEGATION_EDEFAULT;

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
	protected BooleanAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.BOOLEAN_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNegation() {
		return negation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNegation(boolean newNegation) {
		boolean oldNegation = negation;
		negation = newNegation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.BOOLEAN_ATTRIBUTE__NEGATION, oldNegation, negation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT, oldAtt, att));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT, oldAtt, att));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__NEGATION:
				return isNegation();
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT:
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
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__NEGATION:
				setNegation((Boolean)newValue);
				return;
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT:
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
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__NEGATION:
				setNegation(NEGATION_EDEFAULT);
				return;
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT:
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
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__NEGATION:
				return negation != NEGATION_EDEFAULT;
			case ModeldrawPackage.BOOLEAN_ATTRIBUTE__ATT:
				return att != null;
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
		result.append(" (negation: ");
		result.append(negation);
		result.append(')');
		return result.toString();
	}

} //BooleanAttributeImpl
