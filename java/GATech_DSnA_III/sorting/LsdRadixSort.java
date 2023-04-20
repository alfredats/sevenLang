import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class LsdRadixSort {

    private static Comparator<Integer> ic = (Integer a, Integer b) -> { return Integer.compare(a, b); };

    public static void main(String[] args) {
        int[] a = new int[] {-800, -796, -785, -2147483648, -138, 104, 151, 258, 543, 908};
        int[] b = new int[] {2147483647, 1147483647};
        int[] c = new int[] {-2, -111, 1, 3};
        int[] d = new int[] {-9, -2147483648, -2147483648};
        // System.out.println(Arrays.toString(a));
        // lsdRadix(a);
        // System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        lsdRadix(b);
        System.out.println(Arrays.toString(b));
        // System.out.println(Arrays.toString(c));
        // lsdRadix(c);
        // System.out.println(Arrays.toString(c));
        // System.out.println(Arrays.toString(d));
        // lsdRadix(d);
        // System.out.println(Arrays.toString(d));
    }

    public static void lsdRadix(int[] arr) {
        LinkedList<LinkedList<Integer>> buckets = new LinkedList<LinkedList<Integer>>();
        for (int i = 0; i < 19; i++) { buckets.add(new LinkedList<Integer>()); }
        int max10log = 0;
        for (int j : arr) { max10log = Math.max(max10log, (int) Math.log10(Math.abs((long) j))); } // cheeky buggers chose negative lim as an input
        System.out.println("max10log: " + max10log);

        for (int k = 0; k < max10log + 1; k++) {
            long mod = (long) Math.pow(10, k+1);
            long div = (long) Math.pow(10, k);
            System.out.println("mod: " + mod + ", div: " + div);
            for (int ki : arr) {
                int place = (int) (((long) ki % mod) / div) + 9; // +9 to translate negatives to positive
                buckets.get(place).add(ki);
                System.out.println(ki + ", lsd: " + (place-9) + ", bucket: " + place);
            }
            int idx = 0;
            for (LinkedList<Integer> ll : buckets) {
                while (!ll.isEmpty()) {
                    arr[idx++] = ll.removeFirst().intValue();
                }
            }
        }
    }


}
