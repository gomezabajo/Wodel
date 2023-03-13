/**
 */
package mutatormetrics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutator Metrics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.MutatorMetrics#getTrees <em>Trees</em>}</li>
 *   <li>{@link mutatormetrics.MutatorMetrics#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see mutatormetrics.MutatormetricsPackage#getMutatorMetrics()
 * @model
 * @generated
 */
public interface MutatorMetrics extends EObject {
	/**
	 * Returns the value of the '<em><b>Trees</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Folder}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trees</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getMutatorMetrics_Trees()
	 * @model containment="true"
	 * @generated
	 */
	EList<Folder> getTrees();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link mutatormetrics.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see mutatormetrics.MutatormetricsPackage#getMutatorMetrics_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<mutatormetrics.Class> getClasses();

} // MutatorMetrics
