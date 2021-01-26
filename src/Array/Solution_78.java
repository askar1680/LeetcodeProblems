package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        fillList(list, nums, new ArrayList<>(), 0);
        return list;
    }

    private void fillList(List<List<Integer>> list, int[] nums, ArrayList<Integer> subset, int position) {
        list.add(new ArrayList<>(subset));
        for (int i = position; i < nums.length; i++) {
            subset.add(nums[i]);
            fillList(list, nums, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    // With bit manipulation
    private void fillList(
            List<List<Integer>> list,
            int[] nums
    ) {
        for (int bitMask = 0; bitMask < (1 << nums.length); bitMask++) {
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (getBit(bitMask, i) > 0) {
                    current.add(nums[i]);
                }
            }
            list.add(current);
        }
    }

    private int getBit(int n, int index) {
        return (n & (1 << index)) > 0 ? 1 : 0;
    }
}
