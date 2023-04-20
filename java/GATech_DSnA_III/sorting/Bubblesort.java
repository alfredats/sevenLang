import java.util.Arrays;

public class Bubblesort {
  public static void main(String[] args) {
    int[] a = new int[] { 4, 5, 3, 1, 2, 6, 7 };
    System.out.println(Arrays.toString(a));
    bubblesort(a);
    System.out.println(Arrays.toString(a));
  }

  public static void bubblesort(int[] nums) {
    int t = nums.length - 1;
    int ls = t;
    while(t>0) {
      int h = 0;
      while (h < t) {
        if (nums[h] > nums[h+1]) {
          nums[h] += nums[h+1];
          nums[h+1] = nums[h] - nums[h+1];
          nums[h] = nums[h] - nums[h+1];
          ls = h;
        }
        h++;
      }
      t = Math.min(ls, t-1);
    }
  }
}
