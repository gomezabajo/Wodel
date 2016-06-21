/**
 */
package mutatortests.tests;

import junit.textui.TestRunner;

import mutatortests.MultiChoiceDiagram;
import mutatortests.MutatortestsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Multi Choice Diagram</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultiChoiceDiagramTest extends MutatorTestsTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MultiChoiceDiagramTest.class);
	}

	/**
	 * Constructs a new Multi Choice Diagram test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiChoiceDiagramTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Multi Choice Diagram test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected MultiChoiceDiagram getFixture() {
		return (MultiChoiceDiagram)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatortestsFactory.eINSTANCE.createMultiChoiceDiagram());
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

} //MultiChoiceDiagramTest
