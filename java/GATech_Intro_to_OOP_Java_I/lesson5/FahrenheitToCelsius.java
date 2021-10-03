import java.util.Scanner;
import java.text.DecimalFormat;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Fahrenheit value: ");
    int fahrenheit = input.nextInt();
    input.nextLine();
    System.out.print("Enter a day of the week: ");
    String day = input.nextLine();
    double celsius = (5D/9) * (fahrenheit - 32);
    DecimalFormat decfmt = new DecimalFormat("0.0");
    System.out.printf("%s %-10s: %d\n", day, "Fahrenheit", fahrenheit);
    System.out.printf("%s %-10s: %.1f\n", day, "Celsius", celsius);
    System.out.printf("%s %-10s: %s", day, "Centigrade", decfmt.format(celsius));
  }
}

