package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 9/5/16.
 */
public class Q2addTwoNumbers {
    // make this algorithm more generic
    private int base = 10;

    public static void main(String[] args) {
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(2), null));
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(2), new ListNode(8)));
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(2), new ListNode(1)));
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(2).setNext(new ListNode(1)), new ListNode(8)));
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(9), new ListNode(9).setNext(new ListNode(9))));
        ListNode.printList(new Q2addTwoNumbers().addTwoNumbers(new ListNode(9).setNext(new ListNode(9)),
                new ListNode(9).setNext(new ListNode(9).setNext(new ListNode(9)))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            // need to ask interviewer about side effects
            return deepCopy(l2);
        if (l2 == null)
            return deepCopy(l1);
        // first add all digits, then deal with carries on all digits, so as to make the algorithm simpler
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (; p1 != null && p2 != null; p1 = p1.next, p2 = p2.next) {
            tail.next = new ListNode(p1.val + p2.val);
            tail = tail.next;
        }
        ListNode p = (p1 == null) ? p2 : p1;
        tail.next = deepCopy(p);
        int carry = 0;
        for (p = dummy; p.next != null; p = p.next) {
            ListNode node = p.next;
            node.val += carry;
            carry = node.val / base;
            node.val %= base;
        }
        if (carry != 0)
            p.next = new ListNode(carry);
        return dummy.next;
    }

    private ListNode deepCopy(ListNode l) {
        if (l == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode p = l; p != null; p = p.next) {
            tail.next = new ListNode(p.val);
            tail = tail.next;
        }
        return dummy.next;
    }
}
