package Array;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i: nums) {
            temp += i;
            if (i > temp) temp = i;
            max = Math.max(temp, max);
        }
        return max;
    }
}
