package Heap;

import java.util.PriorityQueue;

public class Solution_295 {
    class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
            minHeap = new PriorityQueue<Integer>();
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
                maxHeap.add(num);
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(num);
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return 1.0 * maxHeap.peek();
            } else {
                double sum = minHeap.peek() + maxHeap.peek();
                return sum / 2.0;
            }
        }
    }
}
