package calc;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestMultiply {
    private CalculatorEngine calcEngine = new CalculatorEngine();
//  private CalculatorView calcView = new CalculatorView();

  @Before
  public void runBeforeEveryTest() {
//      calcView.actionClear();
      calcEngine.currentTotal = 0;
  }

  @Test
  public void testMultiply() throws Exception {
      calcEngine.add(10);
      calcEngine.multiply(10);
      assertEquals(calcEngine.currentTotal, 100.0);
  }
}
