package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by speng on 12/29/16.
 */
public class Q138_CopyListwithRandomPointer {
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        queue.offer(head);
        map.put(head, new RandomListNode(head.label));
        while (!queue.isEmpty()) {
            RandomListNode node = queue.poll();
            if (node.next != null && !map.containsKey(node.next)) {
                queue.offer(node.next);
                map.put(node.next, new RandomListNode(node.next.label));
            }
            if (node.random != null && !map.containsKey(node.random)) {
                queue.offer(node.random);
                map.put(node.random, new RandomListNode(node.random.label));
            }
            //if node.next is null, map.get(node.next) will return null, which is exactly what we want
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }

    /**
     * If it is guaranteed that the linked list is not broken, e.g. two parts of a linked list is only connected by a random link,
     * we can use a method that is more specific toward this data structure. In the first pass, we clone all nodes, and map from
     * origin to clone. In the second pass, we clone all the links. (actually we can do this in the clone of graph too)
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
