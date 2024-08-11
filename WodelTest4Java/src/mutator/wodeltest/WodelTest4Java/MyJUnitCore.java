package mutator.wodeltest.WodelTest4Java;

import org.junit.runner.JUnitCore;

public class MyJUnitCore extends JUnitCore {
	public MyJUnitCore() {
		super();
	}
	@SuppressWarnings("deprecation")
	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}
