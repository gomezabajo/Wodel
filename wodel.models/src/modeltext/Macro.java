/**
 */
package modeltext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Macro</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeltext.Macro#getItem <em>Item</em>}</li>
 * </ul>
 *
 * @see modeltext.ModeltextPackage#getMacro()
 * @model
 * @generated
 */
public interface Macro extends Word {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' attribute.
	 * The literals are from the enumeration {@link modeltext.MacroItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' attribute.
	 * @see modeltext.MacroItem
	 * @see #setItem(MacroItem)
	 * @see modeltext.ModeltextPackage#getMacro_Item()
	 * @model required="true"
	 * @generated
	 */
	MacroItem getItem();

	/**
	 * Sets the value of the '{@link modeltext.Macro#getItem <em>Item</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' attribute.
	 * @see modeltext.MacroItem
	 * @see #getItem()
	 * @generated
	 */
	void setItem(MacroItem value);

} // Macro
