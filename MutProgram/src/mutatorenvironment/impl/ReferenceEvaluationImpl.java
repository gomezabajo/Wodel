/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.ReferenceEvaluation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getRefType <em>Ref Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceEvaluationImpl extends EvaluationImpl implements ReferenceEvaluation
{
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected EReference name;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final Operator OPERATOR_EDEFAULT = Operator.EQUALS;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected ObSelectionStrategy value;

	/**
	 * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefType()
	 * @generated
	 * @ordered
	 */
	protected EReference refType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceEvaluationImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return MutatorenvironmentPackage.Literals.REFERENCE_EVALUATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName()
	{
		if (name != null && name.eIsProxy())
		{
			InternalEObject oldName = (InternalEObject)name;
			name = (EReference)eResolveProxy(oldName);
			if (name != oldName)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(EReference newName)
	{
		EReference oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator()
	{
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator)
	{
		Operator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getValue()
	{
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ObSelectionStrategy newValue, NotificationChain msgs)
	{
		ObSelectionStrategy oldValue = value;
		value = newValue;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(ObSelectionStrategy newValue)
	{
		if (newValue != value)
		{
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefType()
	{
		if (refType != null && refType.eIsProxy())
		{
			InternalEObject oldRefType = (InternalEObject)refType;
			refType = (EReference)eResolveProxy(oldRefType);
			if (refType != oldRefType)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE, oldRefType, refType));
			}
		}
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefType()
	{
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefType(EReference newRefType)
	{
		EReference oldRefType = refType;
		refType = newRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
				if (resolve) return getName();
				return basicGetName();
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
				return getOperator();
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
				return getValue();
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
				if (resolve) return getRefType();
				return basicGetRefType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
				setName((EReference)newValue);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
				setValue((ObSelectionStrategy)newValue);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
				setRefType((EReference)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
				setName((EReference)null);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
				setValue((ObSelectionStrategy)null);
				return;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
				setRefType((EReference)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
				return name != null;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
				return value != null;
			case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
				return refType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //ReferenceEvaluationImpl
