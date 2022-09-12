package calc;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestDivideByZero {
    private CalculatorEngine calcEngine = new CalculatorEngine();
//  private CalculatorView calcView = new CalculatorView();

  @Before
  public void runBeforeEveryTest() {
//      calcView.actionClear();
      calcEngine.currentTotal = 0;
  }

  @Test
  public void testDivideByZero() throws Exception {
      calcEngine.divide(10);
      assertEquals(calcEngine.currentTotal, 0.0);
  }
}
