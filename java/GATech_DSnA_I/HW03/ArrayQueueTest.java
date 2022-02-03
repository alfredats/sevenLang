import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueueTest extends ArrayQueue {
  public static void main(String[] args) {
    ArrayQueue<Integer> aq = new ArrayQueue<>();
    ArrayQueue<Integer> sq = new ArrayQueue<>();
    ArrayQueue<Integer> eq = new ArrayQueue<>();

    Integer[] sa = {null, null, null, null, null, null, null, null,0};
    sq.setBackingArray(sa);
    sq.setFront(8);
    sq.setSize(1);

    System.out.println("\n----------------------");
    System.out.println("Array Queue Tests");
    System.out.println("----------------------\n");

    System.out.println("null array queue: " + Arrays.toString(aq.getBackingArray()));
    System.out.println("staggered array queue: " + Arrays.toString(sq.getBackingArray()));

    System.out.println("----------------------\n");
    
    System.out.println("enqueue()\n");

    try {aq.enqueue(null); }
    catch (IllegalArgumentException e) { System.out.println("Throws IAE on null argument"); }

    for (int i = 0; i<9; i++) {
      aq.enqueue(i);
    }
    System.out.println("enqueue 1 - 7: "+ Arrays.toString(aq.getBackingArray()));
    
    aq.enqueue(9);
    System.out.println("resizes backing array when required: " + Arrays.toString(aq.getBackingArray()));

    sq.enqueue(1);
    System.out.println("circles back when available: " + Arrays.toString(sq.getBackingArray()));

    System.out.println("----------------------\n");
    
    System.out.println("dequeue()\n");

    try {eq.dequeue();}
    catch (NoSuchElementException e) { System.out.println("Throws NSEE on empty arrrayqueue"); }
    int foo;
    foo = sq.dequeue();
    System.out.printf("circles back when dequeuing: %s, front: %d%n", Arrays.toString(sq.getBackingArray()), sq.getFront());
    foo = sq.dequeue();
    System.out.printf("circles back when dequeuing: %s, front: %d%n", Arrays.toString(sq.getBackingArray()), sq.getFront());

  }
}
