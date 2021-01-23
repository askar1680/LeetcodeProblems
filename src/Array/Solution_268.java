package Array;

public class Solution_268 {
    public int missingNumber(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i] - i;
        }
        return nums.length - temp;
    }
}
