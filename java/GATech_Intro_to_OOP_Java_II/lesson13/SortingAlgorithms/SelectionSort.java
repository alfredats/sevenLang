import java.util.Arrays;
public class SelectionSort {
  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    int minIndex;
    T temp;

    for (int i = 0; i < arr.length; i++) {
      minIndex = i;
      for(int j = i+1; j < arr.length; j++) {
        if (arr[j].compareTo(arr[minIndex]) < 0) {
          minIndex = j;
        }
      }
      temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }

  public static void main(String[] args) {
    Integer[] ints = {1,5,6,3,2,4,8};
    System.out.println("Before sorting: " + Arrays.toString(ints));
    selectionSort(ints);
    System.out.println("After sorting: " + Arrays.toString(ints));
  }

}
