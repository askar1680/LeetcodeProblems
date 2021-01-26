package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution_347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a,b) -> countMap.get(a) - countMap.get(b)
        );

        for (int i: countMap.keySet()) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
