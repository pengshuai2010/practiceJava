package lintCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 2/11/17.
 */
public class Q599_InsertIntoACyclicSortedList {
    /**
     * @param head a list node in the list
     * @param x    an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode head, int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        ListNode p = head;
        do {
            if (p.val <= x && x <= p.next.val) {
                break;
            }
            if (p.val > p.next.val && (x >= p.val || x <= p.next.val)) {
                break;
            }
            p = p.next;
        } while (p != head);
        newNode.next = p.next;
        p.next = newNode;
        return head;
    }
}
