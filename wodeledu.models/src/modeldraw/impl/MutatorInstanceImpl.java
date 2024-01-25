/**
 */
package modeldraw.impl;

import java.util.Collection;

import modeldraw.Content;
import modeldraw.DrawType;
import modeldraw.ModeldrawPackage;
import modeldraw.MutatorInstance;
import modeldraw.Node;
import modeldraw.Relation;

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
 * An implementation of the model object '<em><b>Mutator Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.MutatorInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link modeldraw.impl.MutatorInstanceImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modeldraw.impl.MutatorInstanceImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link modeldraw.impl.MutatorInstanceImpl#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MutatorInstanceImpl extends ItemImpl implements MutatorInstance {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DrawType TYPE_EDEFAULT = DrawType.DIAGRAM;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DrawType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> relations;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<Content> contents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.MUTATOR_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DrawType newType) {
		DrawType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.MUTATOR_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, ModeldrawPackage.MUTATOR_INSTANCE__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList<Relation>(Relation.class, this, ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Content> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<Content>(Content.class, this, ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeldrawPackage.MUTATOR_INSTANCE__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
			case ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
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
			case ModeldrawPackage.MUTATOR_INSTANCE__TYPE:
				return getType();
			case ModeldrawPackage.MUTATOR_INSTANCE__NODES:
				return getNodes();
			case ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS:
				return getRelations();
			case ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS:
				return getContents();
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
			case ModeldrawPackage.MUTATOR_INSTANCE__TYPE:
				setType((DrawType)newValue);
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends Content>)newValue);
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
			case ModeldrawPackage.MUTATOR_INSTANCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__NODES:
				getNodes().clear();
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS:
				getRelations().clear();
				return;
			case ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS:
				getContents().clear();
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
			case ModeldrawPackage.MUTATOR_INSTANCE__TYPE:
				return type != TYPE_EDEFAULT;
			case ModeldrawPackage.MUTATOR_INSTANCE__NODES:
				return nodes != null && !nodes.isEmpty();
			case ModeldrawPackage.MUTATOR_INSTANCE__RELATIONS:
				return relations != null && !relations.isEmpty();
			case ModeldrawPackage.MUTATOR_INSTANCE__CONTENTS:
				return contents != null && !contents.isEmpty();
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //MutatorInstanceImpl
