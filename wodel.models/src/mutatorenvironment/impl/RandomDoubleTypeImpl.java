/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.RandomDoubleType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Random Double Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.RandomDoubleTypeImpl#getMin <em>Min</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RandomDoubleTypeImpl#getMax <em>Max</em>}</li>
 *   <li>{@link mutatorenvironment.impl.RandomDoubleTypeImpl#isAllowsNull <em>Allows Null</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RandomDoubleTypeImpl extends DoubleTypeImpl implements RandomDoubleType {
	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final double MIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected double min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected double max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #isAllowsNull() <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowsNull()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOWS_NULL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllowsNull() <em>Allows Null</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowsNull()
	 * @generated
	 * @ordered
	 */
	protected boolean allowsNull = ALLOWS_NULL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomDoubleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.RANDOM_DOUBLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(double newMin) {
		double oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(double newMax) {
		double oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllowsNull() {
		return allowsNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllowsNull(boolean newAllowsNull) {
		boolean oldAllowsNull = allowsNull;
		allowsNull = newAllowsNull;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__ALLOWS_NULL, oldAllowsNull, allowsNull));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MIN:
				return getMin();
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MAX:
				return getMax();
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__ALLOWS_NULL:
				return isAllowsNull();
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
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MIN:
				setMin((Double)newValue);
				return;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MAX:
				setMax((Double)newValue);
				return;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__ALLOWS_NULL:
				setAllowsNull((Boolean)newValue);
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
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MIN:
				setMin(MIN_EDEFAULT);
				return;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MAX:
				setMax(MAX_EDEFAULT);
				return;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__ALLOWS_NULL:
				setAllowsNull(ALLOWS_NULL_EDEFAULT);
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
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MIN:
				return min != MIN_EDEFAULT;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__MAX:
				return max != MAX_EDEFAULT;
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE__ALLOWS_NULL:
				return allowsNull != ALLOWS_NULL_EDEFAULT;
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
		result.append(" (min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(", allowsNull: ");
		result.append(allowsNull);
		result.append(')');
		return result.toString();
	}

} //RandomDoubleTypeImpl
