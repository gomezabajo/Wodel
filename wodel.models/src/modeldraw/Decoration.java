/**
 */
package modeldraw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Decoration</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see modeldraw.ModeldrawPackage#getDecoration()
 * @model
 * @generated
 */
public enum Decoration implements Enumerator {
	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "none", "none"),

	/**
	 * The '<em><b>Triangle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE_VALUE
	 * @generated
	 * @ordered
	 */
	TRIANGLE(1, "triangle", "triangle"),

	/**
	 * The '<em><b>Diamond</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAMOND_VALUE
	 * @generated
	 * @ordered
	 */
	DIAMOND(2, "diamond", "diamond"),

	/**
	 * The '<em><b>Odiamond</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ODIAMOND_VALUE
	 * @generated
	 * @ordered
	 */
	ODIAMOND(3, "odiamond", "odiamond"),

	/**
	 * The '<em><b>Open</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN_VALUE
	 * @generated
	 * @ordered
	 */
	OPEN(4, "open", "open"),

	/**
	 * The '<em><b>Empty</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMPTY_VALUE
	 * @generated
	 * @ordered
	 */
	EMPTY(5, "empty", "empty");

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model name="none"
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>Triangle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRIANGLE
	 * @model name="triangle"
	 * @generated
	 * @ordered
	 */
	public static final int TRIANGLE_VALUE = 1;

	/**
	 * The '<em><b>Diamond</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIAMOND
	 * @model name="diamond"
	 * @generated
	 * @ordered
	 */
	public static final int DIAMOND_VALUE = 2;

	/**
	 * The '<em><b>Odiamond</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ODIAMOND
	 * @model name="odiamond"
	 * @generated
	 * @ordered
	 */
	public static final int ODIAMOND_VALUE = 3;

	/**
	 * The '<em><b>Open</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN
	 * @model name="open"
	 * @generated
	 * @ordered
	 */
	public static final int OPEN_VALUE = 4;

	/**
	 * The '<em><b>Empty</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMPTY
	 * @model name="empty"
	 * @generated
	 * @ordered
	 */
	public static final int EMPTY_VALUE = 5;

	/**
	 * An array of all the '<em><b>Decoration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Decoration[] VALUES_ARRAY =
		new Decoration[] {
			NONE,
			TRIANGLE,
			DIAMOND,
			ODIAMOND,
			OPEN,
			EMPTY,
		};

	/**
	 * A public read-only list of all the '<em><b>Decoration</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Decoration> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Decoration</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Decoration get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Decoration result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Decoration</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Decoration getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Decoration result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Decoration</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Decoration get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case TRIANGLE_VALUE: return TRIANGLE;
			case DIAMOND_VALUE: return DIAMOND;
			case ODIAMOND_VALUE: return ODIAMOND;
			case OPEN_VALUE: return OPEN;
			case EMPTY_VALUE: return EMPTY;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Decoration(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Decoration
