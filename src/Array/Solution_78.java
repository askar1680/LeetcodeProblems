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
}
