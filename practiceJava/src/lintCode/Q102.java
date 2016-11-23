package lintCode;

import basicAlgorithms.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaipeng on 8/8/16.
 */
public class Q102 {
    public static void main(String[] args) {
        ListNode cycleList = ListNode.createList(new int[]{1, 2, 3});
        System.out.println(new Q102().hasCycle(cycleList));
        cycleList.next.next.next = cycleList;
        System.out.println(new Q102().hasCycle(cycleList));
    }

    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        for (ListNode p = head; ; p = p.next) {
            if (p == null) {
                return false;
            }
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
    }
}
