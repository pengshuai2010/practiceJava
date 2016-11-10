package leetCode;

import lintCode.ListNode;

/**
 * Created by shuaipeng on 11/9/16.
 */
public class Q24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);// use dummy head so we don't need to treat first two node specially
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode n1 = p.next;
            ListNode n2 = p.next.next;
            n1.next = n2.next;
            n2.next = n1;
            p.next = n2;
            p = p.next.next;
        }
        return dummy.next;
    }
}
