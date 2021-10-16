import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[100];
    Random rand = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }

    System.out.println("Before sorting: " + Arrays.toString(numbers));
    insertionSort(numbers);
    System.out.println("After sorting: " + Arrays.toString(numbers));
  }

  public static <T extends Comparable<T>> void insertionSort(T[] arr) {
    int currInd;
    T currItem;
    for (int i = 1; i < arr.length; i++) {
      currInd = i;
      currItem = arr[i];

      while (currInd > 0 && currItem.compareTo(arr[currInd-1]) < 0) {
        arr[currInd] = arr[currInd - 1]; 
        currInd--;
      }
      
      arr[currInd] = currItem;
    }

  }
}
