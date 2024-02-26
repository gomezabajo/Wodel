/**
 */
package edutest;

import mutatorenvironment.Block;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marked Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edutest.MarkedBlock#getBlock <em>Block</em>}</li>
 *   <li>{@link edutest.MarkedBlock#isSolution <em>Solution</em>}</li>
 * </ul>
 *
 * @see edutest.EdutestPackage#getMarkedBlock()
 * @model
 * @generated
 */
public interface MarkedBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Block</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' reference.
	 * @see #setBlock(Block)
	 * @see edutest.EdutestPackage#getMarkedBlock_Block()
	 * @model annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link edutest.MarkedBlock#getBlock <em>Block</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' attribute.
	 * @see #setSolution(boolean)
	 * @see edutest.EdutestPackage#getMarkedBlock_Solution()
	 * @model
	 * @generated
	 */
	boolean isSolution();

	/**
	 * Sets the value of the '{@link edutest.MarkedBlock#isSolution <em>Solution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution</em>' attribute.
	 * @see #isSolution()
	 * @generated
	 */
	void setSolution(boolean value);

} // MarkedBlock
