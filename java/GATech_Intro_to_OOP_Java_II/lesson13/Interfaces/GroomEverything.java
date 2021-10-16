public class GroomEverything {
  public static void main(String[] args) {
    Groomable[] groom1 = {
      new Poodle(),
      new Wolf(),
      new Car()
    };

    for (Groomable t : groom1) {
      t.groom();
    }

    // uncomment for the compile error
    //Object[] groom2 = {
      //new Poodle(),
      //new Wolf(),
      //new Car()
    //};

    //for (Object o : groom2) {
      //o.groom();
    //}
  }
}
