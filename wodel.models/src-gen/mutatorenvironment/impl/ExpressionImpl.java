/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
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
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ExpressionImpl#getFirst <em>First</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ExpressionImpl#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression {
	/**
	 * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirst()
	 * @generated
	 * @ordered
	 */
	protected Evaluation first;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected EList<BinaryOperator> operator;

	/**
	 * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecond()
	 * @generated
	 * @ordered
	 */
	protected EList<Evaluation> second;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evaluation getFirst() {
		return first;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirst(Evaluation newFirst, NotificationChain msgs) {
		Evaluation oldFirst = first;
		first = newFirst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.EXPRESSION__FIRST, oldFirst, newFirst);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirst(Evaluation newFirst) {
		if (newFirst != first) {
			NotificationChain msgs = null;
			if (first != null)
				msgs = ((InternalEObject) first).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.EXPRESSION__FIRST, null, msgs);
			if (newFirst != null)
				msgs = ((InternalEObject) newFirst).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.EXPRESSION__FIRST, null, msgs);
			msgs = basicSetFirst(newFirst, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.EXPRESSION__FIRST, newFirst,
					newFirst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BinaryOperator> getOperator() {
		if (operator == null) {
			operator = new EObjectContainmentEList<BinaryOperator>(BinaryOperator.class, this,
					MutatorenvironmentPackage.EXPRESSION__OPERATOR);
		}
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Evaluation> getSecond() {
		if (second == null) {
			second = new EObjectContainmentEList<Evaluation>(Evaluation.class, this,
					MutatorenvironmentPackage.EXPRESSION__SECOND);
		}
		return second;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MutatorenvironmentPackage.EXPRESSION__FIRST:
			return basicSetFirst(null, msgs);
		case MutatorenvironmentPackage.EXPRESSION__OPERATOR:
			return ((InternalEList<?>) getOperator()).basicRemove(otherEnd, msgs);
		case MutatorenvironmentPackage.EXPRESSION__SECOND:
			return ((InternalEList<?>) getSecond()).basicRemove(otherEnd, msgs);
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
		case MutatorenvironmentPackage.EXPRESSION__FIRST:
			return getFirst();
		case MutatorenvironmentPackage.EXPRESSION__OPERATOR:
			return getOperator();
		case MutatorenvironmentPackage.EXPRESSION__SECOND:
			return getSecond();
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
		case MutatorenvironmentPackage.EXPRESSION__FIRST:
			setFirst((Evaluation) newValue);
			return;
		case MutatorenvironmentPackage.EXPRESSION__OPERATOR:
			getOperator().clear();
			getOperator().addAll((Collection<? extends BinaryOperator>) newValue);
			return;
		case MutatorenvironmentPackage.EXPRESSION__SECOND:
			getSecond().clear();
			getSecond().addAll((Collection<? extends Evaluation>) newValue);
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
		case MutatorenvironmentPackage.EXPRESSION__FIRST:
			setFirst((Evaluation) null);
			return;
		case MutatorenvironmentPackage.EXPRESSION__OPERATOR:
			getOperator().clear();
			return;
		case MutatorenvironmentPackage.EXPRESSION__SECOND:
			getSecond().clear();
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
		case MutatorenvironmentPackage.EXPRESSION__FIRST:
			return first != null;
		case MutatorenvironmentPackage.EXPRESSION__OPERATOR:
			return operator != null && !operator.isEmpty();
		case MutatorenvironmentPackage.EXPRESSION__SECOND:
			return second != null && !second.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionImpl
