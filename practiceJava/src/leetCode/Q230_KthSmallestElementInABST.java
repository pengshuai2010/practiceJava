package leetCode;

import basicAlgorithms.TreeNode;

import java.util.Stack;

/**
 * Created by speng on 12/31/16.
 */
public class Q230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            throw new java.lang.IllegalArgumentException();
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                count++;
                if (count == k) {
                    return p.val;
                }
                p = p.right;
            }
        }
        throw new java.lang.IllegalArgumentException();
    }
}
