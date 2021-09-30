import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int x; int y; double f; double g;


    System.out.println("List of operations: add subtract multiply divide alphabetize");
    System.out.println("Enter an operation:");
    String op = input.next().toLowerCase();

    switch (op) {
      case ("alphabetize"):
        System.out.println("Enter two words:");
        String s1 = input.next();
        String s2 = input.next();
        int cmpstr = s1.compareToIgnoreCase(s2);
        if (cmpstr == 0) {
          System.out.println("Answer: Chicken or Egg.");
        }
        else if (cmpstr > 0) {
          System.out.printf("Answer: %s comes before %s alphabetically.\n", s2, s1);
        }
        else {
          System.out.printf("Answer: %s comes before %s alphabetically.\n", s1, s2);
        }
        break;
      case ("add"):
        System.out.println("Enter two integers:");
        if (input.hasNextInt()) {
          x = input.nextInt();
        
          if (input.hasNextInt()) {
            y = input.nextInt();
            System.out.printf("Answer: %d\n", x + y);
            break;
          }
          else {
            System.out.println("Invalid input entered. Terminating...");
            break;
          }
        }
        else {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
      case ("subtract"):
        System.out.println("Enter two integers:");
        if (input.hasNextInt()) {
          x = input.nextInt();
          if (input.hasNextInt()) {
            y = input.nextInt();
            System.out.printf("Answer: %d\n", x - y);
            break;
          }
          else {
            System.out.println("Invalid input entered. Terminating...");
            break;
          }
        }
        else {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
      case ("multiply"):
        System.out.println("Enter two doubles:");
        if (input.hasNextDouble()) {
          f = input.nextDouble();
          if (input.hasNextDouble()) {
            g = input.nextDouble();
            System.out.printf("Answer: %.2f\n", f * g);
            break;
          }
          else {
            System.out.println("Invalid input entered. Terminating...");
            break;
          }
        }
        else {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
      case ("divide"):
        System.out.println("Enter two doubles:");
        if (input.hasNextDouble()) {
          f = input.nextDouble();
          if (input.hasNextDouble()) {
            g = input.nextDouble();
            if (g != 0) {
              System.out.printf("Answer: %.2f\n", f / g);
              break;
            }
          }
          else {
            System.out.println("Invalid input entered. Terminating...");
            break;
          }
        }
        else {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
      default:
        System.out.println("Invalid input entered. Terminating...");
    }
  }
}
