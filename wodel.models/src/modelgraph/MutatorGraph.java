/**
 */
package modelgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modelgraph.MutatorGraph#getType <em>Type</em>}</li>
 *   <li>{@link modelgraph.MutatorGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link modelgraph.MutatorGraph#getRelations <em>Relations</em>}</li>
 *   <li>{@link modelgraph.MutatorGraph#getContents <em>Contents</em>}</li>
 *   <li>{@link modelgraph.MutatorGraph#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see modelgraph.ModelgraphPackage#getMutatorGraph()
 * @model
 * @generated
 */
public interface MutatorGraph extends Item {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link modelgraph.GraphType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see modelgraph.GraphType
	 * @see #setType(GraphType)
	 * @see modelgraph.ModelgraphPackage#getMutatorGraph_Type()
	 * @model required="true"
	 * @generated
	 */
	GraphType getType();

	/**
	 * Sets the value of the '{@link modelgraph.MutatorGraph#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see modelgraph.GraphType
	 * @see #getType()
	 * @generated
	 */
	void setType(GraphType value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link modelgraph.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see modelgraph.ModelgraphPackage#getMutatorGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link modelgraph.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see modelgraph.ModelgraphPackage#getMutatorGraph_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link modelgraph.Content}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see modelgraph.ModelgraphPackage#getMutatorGraph_Contents()
	 * @model containment="true"
	 * @generated
	 */
	EList<Content> getContents();

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' attribute.
	 * @see #setMetamodel(String)
	 * @see modelgraph.ModelgraphPackage#getMutatorGraph_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link modelgraph.MutatorGraph#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

} // MutatorGraph
