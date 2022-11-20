/**
 */
package edutest.impl;

import edutest.EdutestPackage;
import edutest.MutatorTests;
import edutest.Test;

import java.util.Collection;

import mutatorenvironment.Block;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mutator Tests</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edutest.impl.MutatorTestsImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link edutest.impl.MutatorTestsImpl#getTests <em>Tests</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MutatorTestsImpl extends MinimalEObjectImpl.Container implements MutatorTests {
	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<Block> blocks;

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
		return EdutestPackage.Literals.MUTATOR_TESTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Block> getBlocks() {
		if (blocks == null) {
			blocks = new EObjectResolvingEList<Block>(Block.class, this, EdutestPackage.MUTATOR_TESTS__BLOCKS);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Test> getTests() {
		if (tests == null) {
			tests = new EObjectContainmentEList<Test>(Test.class, this, EdutestPackage.MUTATOR_TESTS__TESTS);
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
			case EdutestPackage.MUTATOR_TESTS__TESTS:
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
			case EdutestPackage.MUTATOR_TESTS__BLOCKS:
				return getBlocks();
			case EdutestPackage.MUTATOR_TESTS__TESTS:
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
			case EdutestPackage.MUTATOR_TESTS__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends Block>)newValue);
				return;
			case EdutestPackage.MUTATOR_TESTS__TESTS:
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
			case EdutestPackage.MUTATOR_TESTS__BLOCKS:
				getBlocks().clear();
				return;
			case EdutestPackage.MUTATOR_TESTS__TESTS:
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
			case EdutestPackage.MUTATOR_TESTS__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case EdutestPackage.MUTATOR_TESTS__TESTS:
				return tests != null && !tests.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MutatorTestsImpl
