/**
 */
package mutatext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see mutatext.MutatextPackage#getVariableType()
 * @model
 * @generated
 */
public enum VariableType implements Enumerator {
	/**
	 * The '<em><b>Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT(0, "object", "object"),

	/**
	 * The '<em><b>Att Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATT_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	ATT_NAME(1, "attName", "attName"),

	/**
	 * The '<em><b>Old Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OLD_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	OLD_VALUE(2, "oldValue", "oldValue"),

	/**
	 * The '<em><b>New Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	NEW_VALUE(3, "newValue", "newValue"),

	/**
	 * The '<em><b>Ref Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REF_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	REF_NAME(4, "refName", "refName"),

	/**
	 * The '<em><b>From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	FROM_OBJECT(5, "fromObject", "fromObject"),

	/**
	 * The '<em><b>Old From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OLD_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OLD_FROM_OBJECT(6, "oldFromObject", "oldFromObject"),

	/**
	 * The '<em><b>Src Ref Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SRC_REF_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	SRC_REF_NAME(7, "srcRefName", "srcRefName"),

	/**
	 * The '<em><b>To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	TO_OBJECT(8, "toObject", "toObject"),

	/**
	 * The '<em><b>Old To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OLD_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OLD_TO_OBJECT(9, "oldToObject", "oldToObject"),

	/**
	 * The '<em><b>First Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_OBJECT(10, "firstObject", "firstObject"),

	/**
	 * The '<em><b>First Ref Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_REF_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_REF_NAME(11, "firstRefName", "firstRefName"),

	/**
	 * The '<em><b>First From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_FROM_OBJECT(12, "firstFromObject", "firstFromObject"),

	/**
	 * The '<em><b>First To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_TO_OBJECT(13, "firstToObject", "firstToObject"),

	/**
	 * The '<em><b>Second Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_OBJECT(14, "secondObject", "secondObject"),

	/**
	 * The '<em><b>Second Ref Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_REF_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_REF_NAME(15, "secondRefName", "secondRefName"),

	/**
	 * The '<em><b>Second From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_FROM_OBJECT(16, "secondFromObject", "secondFromObject"),

	/**
	 * The '<em><b>Second To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_TO_OBJECT(17, "secondToObject", "secondToObject"),

	/**
	 * The '<em><b>First Att Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_ATT_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_ATT_NAME(18, "firstAttName", "firstAttName"),

	/**
	 * The '<em><b>First Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRST_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	FIRST_VALUE(19, "firstValue", "firstValue"),

	/**
	 * The '<em><b>Second Att Name</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_ATT_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_ATT_NAME(20, "secondAttName", "secondAttName"),

	/**
	 * The '<em><b>Second Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECOND_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	SECOND_VALUE(21, "secondValue", "secondValue"), /**
	 * The '<em><b>Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	VALUE(22, "value", "value"), /**
	 * The '<em><b>Described Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_OBJECT(23, "describedObject", "describedObject"), /**
	 * The '<em><b>Described From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_FROM_OBJECT(24, "describedFromObject", "describedFromObject"), /**
	 * The '<em><b>Described Old From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OLD_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_OLD_FROM_OBJECT(25, "describedOldFromObject", "describedOldFromObject"), /**
	 * The '<em><b>Described To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_TO_OBJECT(26, "describedToObject", "describedToObject"), /**
	 * The '<em><b>Described Old To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OLD_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_OLD_TO_OBJECT(27, "describedOldToObject", "describedOldToObject"), /**
	 * The '<em><b>Described First Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_FIRST_OBJECT(28, "describedFirstObject", "describedFirstObject"), /**
	 * The '<em><b>Described First From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_FIRST_FROM_OBJECT(29, "describedFirstFromObject", "describedFirstFromObject"), /**
	 * The '<em><b>Described First To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_FIRST_TO_OBJECT(30, "describedFirstToObject", "describedFirstToObject"), /**
	 * The '<em><b>Described Second Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_SECOND_OBJECT(31, "describedSecondObject", "describedSecondObject"), /**
	 * The '<em><b>Described Second From Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_FROM_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_SECOND_FROM_OBJECT(32, "describedSecondFromObject", "describedSecondFromObject"), /**
	 * The '<em><b>Described Second To Object</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_TO_OBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	DESCRIBED_SECOND_TO_OBJECT(33, "describedSecondToObject", "describedSecondToObject");

	/**
	 * The '<em><b>Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT
	 * @model name="object"
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_VALUE = 0;

	/**
	 * The '<em><b>Att Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Att Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATT_NAME
	 * @model name="attName"
	 * @generated
	 * @ordered
	 */
	public static final int ATT_NAME_VALUE = 1;

	/**
	 * The '<em><b>Old Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Old Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OLD_VALUE
	 * @model name="oldValue"
	 * @generated
	 * @ordered
	 */
	public static final int OLD_VALUE_VALUE = 2;

	/**
	 * The '<em><b>New Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>New Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEW_VALUE
	 * @model name="newValue"
	 * @generated
	 * @ordered
	 */
	public static final int NEW_VALUE_VALUE = 3;

	/**
	 * The '<em><b>Ref Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ref Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REF_NAME
	 * @model name="refName"
	 * @generated
	 * @ordered
	 */
	public static final int REF_NAME_VALUE = 4;

	/**
	 * The '<em><b>From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FROM_OBJECT
	 * @model name="fromObject"
	 * @generated
	 * @ordered
	 */
	public static final int FROM_OBJECT_VALUE = 5;

	/**
	 * The '<em><b>Old From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Old From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OLD_FROM_OBJECT
	 * @model name="oldFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int OLD_FROM_OBJECT_VALUE = 6;

	/**
	 * The '<em><b>Src Ref Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Src Ref Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SRC_REF_NAME
	 * @model name="srcRefName"
	 * @generated
	 * @ordered
	 */
	public static final int SRC_REF_NAME_VALUE = 7;

	/**
	 * The '<em><b>To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TO_OBJECT
	 * @model name="toObject"
	 * @generated
	 * @ordered
	 */
	public static final int TO_OBJECT_VALUE = 8;

	/**
	 * The '<em><b>Old To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Old To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OLD_TO_OBJECT
	 * @model name="oldToObject"
	 * @generated
	 * @ordered
	 */
	public static final int OLD_TO_OBJECT_VALUE = 9;

	/**
	 * The '<em><b>First Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_OBJECT
	 * @model name="firstObject"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_OBJECT_VALUE = 10;

	/**
	 * The '<em><b>First Ref Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First Ref Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_REF_NAME
	 * @model name="firstRefName"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_REF_NAME_VALUE = 11;

	/**
	 * The '<em><b>First From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_FROM_OBJECT
	 * @model name="firstFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_FROM_OBJECT_VALUE = 12;

	/**
	 * The '<em><b>First To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_TO_OBJECT
	 * @model name="firstToObject"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_TO_OBJECT_VALUE = 13;

	/**
	 * The '<em><b>Second Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_OBJECT
	 * @model name="secondObject"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_OBJECT_VALUE = 14;

	/**
	 * The '<em><b>Second Ref Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second Ref Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_REF_NAME
	 * @model name="secondRefName"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_REF_NAME_VALUE = 15;

	/**
	 * The '<em><b>Second From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_FROM_OBJECT
	 * @model name="secondFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_FROM_OBJECT_VALUE = 16;

	/**
	 * The '<em><b>Second To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_TO_OBJECT
	 * @model name="secondToObject"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_TO_OBJECT_VALUE = 17;

	/**
	 * The '<em><b>First Att Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First Att Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_ATT_NAME
	 * @model name="firstAttName"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_ATT_NAME_VALUE = 18;

	/**
	 * The '<em><b>First Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>First Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRST_VALUE
	 * @model name="firstValue"
	 * @generated
	 * @ordered
	 */
	public static final int FIRST_VALUE_VALUE = 19;

	/**
	 * The '<em><b>Second Att Name</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second Att Name</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_ATT_NAME
	 * @model name="secondAttName"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_ATT_NAME_VALUE = 20;

	/**
	 * The '<em><b>Second Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Second Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECOND_VALUE
	 * @model name="secondValue"
	 * @generated
	 * @ordered
	 */
	public static final int SECOND_VALUE_VALUE = 21;

	/**
	 * The '<em><b>Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE
	 * @model name="value"
	 * @generated
	 * @ordered
	 */
	public static final int VALUE_VALUE = 22;

	/**
	 * The '<em><b>Described Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OBJECT
	 * @model name="describedObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_OBJECT_VALUE = 23;

	/**
	 * The '<em><b>Described From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FROM_OBJECT
	 * @model name="describedFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_FROM_OBJECT_VALUE = 24;

	/**
	 * The '<em><b>Described Old From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Old From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OLD_FROM_OBJECT
	 * @model name="describedOldFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_OLD_FROM_OBJECT_VALUE = 25;

	/**
	 * The '<em><b>Described To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_TO_OBJECT
	 * @model name="describedToObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_TO_OBJECT_VALUE = 26;

	/**
	 * The '<em><b>Described Old To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Old To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_OLD_TO_OBJECT
	 * @model name="describedOldToObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_OLD_TO_OBJECT_VALUE = 27;

	/**
	 * The '<em><b>Described First Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described First Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_OBJECT
	 * @model name="describedFirstObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_FIRST_OBJECT_VALUE = 28;

	/**
	 * The '<em><b>Described First From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described First From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_FROM_OBJECT
	 * @model name="describedFirstFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_FIRST_FROM_OBJECT_VALUE = 29;

	/**
	 * The '<em><b>Described First To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described First To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_FIRST_TO_OBJECT
	 * @model name="describedFirstToObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_FIRST_TO_OBJECT_VALUE = 30;

	/**
	 * The '<em><b>Described Second Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Second Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_OBJECT
	 * @model name="describedSecondObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_SECOND_OBJECT_VALUE = 31;

	/**
	 * The '<em><b>Described Second From Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Second From Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_FROM_OBJECT
	 * @model name="describedSecondFromObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_SECOND_FROM_OBJECT_VALUE = 32;

	/**
	 * The '<em><b>Described Second To Object</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Described Second To Object</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIBED_SECOND_TO_OBJECT
	 * @model name="describedSecondToObject"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIBED_SECOND_TO_OBJECT_VALUE = 33;

	/**
	 * An array of all the '<em><b>Variable Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariableType[] VALUES_ARRAY =
		new VariableType[] {
			OBJECT,
			ATT_NAME,
			OLD_VALUE,
			NEW_VALUE,
			REF_NAME,
			FROM_OBJECT,
			OLD_FROM_OBJECT,
			SRC_REF_NAME,
			TO_OBJECT,
			OLD_TO_OBJECT,
			FIRST_OBJECT,
			FIRST_REF_NAME,
			FIRST_FROM_OBJECT,
			FIRST_TO_OBJECT,
			SECOND_OBJECT,
			SECOND_REF_NAME,
			SECOND_FROM_OBJECT,
			SECOND_TO_OBJECT,
			FIRST_ATT_NAME,
			FIRST_VALUE,
			SECOND_ATT_NAME,
			SECOND_VALUE,
			VALUE,
			DESCRIBED_OBJECT,
			DESCRIBED_FROM_OBJECT,
			DESCRIBED_OLD_FROM_OBJECT,
			DESCRIBED_TO_OBJECT,
			DESCRIBED_OLD_TO_OBJECT,
			DESCRIBED_FIRST_OBJECT,
			DESCRIBED_FIRST_FROM_OBJECT,
			DESCRIBED_FIRST_TO_OBJECT,
			DESCRIBED_SECOND_OBJECT,
			DESCRIBED_SECOND_FROM_OBJECT,
			DESCRIBED_SECOND_TO_OBJECT,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariableType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariableType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariableType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static VariableType get(int value) {
		switch (value) {
			case OBJECT_VALUE: return OBJECT;
			case ATT_NAME_VALUE: return ATT_NAME;
			case OLD_VALUE_VALUE: return OLD_VALUE;
			case NEW_VALUE_VALUE: return NEW_VALUE;
			case REF_NAME_VALUE: return REF_NAME;
			case FROM_OBJECT_VALUE: return FROM_OBJECT;
			case OLD_FROM_OBJECT_VALUE: return OLD_FROM_OBJECT;
			case SRC_REF_NAME_VALUE: return SRC_REF_NAME;
			case TO_OBJECT_VALUE: return TO_OBJECT;
			case OLD_TO_OBJECT_VALUE: return OLD_TO_OBJECT;
			case FIRST_OBJECT_VALUE: return FIRST_OBJECT;
			case FIRST_REF_NAME_VALUE: return FIRST_REF_NAME;
			case FIRST_FROM_OBJECT_VALUE: return FIRST_FROM_OBJECT;
			case FIRST_TO_OBJECT_VALUE: return FIRST_TO_OBJECT;
			case SECOND_OBJECT_VALUE: return SECOND_OBJECT;
			case SECOND_REF_NAME_VALUE: return SECOND_REF_NAME;
			case SECOND_FROM_OBJECT_VALUE: return SECOND_FROM_OBJECT;
			case SECOND_TO_OBJECT_VALUE: return SECOND_TO_OBJECT;
			case FIRST_ATT_NAME_VALUE: return FIRST_ATT_NAME;
			case FIRST_VALUE_VALUE: return FIRST_VALUE;
			case SECOND_ATT_NAME_VALUE: return SECOND_ATT_NAME;
			case SECOND_VALUE_VALUE: return SECOND_VALUE;
			case VALUE_VALUE: return VALUE;
			case DESCRIBED_OBJECT_VALUE: return DESCRIBED_OBJECT;
			case DESCRIBED_FROM_OBJECT_VALUE: return DESCRIBED_FROM_OBJECT;
			case DESCRIBED_OLD_FROM_OBJECT_VALUE: return DESCRIBED_OLD_FROM_OBJECT;
			case DESCRIBED_TO_OBJECT_VALUE: return DESCRIBED_TO_OBJECT;
			case DESCRIBED_OLD_TO_OBJECT_VALUE: return DESCRIBED_OLD_TO_OBJECT;
			case DESCRIBED_FIRST_OBJECT_VALUE: return DESCRIBED_FIRST_OBJECT;
			case DESCRIBED_FIRST_FROM_OBJECT_VALUE: return DESCRIBED_FIRST_FROM_OBJECT;
			case DESCRIBED_FIRST_TO_OBJECT_VALUE: return DESCRIBED_FIRST_TO_OBJECT;
			case DESCRIBED_SECOND_OBJECT_VALUE: return DESCRIBED_SECOND_OBJECT;
			case DESCRIBED_SECOND_FROM_OBJECT_VALUE: return DESCRIBED_SECOND_FROM_OBJECT;
			case DESCRIBED_SECOND_TO_OBJECT_VALUE: return DESCRIBED_SECOND_TO_OBJECT;
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
	private VariableType(int value, String name, String literal) {
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
	
} //VariableType
