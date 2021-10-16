import java.util.Arrays; // for the toString method only
import java.util.Random;

public class MergeSort {
  public static void main(String[] args) {
    Integer[] numbers = new Integer[100];
    Random rand = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }
    System.out.println("Before sorting: " + Arrays.toString(numbers));
    long start = System.nanoTime();
    mergeSort(numbers, 0, numbers.length - 1);
    long end = System.nanoTime();
    System.out.println("After sorting: " + Arrays.toString(numbers));
    System.out.printf("Sorting took %f ms\n", ((end-start)/1000000D));
  }

  public static <T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) { // end is index-inclusive
    if (start == end) {
      return;
    } else if (start == end - 1) {
      if (arr[start].compareTo(arr[end]) < 0) {
        return;
      } else {
        T temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
      }
    }
    int anchor = (end - start)/2;

    mergeSort(arr, start, start+anchor);
    mergeSort(arr, start+anchor+1, end);
    merge(arr, start, start+anchor, end);
  }

  private static <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
    int leftSize = mid - start + 1;
    int rightSize = end - mid;

    T[] leftHalf = Arrays.copyOfRange(arr, start, start+leftSize);
    T[] rightHalf = Arrays.copyOfRange(arr, mid+1, mid+1+rightSize);

    int i = 0; int j = 0; int k = start;
    while (i < leftSize && j < rightSize) {
      if (leftHalf[i].compareTo(rightHalf[j]) <= 0) {
        arr[k] = leftHalf[i];
        i++;
      } else {
        arr[k] = rightHalf[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) {
      arr[k] = leftHalf[i];
      i++; k++;
    }

    while (j < rightSize) {
      arr[k] = rightHalf[j];
      j++; k++;
    }
  }
}
