/**
 */
package efinder.ir.impl;

import efinder.ir.EFEnum;
import efinder.ir.EFEnumLiteral;
import efinder.ir.EfinderPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EF Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.impl.EFEnumImpl#getEnum_ <em>Enum </em>}</li>
 *   <li>{@link efinder.ir.impl.EFEnumImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EFEnumImpl extends EFTypeImpl implements EFEnum {
	/**
	 * The cached value of the '{@link #getEnum_() <em>Enum </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnum_()
	 * @generated
	 * @ordered
	 */
	protected EEnum enum_;

	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EFEnumLiteral> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFEnumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EfinderPackage.Literals.EF_ENUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEnum_() {
		if (enum_ != null && enum_.eIsProxy()) {
			InternalEObject oldEnum_ = (InternalEObject)enum_;
			enum_ = (EEnum)eResolveProxy(oldEnum_);
			if (enum_ != oldEnum_) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EfinderPackage.EF_ENUM__ENUM_, oldEnum_, enum_));
			}
		}
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetEnum_() {
		return enum_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnum_(EEnum newEnum_) {
		EEnum oldEnum_ = enum_;
		enum_ = newEnum_;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EfinderPackage.EF_ENUM__ENUM_, oldEnum_, enum_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFEnumLiteral> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentEList<EFEnumLiteral>(EFEnumLiteral.class, this, EfinderPackage.EF_ENUM__LITERALS);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EfinderPackage.EF_ENUM__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
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
			case EfinderPackage.EF_ENUM__ENUM_:
				if (resolve) return getEnum_();
				return basicGetEnum_();
			case EfinderPackage.EF_ENUM__LITERALS:
				return getLiterals();
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
			case EfinderPackage.EF_ENUM__ENUM_:
				setEnum_((EEnum)newValue);
				return;
			case EfinderPackage.EF_ENUM__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends EFEnumLiteral>)newValue);
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
			case EfinderPackage.EF_ENUM__ENUM_:
				setEnum_((EEnum)null);
				return;
			case EfinderPackage.EF_ENUM__LITERALS:
				getLiterals().clear();
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
			case EfinderPackage.EF_ENUM__ENUM_:
				return enum_ != null;
			case EfinderPackage.EF_ENUM__LITERALS:
				return literals != null && !literals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EFEnumImpl
