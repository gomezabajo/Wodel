package calc;

import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestAdd {
    private CalculatorEngine calcEngine = new CalculatorEngine();
//  private CalculatorView calcView = new CalculatorView();

  @Before
  public void runBeforeEveryTest() {
//      calcView.actionClear();
      calcEngine.currentTotal = 0;
  }

  @Test
  public void testAdd() throws Exception {
      calcEngine.add(20);
      assertEquals(calcEngine.currentTotal, 20.0);

  }
}
