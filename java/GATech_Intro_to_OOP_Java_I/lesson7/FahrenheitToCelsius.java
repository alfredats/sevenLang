import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main(String[] args) {
    final int MAX_TEMP = 140;
    final int MAX_PARK_TEMP = 90;
    final int MIN_PARK_TEMP = 70;

    Scanner input = new Scanner(System.in);
    int fahrenheit;
    do {
      System.out.print("Enter a Fahrenheit value: ");
      fahrenheit = input.nextInt(); 
    } while (fahrenheit > MAX_TEMP);
    
    double celsius = (5D/9) * (fahrenheit - 32);
    System.out.printf("%-10s: %s\n", "Fahrenheit", fahrenheit);
    System.out.printf("%-10s: %.1f\n", "Celsius", celsius);
    if ((fahrenheit <= MAX_PARK_TEMP) && (fahrenheit >= MIN_PARK_TEMP)) {
      System.out.println("Yay, go to the park!");
    }
    else {
      System.out.println("Stay home...");
    }
    
  }
}
