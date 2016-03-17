/**
 */
package mutatorenvironment.tests;

import junit.textui.TestRunner;

import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.ReferenceEvaluation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Reference Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceEvaluationTest extends EvaluationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ReferenceEvaluationTest.class);
	}

	/**
	 * Constructs a new Reference Evaluation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceEvaluationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Reference Evaluation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ReferenceEvaluation getFixture() {
		return (ReferenceEvaluation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatorenvironmentFactory.eINSTANCE.createReferenceEvaluation());
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

} //ReferenceEvaluationTest
