import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[100];
    Random rand = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }
    System.out.println("Array to be searched: " 
        + Arrays.toString(numbers));
    Integer find = rand.nextInt(100);
    System.out.println("Integer to be found: " + find);
    System.out.println("Index in arr: " 
        + binarySearch(numbers,find));

  }
  
  public static <T extends Comparable<T>> int binarySearch(T[] arr, 
      T item) {
    int start = 0; int end = arr.length - 1; int anchor;

    while (start <= end) {
      anchor = (start + end)/2;
      if (item.compareTo(arr[anchor]) == 0) {
        return anchor;
      } else if (item.compareTo(arr[anchor]) < 0) {
        end = anchor-1;
      } else {
        start = anchor+1;
      }
    }

    return -1;
  }
}
