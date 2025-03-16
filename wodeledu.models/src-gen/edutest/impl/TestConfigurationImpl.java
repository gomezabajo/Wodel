/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.Mode;
import edutest.TestConfiguration;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edutest.impl.TestConfigurationImpl#isRetry <em>Retry</em>}</li>
 *   <li>{@link edutest.impl.TestConfigurationImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link edutest.impl.TestConfigurationImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link edutest.impl.TestConfigurationImpl#getAnswers <em>Answers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestConfigurationImpl extends ConfigurationImpl implements TestConfiguration {
	/**
	 * The default value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETRY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
	protected boolean retry = RETRY_EDEFAULT;

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
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> statement;

	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> answers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdutestPackage.Literals.TEST_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRetry() {
		return retry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetry(boolean newRetry) {
		boolean oldRetry = retry;
		retry = newRetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.TEST_CONFIGURATION__RETRY, oldRetry,
					retry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.TEST_CONFIGURATION__MODE, oldMode,
					mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getStatement() {
		if (statement == null) {
			statement = new EObjectResolvingEList<EClass>(EClass.class, this,
					EdutestPackage.TEST_CONFIGURATION__STATEMENT);
		}
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getAnswers() {
		if (answers == null) {
			answers = new EObjectResolvingEList<EClass>(EClass.class, this, EdutestPackage.TEST_CONFIGURATION__ANSWERS);
		}
		return answers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EdutestPackage.TEST_CONFIGURATION__RETRY:
			return isRetry();
		case EdutestPackage.TEST_CONFIGURATION__MODE:
			return getMode();
		case EdutestPackage.TEST_CONFIGURATION__STATEMENT:
			return getStatement();
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			return getAnswers();
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
		case EdutestPackage.TEST_CONFIGURATION__RETRY:
			setRetry((Boolean) newValue);
			return;
		case EdutestPackage.TEST_CONFIGURATION__MODE:
			setMode((Mode) newValue);
			return;
		case EdutestPackage.TEST_CONFIGURATION__STATEMENT:
			getStatement().clear();
			getStatement().addAll((Collection<? extends EClass>) newValue);
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			getAnswers().clear();
			getAnswers().addAll((Collection<? extends EClass>) newValue);
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
		case EdutestPackage.TEST_CONFIGURATION__RETRY:
			setRetry(RETRY_EDEFAULT);
			return;
		case EdutestPackage.TEST_CONFIGURATION__MODE:
			setMode(MODE_EDEFAULT);
			return;
		case EdutestPackage.TEST_CONFIGURATION__STATEMENT:
			getStatement().clear();
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			getAnswers().clear();
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
		case EdutestPackage.TEST_CONFIGURATION__RETRY:
			return retry != RETRY_EDEFAULT;
		case EdutestPackage.TEST_CONFIGURATION__MODE:
			return mode != MODE_EDEFAULT;
		case EdutestPackage.TEST_CONFIGURATION__STATEMENT:
			return statement != null && !statement.isEmpty();
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			return answers != null && !answers.isEmpty();
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
		result.append(" (retry: ");
		result.append(retry);
		result.append(", mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //TestConfigurationImpl
