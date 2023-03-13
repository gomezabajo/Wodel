/**
 */
package mutatormetrics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.Tree#getName <em>Name</em>}</li>
 *   <li>{@link mutatormetrics.Tree#getMutants <em>Mutants</em>}</li>
 *   <li>{@link mutatormetrics.Tree#getClasses <em>Classes</em>}</li>
 *   <li>{@link mutatormetrics.Tree#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see mutatormetrics.MutatormetricsPackage#getTree()
 * @model abstract="true"
 * @generated
 */
public interface Tree extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatormetrics.MutatormetricsPackage#getTree_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatormetrics.Tree#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Mutants</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Folder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutants</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getTree_Mutants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Folder> getMutants();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getTree_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<mutatormetrics.Class> getClasses();

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see mutatormetrics.MutatormetricsPackage#getTree_Path()
	 * @model required="true"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link mutatormetrics.Tree#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

} // Tree
