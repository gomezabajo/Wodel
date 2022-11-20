/**
 */
package modeltext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valued Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.ValuedFeature#getName <em>Name</em>}</li>
 *   <li>{@link modeltext.ValuedFeature#isNegation <em>Negation</em>}</li>
 *   <li>{@link modeltext.ValuedFeature#getFeat <em>Feat</em>}</li>
 *   <li>{@link modeltext.ValuedFeature#getRefFeature <em>Ref Feature</em>}</li>
 *   <li>{@link modeltext.ValuedFeature#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getValuedFeature()
 * @model
 * @generated
 */
public interface ValuedFeature extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' reference.
	 * @see #setName(EClass)
	 * @see modeltext.ModeltextPackage#getValuedFeature_Name()
	 * @model
	 * @generated
	 */
	EClass getName();

	/**
	 * Sets the value of the '{@link modeltext.ValuedFeature#getName <em>Name</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(EClass value);

	/**
	 * Returns the value of the '<em><b>Negation</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negation</em>' attribute.
	 * @see #setNegation(boolean)
	 * @see modeltext.ModeltextPackage#getValuedFeature_Negation()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isNegation();

	/**
	 * Sets the value of the '{@link modeltext.ValuedFeature#isNegation <em>Negation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negation</em>' attribute.
	 * @see #isNegation()
	 * @generated
	 */
	void setNegation(boolean value);

	/**
	 * Returns the value of the '<em><b>Feat</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feat</em>' reference.
	 * @see #setFeat(EStructuralFeature)
	 * @see modeltext.ModeltextPackage#getValuedFeature_Feat()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeat();

	/**
	 * Sets the value of the '{@link modeltext.ValuedFeature#getFeat <em>Feat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feat</em>' reference.
	 * @see #getFeat()
	 * @generated
	 */
	void setFeat(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Ref Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Feature</em>' reference.
	 * @see #setRefFeature(EStructuralFeature)
	 * @see modeltext.ModeltextPackage#getValuedFeature_RefFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getRefFeature();

	/**
	 * Sets the value of the '{@link modeltext.ValuedFeature#getRefFeature <em>Ref Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Feature</em>' reference.
	 * @see #getRefFeature()
	 * @generated
	 */
	void setRefFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see modeltext.ModeltextPackage#getValuedFeature_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link modeltext.ValuedFeature#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ValuedFeature
