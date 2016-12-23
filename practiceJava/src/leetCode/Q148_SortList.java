package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/22/16.
 */
public class Q148_SortList {
    /**
     * merge sort, takes O(nlog(n)) time. And O(log(n)) space because of recursion.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int count = 0;
        //pay attention to corner case when there are only two elements.
        //we should dived the list into two lists of length 1.
        //In the following while loop, if we use while (fast != null), l1 will have length 2, l2 will be empty, thus
        //causing infinite recursion.
        while (fast.next != null) {
            fast = fast.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        return mergeSortedLists(l1, l2);
    }

    private ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        ListNode dummy3 = new ListNode(0);
        ListNode tail = dummy3;
        while (dummy1.next != null && dummy2.next != null) {
            ListNode p = null;
            if (dummy1.next.val < dummy2.next.val) {
                p = dummy1.next;
                dummy1.next = dummy1.next.next;
            } else {
                p = dummy2.next;
                dummy2.next = dummy2.next.next;
            }
            tail.next = p;
            tail = tail.next;
        }
        if (dummy1.next != null) {
            tail.next = dummy1.next;
        } else {
            tail.next = dummy2.next;
        }
        return dummy3.next;
    }
}
