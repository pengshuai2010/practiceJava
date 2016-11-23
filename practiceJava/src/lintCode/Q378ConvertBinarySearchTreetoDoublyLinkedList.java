package lintCode;

import basicAlgorithms.DoublyListNode;
import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q378ConvertBinarySearchTreetoDoublyLinkedList {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode tail = dummy;
        inorder(root, tail);
        return dummy.next;
    }

    private DoublyListNode inorder(TreeNode root, DoublyListNode tail) {
        if (root == null)
            return tail;
        tail = inorder(root.left, tail);
        DoublyListNode node = new DoublyListNode(root.val);
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail = inorder(root.right, tail);
        return tail;
    }
}
