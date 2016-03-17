/**
 */
package appliedMutations.tests;

import appliedMutations.AppliedMutationsFactory;
import appliedMutations.AttributeChanged;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Changed</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeChangedTest extends AppMutationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AttributeChangedTest.class);
	}

	/**
	 * Constructs a new Attribute Changed test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeChangedTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Attribute Changed test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AttributeChanged getFixture() {
		return (AttributeChanged)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AppliedMutationsFactory.eINSTANCE.createAttributeChanged());
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

} //AttributeChangedTest
