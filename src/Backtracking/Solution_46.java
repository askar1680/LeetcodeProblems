package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        generate(
                list,
                new ArrayList<>(),
                new boolean[nums.length],
                nums
        );
        return list;
    }

    private void generate(
            List<List<Integer>> list,
            List<Integer> current,
            boolean[] visited,
            int[] nums
    ) {
        if (current.size() == nums.length) list.add(new ArrayList<>(current));
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                generate(list, current, visited, nums);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
