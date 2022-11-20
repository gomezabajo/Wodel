/**
 */
package modeltext.impl;

import java.util.Collection;

import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.ModeltextPackage;

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
 * An implementation of the model object '<em><b>Identify Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeltext.impl.IdentifyElementsImpl#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link modeltext.impl.IdentifyElementsImpl#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IdentifyElementsImpl extends MinimalEObjectImpl.Container implements IdentifyElements {
	/**
	 * The default value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected static final String METAMODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodel()
	 * @generated
	 * @ordered
	 */
	protected String metamodel = METAMODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> elements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifyElementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeltextPackage.Literals.IDENTIFY_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetamodel(String newMetamodel) {
		String oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltextPackage.IDENTIFY_ELEMENTS__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<Element>(Element.class, this, ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case ModeltextPackage.IDENTIFY_ELEMENTS__METAMODEL:
				return getMetamodel();
			case ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS:
				return getElements();
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
			case ModeltextPackage.IDENTIFY_ELEMENTS__METAMODEL:
				setMetamodel((String)newValue);
				return;
			case ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Element>)newValue);
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
			case ModeltextPackage.IDENTIFY_ELEMENTS__METAMODEL:
				setMetamodel(METAMODEL_EDEFAULT);
				return;
			case ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS:
				getElements().clear();
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
			case ModeltextPackage.IDENTIFY_ELEMENTS__METAMODEL:
				return METAMODEL_EDEFAULT == null ? metamodel != null : !METAMODEL_EDEFAULT.equals(metamodel);
			case ModeltextPackage.IDENTIFY_ELEMENTS__ELEMENTS:
				return elements != null && !elements.isEmpty();
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
		result.append(" (metamodel: ");
		result.append(metamodel);
		result.append(')');
		return result.toString();
	}

} //IdentifyElementsImpl
