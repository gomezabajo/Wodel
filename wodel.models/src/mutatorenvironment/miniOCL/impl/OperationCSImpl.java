/**
 */
package mutatorenvironment.miniOCL.impl;

import java.util.Collection;

import mutatorenvironment.miniOCL.ExpCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.OperationCS;
import mutatorenvironment.miniOCL.ParameterCS;
import mutatorenvironment.miniOCL.PathNameCS;

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
 * An implementation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.OperationCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.OperationCSImpl#getParams <em>Params</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.OperationCSImpl#getResultRef <em>Result Ref</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.OperationCSImpl#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationCSImpl extends MinimalEObjectImpl.Container implements OperationCS {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParams()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> params;

	/**
	 * The cached value of the '{@link #getResultRef() <em>Result Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultRef()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS resultRef;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected ExpCS body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.OPERATION_CS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getParams() {
		if (params == null) {
			params = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, MiniOCLPackage.OPERATION_CS__PARAMS);
		}
		return params;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameCS getResultRef() {
		return resultRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultRef(PathNameCS newResultRef, NotificationChain msgs) {
		PathNameCS oldResultRef = resultRef;
		resultRef = newResultRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.OPERATION_CS__RESULT_REF, oldResultRef, newResultRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultRef(PathNameCS newResultRef) {
		if (newResultRef != resultRef) {
			NotificationChain msgs = null;
			if (resultRef != null)
				msgs = ((InternalEObject)resultRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.OPERATION_CS__RESULT_REF, null, msgs);
			if (newResultRef != null)
				msgs = ((InternalEObject)newResultRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.OPERATION_CS__RESULT_REF, null, msgs);
			msgs = basicSetResultRef(newResultRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.OPERATION_CS__RESULT_REF, newResultRef, newResultRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(ExpCS newBody, NotificationChain msgs) {
		ExpCS oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniOCLPackage.OPERATION_CS__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(ExpCS newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.OPERATION_CS__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniOCLPackage.OPERATION_CS__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.OPERATION_CS__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MiniOCLPackage.OPERATION_CS__PARAMS:
				return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
			case MiniOCLPackage.OPERATION_CS__RESULT_REF:
				return basicSetResultRef(null, msgs);
			case MiniOCLPackage.OPERATION_CS__BODY:
				return basicSetBody(null, msgs);
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
			case MiniOCLPackage.OPERATION_CS__NAME:
				return getName();
			case MiniOCLPackage.OPERATION_CS__PARAMS:
				return getParams();
			case MiniOCLPackage.OPERATION_CS__RESULT_REF:
				return getResultRef();
			case MiniOCLPackage.OPERATION_CS__BODY:
				return getBody();
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
			case MiniOCLPackage.OPERATION_CS__NAME:
				setName((String)newValue);
				return;
			case MiniOCLPackage.OPERATION_CS__PARAMS:
				getParams().clear();
				getParams().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case MiniOCLPackage.OPERATION_CS__RESULT_REF:
				setResultRef((PathNameCS)newValue);
				return;
			case MiniOCLPackage.OPERATION_CS__BODY:
				setBody((ExpCS)newValue);
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
			case MiniOCLPackage.OPERATION_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MiniOCLPackage.OPERATION_CS__PARAMS:
				getParams().clear();
				return;
			case MiniOCLPackage.OPERATION_CS__RESULT_REF:
				setResultRef((PathNameCS)null);
				return;
			case MiniOCLPackage.OPERATION_CS__BODY:
				setBody((ExpCS)null);
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
			case MiniOCLPackage.OPERATION_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MiniOCLPackage.OPERATION_CS__PARAMS:
				return params != null && !params.isEmpty();
			case MiniOCLPackage.OPERATION_CS__RESULT_REF:
				return resultRef != null;
			case MiniOCLPackage.OPERATION_CS__BODY:
				return body != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //OperationCSImpl
