public class Pond {
    public static void main(String[] args) {
      Frog fr1 = new Frog("Peepo");
      Frog fr2 = new Frog("Pepe", 10, 15);
      Frog fr3 = new Frog("Peepaw", 4.6, 5);
      Frog fr4 = new Frog("Blep", 25, 30);  

      Fly fl1 = new Fly(1.0, 3.0);
      Fly fl2 = new Fly(6.0);
      Fly fl3 = new Fly(30,50);

      
      fr1.setSpecies("1331 Frogs");
      System.out.println(fr1);
      fr1.eat(fl2);
      System.out.println(fl2);
      fr1.grow(8);
      fr1.eat(fl2);
      System.out.println(fl2);
      System.out.println(fr1);
      System.out.println(fr4);
      fr3.grow(4);
      System.out.println(fr3);
      System.out.println(fr2);
    }
}
