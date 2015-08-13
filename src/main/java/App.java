import java.io.Console;
import java.util.Map;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {

  Console myConsole = System.console();
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/home.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String cents = request.queryParams("cents");
      Integer valueInCents = Integer.parseInt(cents);


      int[] savedCoins = makeChange(valueInCents);
      int quarters = savedCoins[0];
      int dimes = savedCoins[1];
      int nickels = savedCoins[2];
      int pennies = savedCoins[3];

      model.put("valueInCents", valueInCents);
      model.put("quarters", quarters);
      model.put("dimes",dimes);
      model.put("nickels", nickels);
      model.put("pennies", pennies);

      return new ModelAndView(model, layout);


    }, new VelocityTemplateEngine());

  }
  public static int[] makeChange(int valueInCents){

    int howManyQuarters = 0;
    int howManyDimes = 0;
    int howManyNickles = 0;
    int howManyPennies = 0;

    while (valueInCents >= 25) {
      valueInCents = valueInCents - 25;
      howManyQuarters = howManyQuarters + 1;
    }

    while (valueInCents >= 10 ) {
      valueInCents = valueInCents - 10;
      howManyDimes = howManyDimes + 1;
    }


    while (valueInCents >= 5 ) {
      valueInCents = valueInCents - 5;
      howManyNickles = howManyNickles + 1;
    }

    while (valueInCents >= 1 ) {
      valueInCents = valueInCents - 1;
      howManyPennies = howManyPennies + 1;
    }

    int coins[] = {howManyQuarters, howManyDimes, howManyNickles, howManyPennies};

    return coins;

  }

}
