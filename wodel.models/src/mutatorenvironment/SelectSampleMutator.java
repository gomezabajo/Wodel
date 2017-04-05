/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Select Sample Mutator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link mutatorenvironment.SelectSampleMutator#getObject <em>Object</em>}</li>
 *   <li>{@link mutatorenvironment.SelectSampleMutator#getClause <em>Clause</em>}</li>
 *   <li>{@link mutatorenvironment.SelectSampleMutator#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getSelectSampleMutator()
 * @model
 * @generated
 */
public interface SelectSampleMutator extends Mutator {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference.
	 * @see #setObject(ObSelectionStrategy)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSelectSampleMutator_Object()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ObSelectionStrategy getObject();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SelectSampleMutator#getObject <em>Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' containment reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(ObSelectionStrategy value);

	/**
	 * Returns the value of the '<em><b>Clause</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.SampleClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clause</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clause</em>' attribute.
	 * @see mutatorenvironment.SampleClause
	 * @see #setClause(SampleClause)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSelectSampleMutator_Clause()
	 * @model
	 * @generated
	 */
	SampleClause getClause();

	/**
	 * Sets the value of the '{@link mutatorenvironment.SelectSampleMutator#getClause <em>Clause</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clause</em>' attribute.
	 * @see mutatorenvironment.SampleClause
	 * @see #getClause()
	 * @generated
	 */
	void setClause(SampleClause value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getSelectSampleMutator_Features()
	 * @model
	 * @generated
	 */
	EList<EStructuralFeature> getFeatures();

} // SelectSampleMutator
