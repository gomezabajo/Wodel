/**
 */
package mutatortests.tests;

import junit.textui.TestRunner;

import mutatortests.MutatortestsFactory;
import mutatortests.ProgramConfiguration;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Program Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProgramConfigurationTest extends ConfigurationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ProgramConfigurationTest.class);
	}

	/**
	 * Constructs a new Program Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProgramConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Program Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected ProgramConfiguration getFixture() {
		return (ProgramConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(MutatortestsFactory.eINSTANCE.createProgramConfiguration());
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

} //ProgramConfigurationTest
