package calc;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestEqual {

   private CalculatorEngine calcEngine = new CalculatorEngine();
// private CalculatorView calcView = new CalculatorView();

	@Before
    public void runBeforeEveryTest() {
//      calcView.actionClear();
        calcEngine.currentTotal = 0;
    }
    @Test
    public void testEqual() throws Exception {
        calcEngine.equal("20");
        assertEquals(calcEngine.currentTotal, 20.0);
    }
}
