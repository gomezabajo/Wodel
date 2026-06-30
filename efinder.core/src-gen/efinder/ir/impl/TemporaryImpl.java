/**
 */
package efinder.ir.impl;

import efinder.ir.EFClass;
import efinder.ir.EfinderPackage;
import efinder.ir.Temporary;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.impl.TemporaryImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link efinder.ir.impl.TemporaryImpl#getDangling <em>Dangling</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemporaryImpl extends MinimalEObjectImpl.Container implements Temporary {
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
	 * The cached value of the '{@link #getDangling() <em>Dangling</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDangling()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> dangling;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemporaryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EfinderPackage.Literals.TEMPORARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<EFClass>(EFClass.class, this, EfinderPackage.TEMPORARY__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getDangling() {
		if (dangling == null) {
			dangling = new EObjectContainmentEList<EObject>(EObject.class, this, EfinderPackage.TEMPORARY__DANGLING);
		}
		return dangling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EfinderPackage.TEMPORARY__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case EfinderPackage.TEMPORARY__DANGLING:
				return ((InternalEList<?>)getDangling()).basicRemove(otherEnd, msgs);
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
			case EfinderPackage.TEMPORARY__CLASSES:
				return getClasses();
			case EfinderPackage.TEMPORARY__DANGLING:
				return getDangling();
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
			case EfinderPackage.TEMPORARY__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends EFClass>)newValue);
				return;
			case EfinderPackage.TEMPORARY__DANGLING:
				getDangling().clear();
				getDangling().addAll((Collection<? extends EObject>)newValue);
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
			case EfinderPackage.TEMPORARY__CLASSES:
				getClasses().clear();
				return;
			case EfinderPackage.TEMPORARY__DANGLING:
				getDangling().clear();
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
			case EfinderPackage.TEMPORARY__CLASSES:
				return classes != null && !classes.isEmpty();
			case EfinderPackage.TEMPORARY__DANGLING:
				return dangling != null && !dangling.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemporaryImpl
