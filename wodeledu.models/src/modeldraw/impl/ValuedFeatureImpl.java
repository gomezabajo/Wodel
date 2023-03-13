/**
 */
package modeldraw.impl;

import modeldraw.ModeldrawPackage;
import modeldraw.ValuedFeature;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Valued Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.ValuedFeatureImpl#isNegation <em>Negation</em>}</li>
 *   <li>{@link modeldraw.impl.ValuedFeatureImpl#getFeat <em>Feat</em>}</li>
 *   <li>{@link modeldraw.impl.ValuedFeatureImpl#getRefFeature <em>Ref Feature</em>}</li>
 *   <li>{@link modeldraw.impl.ValuedFeatureImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValuedFeatureImpl extends ItemImpl implements ValuedFeature {
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
	 * The cached value of the '{@link #getFeat() <em>Feat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeat()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature feat;

	/**
	 * The cached value of the '{@link #getRefFeature() <em>Ref Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature refFeature;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValuedFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.VALUED_FEATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.VALUED_FEATURE__NEGATION, oldNegation, negation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeat() {
		if (feat != null && feat.eIsProxy()) {
			InternalEObject oldFeat = (InternalEObject)feat;
			feat = (EStructuralFeature)eResolveProxy(oldFeat);
			if (feat != oldFeat) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.VALUED_FEATURE__FEAT, oldFeat, feat));
			}
		}
		return feat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeat() {
		return feat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeat(EStructuralFeature newFeat) {
		EStructuralFeature oldFeat = feat;
		feat = newFeat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.VALUED_FEATURE__FEAT, oldFeat, feat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getRefFeature() {
		if (refFeature != null && refFeature.eIsProxy()) {
			InternalEObject oldRefFeature = (InternalEObject)refFeature;
			refFeature = (EStructuralFeature)eResolveProxy(oldRefFeature);
			if (refFeature != oldRefFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.VALUED_FEATURE__REF_FEATURE, oldRefFeature, refFeature));
			}
		}
		return refFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetRefFeature() {
		return refFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefFeature(EStructuralFeature newRefFeature) {
		EStructuralFeature oldRefFeature = refFeature;
		refFeature = newRefFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.VALUED_FEATURE__REF_FEATURE, oldRefFeature, refFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.VALUED_FEATURE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModeldrawPackage.VALUED_FEATURE__NEGATION:
				return isNegation();
			case ModeldrawPackage.VALUED_FEATURE__FEAT:
				if (resolve) return getFeat();
				return basicGetFeat();
			case ModeldrawPackage.VALUED_FEATURE__REF_FEATURE:
				if (resolve) return getRefFeature();
				return basicGetRefFeature();
			case ModeldrawPackage.VALUED_FEATURE__VALUE:
				return getValue();
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
			case ModeldrawPackage.VALUED_FEATURE__NEGATION:
				setNegation((Boolean)newValue);
				return;
			case ModeldrawPackage.VALUED_FEATURE__FEAT:
				setFeat((EStructuralFeature)newValue);
				return;
			case ModeldrawPackage.VALUED_FEATURE__REF_FEATURE:
				setRefFeature((EStructuralFeature)newValue);
				return;
			case ModeldrawPackage.VALUED_FEATURE__VALUE:
				setValue((String)newValue);
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
			case ModeldrawPackage.VALUED_FEATURE__NEGATION:
				setNegation(NEGATION_EDEFAULT);
				return;
			case ModeldrawPackage.VALUED_FEATURE__FEAT:
				setFeat((EStructuralFeature)null);
				return;
			case ModeldrawPackage.VALUED_FEATURE__REF_FEATURE:
				setRefFeature((EStructuralFeature)null);
				return;
			case ModeldrawPackage.VALUED_FEATURE__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case ModeldrawPackage.VALUED_FEATURE__NEGATION:
				return negation != NEGATION_EDEFAULT;
			case ModeldrawPackage.VALUED_FEATURE__FEAT:
				return feat != null;
			case ModeldrawPackage.VALUED_FEATURE__REF_FEATURE:
				return refFeature != null;
			case ModeldrawPackage.VALUED_FEATURE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ValuedFeatureImpl
