package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 8/8/16.
 */
public class Q99 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{0, 1, 2, 3, 4});
        new Q99().reorderList(head);
        ListNode.printList(head);
    }

    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            list.add(tmp);
        }
        int p = 0, q = list.size() - 1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (p < q) {
            tail.next = list.get(p);
            tail = tail.next;
            tail.next = list.get(q);
            tail = tail.next;
            p++;
            q--;
        }
        if (p == q) {
            tail.next = list.get(p);
            tail = tail.next;
        }
        tail.next = null;
        dummy.next = null;
        dummy = null;
    }

    public void reorderList(ListNode head) {
        //break from middle
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode other = slow.next;
        slow.next = null;
        other = reverseList(other);
        weaveList(head, other);
    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = null, q = head;
        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    void weaveList(ListNode head, ListNode other) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = head, q = other;
        while (p != null && q != null) {
            tail.next = p;
            p = p.next;
            tail = tail.next;
            tail.next = q;
            q = q.next;
            tail = tail.next;
        }
        if (p == null) {
            tail.next = q;
        } else {
            tail.next = p;
        }
        return;
    }
}
