package efinder.emfocl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ValidationTest.class,
	ValidateEcoreTest.class, 
	RelSchemaExampleTest.class,
	FootprintTest.class})
public class AllTests {

}
