package Array;

public class Solution_643 {
    public double findMaxAverage(int[] nums, int k) {
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        int max = temp;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            temp -= nums[i - 1];
            temp += nums[i + k - 1];
            max = Math.max(temp, max);
        }
        return (double) max / k;
    }
}
