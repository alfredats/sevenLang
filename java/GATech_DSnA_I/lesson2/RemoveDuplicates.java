import java.util.Random;
import java.util.Arrays;

public class RemoveDuplicates extends LinkedList {
  public static void main(String[] args) {
    Random rnd = new Random();
    LinkedList<Integer> LL = new LinkedList<>();
    
    Integer[] intArr = new Integer[10];
    for (int i = 0; i < 10; i++) {
      intArr[i] = rnd.nextInt(10);
    }
    
    Arrays.sort(intArr);
    for (int i = 0; i < 10; i++) {
      LL.addToBack(intArr[i]);
    }

    System.out.println(LL.toString());
    LL.removeDuplicates();   
    System.out.println(LL.toString());
  }

}
