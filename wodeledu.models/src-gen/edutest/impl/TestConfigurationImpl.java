/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.Mode;
import edutest.TestConfiguration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The default value of the '{@link #getStatement() <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected String statement = STATEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAnswers() <em>Answers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected static final String ANSWERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected String answers = ANSWERS_EDEFAULT;

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
	public String getStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(String newStatement) {
		String oldStatement = statement;
		statement = newStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.TEST_CONFIGURATION__STATEMENT,
					oldStatement, statement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnswers() {
		return answers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnswers(String newAnswers) {
		String oldAnswers = answers;
		answers = newAnswers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdutestPackage.TEST_CONFIGURATION__ANSWERS,
					oldAnswers, answers));
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
			setStatement((String) newValue);
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			setAnswers((String) newValue);
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
			setStatement(STATEMENT_EDEFAULT);
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			setAnswers(ANSWERS_EDEFAULT);
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
			return STATEMENT_EDEFAULT == null ? statement != null : !STATEMENT_EDEFAULT.equals(statement);
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			return ANSWERS_EDEFAULT == null ? answers != null : !ANSWERS_EDEFAULT.equals(answers);
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
		result.append(", statement: ");
		result.append(statement);
		result.append(", answers: ");
		result.append(answers);
		result.append(')');
		return result.toString();
	}

} //TestConfigurationImpl
