import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 4, 5, 3, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(a));
        insertionsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionsort(int[] nums) {
        int t = 0;
        while (t < nums.length) {
            int h = t;
            while (h != 0) {
                if (nums[h] < nums[h-1]) {
                    nums[h] += nums[h-1];
                    nums[h-1] = nums[h] - nums[h-1];
                    nums[h] = nums[h] - nums[h-1];
                }
                h--;
            }
            t++;
        }
    }

}
