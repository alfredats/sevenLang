public class FlyingInsect extends Insect {
  protected int numWings;

  private static final int DEFAULT_WINGS = 0;

  public FlyingInsect() {
    this(DEFAULT_WINGS);
  }

  public FlyingInsect(int numWings) {
    super();
    this.numWings = numWings; 
  }

  public FlyingInsect(double weight, int x, int y, int numWings) {
    super(weight, x, y);
    this.numWings = numWings;
  }

  public int getNumWings() {
    return numWings;
  }

  public String toString() {
    return super.toString() + ", numWings: " + numWings;
  }

  public static void main(String[] args) {
    Insect wasp = new FlyingInsect(1, 0, 0, 4);
    System.out.println(wasp);
  }
}
