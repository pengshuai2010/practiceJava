package lintCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by speng on 9/3/16.
 */
public class Q104mergeKSortedLists {
    public static void main(String[] args) {
        ListNode.printList(new Q104mergeKSortedLists().mergeKLists(Arrays.asList(
                new ListNode(2).setNext(new ListNode(4)),
                null,
                new ListNode(-1),
                new ListNode(-2).setNext(new ListNode(0).setNext(new ListNode(2))))));
    }

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // PriorityQueue is backed by heap data structure
        if (lists == null || lists.size() == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // if lambda is supported
//        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(),
//                (ListNode n1, ListNode n2) -> n1.val - n2.val);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(),
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode listNode, ListNode t1) {
                        return listNode.val - t1.val;
                    }
                });
        for (ListNode node : lists)
            // null is not allowed in a PriorityQueue
            if (node != null)
                heap.offer(node);
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null)
                heap.offer(node.next);
            tail.next = node;
            tail = tail.next;
        }
        // when rearrange a linked list, remember to set the last node's next to null!
        tail.next = null;// don't forget this!
        return dummy.next;
    }
}
