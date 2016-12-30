package leetCode;

import basicAlgorithms.ListNode;

/**
 * Created by speng on 12/30/16.
 */
public class Q160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //find out if there's intersection
        ListNode p = headA;
        while (p.next != null) {
            p = p.next;
        }
        ListNode end = p;
        p = headB;
        while (p.next != null) {
            p = p.next;
        }
        if (p != end) {
            return null;
        }
        //make a loop, intersection becomes beginning of the loop. Now this problem becomes "finding the beginning" of
        //the loop
        end.next = headB;
        p = headB;
        int cycleLength = 0;
        do {
            cycleLength++;
            p = p.next;
        } while (p != headB);
        ListNode fast = headA, slow = headA;
        for (int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode intersection = fast;
        end.next = null;//restore: removed the loop
        return intersection;
    }

    /**
     * Brilliant idea!
     * several test cases: both empty [], []; one is empty [] [b1, b2]; same length [a1, a2, c], [b1, b2, c]; different length [a1, a2, c], [b1, c];
     * one node [c], [c]; part of the other [a1, a2, c], [a2, c]; no intersection [a1, a2], [b1, b2]
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == b) {//this handles that case where there's no intersection
                return a;
            }
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
        }
        return a;
    }
}
