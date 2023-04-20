import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 4, 5, 3, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(a));
        selectionsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionsort(int[] nums) {
        int h = nums.length-1;
        while (h>=0) {
            int wm = h;
            for (int p = h; p >= 0; p--) {
                if (nums[p] > nums[wm]) {
                    wm = p;
                }
            }
            if (wm != h) {
                nums[wm] += nums[h];
                nums[h] = nums[wm] - nums[h];
                nums[wm] = nums[wm] - nums[h];
            }
            h--;
        }
    }

}
