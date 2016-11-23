package basicAlgorithms;

/**
 * Created by speng on 11/22/16.
 */
public class DoublyListNode {
    public DoublyListNode next;
    public DoublyListNode prev;
    int val;

    public DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
