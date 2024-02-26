/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.Mode;
import edutest.TestConfiguration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
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
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected EClass statement;

	/**
	 * The cached value of the '{@link #getAnswers() <em>Answers</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnswers()
	 * @generated
	 * @ordered
	 */
	protected EClass answers;

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
	public EClass getStatement() {
		if (statement != null && statement.eIsProxy()) {
			InternalEObject oldStatement = (InternalEObject) statement;
			statement = (EClass) eResolveProxy(oldStatement);
			if (statement != oldStatement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EdutestPackage.TEST_CONFIGURATION__STATEMENT, oldStatement, statement));
			}
		}
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(EClass newStatement) {
		EClass oldStatement = statement;
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
	public EClass getAnswers() {
		if (answers != null && answers.eIsProxy()) {
			InternalEObject oldAnswers = (InternalEObject) answers;
			answers = (EClass) eResolveProxy(oldAnswers);
			if (answers != oldAnswers) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							EdutestPackage.TEST_CONFIGURATION__ANSWERS, oldAnswers, answers));
			}
		}
		return answers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetAnswers() {
		return answers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnswers(EClass newAnswers) {
		EClass oldAnswers = answers;
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
			if (resolve)
				return getStatement();
			return basicGetStatement();
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			if (resolve)
				return getAnswers();
			return basicGetAnswers();
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
			setStatement((EClass) newValue);
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			setAnswers((EClass) newValue);
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
			setStatement((EClass) null);
			return;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			setAnswers((EClass) null);
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
			return statement != null;
		case EdutestPackage.TEST_CONFIGURATION__ANSWERS:
			return answers != null;
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
