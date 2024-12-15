package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by speng on 12/22/16.
 */
public class Q173_BinarySearchTreeIterator_Simplified {
    private final Deque<TreeNode> stack;

    public Q173_BinarySearchTreeIterator_Simplified(TreeNode root) {
        // will root be null?
        this.stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
    }

    public int next() {
        if (!this.hasNext()) {
            throw new java.util.NoSuchElementException("No more element left");
        }
        TreeNode curr = stack.removeLast();
        int value = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
        return value;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}
