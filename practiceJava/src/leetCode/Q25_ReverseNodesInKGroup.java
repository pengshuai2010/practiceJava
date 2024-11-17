package leetCode;

import basicAlgorithms.ListNode;

public class Q25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < k && p != null; i++) {
            p = p.next;
        }
        if (p == null) {
            return head;
        }
        ListNode tmp = p.next;
        p.next = null;
        ListNode reversed = reverseKGroup(tmp, k);
        ListNode reversedHead = reverse(head);
        head.next = reversed;
        return reversedHead;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = null;
        ListNode q = head;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
    }
}
