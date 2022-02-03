import java.util.NoSuchElementException;
import java.util.Arrays;

public class ArrayListTest extends ArrayList {

  public static void main(String[] args) {
    // Basic functionality
    ArrayList<Integer> nual = new ArrayList<Integer>();
    nual.addToFront(1);
    System.out.println("Add 1 to front:\nArray: " + Arrays.toString(nual.getBackingArray()) + "\nSize: " + nual.size());
    System.out.print("\n");

    nual.addToBack(2);
    System.out.println("Add 2 to back:\nArray: " + Arrays.toString(nual.getBackingArray()) + "\nSize: " + nual.size());
    System.out.print("\n");

    Integer headFR = nual.removeFromFront(); 
    System.out.println("removeFromFront removed " + headFR + "\nArray: " + Arrays.toString(nual.getBackingArray())+ 
        "\nSize: " + nual.size());
    System.out.print("\n");

    Integer tailFR = nual.removeFromBack(); 
    System.out.println("removeFromBack removed " + tailFR + "\nArray: " + Arrays.toString(nual.getBackingArray()) +
        "\nSize: " + nual.size());
    System.out.print("\n");

    // Null checking
    ArrayList<Integer> nullh = new ArrayList<Integer>();
    try {
      nullh.addToFront(null);
    } catch (IllegalArgumentException e) {
      System.err.println(e);
      System.out.println("addToFront throws IllegalArgumentException when fed null object");
    }

    try {
      nullh.addToBack(null);
    } catch (IllegalArgumentException e) {
      System.err.println(e);
      System.out.println("addToBack throws IllegalArgumentException when fed null object");
    }
    System.out.println();

    try {
      nual.removeFromFront();
    } catch (NoSuchElementException e) {
      System.err.println(e);
      System.out.println("removeFromFront throws NoSuchElementException when acting on empty arraylist");
    }

    try {
      nual.removeFromBack();
    } catch (NoSuchElementException e) {
      System.err.println(e);
      System.out.println("removeFromBack throws NoSuchElementException when acting on empty arraylist");
    }
    System.out.println();

    // resizing checks
    ArrayList<Integer> frontresize = new ArrayList<Integer>();
    ArrayList<Integer> backresize = new ArrayList<Integer>();
    for (int i = 0; i < 18; i++) {
      frontresize.addToFront(17-i);
      backresize.addToBack(i);
    }
    System.out.println("(addToFront) Array: " + Arrays.toString(frontresize.getBackingArray()) + 
        "\nSize: " + frontresize.size());
    System.out.println("(addToBack) Array: " + Arrays.toString(backresize.getBackingArray()) + 
        "\nSize: " + backresize.size());

    System.out.println("tests complete");
    return;
  }
}
