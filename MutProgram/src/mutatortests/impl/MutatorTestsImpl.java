/**
 */
package mutatortests.impl;

import java.util.Collection;
import mutatortests.Configuration;
import mutatortests.MutatorTests;
import mutatortests.MutatortestsPackage;
import mutatortests.Test;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutator Tests</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatortests.impl.MutatorTestsImpl#getConfig <em>Config</em>}</li>
 *   <li>{@link mutatortests.impl.MutatorTestsImpl#getTests <em>Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatorTestsImpl extends MinimalEObjectImpl.Container implements MutatorTests {
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
	 * The cached value of the '{@link #getTests() <em>Tests</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTests()
	 * @generated
	 * @ordered
	 */
	protected EList<Test> tests;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorTestsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatortestsPackage.Literals.MUTATOR_TESTS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatortestsPackage.MUTATOR_TESTS__CONFIG, oldConfig, newConfig);
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
				msgs = ((InternalEObject)config).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatortestsPackage.MUTATOR_TESTS__CONFIG, null, msgs);
			if (newConfig != null)
				msgs = ((InternalEObject)newConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatortestsPackage.MUTATOR_TESTS__CONFIG, null, msgs);
			msgs = basicSetConfig(newConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatortestsPackage.MUTATOR_TESTS__CONFIG, newConfig, newConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Test> getTests() {
		if (tests == null) {
			tests = new EObjectContainmentEList<Test>(Test.class, this, MutatortestsPackage.MUTATOR_TESTS__TESTS);
		}
		return tests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatortestsPackage.MUTATOR_TESTS__CONFIG:
				return basicSetConfig(null, msgs);
			case MutatortestsPackage.MUTATOR_TESTS__TESTS:
				return ((InternalEList<?>)getTests()).basicRemove(otherEnd, msgs);
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
			case MutatortestsPackage.MUTATOR_TESTS__CONFIG:
				return getConfig();
			case MutatortestsPackage.MUTATOR_TESTS__TESTS:
				return getTests();
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
			case MutatortestsPackage.MUTATOR_TESTS__CONFIG:
				setConfig((Configuration)newValue);
				return;
			case MutatortestsPackage.MUTATOR_TESTS__TESTS:
				getTests().clear();
				getTests().addAll((Collection<? extends Test>)newValue);
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
			case MutatortestsPackage.MUTATOR_TESTS__CONFIG:
				setConfig((Configuration)null);
				return;
			case MutatortestsPackage.MUTATOR_TESTS__TESTS:
				getTests().clear();
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
			case MutatortestsPackage.MUTATOR_TESTS__CONFIG:
				return config != null;
			case MutatortestsPackage.MUTATOR_TESTS__TESTS:
				return tests != null && !tests.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MutatorTestsImpl
