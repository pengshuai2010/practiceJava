package leetCode;

import basicAlgorithms.ListNode;

import java.util.PriorityQueue;

public class Q23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Clarifying quesions: will any of lists be null?
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) { // in case any list is empty
                minHeap.add(list);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.remove();
            tail.next = minNode;
            tail = tail.next;
            ListNode nextNode = minNode.next;
            minNode.next = null;
            if (nextNode != null) { // check for end of this list
                minHeap.add(nextNode);
            }
        }
        return dummy.next;
    }
}
