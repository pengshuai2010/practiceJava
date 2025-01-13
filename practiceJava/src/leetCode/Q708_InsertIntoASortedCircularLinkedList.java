package leetCode;

public class Q708_InsertIntoASortedCircularLinkedList {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal, null);
            node.next = node;
            return node;
        }
        Node curr = head;
        do {
            Node next = curr.next;
            if (inBetween(curr, next, insertVal) || greaterThanGreatest(curr, next, insertVal)
                    || smallerThanSmallest(curr, next, insertVal))
            {
                Node node = new Node(insertVal, null);
                node.next = next;
                curr.next = node;
                return head;
            }
            curr = next;
            next = curr.next;
        } while (curr != head);
        // all values are the same
        Node node = new Node(insertVal, null);
        node.next = head.next;
        head.next = node;
        return head;
    }

    private boolean inBetween(Node curr, Node next, int insertVal) {
        return curr.val <= insertVal && insertVal <= next.val;
    }

    private boolean greaterThanGreatest(Node curr, Node next, int insertVal) {
        return curr.val > next.val && insertVal >= curr.val;
    }

    private boolean smallerThanSmallest(Node curr, Node next, int insertVal) {
        return curr.val > next.val && insertVal <= next.val;
    }
}
