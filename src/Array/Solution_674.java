package Array;

public class Solution_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int maxLength = 1;
        int temp = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                temp = 0;
            }
            temp++;
            maxLength = Math.max(temp, maxLength);
        }

        return maxLength;
    }
}
