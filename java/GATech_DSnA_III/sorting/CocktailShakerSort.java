import java.util.Arrays;

public class CocktailShakerSort {
    public static void main(String[] args) {
        int[] a = new int[] { 6, 4, 5, 3, 1, 2, 6, 7 };
        System.out.println(Arrays.toString(a));
        cocktailshaker(a);
        System.out.println(Arrays.toString(a));
    }

    public static void cocktailshaker(int[] nums) {
        boolean swapsMade=true;
        int startInd = 0;
        int endInd = nums.length-1;
        int ls = Integer.MAX_VALUE;
        while (swapsMade) {
            swapsMade=false;
            for (int i = startInd; i < endInd; i++) {
                if (nums[i] > nums[i+1]) {
                    nums[i] += nums[i+1];
                    nums[i+1] = nums[i] - nums[i+1];
                    nums[i] = nums[i] - nums[i+1];
                    swapsMade=true;
                    ls = i;
                }
            }
            endInd = Math.min(ls, endInd-1);
            if (swapsMade) {
                swapsMade=false;
                for (int i = endInd; i > startInd; i--) {
                    if (nums[i] < nums[i-1]) {
                        nums[i] += nums[i-1];
                        nums[i-1] = nums[i] - nums[i-1];
                        nums[i] = nums[i] - nums[i-1];
                        swapsMade=true;
                        ls = i;
                    }
                }
            }
            startInd = Math.max(ls, startInd +1);
        }
    }

}
