/**
 */
package mutatorenvironment.miniOCL.impl;

import mutatorenvironment.miniOCL.MiniOCLPackage;
import mutatorenvironment.miniOCL.PathElementCS;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.impl.PathElementCSImpl#getPathName <em>Path Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathElementCSImpl extends PathCSImpl implements PathElementCS {
	/**
	 * The cached value of the '{@link #getPathName() <em>Path Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathName()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature pathName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathElementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MiniOCLPackage.Literals.PATH_ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getPathName() {
		if (pathName != null && pathName.eIsProxy()) {
			InternalEObject oldPathName = (InternalEObject)pathName;
			pathName = (EStructuralFeature)eResolveProxy(oldPathName);
			if (pathName != oldPathName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME, oldPathName, pathName));
			}
		}
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetPathName() {
		return pathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathName(EStructuralFeature newPathName) {
		EStructuralFeature oldPathName = pathName;
		pathName = newPathName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME, oldPathName, pathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME:
				if (resolve) return getPathName();
				return basicGetPathName();
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
			case MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME:
				setPathName((EStructuralFeature)newValue);
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
			case MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME:
				setPathName((EStructuralFeature)null);
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
			case MiniOCLPackage.PATH_ELEMENT_CS__PATH_NAME:
				return pathName != null;
		}
		return super.eIsSet(featureID);
	}

} //PathElementCSImpl
