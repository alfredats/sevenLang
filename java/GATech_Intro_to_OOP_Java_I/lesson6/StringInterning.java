public class StringInterning {
  public static void main(String[] args) {
    String x = "park";
    String y = "park";
    String z = new String("park");

    System.out.printf("x: %s\n", x);
    System.out.printf("y: %s\n", y);
    System.out.printf("z: %s\n", z);

    if (x == y) {
      System.out.println("x and y are aliases");
    }
    if (x != z) {
      System.out.println("x and z are not aliases");
    }
    if (x.equals(y) & y.equals(z)) {
      System.out.println("x, y, and z have the same string value");
    }

  }
}
