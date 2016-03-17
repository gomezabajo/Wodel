/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.AttributeUnset;
import mutatorenvironment.MutatorenvironmentFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Unset</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeUnsetTest extends AttributeSetTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AttributeUnsetTest.class);
	}

	/**
	 * Constructs a new Attribute Unset test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeUnsetTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Attribute Unset test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AttributeUnset getFixture() {
		return (AttributeUnset)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createAttributeUnset());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AttributeUnsetTest
