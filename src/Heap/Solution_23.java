package Heap;

import java.util.PriorityQueue;

public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node: lists) {
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode answer = new ListNode(0);
        ListNode temp = answer;
        while (pq.size() != 0) {
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }

        return answer.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
