import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {

    private static Comparator<Integer> ic = (Integer a, Integer b) -> { return Integer.compare(a, b); };

    public static void main(String[] args) {
        Integer[] a = new Integer[] { 6, 4, 5, 3, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(a));
        mergesort(a, ic);
        System.out.println(Arrays.toString(a));
    }

    public static <T> void mergesort(T[] arr, Comparator<T> cmp) {
        if (arr.length <= 1) { return; }
        int len = arr.length;
        int m = arr.length/2;
        T[] l = Arrays.copyOfRange(arr, 0, m);
        T[] r = Arrays.copyOfRange(arr, m, len);

        mergesort(l, cmp);
        mergesort(r, cmp);

        int i = 0; int j = 0;
        while (i < l.length && j < r.length) {
            if (cmp.compare(l[i], r[j]) <= 0) {
                arr[i+j] = l[i];
                i++;
            } else {
                arr[i+j] = r[j];
                j++;
            }
        }
        while (i < l.length) {
            arr[i+j] = l[i]; i++;
        }
        while (j < r.length) {
            arr[i+j] = r[j]; j++;
        }
    }
}
