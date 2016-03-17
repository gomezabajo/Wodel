/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.Definition;
import mutatorenvironment.Load;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentPackage;

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
 * An implementation of the model object '<em><b>Mutator Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.MutatorEnvironmentImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link mutatorenvironment.impl.MutatorEnvironmentImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link mutatorenvironment.impl.MutatorEnvironmentImpl#getLoad <em>Load</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatorEnvironmentImpl extends MinimalEObjectImpl.Container implements MutatorEnvironment {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected Definition definition;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<Mutator> commands;

	/**
	 * The cached value of the '{@link #getLoad() <em>Load</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoad()
	 * @generated
	 * @ordered
	 */
	protected EList<Load> load;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorEnvironmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.MUTATOR_ENVIRONMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Definition getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinition(Definition newDefinition, NotificationChain msgs) {
		Definition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION, oldDefinition, newDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(Definition newDefinition) {
		if (newDefinition != definition) {
			NotificationChain msgs = null;
			if (definition != null)
				msgs = ((InternalEObject)definition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION, null, msgs);
			if (newDefinition != null)
				msgs = ((InternalEObject)newDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION, null, msgs);
			msgs = basicSetDefinition(newDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION, newDefinition, newDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mutator> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<Mutator>(Mutator.class, this, MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Load> getLoad() {
		if (load == null) {
			load = new EObjectContainmentEList<Load>(Load.class, this, MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD);
		}
		return load;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION:
				return basicSetDefinition(null, msgs);
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS:
				return ((InternalEList<?>)getCommands()).basicRemove(otherEnd, msgs);
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD:
				return ((InternalEList<?>)getLoad()).basicRemove(otherEnd, msgs);
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
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION:
				return getDefinition();
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS:
				return getCommands();
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD:
				return getLoad();
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
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION:
				setDefinition((Definition)newValue);
				return;
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS:
				getCommands().clear();
				getCommands().addAll((Collection<? extends Mutator>)newValue);
				return;
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD:
				getLoad().clear();
				getLoad().addAll((Collection<? extends Load>)newValue);
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
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION:
				setDefinition((Definition)null);
				return;
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS:
				getCommands().clear();
				return;
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD:
				getLoad().clear();
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
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__DEFINITION:
				return definition != null;
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__COMMANDS:
				return commands != null && !commands.isEmpty();
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT__LOAD:
				return load != null && !load.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MutatorEnvironmentImpl
