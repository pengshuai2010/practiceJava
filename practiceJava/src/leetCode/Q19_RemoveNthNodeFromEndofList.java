package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by shuaipeng on 11/8/16.
 */
public class Q19_RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        // TODO add tests [1,2, 3] 1, [1, 2, 3] 3, [1] 1
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        //assuming n is valid
        // the head node might be the node to remove, using a dummy head can simplify the handling of this case
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // the slow point should stop before the node to delete, hence move fast pointer (n + 1) steps instead of n
        for (int i = 0; i < n + 1; i++)
            fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
