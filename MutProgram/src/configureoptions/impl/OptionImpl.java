/**
 */
package configureoptions.impl;

import configureoptions.ConfigureoptionsPackage;
import configureoptions.Option;
import configureoptions.Text;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link configureoptions.impl.OptionImpl#getType <em>Type</em>}</li>
 *   <li>{@link configureoptions.impl.OptionImpl#getObject <em>Object</em>}</li>
 *   <li>{@link configureoptions.impl.OptionImpl#getValid <em>Valid</em>}</li>
 *   <li>{@link configureoptions.impl.OptionImpl#getInvalid <em>Invalid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionImpl extends MinimalEObjectImpl.Container implements Option {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * The cached value of the '{@link #getValid() <em>Valid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValid()
	 * @generated
	 * @ordered
	 */
	protected Text valid;

	/**
	 * The cached value of the '{@link #getInvalid() <em>Invalid</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalid()
	 * @generated
	 * @ordered
	 */
	protected Text invalid;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigureoptionsPackage.Literals.OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigureoptionsPackage.OPTION__VALID:
				return basicSetValid(null, msgs);
			case ConfigureoptionsPackage.OPTION__INVALID:
				return basicSetInvalid(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigureoptionsPackage.OPTION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getObject() {
		if (object != null && object.eIsProxy()) {
			InternalEObject oldObject = (InternalEObject)object;
			object = eResolveProxy(oldObject);
			if (object != oldObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigureoptionsPackage.OPTION__OBJECT, oldObject, object));
			}
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObject(EObject newObject) {
		EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getValid() {
		return valid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValid(Text newValid, NotificationChain msgs) {
		Text oldValid = valid;
		valid = newValid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__VALID, oldValid, newValid);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid(Text newValid) {
		if (newValid != valid) {
			NotificationChain msgs = null;
			if (valid != null)
				msgs = ((InternalEObject)valid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigureoptionsPackage.OPTION__VALID, null, msgs);
			if (newValid != null)
				msgs = ((InternalEObject)newValid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigureoptionsPackage.OPTION__VALID, null, msgs);
			msgs = basicSetValid(newValid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__VALID, newValid, newValid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getInvalid() {
		return invalid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvalid(Text newInvalid, NotificationChain msgs) {
		Text oldInvalid = invalid;
		invalid = newInvalid;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__INVALID, oldInvalid, newInvalid);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvalid(Text newInvalid) {
		if (newInvalid != invalid) {
			NotificationChain msgs = null;
			if (invalid != null)
				msgs = ((InternalEObject)invalid).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigureoptionsPackage.OPTION__INVALID, null, msgs);
			if (newInvalid != null)
				msgs = ((InternalEObject)newInvalid).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigureoptionsPackage.OPTION__INVALID, null, msgs);
			msgs = basicSetInvalid(newInvalid, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigureoptionsPackage.OPTION__INVALID, newInvalid, newInvalid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigureoptionsPackage.OPTION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ConfigureoptionsPackage.OPTION__OBJECT:
				if (resolve) return getObject();
				return basicGetObject();
			case ConfigureoptionsPackage.OPTION__VALID:
				return getValid();
			case ConfigureoptionsPackage.OPTION__INVALID:
				return getInvalid();
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
			case ConfigureoptionsPackage.OPTION__TYPE:
				setType((EClass)newValue);
				return;
			case ConfigureoptionsPackage.OPTION__OBJECT:
				setObject((EObject)newValue);
				return;
			case ConfigureoptionsPackage.OPTION__VALID:
				setValid((Text)newValue);
				return;
			case ConfigureoptionsPackage.OPTION__INVALID:
				setInvalid((Text)newValue);
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
			case ConfigureoptionsPackage.OPTION__TYPE:
				setType((EClass)null);
				return;
			case ConfigureoptionsPackage.OPTION__OBJECT:
				setObject((EObject)null);
				return;
			case ConfigureoptionsPackage.OPTION__VALID:
				setValid((Text)null);
				return;
			case ConfigureoptionsPackage.OPTION__INVALID:
				setInvalid((Text)null);
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
			case ConfigureoptionsPackage.OPTION__TYPE:
				return type != null;
			case ConfigureoptionsPackage.OPTION__OBJECT:
				return object != null;
			case ConfigureoptionsPackage.OPTION__VALID:
				return valid != null;
			case ConfigureoptionsPackage.OPTION__INVALID:
				return invalid != null;
		}
		return super.eIsSet(featureID);
	}

} //OptionImpl
