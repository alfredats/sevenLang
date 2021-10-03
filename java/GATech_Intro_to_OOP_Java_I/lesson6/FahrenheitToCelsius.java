import java.util.Scanner;


public class FahrenheitToCelsius {
  public static void main(String[] args) {
    final int PARK_MAX_TEMP = 90;
    final int PARK_MIN_TEMP = 70;

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a new Fahrenheit value: ");
    int fval = input.nextInt();
    System.out.print("Enter a day of the week: ");
    String day = input.next();
    System.out.print("Is it raining? (y/n) ");
    String wet = input.next();

    double celsius = (5D/9) * (fval - 32);
    boolean raining = wet.startsWith("y");


    System.out.println("\nToday's weather");
    System.out.printf("%s %-10s: %d\n", day, "Fahrenheit", fval);
    System.out.printf("%s %-10s: %.1f\n", day, "Celsius", celsius);
    System.out.printf("%s %-10s: %b\n", day, "Raining", raining);
    if ((fval >= PARK_MIN_TEMP) && (fval <= PARK_MAX_TEMP)
                                && (!raining)) {
      System.out.println("Go to the park!");
    }
    else {
      System.out.println("Stay home....");
    }

  }
}
