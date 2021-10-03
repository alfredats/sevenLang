import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyDemo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of items: ");
    int numItems = input.nextInt();
    input.nextLine();
    System.out.print("Enter the average price of each item: ");
    double price = input.nextDouble();
    NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.FRENCH);
    System.out.printf("The total price is: %s", fmt.format(price));
  }
}
