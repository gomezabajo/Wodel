/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.Mode;
import edutest.MultiChoiceEmConfig;
import edutest.Order;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Choice Em Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edutest.impl.MultiChoiceEmConfigImpl#isWeighted <em>Weighted</em>}</li>
 *   <li>{@link edutest.impl.MultiChoiceEmConfigImpl#getPenalty <em>Penalty</em>}</li>
 *   <li>{@link edutest.impl.MultiChoiceEmConfigImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link edutest.impl.MultiChoiceEmConfigImpl#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiChoiceEmConfigImpl extends TestConfigurationImpl implements MultiChoiceEmConfig {
	/**
	 * The default value of the '{@link #isWeighted() <em>Weighted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWeighted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WEIGHTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWeighted() <em>Weighted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWeighted()
	 * @generated
	 * @ordered
	 */
	protected boolean weighted = WEIGHTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getPenalty() <em>Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenalty()
	 * @generated
	 * @ordered
	 */
	protected static final double PENALTY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPenalty() <em>Penalty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenalty()
	 * @generated
	 * @ordered
	 */
	protected double penalty = PENALTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final Order ORDER_EDEFAULT = Order.FIXED;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected Order order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final Mode MODE_EDEFAULT = Mode.RADIOBUTTON;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiChoiceEmConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdutestPackage.Literals.MULTI_CHOICE_EM_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isWeighted() {
		return weighted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWeighted(boolean newWeighted) {
		boolean oldWeighted = weighted;
		weighted = newWeighted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.MULTI_CHOICE_EM_CONFIG__WEIGHTED, oldWeighted, weighted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPenalty() {
		return penalty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPenalty(double newPenalty) {
		double oldPenalty = penalty;
		penalty = newPenalty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.MULTI_CHOICE_EM_CONFIG__PENALTY, oldPenalty, penalty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Order getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOrder(Order newOrder) {
		Order oldOrder = order;
		order = newOrder == null ? ORDER_EDEFAULT : newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.MULTI_CHOICE_EM_CONFIG__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.MULTI_CHOICE_EM_CONFIG__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__WEIGHTED:
				return isWeighted();
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__PENALTY:
				return getPenalty();
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__ORDER:
				return getOrder();
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__MODE:
				return getMode();
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
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__WEIGHTED:
				setWeighted((Boolean)newValue);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__PENALTY:
				setPenalty((Double)newValue);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__ORDER:
				setOrder((Order)newValue);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__MODE:
				setMode((Mode)newValue);
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
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__WEIGHTED:
				setWeighted(WEIGHTED_EDEFAULT);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__PENALTY:
				setPenalty(PENALTY_EDEFAULT);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__MODE:
				setMode(MODE_EDEFAULT);
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
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__WEIGHTED:
				return weighted != WEIGHTED_EDEFAULT;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__PENALTY:
				return penalty != PENALTY_EDEFAULT;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__ORDER:
				return order != ORDER_EDEFAULT;
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG__MODE:
				return mode != MODE_EDEFAULT;
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
		result.append(" (weighted: ");
		result.append(weighted);
		result.append(", penalty: ");
		result.append(penalty);
		result.append(", order: ");
		result.append(order);
		result.append(", mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //MultiChoiceEmConfigImpl
