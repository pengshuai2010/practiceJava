package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/4/16.
 */
public class Q82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                int duplicateVal = fast.val;
                while (slow.next != null && slow.next.val == duplicateVal) {
                    slow.next = slow.next.next;
                }
                fast = slow.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return dummy.next;
    }
}
