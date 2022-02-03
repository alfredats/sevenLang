import java.util.NoSuchElementException;

public class BSTTest {
  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();
    BST<Integer> rooted = new BST<>();
    BST<Integer> twoElem = new BST<>();

    rooted.add(0);
    System.out.println("Removed " + rooted.remove(0) + ", bst: " + rooted.toString());

    twoElem.add(1);
    twoElem.add(0);
    System.out.println("Removed " + twoElem.remove(1) + ", bst: " + twoElem.toString());

    bst.add(8);
    System.out.println(bst.toString());

    bst.add(4);
    bst.add(12);
    System.out.println(bst.toString());

    bst.add(2);
    bst.add(5);
    System.out.println(bst.toString());
    
    bst.add(1);
    bst.add(3);
    bst.add(6);
    bst.add(7);
    System.out.println(bst.toString());

    bst.add(11);
    System.out.println(bst.toString());

    bst.add(13);
    bst.add(14);
    System.out.println(bst.toString());

    bst.add(0);
    System.out.println(bst.toString());

    try {
      bst.add(null);
    } catch (IllegalArgumentException e) {
      System.out.println("null entry caught");
    }

    bst.add(8);
    System.out.println(bst.toString());
    

    try {
      bst.remove(null);
    } catch (IllegalArgumentException e) {
      System.out.println("null entry caught");
    }

    try {
      bst.remove(99);
    } catch (NoSuchElementException e) {
      System.out.println("No such element");
    }

    System.out.println("Removed " + bst.remove(8) + ", bst: " + bst.toString());
    System.out.println("Removed " + bst.remove(6) + ", bst: " + bst.toString());
    System.out.println("Removed " + bst.remove(3) + ", bst: " + bst.toString());
    System.out.println("Removed " + bst.remove(1) + ", bst: " + bst.toString());

  }
}
