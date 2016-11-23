package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by shuaipeng on 11/14/16.
 */
public class Q61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 0)
            return null;
        if (head == null || head.next == null)
            return head;
        int len = 0;
        for (ListNode p = head; p != null; p = p.next)
            len++;
        k = k % len;
        if (k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode takenOff = slow.next;
        slow.next = null;
        fast.next = head;
        return takenOff;
    }
}
