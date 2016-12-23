package leetCode;

import basicAlgorithms.TreeNode;

import java.util.Stack;

/**
 * Created by speng on 12/22/16.
 */
public class Q173_BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    private TreeNode p;

    /**
     * adapted from the iterative in-order binary tree traversal.
     * constructor and hasNext() takes O(1) time. worst case time complexity of next() is O(h), where h is height of the
     * tree, amortized time complexity is O(1). Space complexity is O(h).
     */
    public Q173_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        p = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return p != null || !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (hasNext()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                int val = p.val;// if we were using Python, it can be as simple as writing a yield statement here
                p = p.right;
                return val;
            }
        }
        throw new java.util.NoSuchElementException();
    }
}
