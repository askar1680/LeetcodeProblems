package Heap;

import java.util.PriorityQueue;

public class Solution_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] array: matrix) {
            for (int i: array) {
                pq.add(i);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}
