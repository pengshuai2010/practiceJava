package leetCode;

import basicAlgorithms.ListNode;

public class Q1721_SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        // will head be null? Is k guranteed to be valid? (k is less than or equal to the length)
        // can we simply update the value?
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(dummy);
        ListNode kthNode = getNode(dummy, k);
        ListNode backwardKthNode = getNode(dummy, length - k + 1);
        swapValue(kthNode, backwardKthNode);
        return dummy.next;
    }

    private int getLength(ListNode dummy) {
        ListNode p = dummy.next;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    private ListNode getNode(ListNode dummy, int k) {
        ListNode p = dummy;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        return p;
    }

    private void swapValue(ListNode node1, ListNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
