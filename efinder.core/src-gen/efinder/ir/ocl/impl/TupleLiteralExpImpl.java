/**
 */
package efinder.ir.ocl.impl;

import efinder.ir.EFTupleType;

import efinder.ir.ocl.OclPackage;
import efinder.ir.ocl.TupleLiteralExp;
import efinder.ir.ocl.TuplePart;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.ocl.impl.TupleLiteralExpImpl#getTupleType <em>Tuple Type</em>}</li>
 *   <li>{@link efinder.ir.ocl.impl.TupleLiteralExpImpl#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TupleLiteralExpImpl extends LiteralExpImpl implements TupleLiteralExp {
	/**
	 * The cached value of the '{@link #getTupleType() <em>Tuple Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTupleType()
	 * @generated
	 * @ordered
	 */
	protected EFTupleType tupleType;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<TuplePart> parts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OclPackage.Literals.TUPLE_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EFTupleType getTupleType() {
		if (tupleType != null && tupleType.eIsProxy()) {
			InternalEObject oldTupleType = (InternalEObject)tupleType;
			tupleType = (EFTupleType)eResolveProxy(oldTupleType);
			if (tupleType != oldTupleType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE, oldTupleType, tupleType));
			}
		}
		return tupleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EFTupleType basicGetTupleType() {
		return tupleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTupleType(EFTupleType newTupleType) {
		EFTupleType oldTupleType = tupleType;
		tupleType = newTupleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE, oldTupleType, tupleType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TuplePart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentEList<TuplePart>(TuplePart.class, this, OclPackage.TUPLE_LITERAL_EXP__PARTS);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OclPackage.TUPLE_LITERAL_EXP__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
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
			case OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE:
				if (resolve) return getTupleType();
				return basicGetTupleType();
			case OclPackage.TUPLE_LITERAL_EXP__PARTS:
				return getParts();
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
			case OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE:
				setTupleType((EFTupleType)newValue);
				return;
			case OclPackage.TUPLE_LITERAL_EXP__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends TuplePart>)newValue);
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
			case OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE:
				setTupleType((EFTupleType)null);
				return;
			case OclPackage.TUPLE_LITERAL_EXP__PARTS:
				getParts().clear();
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
			case OclPackage.TUPLE_LITERAL_EXP__TUPLE_TYPE:
				return tupleType != null;
			case OclPackage.TUPLE_LITERAL_EXP__PARTS:
				return parts != null && !parts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TupleLiteralExpImpl
