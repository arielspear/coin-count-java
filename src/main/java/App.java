
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {

  public static void main(String[] args) {
  }

  public Integer makeChange(Integer valueInCents){

    Integer quarters = 0;
    Integer dimes = 0;
    Integer nickles = 0;
    Integer pennies = 0;


    while (valueInCents >= 25) {
     valueInCents = valueInCents - 25;
     quarters = quarters + 1;
    }
    return quarters;
  }
}
