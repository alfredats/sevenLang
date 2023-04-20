import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class QuickSort {

    private static Comparator<Integer> ic = (Integer a, Integer b) -> { return Integer.compare(a, b); };
    private static Random rand = new Random();

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 6, 4, 5, 3, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(a));
        quicksort(a, ic, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static <T> void swap(T[] arr, int i1, int i2) {
        T tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static <T> void quicksort(T[] arr, Comparator<T> cmp, int h, int t) {
        if (t-h < 1) { return; }
        int pind = h + rand.nextInt(t-h);
        T pval = arr[pind];

        swap(arr, h, pind);

        int i = h + 1; int j = t;
        while (i<=j) {
            while (i <= j && cmp.compare(arr[i], pval) <= 0) {
                i++;
            }
            while (i <= j && cmp.compare(arr[j], pval) >= 0) {
                j--;
            }
            if (i<=j) {
                swap(arr, i, j);
                i++; j--;
            }
        }
        swap(arr, h, j);
        quicksort(arr, cmp, h, j-1);
        quicksort(arr, cmp, j+1, t);
    }
}
