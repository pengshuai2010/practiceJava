package leetCode;

import basicAlgorithms.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by speng on 12/22/16.
 */
public class Q142_LinkedListCycleII {
    /**
     * O(n) time and O(n) space.
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null && !set.contains(p)) {
            set.add(p);
            p = p.next;
        }
        return p;
    }

    /**
     * see Tortoise and hare algorithm in cycle detection https://en.wikipedia.org/wiki/Cycle_detection
     * Suppose cycle length is p, when slow and fast first meets, slow has traveled distance v, fast has travaled 2*v, then 2*v - v = n*p. so
     * v is a multiple of p. Reset slow to the head, and let fast stay where it is. Let fast and slow travel at same speed, they will meet at the
     * beginning of loop.
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        int count = 0;
        while (fast != null) {
            fast = fast.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
                if (fast == slow) {//we put the detection inside the if statement, so that fast always goes twice as far as slow goes upon breaking out of loop.
                    break;
                }
            }
        }
        if (fast == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
