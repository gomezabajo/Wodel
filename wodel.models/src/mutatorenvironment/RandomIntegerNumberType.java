/**
 */
package mutatorenvironment;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Integer Number Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.RandomIntegerNumberType#getMin <em>Min</em>}</li>
 * </ul>
 *
 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomIntegerNumberType()
 * @model
 * @generated
 */
public interface RandomIntegerNumberType extends RandomNumberType {
	/**
	 * Returns the value of the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min</em>' attribute.
	 * @see #setMin(int)
	 * @see mutatorenvironment.MutatorenvironmentPackage#getRandomIntegerNumberType_Min()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SpecificClosureSelection' unique='false' upper='*'"
	 * @generated
	 */
	int getMin();

	/**
	 * Sets the value of the '{@link mutatorenvironment.RandomIntegerNumberType#getMin <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min</em>' attribute.
	 * @see #getMin()
	 * @generated
	 */
	void setMin(int value);

} // RandomIntegerNumberType
