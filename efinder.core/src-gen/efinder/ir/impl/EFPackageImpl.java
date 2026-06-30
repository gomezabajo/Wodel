/**
 */
package efinder.ir.impl;

import efinder.ir.EFClass;
import efinder.ir.EFEnum;
import efinder.ir.EFPackage;
import efinder.ir.EfinderPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EF Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.impl.EFPackageImpl#getPkg <em>Pkg</em>}</li>
 *   <li>{@link efinder.ir.impl.EFPackageImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link efinder.ir.impl.EFPackageImpl#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EFPackageImpl extends MinimalEObjectImpl.Container implements EFPackage {
	/**
	 * The cached value of the '{@link #getPkg() <em>Pkg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkg()
	 * @generated
	 * @ordered
	 */
	protected EPackage pkg;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<EFClass> classes;

	/**
	 * The cached value of the '{@link #getEnumerations() <em>Enumerations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerations()
	 * @generated
	 * @ordered
	 */
	protected EList<EFEnum> enumerations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EfinderPackage.Literals.EF_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPackage getPkg() {
		if (pkg != null && pkg.eIsProxy()) {
			InternalEObject oldPkg = (InternalEObject)pkg;
			pkg = (EPackage)eResolveProxy(oldPkg);
			if (pkg != oldPkg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EfinderPackage.EF_PACKAGE__PKG, oldPkg, pkg));
			}
		}
		return pkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetPkg() {
		return pkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPkg(EPackage newPkg) {
		EPackage oldPkg = pkg;
		pkg = newPkg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EfinderPackage.EF_PACKAGE__PKG, oldPkg, pkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<EFClass>(EFClass.class, this, EfinderPackage.EF_PACKAGE__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFEnum> getEnumerations() {
		if (enumerations == null) {
			enumerations = new EObjectContainmentEList<EFEnum>(EFEnum.class, this, EfinderPackage.EF_PACKAGE__ENUMERATIONS);
		}
		return enumerations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EfinderPackage.EF_PACKAGE__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case EfinderPackage.EF_PACKAGE__ENUMERATIONS:
				return ((InternalEList<?>)getEnumerations()).basicRemove(otherEnd, msgs);
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
			case EfinderPackage.EF_PACKAGE__PKG:
				if (resolve) return getPkg();
				return basicGetPkg();
			case EfinderPackage.EF_PACKAGE__CLASSES:
				return getClasses();
			case EfinderPackage.EF_PACKAGE__ENUMERATIONS:
				return getEnumerations();
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
			case EfinderPackage.EF_PACKAGE__PKG:
				setPkg((EPackage)newValue);
				return;
			case EfinderPackage.EF_PACKAGE__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends EFClass>)newValue);
				return;
			case EfinderPackage.EF_PACKAGE__ENUMERATIONS:
				getEnumerations().clear();
				getEnumerations().addAll((Collection<? extends EFEnum>)newValue);
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
			case EfinderPackage.EF_PACKAGE__PKG:
				setPkg((EPackage)null);
				return;
			case EfinderPackage.EF_PACKAGE__CLASSES:
				getClasses().clear();
				return;
			case EfinderPackage.EF_PACKAGE__ENUMERATIONS:
				getEnumerations().clear();
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
			case EfinderPackage.EF_PACKAGE__PKG:
				return pkg != null;
			case EfinderPackage.EF_PACKAGE__CLASSES:
				return classes != null && !classes.isEmpty();
			case EfinderPackage.EF_PACKAGE__ENUMERATIONS:
				return enumerations != null && !enumerations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EFPackageImpl
