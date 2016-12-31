package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/30/16.
 */
public class Q92_ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = ListNode.createList(new int[]{1, 2, 3});
        Q92_ReverseLinkedListII solution = new Q92_ReverseLinkedListII();
        head = solution.reverseBetween(head, 1, 3);
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;//don't ever forget!
        ListNode p = dummy;
        int count = 0;
        ListNode part1End = null, part2Start = null, part2End = null, part3Start = null;
        while (p != null) {
            if (count == m - 1) {
                part1End = p;
            }
            if (count == n) {
                part2End = p;
            }
            p = p.next;
            count++;
        }
        part2Start = part1End.next;
        part3Start = part2End.next;
        part1End.next = null;
        part2End.next = null;
        reverseList(part2Start);
        ListNode tmp = part2Start;
        part2Start = part2End;
        part2End = tmp;
        part1End.next = part2Start;
        part2End.next = part3Start;
        return dummy.next;
    }

    private void reverseList(ListNode head) {
        ListNode p = null, q = head, r = head;
        while (r != null) {
            r = r.next;
            q.next = p;
            p = q;
            q = r;
        }
    }

    /**
     * concise and brilliant
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;//don't ever forget!
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        //pre is the node before the sublist that will be reversed
        //start is the last node of already reversed list
        //then is the node to be reversed(to be inserted between pre and the sublist)
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}
