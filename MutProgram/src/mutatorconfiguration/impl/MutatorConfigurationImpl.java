/**
 */
package mutatorconfiguration.impl;

import java.util.Collection;

import mutatorconfiguration.Configuration;
import mutatorconfiguration.MutatorConfiguration;
import mutatorconfiguration.MutatorconfigurationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutator Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorconfiguration.impl.MutatorConfigurationImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link mutatorconfiguration.impl.MutatorConfigurationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorconfiguration.impl.MutatorConfigurationImpl#getQuestion <em>Question</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatorConfigurationImpl extends MinimalEObjectImpl.Container implements MutatorConfiguration {
	/**
	 * The cached value of the '{@link #getConfig() <em>Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfig()
	 * @generated
	 * @ordered
	 */
	protected Configuration config;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<String> source;

	/**
	 * The cached value of the '{@link #getQuestion() <em>Question</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuestion()
	 * @generated
	 * @ordered
	 */
	protected EList<String> question;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorconfigurationPackage.Literals.MUTATOR_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfig() {
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfig(Configuration newConfig, NotificationChain msgs) {
		Configuration oldConfig = config;
		config = newConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG, oldConfig, newConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfig(Configuration newConfig) {
		if (newConfig != config) {
			NotificationChain msgs = null;
			if (config != null)
				msgs = ((InternalEObject)config).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG, null, msgs);
			if (newConfig != null)
				msgs = ((InternalEObject)newConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG, null, msgs);
			msgs = basicSetConfig(newConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG, newConfig, newConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSource() {
		if (source == null) {
			source = new EDataTypeUniqueEList<String>(String.class, this, MutatorconfigurationPackage.MUTATOR_CONFIGURATION__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQuestion() {
		if (question == null) {
			question = new EDataTypeUniqueEList<String>(String.class, this, MutatorconfigurationPackage.MUTATOR_CONFIGURATION__QUESTION);
		}
		return question;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG:
				return basicSetConfig(null, msgs);
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
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG:
				return getConfig();
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__SOURCE:
				return getSource();
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__QUESTION:
				return getQuestion();
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
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG:
				setConfig((Configuration)newValue);
				return;
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends String>)newValue);
				return;
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__QUESTION:
				getQuestion().clear();
				getQuestion().addAll((Collection<? extends String>)newValue);
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
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG:
				setConfig((Configuration)null);
				return;
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__SOURCE:
				getSource().clear();
				return;
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__QUESTION:
				getQuestion().clear();
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
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__CONFIG:
				return config != null;
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__SOURCE:
				return source != null && !source.isEmpty();
			case MutatorconfigurationPackage.MUTATOR_CONFIGURATION__QUESTION:
				return question != null && !question.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (source: ");
		result.append(source);
		result.append(", question: ");
		result.append(question);
		result.append(')');
		return result.toString();
	}

} //MutatorConfigurationImpl
