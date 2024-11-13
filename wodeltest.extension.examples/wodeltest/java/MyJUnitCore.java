package mutator.wodeltest.[@**@];

import org.junit.runner.JUnitCore;

public class MyJUnitCore extends JUnitCore {
	@SuppressWarnings("deprecation")
	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}
