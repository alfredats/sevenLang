public class Insect {
  // instance variables
  private double weight;
  private int x;
  private int y;

  // defaults
  private static final double DEFAULT_WEIGHT = 0.0;
  private static final int DEFAULT_X = 0;
  private static final int DEFAULT_Y = 0;

  // DIST_WEIGHT_LOSS_FACTOR being public doesn't break encapsulation,
  // because it is declared as a constant and cannot be modified by
  // external classes (or even modified at all);
  public static final double DIST_WEIGHT_LOSS_FACTOR = .0001;
  // in the case of population however, because it is not a constant,
  // we need to use the 'private' keyword to enforce encapsulation,
  // given that it is 'static' and all instances of Insect share the
  // same reference
  private static int population = 0;
  private static String[] FACTS = {
    "There are more than 1,000,000 insect species.",
    "Insects are cold-blooded",
    "Spiders are not considered insects.",
    "The two main groups of insects are winged and wingless."};


  // constructor methods
  public Insect() {
    this(DEFAULT_WEIGHT,DEFAULT_X,DEFAULT_Y);
  }

  public Insect(double initWeight) {
    this(initWeight,DEFAULT_X,DEFAULT_Y);
  }

  public Insect(double weight, int x, int y) {
    this.weight = weight;
    this.x = x;
    this.y = y;
    population++;
  }

  // toString
  public String toString() {
    return "weight: " + weight + ", x: " + x + ", y: " + y;
  }



  // test method
  public static void main(String[] args) {
    Insect bee = new Insect(1.0, 10, 10);
    Insect ant = new Insect(0.5, 0, 1);

    bee.move(1,10);
    ant.move(-300,400);

    System.out.println(bee.randomFact());
  }

  // accessors
  public double getWeight() {
    return weight;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  // mutators
  public void setX(int newX) {
    if (isLegalX(newX)) {
      x = newX;
    }
  }

  public void setY(int newY) {
    if (isLegalY(newY)) {
      y = newY;
    }
  }

  private static boolean isLegalX(int newX) {
    return (newX >= 0);
  }

  private static boolean isLegalY(int newY) {
    return (newY >= 0);
  }

  // methods
  public void eat(double amount) {
    System.out.println("Nibble Nibble");
    weight = weight + amount;
  }

  public void move(int newX, int newY) {
    double distance = calculateDistance(x,y,newX,newY);
    if (distance > 0) {
      x = newX;
      y = newY;
      weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
      System.out.printf("Moved %.2f units\n", distance);
    }
    else
      System.out.println("Staying put");
  }
  
  private static double calculateDistance(double x1, double y1,
                                          double x2, double y2) {
   return Math.sqrt((y2-y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)); 
  }

  public static String randomFact() {
    int ind = (int)(Math.random() * FACTS.length);
    return FACTS[ind];
  }
}
