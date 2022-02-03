import java.util.Scanner;
import java.util.InputMismatchException;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean success = false;
    int fahrenheit = 0;

    // this is known as an exception-controlled loop
    while (!success) {
      try {
        System.out.printf("Enter Fahrenheit value: ");
        fahrenheit = scan.nextInt();
        success = true;
      } catch (InputMismatchException e) {
        System.out.println("Sorry, that wasn't an int.");
        System.out.println("Please try again.");
      } finally {
        scan.nextLine();
      }
    }

    double celsius;
    celsius = (5D/9) * (fahrenheit-32);
    System.out.printf("%-10s: %d\n", "Fahrenheit", fahrenheit);
    System.out.printf("%-10s: %.2f\n", "Celsius", celsius);
  }

}
