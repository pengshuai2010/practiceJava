package leetCode;

import basicAlgorithms.ListNode;

import java.util.Stack;

/**
 * Created by speng on 12/27/16.
 */
public class Q445_AddTwoNumbersII {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //ask interviewer: can I modify the input list? requirement for memory usage?
        //when only one list is null, can I just return the other one? or must creat a new list?
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = l1, q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int sum = carry;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            carry = sum / 10;
            sum %= 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        if (carry > 0) {//don't forget carry
            tail.next = new ListNode(carry);
        }
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null;
        ListNode q = head;
        ListNode r = head;
        while (r != null) {
            r = r.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }

    /**
     * stack version is easier to write.
     * There two places we need extra attention. carry of MSD; result should also starts with MSD.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (ListNode p = l1; p != null; p = p.next) {
            s1.push(p.val);
        }
        for (ListNode p = l2; p != null; p = p.next) {
            s2.push(p.val);
        }
        Stack<Integer> res = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            carry = sum / 10;
            sum %= 10;
            res.push(sum);
        }
        if (carry > 0) {//don't forget carry
            res.push(carry);
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!res.isEmpty()) {
            tail.next = new ListNode(res.pop());
            tail = tail.next;
        }
        return dummy.next;
    }
}
