import java.util.Scanner;
import java.util.InputMismatchException;

public class FahrenheitToCelsiusExceptions {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a new Fahrenheit value: ");
    try {
      int fahrenheit = input.nextInt();
      double celsius = (5D/9) * (fahrenheit-32);
      System.out.printf("%-10s: %d\n", "Fahrenheit", fahrenheit);
      System.out.printf("%-10s: %.2f\n", "Celsius", celsius);
      double x = 1331/fahrenheit;
    } catch (InputMismatchException | ArithmeticException ie) {
      System.out.println("Sorry, that wasn't a valid value.");
      System.out.println("Please re-run the program and enter a non-zero integer");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
