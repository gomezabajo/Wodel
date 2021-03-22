/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.Expression;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.ObSelectionStrategy;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ob Selection Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ObSelectionStrategyImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObSelectionStrategyImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObSelectionStrategyImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObSelectionStrategyImpl#getRefRefType <em>Ref Ref Type</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ObSelectionStrategyImpl#getRefRefRefType <em>Ref Ref Ref Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ObSelectionStrategyImpl extends ObjectEmitterImpl implements ObSelectionStrategy {
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
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression expression;

	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected String resource = RESOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefRefType() <em>Ref Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRefType()
	 * @generated
	 * @ordered
	 */
	protected EReference refRefType;

	/**
	 * The cached value of the '{@link #getRefRefRefType() <em>Ref Ref Ref Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefRefRefType()
	 * @generated
	 * @ordered
	 */
	protected EReference refRefRefType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObSelectionStrategyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.OB_SELECTION_STRATEGY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRefType() {
		if (refType != null && refType.eIsProxy()) {
			InternalEObject oldRefType = (InternalEObject)refType;
			refType = (EReference)eResolveProxy(oldRefType);
			if (refType != oldRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE, oldRefType, refType));
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
	@Override
	public void setRefType(EReference newRefType) {
		EReference oldRefType = refType;
		refType = newRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE, oldRefType, refType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs) {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpression(Expression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResource(String newResource) {
		String oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRefRefType() {
		if (refRefType != null && refRefType.eIsProxy()) {
			InternalEObject oldRefRefType = (InternalEObject)refRefType;
			refRefType = (EReference)eResolveProxy(oldRefRefType);
			if (refRefType != oldRefRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE, oldRefRefType, refRefType));
			}
		}
		return refRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefRefType() {
		return refRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefRefType(EReference newRefRefType) {
		EReference oldRefRefType = refRefType;
		refRefType = newRefRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE, oldRefRefType, refRefType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRefRefRefType() {
		if (refRefRefType != null && refRefRefType.eIsProxy()) {
			InternalEObject oldRefRefRefType = (InternalEObject)refRefRefType;
			refRefRefType = (EReference)eResolveProxy(oldRefRefRefType);
			if (refRefRefType != oldRefRefRefType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE, oldRefRefRefType, refRefRefType));
			}
		}
		return refRefRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRefRefRefType() {
		return refRefRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefRefRefType(EReference newRefRefRefType) {
		EReference oldRefRefRefType = refRefRefType;
		refRefRefType = newRefRefRefType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE, oldRefRefRefType, refRefRefType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE:
				if (resolve) return getRefType();
				return basicGetRefType();
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION:
				return getExpression();
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__RESOURCE:
				return getResource();
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE:
				if (resolve) return getRefRefType();
				return basicGetRefRefType();
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE:
				if (resolve) return getRefRefRefType();
				return basicGetRefRefRefType();
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
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE:
				setRefType((EReference)newValue);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION:
				setExpression((Expression)newValue);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__RESOURCE:
				setResource((String)newValue);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE:
				setRefRefType((EReference)newValue);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE:
				setRefRefRefType((EReference)newValue);
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
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE:
				setRefType((EReference)null);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION:
				setExpression((Expression)null);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE:
				setRefRefType((EReference)null);
				return;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE:
				setRefRefRefType((EReference)null);
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
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_TYPE:
				return refType != null;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__EXPRESSION:
				return expression != null;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__RESOURCE:
				return RESOURCE_EDEFAULT == null ? resource != null : !RESOURCE_EDEFAULT.equals(resource);
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_TYPE:
				return refRefType != null;
			case MutatorenvironmentPackage.OB_SELECTION_STRATEGY__REF_REF_REF_TYPE:
				return refRefRefType != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (resource: ");
		result.append(resource);
		result.append(')');
		return result.toString();
	}

} //ObSelectionStrategyImpl
