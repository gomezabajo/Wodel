/**
 */
package mutatorenvironment.miniOCL.impl;

import java.util.Collection;

import mutatorenvironment.miniOCL.ConstraintCS;
import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.PackageCS;
import mutatorenvironment.miniOCL.RootCS;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.RootCSImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link mutatorenvironment.miniOCL.impl.RootCSImpl#getContraints <em>Contraints</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootCSImpl extends MinimalEObjectImpl.Container implements RootCS {
	/**
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageCS> packages;

	/**
	 * The cached value of the '{@link #getContraints() <em>Contraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> contraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.ROOT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageCS> getPackages() {
		if (packages == null) {
			packages = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, MiniOCLPackage.ROOT_CS__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getContraints() {
		if (contraints == null) {
			contraints = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this,
					MiniOCLPackage.ROOT_CS__CONTRAINTS);
		}
		return contraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.ROOT_CS__PACKAGES:
			return ((InternalEList<?>) getPackages()).basicRemove(otherEnd, msgs);
		case MiniOCLPackage.ROOT_CS__CONTRAINTS:
			return ((InternalEList<?>) getContraints()).basicRemove(otherEnd, msgs);
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
		case MiniOCLPackage.ROOT_CS__PACKAGES:
			return getPackages();
		case MiniOCLPackage.ROOT_CS__CONTRAINTS:
			return getContraints();
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
		case MiniOCLPackage.ROOT_CS__PACKAGES:
			getPackages().clear();
			getPackages().addAll((Collection<? extends PackageCS>) newValue);
			return;
		case MiniOCLPackage.ROOT_CS__CONTRAINTS:
			getContraints().clear();
			getContraints().addAll((Collection<? extends ConstraintCS>) newValue);
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
		case MiniOCLPackage.ROOT_CS__PACKAGES:
			getPackages().clear();
			return;
		case MiniOCLPackage.ROOT_CS__CONTRAINTS:
			getContraints().clear();
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
		case MiniOCLPackage.ROOT_CS__PACKAGES:
			return packages != null && !packages.isEmpty();
		case MiniOCLPackage.ROOT_CS__CONTRAINTS:
			return contraints != null && !contraints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootCSImpl
