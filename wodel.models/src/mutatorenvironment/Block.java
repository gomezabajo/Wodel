/**
 */
package mutatorenvironment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.Block#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getCommands <em>Commands</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getFrom <em>From</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getRepeat <em>Repeat</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getReverse <em>Reverse</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getMin <em>Min</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getMax <em>Max</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getFixed <em>Fixed</em>}</li>
 *   <li>{@link mutatorenvironment.Block#getDescription <em>Description</em>}</li>
 *   <li>{@link mutatorenvironment.Block#isMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link mutatorenvironment.Mutator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Mutator> getCommands();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference list.
	 * The list contents are of type {@link mutatorenvironment.Block}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference list.
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_From()
	 * @model
	 * @generated
	 */
	EList<Block> getFrom();

	/**
	 * Returns the value of the '<em><b>Repeat</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.Repeat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat</em>' attribute.
	 * @see mutatorenvironment.Repeat
	 * @see #setRepeat(Repeat)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Repeat()
	 * @model required="true"
	 * @generated
	 */
	Repeat getRepeat();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getRepeat <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat</em>' attribute.
	 * @see mutatorenvironment.Repeat
	 * @see #getRepeat()
	 * @generated
	 */
	void setRepeat(Repeat value);

	/**
	 * Returns the value of the '<em><b>Reverse</b></em>' attribute.
	 * The literals are from the enumeration {@link mutatorenvironment.Reverse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse</em>' attribute.
	 * @see mutatorenvironment.Reverse
	 * @see #setReverse(Reverse)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Reverse()
	 * @model required="true"
	 * @generated
	 */
	Reverse getReverse();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getReverse <em>Reverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse</em>' attribute.
	 * @see mutatorenvironment.Reverse
	 * @see #getReverse()
	 * @generated
	 */
	void setReverse(Reverse value);

	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Min()
	 * @model
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

	/**
	 * Returns the value of the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max</em>' attribute.
	 * @see #setMax(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Max()
	 * @model
	 * @generated
	 */
	int getMax();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getMax <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max</em>' attribute.
	 * @see #getMax()
	 * @generated
	 */
	void setMax(int value);

	/**
	 * Returns the value of the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed</em>' attribute.
	 * @see #setFixed(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Fixed()
	 * @model
	 * @generated
	 */
	int getFixed();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getFixed <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed</em>' attribute.
	 * @see #getFixed()
	 * @generated
	 */
	void setFixed(int value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(boolean)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getBlock_Mode()
	 * @model default="false"
	 * @generated
	 */
	boolean isMode();

	/**
	 * Sets the value of the '{@link mutatorenvironment.Block#isMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #isMode()
	 * @generated
	 */
	void setMode(boolean value);

} // Block
