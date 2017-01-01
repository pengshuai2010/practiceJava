package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/31/16.
 */
public class Q141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        //concise and elegant
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
