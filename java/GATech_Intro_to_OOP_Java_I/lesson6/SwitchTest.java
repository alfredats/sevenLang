import java.util.Scanner;

public class SwitchTest {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter 5 for the following option to see effects of unsafe switch statements");
    System.out.println("Pick a number from 1 to 5: ");
    int selection = input.nextInt();

    String menuOption;

    switch (selection) {
      case 1:
        menuOption = "Operator";
        break;
      case 2:
        menuOption = "Customer Service";
        break;
      case 3:
        menuOption = "Billing";
        break;
      case 4:
        menuOption = "Repeat Menu";
        break;
      case 5:
        menuOption = "Hang Up";
        // break;
      default:
        menuOption = "Retry Selection";
        break;
    }
    System.out.println(menuOption);

    if (selection == 5) {
      System.out.println("menuOption should be \'Hang Up\', but because of a missing break statement, it continued on to run the default switch branch.");
    }
  }
}
