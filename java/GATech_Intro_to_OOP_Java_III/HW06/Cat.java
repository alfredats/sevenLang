public class Cat extends Pet {
  private int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name,health,painLevel);
    this.miceCaught = (miceCaught < 0) ? 0 : miceCaught;
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught() {
    return this.miceCaught;
  }

  public int treat() {
    double pl = (double)getPainLevel();
    double h = getHealth(); 
    super.heal();

    if (miceCaught < 4) {
      return (int)Math.ceil((pl*2)/h);
    } else if (miceCaught < 8) {
      return (int)Math.ceil(pl/h);
    } else {
      return (int)Math.ceil(pl/(h*2));
    }
  }

  public void speak() {
    super.speak();
    String outStr = (getPainLevel() > 5) ? "MEOW " : "meow ";
    for (int i = 0; i < miceCaught; i++) {
      System.out.printf(outStr); 
    }
    System.out.println();
  }

  public boolean equals(Object o) {
    if (o instanceof Cat) {
      Cat c = (Cat) o;
      return super.equals(c) && (c.getMiceCaught() == miceCaught);
    } 
    return false;
  }

  //public static void main(String[] args) {
    //Cat c1 = new Cat("jingles", 0.9, 6, 3);
    //Cat c2 = new Cat("twiddles", 0.9, 4, 5);

    //c1.speak();
    //c2.speak();

    //System.out.printf("%d, %d\n", c1.treat(), c2.treat());

    //System.out.println(c1.equals(c2));
    //System.out.println(c1.equals(c1));
  //}


}
