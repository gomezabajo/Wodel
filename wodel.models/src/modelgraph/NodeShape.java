/**
 */
package modelgraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Node Shape</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see modelgraph.ModelgraphPackage#getNodeShape()
 * @model
 * @generated
 */
public enum NodeShape implements Enumerator {
	/**
	 * The '<em><b>Circle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CIRCLE_VALUE
	 * @generated
	 * @ordered
	 */
	CIRCLE(0, "circle", "circle"),

	/**
	 * The '<em><b>Doublecircle</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLECIRCLE_VALUE
	 * @generated
	 * @ordered
	 */
	DOUBLECIRCLE(1, "doublecircle", "doublecircle");

	/**
	 * The '<em><b>Circle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Circle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CIRCLE
	 * @model name="circle"
	 * @generated
	 * @ordered
	 */
	public static final int CIRCLE_VALUE = 0;

	/**
	 * The '<em><b>Doublecircle</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Doublecircle</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLECIRCLE
	 * @model name="doublecircle"
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLECIRCLE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Node Shape</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NodeShape[] VALUES_ARRAY =
		new NodeShape[] {
			CIRCLE,
			DOUBLECIRCLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Node Shape</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NodeShape> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Node Shape</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NodeShape get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NodeShape result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Shape</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NodeShape getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			NodeShape result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Node Shape</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NodeShape get(int value) {
		switch (value) {
			case CIRCLE_VALUE: return CIRCLE;
			case DOUBLECIRCLE_VALUE: return DOUBLECIRCLE;
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
	private NodeShape(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	
} //NodeShape
