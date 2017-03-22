/**
 */
package modelgraph.impl;

import java.util.Collection;

import modelgraph.Content;
import modelgraph.GraphType;
import modelgraph.ModelgraphPackage;
import modelgraph.MutatorGraph;
import modelgraph.Node;
import modelgraph.Relation;

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
 * An implementation of the model object '<em><b>Mutator Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelgraph.impl.MutatorGraphImpl#getType <em>Type</em>}</li>
 *   <li>{@link modelgraph.impl.MutatorGraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modelgraph.impl.MutatorGraphImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link modelgraph.impl.MutatorGraphImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link modelgraph.impl.MutatorGraphImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MutatorGraphImpl extends ItemImpl implements MutatorGraph {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final GraphType TYPE_EDEFAULT = GraphType.DIAGRAM;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected GraphType type = TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelgraphPackage.Literals.MUTATOR_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(GraphType newType) {
		GraphType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.MUTATOR_GRAPH__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, ModelgraphPackage.MUTATOR_GRAPH__NODES);
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
			relations = new EObjectContainmentEList<Relation>(Relation.class, this, ModelgraphPackage.MUTATOR_GRAPH__RELATIONS);
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
			contents = new EObjectContainmentEList<Content>(Content.class, this, ModelgraphPackage.MUTATOR_GRAPH__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetamodel() {
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetamodel(String newMetamodel) {
		String oldMetamodel = metamodel;
		metamodel = newMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.MUTATOR_GRAPH__METAMODEL, oldMetamodel, metamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelgraphPackage.MUTATOR_GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case ModelgraphPackage.MUTATOR_GRAPH__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
			case ModelgraphPackage.MUTATOR_GRAPH__CONTENTS:
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
			case ModelgraphPackage.MUTATOR_GRAPH__TYPE:
				return getType();
			case ModelgraphPackage.MUTATOR_GRAPH__NODES:
				return getNodes();
			case ModelgraphPackage.MUTATOR_GRAPH__RELATIONS:
				return getRelations();
			case ModelgraphPackage.MUTATOR_GRAPH__CONTENTS:
				return getContents();
			case ModelgraphPackage.MUTATOR_GRAPH__METAMODEL:
				return getMetamodel();
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
			case ModelgraphPackage.MUTATOR_GRAPH__TYPE:
				setType((GraphType)newValue);
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends Relation>)newValue);
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends Content>)newValue);
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__METAMODEL:
				setMetamodel((String)newValue);
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
			case ModelgraphPackage.MUTATOR_GRAPH__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__NODES:
				getNodes().clear();
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__RELATIONS:
				getRelations().clear();
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__CONTENTS:
				getContents().clear();
				return;
			case ModelgraphPackage.MUTATOR_GRAPH__METAMODEL:
				setMetamodel(METAMODEL_EDEFAULT);
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
			case ModelgraphPackage.MUTATOR_GRAPH__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelgraphPackage.MUTATOR_GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case ModelgraphPackage.MUTATOR_GRAPH__RELATIONS:
				return relations != null && !relations.isEmpty();
			case ModelgraphPackage.MUTATOR_GRAPH__CONTENTS:
				return contents != null && !contents.isEmpty();
			case ModelgraphPackage.MUTATOR_GRAPH__METAMODEL:
				return METAMODEL_EDEFAULT == null ? metamodel != null : !METAMODEL_EDEFAULT.equals(metamodel);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(", metamodel: ");
		result.append(metamodel);
		result.append(')');
		return result.toString();
	}

} //MutatorGraphImpl
