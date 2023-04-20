import java.util.NoSuchElementException;
import java.util.Arrays;

public class MinHeapTest {
  public static void main(String[] args) {
    MinHeap<Integer> h0 = new MinHeap<>();
    MinHeap<Integer> h1 = new MinHeap<>();
    MinHeap<Integer> h2 = new MinHeap<>(new Integer[]{0, 1, 2, 4, 3, 5, 7, 6, 8, 9, 10});
    
    // test cases for add()
    // 1) singular add
    // 2) small tree
    // 3) null input
    // 4) big tree + resize

    try {
      h0.add(null);
    } catch (IllegalArgumentException e) {
      System.out.println("null entry caught");
    }

    for (int i = 12; i > 0; i--) {
      h1.add(i);
    }
    System.out.println(Arrays.toString(h1.getBackingArray()));

    h1.add(13);
    System.out.println(Arrays.toString(h1.getBackingArray()));

    h1.add(14);
    System.out.println(Arrays.toString(h1.getBackingArray()));


    // test cases for remove()
    // 1) empty tree
    // 2) 

    try {
      h0.remove();
    } catch (NoSuchElementException e) {
      System.out.println("empty tree");
    }

    System.out.println("Remove " + h1.remove() + ", backingArr: " + Arrays.toString(h1.getBackingArray()));
    System.out.println("Remove " + h2.remove() + ", backingArr: " + Arrays.toString(h2.getBackingArray()));

  }
}
