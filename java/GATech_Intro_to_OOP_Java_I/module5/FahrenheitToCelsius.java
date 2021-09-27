import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Fahrenheit value: ");
    int fahrenheit = input.nextInt();
    input.nextLine();
    System.out.print("Enter a day of the week, along with the month, day, and year: ");
    String day = input.nextLine();
    double celsius = (5D/9) * (fahrenheit - 32);
    System.out.println(day + " Celsius: " + celsius);
  }
}

