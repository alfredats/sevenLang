public class Wolf extends Canine implements Groomable, Comparable<Wolf> {
  protected int rank; // recall that protected only allows members
  // within the same package, or subclasses to modify it
  

  public Wolf(int rank) {
    this.rank = rank;
  }

  public int getRank() {
    return rank;
  }

  public void groom() {
    System.out.println("Don't you dare.");
  }

  //public int compareTo(Object anotherWolf) {
    //return -(rank - ((Wolf)anotherWolf).rank);
  //}
  //
  //By using the typed Comparable interface, we restrict methods that
  //comparable necessitates to take only objects of the type mentioned
  public int compareTo(Wolf anotherWolf) {
    return -(rank - anotherWolf.rank);
  }

  public static void main(String[] args) {
    Wolf alpha = new Wolf(1);
    Wolf puppy = new Wolf(10);
    System.out.println(alpha.compareTo(puppy));
    //System.out.println(alpha.compareTo("hello world"));
  }
}

