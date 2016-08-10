package lintCode;

/**
 * Created by speng on 8/9/16.
 */
// https://www.cs.mtu.edu/~shene/PUBLICATIONS/1996/3Conline.pdf
public class Q98 {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode middle = findMiddle(head);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        middle.next = null;
        l1 = sortList(l1);
        l2 = sortList(l2);
        ListNode newHead = mergeList(l1, l2);
        return newHead;
    }

    ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            tail.next = p2;
        } else {
            tail.next = p1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[] {9, 8, 7, 6, 5});
        head = new Q98().sortList(head);
        ListNode.printList(head);
    }
}
