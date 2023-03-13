/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.Operator;
import mutatorenvironment.ReferenceEvaluation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EAttribute;
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
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getRefName <em>Ref Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getRefRefName <em>Ref Ref Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getAttName <em>Att Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#getAttValue <em>Att Value</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ReferenceEvaluationImpl#isContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceEvaluationImpl extends EvaluationImpl implements ReferenceEvaluation {
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
	 * The cached value of the '{@link #getRefName() <em>Ref Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefName()
	 * @generated
	 * @ordered
	 */
	protected EReference refName;

	/**
	 * The cached value of the '{@link #getRefRefName() <em>Ref Ref Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRefName()
	 * @generated
	 * @ordered
	 */
	protected EReference refRefName;

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
	 * The cached value of the '{@link #getAttName() <em>Att Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttName()
	 * @generated
	 * @ordered
	 */
	protected EAttribute attName;

	/**
	 * The cached value of the '{@link #getAttValue() <em>Att Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttValue()
	 * @generated
	 * @ordered
	 */
	protected AttributeEvaluationType attValue;

	/**
	 * The default value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainer() <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainer()
	 * @generated
	 * @ordered
	 */
	protected boolean container = CONTAINER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceEvaluationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.REFERENCE_EVALUATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getName() {
		if (name != null && name.eIsProxy()) {
			InternalEObject oldName = (InternalEObject) name;
			name = (EReference) eResolveProxy(oldName);
			if (name != oldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(EReference newName) {
		EReference oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefName() {
		if (refName != null && refName.eIsProxy()) {
			InternalEObject oldRefName = (InternalEObject) refName;
			refName = (EReference) eResolveProxy(oldRefName);
			if (refName != oldRefName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME, oldRefName, refName));
			}
		}
		return refName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefName() {
		return refName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefName(EReference newRefName) {
		EReference oldRefName = refName;
		refName = newRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME, oldRefName, refName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefRefName() {
		if (refRefName != null && refRefName.eIsProxy()) {
			InternalEObject oldRefRefName = (InternalEObject) refRefName;
			refRefName = (EReference) eResolveProxy(oldRefRefName);
			if (refRefName != oldRefRefName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME, oldRefRefName, refRefName));
			}
		}
		return refRefName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefRefName() {
		return refRefName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefRefName(EReference newRefRefName) {
		EReference oldRefRefName = refRefName;
		refRefName = newRefRefName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME, oldRefRefName, refRefName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(Operator newOperator) {
		Operator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObSelectionStrategy getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(ObSelectionStrategy newValue, NotificationChain msgs) {
		ObSelectionStrategy oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, oldValue, newValue);
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
	public void setValue(ObSelectionStrategy newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE,
					newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefType() {
		if (refType != null && refType.eIsProxy()) {
			InternalEObject oldRefType = (InternalEObject) refType;
			refType = (EReference) eResolveProxy(oldRefType);
			if (refType != oldRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE, oldRefType, refType));
			}
		}
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefType() {
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefType(EReference newRefType) {
		EReference oldRefType = refType;
		refType = newRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttName() {
		if (attName != null && attName.eIsProxy()) {
			InternalEObject oldAttName = (InternalEObject) attName;
			attName = (EAttribute) eResolveProxy(oldAttName);
			if (attName != oldAttName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME, oldAttName, attName));
			}
		}
		return attName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetAttName() {
		return attName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttName(EAttribute newAttName) {
		EAttribute oldAttName = attName;
		attName = newAttName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME, oldAttName, attName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeEvaluationType getAttValue() {
		return attValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttValue(AttributeEvaluationType newAttValue, NotificationChain msgs) {
		AttributeEvaluationType oldAttValue = attValue;
		attValue = newAttValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE, oldAttValue, newAttValue);
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
	public void setAttValue(AttributeEvaluationType newAttValue) {
		if (newAttValue != attValue) {
			NotificationChain msgs = null;
			if (attValue != null)
				msgs = ((InternalEObject) attValue).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE, null, msgs);
			if (newAttValue != null)
				msgs = ((InternalEObject) newAttValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE, null, msgs);
			msgs = basicSetAttValue(newAttValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE, newAttValue, newAttValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainer() {
		return container;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer(boolean newContainer) {
		boolean oldContainer = container;
		container = newContainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.REFERENCE_EVALUATION__CONTAINER, oldContainer, container));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
			return basicSetValue(null, msgs);
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE:
			return basicSetAttValue(null, msgs);
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
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
			if (resolve)
				return getName();
			return basicGetName();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME:
			if (resolve)
				return getRefName();
			return basicGetRefName();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME:
			if (resolve)
				return getRefRefName();
			return basicGetRefRefName();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
			return getOperator();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
			return getValue();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
			if (resolve)
				return getRefType();
			return basicGetRefType();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME:
			if (resolve)
				return getAttName();
			return basicGetAttName();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE:
			return getAttValue();
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__CONTAINER:
			return isContainer();
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
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
			setName((EReference) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME:
			setRefName((EReference) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME:
			setRefRefName((EReference) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
			setOperator((Operator) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
			setValue((ObSelectionStrategy) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
			setRefType((EReference) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME:
			setAttName((EAttribute) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE:
			setAttValue((AttributeEvaluationType) newValue);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__CONTAINER:
			setContainer((Boolean) newValue);
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
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
			setName((EReference) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME:
			setRefName((EReference) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME:
			setRefRefName((EReference) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
			setOperator(OPERATOR_EDEFAULT);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
			setValue((ObSelectionStrategy) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
			setRefType((EReference) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME:
			setAttName((EAttribute) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE:
			setAttValue((AttributeEvaluationType) null);
			return;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__CONTAINER:
			setContainer(CONTAINER_EDEFAULT);
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
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__NAME:
			return name != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_NAME:
			return refName != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_REF_NAME:
			return refRefName != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__OPERATOR:
			return operator != OPERATOR_EDEFAULT;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__VALUE:
			return value != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__REF_TYPE:
			return refType != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_NAME:
			return attName != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__ATT_VALUE:
			return attValue != null;
		case MutatorenvironmentPackage.REFERENCE_EVALUATION__CONTAINER:
			return container != CONTAINER_EDEFAULT;
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(", container: ");
		result.append(container);
		result.append(')');
		return result.toString();
	}

} //ReferenceEvaluationImpl
