// Converts from Fahrenheit to celsius

public class Fahrenheit2Celsius {
  public static void main(String[] args) {
    int satFahrenheit;
    int sunFahrenheit;
    satFahrenheit = 30;
    sunFahrenheit = 31;
    double satCelsius = (satFahrenheit * 5) / 9;
    double sunCelsius = (sunFahrenheit * 5) / 9;
    System.out.println("Saturday's temp in celsius is " + satCelsius);
    System.out.println("Sunday's temp in celsius is " + sunCelsius);
  }
}
