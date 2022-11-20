/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Emitter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.ObjectEmitter#getType <em>Type</em>}</li>
 *   <li>{@link mutatorenvironment.ObjectEmitter#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.ObjectEmitter#getTypes <em>Types</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectEmitter()
 * @model abstract="true"
 * @generated
 */
public interface ObjectEmitter extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectEmitter_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObjectEmitter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectEmitter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.ObjectEmitter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getObjectEmitter_Types()
	 * @model
	 * @generated
	 */
	EList<EClass> getTypes();

} // ObjectEmitter
