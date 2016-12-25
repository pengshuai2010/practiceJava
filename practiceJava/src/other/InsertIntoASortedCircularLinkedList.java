package other;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/24/16.
 */
public class InsertIntoASortedCircularLinkedList {
    public static void main(String[] args) {
        InsertIntoASortedCircularLinkedList solution = new InsertIntoASortedCircularLinkedList();
        ListNode head = solution.insert(null, new ListNode(1));
        solution.print(head);
        solution.insert(head, new ListNode(12));
        solution.print(head);
        solution.insert(head, new ListNode(5));
        solution.print(head);
    }

    ListNode insert(ListNode head, ListNode node) {
        if (node == null) {
            return head;
        }
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }
        if (node.val < head.val) {
            node.next = head.next;
            head.next = node;
            int tmp = head.val;
            head.val = node.val;
            node.val = tmp;
            return head;
        }
        ListNode p = head;
        while (p.next != head && node.val > p.next.val) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
        return head;
    }

    private void print(ListNode head) {
        ListNode p = head;
        do {
            System.out.print(p.val + ", ");
            p = p.next;
        } while (p != head);
        System.out.println();
    }
}
