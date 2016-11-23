package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by shuaipeng on 11/9/16.
 */
public class Q21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);//use dummy head to simplify linked list operations
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;//don't forget to move the tail
        }
        if (l1 == null)
            tail.next = l2;
        else
            tail.next = l1;
        return head.next;
    }
}
