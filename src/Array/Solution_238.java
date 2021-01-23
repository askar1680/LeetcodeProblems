package Array;

import java.util.Arrays;

public class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int temp = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            result[i] = temp;
        }
        temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp *= nums[i - 1];
            result[i] *= temp;
        }

        return result;
    }
}
