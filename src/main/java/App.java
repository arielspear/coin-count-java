import java.io.Console;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {

  Console myConsole = System.console();
  public static void main(String[] args) {
  }

  public int[] makeChange(int valueInCents){

    int quarters = 0;
    int dimes = 0;
    int nickles = 0;
    int pennies = 0;

    while (valueInCents >= 25) {
      valueInCents = valueInCents - 25;
      quarters = quarters + 1;
    }

    while (valueInCents >= 10 ) {
      valueInCents = valueInCents - 10;
      dimes = dimes + 1;
    }


    while (valueInCents >= 5 ) {
      valueInCents = valueInCents - 5;
      nickles = nickles + 1;
    }

    while (valueInCents >= 1 ) {
      valueInCents = valueInCents - 1;
      pennies = pennies + 1;
    }

    int coins[] = {quarters, dimes, nickles, pennies};

    return coins;
  }
}
