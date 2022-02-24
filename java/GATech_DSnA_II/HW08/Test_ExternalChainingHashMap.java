import java.util.Arrays;
import java.util.NoSuchElementException;

public class Test_ExternalChainingHashMap {
  public static void main(String[] args) {
    ExternalChainingHashMap<Integer, Integer> initial = new ExternalChainingHashMap<>();

    // catching null
    try {
      initial.put(null,1);
    } catch (IllegalArgumentException e) {
      System.out.println("put catches null key");
    }

    try {
      initial.put(1,null);
    } catch (IllegalArgumentException e) {
      System.out.println("put catches null value");
    }
    System.out.println();

    // backing table insertions
    initial.put(5,5);
    printHashmap(initial);

    // chain functionality
    initial.put(6,6);
    initial.put(19,19);
    System.out.println("Chain returns value " + initial.put(6,10) + " for existing key 6");
    printHashmap(initial);

    // resizing
    for (int i = 1; i < 100; i += 13) {
      initial.put(i,i);
      if (i == 66) {
        printHashmap(initial);
      }
    }

    ExternalChainingHashMap<Integer, Integer> post = new ExternalChainingHashMap<>();
  
    try {
      post.remove(null);
    } catch (IllegalArgumentException e) {
      System.out.println("remove catches null key");
    }

    try {
      post.remove(20);
    } catch (NoSuchElementException e) {
      System.out.println("remove catches non-existent key for empty index");
    }
    System.out.println();

    post.put(5,5);
    System.out.println("Remove " + post.remove(5));
    printHashmap(post);

    for (int i = 1; i < 54; i += 13) {
      post.put(i,i);
    }
    printHashmap(post);


    try {
      post.remove(66);
    } catch (NoSuchElementException e) {
      System.out.println("remove catches non-existent key for existing chain");
    }

    System.out.println();
    System.out.println("Remove " + post.remove(53));
    printHashmap(post);

    System.out.println("Remove " + post.remove(1));
    printHashmap(post);

    System.out.println("Remove " + post.remove(27));
    printHashmap(post);

  }

  public static void printHashmap(ExternalChainingHashMap hm) {
    ExternalChainingMapEntry[] table = hm.getTable();
    System.out.println(Arrays.toString(table));
    for (int i = 0; i < table.length; i++) {
      if (table[i] == null) { continue; }
      else {
        if (table[i].getNext() == null) { continue; }
        System.out.println("Chain at index " + i + ": " + printChain(table[i]));
      }
    }
    System.out.println("Size: " + hm.size());
    System.out.println("LF: " + hm.lf());
    System.out.println();
  }

  public static String printChain(ExternalChainingMapEntry head) {
    if (head == null) {
      return "";
    }
    String outStr = "" + head.toString();
    while (head.getNext() != null) {
      head = head.getNext();
      outStr += (", " + head.toString());
    }
    return outStr;
  }
}
