public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";

  private static int DEFAULT_AGE = 5;
  private static double DEFAULT_TONGUE_SPEED = 5;

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = (age > 1) && (age < 7);
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int)(ageInYears * 12), tongueSpeed);
  }

  public Frog(String name) {
    this(name, DEFAULT_AGE, DEFAULT_TONGUE_SPEED);
  }

  public static String getSpecies() {
    return species;
  }
  
  public static void setSpecies(String spec) {
    species = spec;
  }

  public void grow(int months) {
    for (int i = 0; i < months; i++) {
      if (age < 12) {
        tongueSpeed++;
      }
      else if ((tongueSpeed > 5) && (age >= 30)) {
        tongueSpeed--;
      }
    age++;
    }
    this.isFroglet = (age > 1) && (age < 7);
  }

  public void grow() {
    this.grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {}
    if (tongueSpeed > fly.getSpeed()) {
      if ((2 * fly.getMass()) > age) {
        grow();
      }
      fly.setMass(0);
    }
    else {
      fly.grow(1);
    }
  }
  
  public String toString() {
    double printTS = Math.round(tongueSpeed * 100) / 100.0;
    if (isFroglet) {
      return "My name is " + name + " and I'm a rare froglet! I'm " + age + " months old and my tongue has a speed of " + printTS+ ".";
    }
    else {
      return "My name is " + name + " and I'm a rare frog. I'm " + age + " months old and my tongue has a speed of " + printTS + ".";
    }
  }
}
