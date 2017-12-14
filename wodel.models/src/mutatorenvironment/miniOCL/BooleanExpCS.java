/**
 */
package mutatorenvironment.miniOCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.miniOCL.BooleanExpCS#isBoolSymbol <em>Bool Symbol</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getBooleanExpCS()
 * @model
 * @generated
 */
public interface BooleanExpCS extends BooleanLiteralExpCS {
	/**
	 * Returns the value of the '<em><b>Bool Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bool Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Symbol</em>' attribute.
	 * @see #setBoolSymbol(boolean)
	 * @see mutatorenvironment.miniOCL.MiniOCLPackage#getBooleanExpCS_BoolSymbol()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='ExistsExpCS'"
	 * @generated
	 */
	boolean isBoolSymbol();

	/**
	 * Sets the value of the '{@link mutatorenvironment.miniOCL.BooleanExpCS#isBoolSymbol <em>Bool Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool Symbol</em>' attribute.
	 * @see #isBoolSymbol()
	 * @generated
	 */
	void setBoolSymbol(boolean value);

} // BooleanExpCS
