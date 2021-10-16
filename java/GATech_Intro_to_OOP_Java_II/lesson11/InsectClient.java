public class InsectClient {
  public static void main(String[] args) {
    Insect bee = new Insect(0.5);
    Insect ant = new Insect(0.1, 1, 1);
    Insect emp = new Insect();

    System.out.printf("\nbee:\n%.2f\n%d\n%d\n", bee.getWeight(),
        bee.getX(), bee.getY());
    System.out.printf("\nant:\n%.2f\n%d\n%d\n", ant.getWeight(),
        ant.getX(), ant.getY());
    System.out.printf("\nemp:\n%.2f\n%d\n%d\n\n", emp.getWeight(),
        emp.getX(), emp.getY());

    System.out.println(bee);

    System.out.println(Insect.randomFact());
  }
}
