import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {
  App testApp = new App();

  @Test
  public void makeChange_ifMoneyIsGreaterThan25CentsAddQuarter_1() {
    Integer quarters = 1;
    assertEquals(quarters, testApp.makeChange(25));
  }

  @Test
  public void makeChange_ifMoneyIsGreaterThan10CentsAddDime_2() {
    Integer dimes = 2;
    assertEquals(dimes, testApp.makeChange(20));
  }
}
