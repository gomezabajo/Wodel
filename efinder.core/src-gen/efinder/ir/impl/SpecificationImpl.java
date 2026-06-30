/**
 */
package efinder.ir.impl;

import efinder.ir.Constraint;
import efinder.ir.DerivedProperty;
import efinder.ir.EFMetamodel;
import efinder.ir.EFPrimitiveType;
import efinder.ir.EFTupleType;
import efinder.ir.EfinderPackage;
import efinder.ir.Operation;
import efinder.ir.Specification;

import efinder.ir.Temporary;
import java.util.Collection;

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
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getMetamodels <em>Metamodels</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getTemporary <em>Temporary</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getPrimitiveTypes <em>Primitive Types</em>}</li>
 *   <li>{@link efinder.ir.impl.SpecificationImpl#getTupleTypes <em>Tuple Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SpecificationImpl extends MinimalEObjectImpl.Container implements Specification {
	/**
	 * The cached value of the '{@link #getMetamodels() <em>Metamodels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetamodels()
	 * @generated
	 * @ordered
	 */
	protected EList<EFMetamodel> metamodels;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<Constraint> constraints;

	/**
	 * The cached value of the '{@link #getTemporary() <em>Temporary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporary()
	 * @generated
	 * @ordered
	 */
	protected Temporary temporary;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<DerivedProperty> properties;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * The cached value of the '{@link #getPrimitiveTypes() <em>Primitive Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EFPrimitiveType> primitiveTypes;

	/**
	 * The cached value of the '{@link #getTupleTypes() <em>Tuple Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTupleTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EFTupleType> tupleTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EfinderPackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFMetamodel> getMetamodels() {
		if (metamodels == null) {
			metamodels = new EObjectContainmentEList<EFMetamodel>(EFMetamodel.class, this, EfinderPackage.SPECIFICATION__METAMODELS);
		}
		return metamodels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Constraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, EfinderPackage.SPECIFICATION__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Temporary getTemporary() {
		return temporary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTemporary(Temporary newTemporary, NotificationChain msgs) {
		Temporary oldTemporary = temporary;
		temporary = newTemporary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EfinderPackage.SPECIFICATION__TEMPORARY, oldTemporary, newTemporary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTemporary(Temporary newTemporary) {
		if (newTemporary != temporary) {
			NotificationChain msgs = null;
			if (temporary != null)
				msgs = ((InternalEObject)temporary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EfinderPackage.SPECIFICATION__TEMPORARY, null, msgs);
			if (newTemporary != null)
				msgs = ((InternalEObject)newTemporary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EfinderPackage.SPECIFICATION__TEMPORARY, null, msgs);
			msgs = basicSetTemporary(newTemporary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EfinderPackage.SPECIFICATION__TEMPORARY, newTemporary, newTemporary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DerivedProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<DerivedProperty>(DerivedProperty.class, this, EfinderPackage.SPECIFICATION__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentEList<Operation>(Operation.class, this, EfinderPackage.SPECIFICATION__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFPrimitiveType> getPrimitiveTypes() {
		if (primitiveTypes == null) {
			primitiveTypes = new EObjectContainmentEList<EFPrimitiveType>(EFPrimitiveType.class, this, EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES);
		}
		return primitiveTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EFTupleType> getTupleTypes() {
		if (tupleTypes == null) {
			tupleTypes = new EObjectContainmentEList<EFTupleType>(EFTupleType.class, this, EfinderPackage.SPECIFICATION__TUPLE_TYPES);
		}
		return tupleTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EfinderPackage.SPECIFICATION__METAMODELS:
				return ((InternalEList<?>)getMetamodels()).basicRemove(otherEnd, msgs);
			case EfinderPackage.SPECIFICATION__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case EfinderPackage.SPECIFICATION__TEMPORARY:
				return basicSetTemporary(null, msgs);
			case EfinderPackage.SPECIFICATION__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EfinderPackage.SPECIFICATION__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES:
				return ((InternalEList<?>)getPrimitiveTypes()).basicRemove(otherEnd, msgs);
			case EfinderPackage.SPECIFICATION__TUPLE_TYPES:
				return ((InternalEList<?>)getTupleTypes()).basicRemove(otherEnd, msgs);
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
			case EfinderPackage.SPECIFICATION__METAMODELS:
				return getMetamodels();
			case EfinderPackage.SPECIFICATION__CONSTRAINTS:
				return getConstraints();
			case EfinderPackage.SPECIFICATION__TEMPORARY:
				return getTemporary();
			case EfinderPackage.SPECIFICATION__PROPERTIES:
				return getProperties();
			case EfinderPackage.SPECIFICATION__OPERATIONS:
				return getOperations();
			case EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES:
				return getPrimitiveTypes();
			case EfinderPackage.SPECIFICATION__TUPLE_TYPES:
				return getTupleTypes();
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
			case EfinderPackage.SPECIFICATION__METAMODELS:
				getMetamodels().clear();
				getMetamodels().addAll((Collection<? extends EFMetamodel>)newValue);
				return;
			case EfinderPackage.SPECIFICATION__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends Constraint>)newValue);
				return;
			case EfinderPackage.SPECIFICATION__TEMPORARY:
				setTemporary((Temporary)newValue);
				return;
			case EfinderPackage.SPECIFICATION__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends DerivedProperty>)newValue);
				return;
			case EfinderPackage.SPECIFICATION__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES:
				getPrimitiveTypes().clear();
				getPrimitiveTypes().addAll((Collection<? extends EFPrimitiveType>)newValue);
				return;
			case EfinderPackage.SPECIFICATION__TUPLE_TYPES:
				getTupleTypes().clear();
				getTupleTypes().addAll((Collection<? extends EFTupleType>)newValue);
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
			case EfinderPackage.SPECIFICATION__METAMODELS:
				getMetamodels().clear();
				return;
			case EfinderPackage.SPECIFICATION__CONSTRAINTS:
				getConstraints().clear();
				return;
			case EfinderPackage.SPECIFICATION__TEMPORARY:
				setTemporary((Temporary)null);
				return;
			case EfinderPackage.SPECIFICATION__PROPERTIES:
				getProperties().clear();
				return;
			case EfinderPackage.SPECIFICATION__OPERATIONS:
				getOperations().clear();
				return;
			case EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES:
				getPrimitiveTypes().clear();
				return;
			case EfinderPackage.SPECIFICATION__TUPLE_TYPES:
				getTupleTypes().clear();
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
			case EfinderPackage.SPECIFICATION__METAMODELS:
				return metamodels != null && !metamodels.isEmpty();
			case EfinderPackage.SPECIFICATION__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case EfinderPackage.SPECIFICATION__TEMPORARY:
				return temporary != null;
			case EfinderPackage.SPECIFICATION__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EfinderPackage.SPECIFICATION__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case EfinderPackage.SPECIFICATION__PRIMITIVE_TYPES:
				return primitiveTypes != null && !primitiveTypes.isEmpty();
			case EfinderPackage.SPECIFICATION__TUPLE_TYPES:
				return tupleTypes != null && !tupleTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificationImpl
