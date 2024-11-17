package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/5/16.
 */
public class Q86_PartitionList {
    public ListNode partition1(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = new ListNode(0);
        l1.next = head;
        ListNode l2 = new ListNode(0);
        ListNode tail = l2;
        ListNode p = l1;
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode tmp = p.next;
                p.next = p.next.next;
                tail.next = tmp;
                tail = tail.next;
            } else {
                p = p.next;
            }
        }
        tail.next = l1.next;
        return l2.next;
    }

    /**
     * The basic idea is to have two lists: one for nodes smaller than x; the other for nodes greater or equal to x.
     * We delete nodes one by one from the orignal list, adding each node to either of the two lists.
     * The logic of this solution is simpler than only using one extra list, and thus less error-prone.
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode greaterDummy = new ListNode(0);
        ListNode greaterTail = greaterDummy;
        ListNode smallerDummy = new ListNode(0);
        ListNode smallerTail = smallerDummy;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (dummy.next != null) {
            ListNode node = dummy.next;
            dummy.next = dummy.next.next;
            node.next = null;
            if (node.val < x) {
                smallerTail.next = node;
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = node;
                greaterTail = greaterTail.next;
            }
        }
        smallerTail.next = greaterDummy.next;
        return smallerDummy.next;
    }
}
