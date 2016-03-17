/**
 */
package mutatorgraph;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorgraph.MutatorGraph#getType <em>Type</em>}</li>
 *   <li>{@link mutatorgraph.MutatorGraph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link mutatorgraph.MutatorGraph#getEdges <em>Edges</em>}</li>
 *   <li>{@link mutatorgraph.MutatorGraph#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorgraph.MutatorgraphPackage#getMutatorGraph()
 * @model
 * @generated
 */
public interface MutatorGraph extends Item {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorgraph.GraphType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see mutatorgraph.GraphType
	 * @see #setType(GraphType)
	 * @see mutatorgraph.MutatorgraphPackage#getMutatorGraph_Type()
	 * @model required="true"
	 * @generated
	 */
	GraphType getType();

	/**
	 * Sets the value of the '{@link mutatorgraph.MutatorGraph#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see mutatorgraph.GraphType
	 * @see #getType()
	 * @generated
	 */
	void setType(GraphType value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorgraph.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see mutatorgraph.MutatorgraphPackage#getMutatorGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorgraph.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see mutatorgraph.MutatorgraphPackage#getMutatorGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

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
	 * @see mutatorgraph.MutatorgraphPackage#getMutatorGraph_Metamodel()
	 * @model
	 * @generated
	 */
	String getMetamodel();

	/**
	 * Sets the value of the '{@link mutatorgraph.MutatorGraph#getMetamodel <em>Metamodel</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' attribute.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(String value);

} // MutatorGraph
