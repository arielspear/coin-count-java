import org.junit.*;
import static org.junit.Assert.*;
import java.io.Console;
import java.util.Arrays;

public class AppTest {

  Console myConsole = System.console();

  App testApp = new App();

  @Test
  public void makeChange_ifMoneyIsGreaterThan25CentsAddQuarter_1() {
    int[] result = {1,0,0,0};
    assertTrue(Arrays.equals(result,testApp.makeChange(25)));
  }

  @Test
  public void makeChange_ifMoneyIsGreaterThan10CentsAddDime_2() {
    int[] result = {0,2,0,0};
    assertTrue(Arrays.equals(result,testApp.makeChange(20)));
  }

  @Test
  public void makeChange_ifMoneyIsGreaterThan5CentsAddNickle_1() {
    int[] result = {0,0,1,0};
    assertTrue(Arrays.equals(result,testApp.makeChange(5)));
  }

  @Test
  public void makeChange_ifMoneyIsGreaterThan1CentsAddPennies_3() {
      int[] result = {0,0,0,3};
      assertTrue(Arrays.equals(result,testApp.makeChange(3)));
  }
}
