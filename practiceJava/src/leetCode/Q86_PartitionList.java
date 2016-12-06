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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = new ListNode(0);
        ListNode t1 = l1;
        ListNode l2 = new ListNode(0);
        ListNode t2 = l2;
        while (dummy.next != null) {
            ListNode tmp = dummy.next;
            dummy.next = dummy.next.next;
            if (tmp.val < x) {
                t1.next = tmp;
                t1 = t1.next;
            } else {
                t2.next = tmp;
                t2 = t2.next;
            }
        }
        t1.next = l2.next;
        //always remember to set the tail's next pointer to null! Another way is to set the next pointer of a deleted node
        // to null as soon as we delete it.
        t2.next = null;
        return l1.next;
    }
}
