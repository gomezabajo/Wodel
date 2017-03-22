/**
 */
package mutatormetrics.impl;

import java.util.Collection;

import mutatormetrics.Folder;
import mutatormetrics.MutatorMetrics;
import mutatormetrics.MutatormetricsPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutator Metrics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatormetrics.impl.MutatorMetricsImpl#getTrees <em>Trees</em>}</li>
 *   <li>{@link mutatormetrics.impl.MutatorMetricsImpl#getClasses <em>Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatorMetricsImpl extends MinimalEObjectImpl.Container implements MutatorMetrics {
	/**
	 * The cached value of the '{@link #getTrees() <em>Trees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrees()
	 * @generated
	 * @ordered
	 */
	protected EList<Folder> trees;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<mutatormetrics.Class> classes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorMetricsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatormetricsPackage.Literals.MUTATOR_METRICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Folder> getTrees() {
		if (trees == null) {
			trees = new EObjectContainmentEList<Folder>(Folder.class, this, MutatormetricsPackage.MUTATOR_METRICS__TREES);
		}
		return trees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<mutatormetrics.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<mutatormetrics.Class>(mutatormetrics.Class.class, this, MutatormetricsPackage.MUTATOR_METRICS__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatormetricsPackage.MUTATOR_METRICS__TREES:
				return ((InternalEList<?>)getTrees()).basicRemove(otherEnd, msgs);
			case MutatormetricsPackage.MUTATOR_METRICS__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
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
			case MutatormetricsPackage.MUTATOR_METRICS__TREES:
				return getTrees();
			case MutatormetricsPackage.MUTATOR_METRICS__CLASSES:
				return getClasses();
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
			case MutatormetricsPackage.MUTATOR_METRICS__TREES:
				getTrees().clear();
				getTrees().addAll((Collection<? extends Folder>)newValue);
				return;
			case MutatormetricsPackage.MUTATOR_METRICS__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends mutatormetrics.Class>)newValue);
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
			case MutatormetricsPackage.MUTATOR_METRICS__TREES:
				getTrees().clear();
				return;
			case MutatormetricsPackage.MUTATOR_METRICS__CLASSES:
				getClasses().clear();
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
			case MutatormetricsPackage.MUTATOR_METRICS__TREES:
				return trees != null && !trees.isEmpty();
			case MutatormetricsPackage.MUTATOR_METRICS__CLASSES:
				return classes != null && !classes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MutatorMetricsImpl
