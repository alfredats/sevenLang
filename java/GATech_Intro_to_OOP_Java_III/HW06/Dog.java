public class Dog extends Pet {
  private double droolRate;

  public Dog(String name, double health, 
      int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = (droolRate <= 0.0) ? 0.5 : droolRate;
  }

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public double getDroolRate() {
    return this.droolRate;
  };

  public int treat() {
    double pl = (double)getPainLevel();
    double h = getHealth();
    super.heal();

    if (droolRate < 3.5) {
      return (int)Math.ceil((pl* 2) / h);
    } else if (droolRate <= 7.5) {
      return (int)Math.ceil(pl/h);
    } else {
      return (int)Math.ceil(pl/(h* 2));
    }
  };

  public void speak() {
    super.speak();
    String pStr = (this.getPainLevel() > 5) ? "BARK " : "bark ";
    for (int i = 0; i < getPainLevel(); i++) {
      System.out.printf(pStr);
    }
    System.out.println();
  }

  public boolean equals(Object o) {
    if (o instanceof Dog) {
      Dog d = (Dog) o;
      return (super.equals(d)) && (d.getDroolRate() == getDroolRate());
    }
    return false;
  }

  //public static void main(String[] args) {
    //Dog d1 = new Dog("spot", 0.9, 6, 0);
    //Dog d2 = new Dog("bingo", 0.9, 4, 10.0);
    //d1.speak();
    //d2.speak();
    
    //System.out.printf("%f, %f\n", d1.getDroolRate(), d2.getDroolRate());
    //System.out.printf("%d, %d\n", d1.treat(), d2.treat());

    //System.out.println(d1.equals(d2));
    //System.out.println(d1.equals(d1));
  //}


}
