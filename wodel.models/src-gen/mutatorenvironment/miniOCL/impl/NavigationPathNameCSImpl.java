/**
 */
package mutatorenvironment.miniOCL.impl;

import java.util.Collection;

import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.NavigationPathCS;
import mutatorenvironment.miniOCL.NavigationPathNameCS;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.NavigationPathNameCSImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NavigationPathNameCSImpl extends MinimalEObjectImpl.Container implements NavigationPathNameCS {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<NavigationPathCS> path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationPathNameCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.NAVIGATION_PATH_NAME_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NavigationPathCS> getPath() {
		if (path == null) {
			path = new EObjectContainmentEList<NavigationPathCS>(NavigationPathCS.class, this,
					MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH:
			return ((InternalEList<?>) getPath()).basicRemove(otherEnd, msgs);
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
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH:
			return getPath();
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
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH:
			getPath().clear();
			getPath().addAll((Collection<? extends NavigationPathCS>) newValue);
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
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH:
			getPath().clear();
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
		case MiniOCLPackage.NAVIGATION_PATH_NAME_CS__PATH:
			return path != null && !path.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NavigationPathNameCSImpl
