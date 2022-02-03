public class SinglyLinkedListTest {

  public static void main(String[] args) {

    System.out.println("\n-----------------------");
    System.out.println("Tests: SinglyLinkedList");
    System.out.println("-----------------------\n");

    SinglyLinkedList<Integer> LL1 = new SinglyLinkedList<>(); 
    SinglyLinkedList<Integer> LL2 = new SinglyLinkedList<>(); 

    System.out.println("addToFront"); 
    System.out.println("LL1 initial: " + LL1.toString());
    try { LL1.addToFront(null); }
    catch (IllegalArgumentException e) { System.out.println("Throws IllegalArgumentException when given null as argument"); }
    LL1.addToFront(2);
    System.out.println("add 2 to front: " + LL1.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL1.getHead().toString(), LL1.getTail().toString(), LL1.size());
    try { System.out.println(LL1.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }
    LL1.addToFront(1);
    System.out.println("add 1 to front: " + LL1.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL1.getHead().toString(), LL1.getTail().toString(), LL1.size());
    try { System.out.println(LL1.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }
    LL1.addToFront(0);
    System.out.println("add 0 to front: " + LL1.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL1.getHead().toString(), LL1.getTail().toString(), LL1.size());
    try { System.out.println(LL1.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }


    System.out.println("\n-----------------------");

    System.out.println("addToBack"); 
    System.out.println("LL2 initial: " + LL2.toString());
    try { LL2.addToBack(null); }
    catch (IllegalArgumentException e) { System.out.println("Throws IllegalArgumentException when given null as argument"); }
    LL2.addToBack(2);
    System.out.println("add 2 to back: " + LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }
    LL2.addToBack(3);
    System.out.println("add 3 to back: " + LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }
    LL2.addToBack(4);
    System.out.println("add 4 to back: " + LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d\n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.println("\n-----------------------");
    
    System.out.println("removeFromFront");
    System.out.println("LL1 initial: " + LL1.toString());
    System.out.printf("remove %d from front: %s%n", LL1.removeFromFront(), LL1.toString());
    System.out.printf("head: %s, tail: %s, size: %d%n", LL1.getHead().toString(), LL1.getTail().toString(), LL1.size());
    try { System.out.println(LL1.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.printf("remove %d from front: %s%n", LL1.removeFromFront(), LL1.toString());
    System.out.printf("head: %s, tail: %s, size: %d%n", LL1.getHead().toString(), LL1.getTail().toString(), LL1.size());
    try { System.out.println(LL1.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.printf("remove %d from front: %s%n", LL1.removeFromFront(), LL1.toString());
    try {LL1.getHead().toString(); }
    catch (NullPointerException e) { System.out.printf("head: null, "); }
    try {LL1.getTail().toString(); }
    catch (NullPointerException e) { System.out.printf("tail: null, "); }
    System.out.printf("size: %d%n", LL1.size());

    System.out.println("\n-----------------------");
    
    System.out.println("removeFromBack");
    System.out.println("LL2 initial: " + LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d%n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.printf("remove %d from back: %s%n", LL2.removeFromBack(), LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d%n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.printf("remove %d from back: %s%n", LL2.removeFromBack(), LL2.toString());
    System.out.printf("head: %s, tail: %s, size: %d%n", LL2.getHead().toString(), LL2.getTail().toString(), LL2.size());
    try { System.out.println(LL2.getTail().getNext().toString()); }
    catch (NullPointerException e) { System.out.println("Tail correctly points to null"); }

    System.out.printf("remove %d from front: %s%n", LL2.removeFromBack(), LL2.toString());
    try {LL2.getHead().toString(); }
    catch (NullPointerException e) { System.out.printf("head: null, "); }
    try {LL2.getTail().toString(); }
    catch (NullPointerException e) { System.out.printf("tail: null, "); }
    System.out.printf("size: %d%n", LL2.size());


  }
}
