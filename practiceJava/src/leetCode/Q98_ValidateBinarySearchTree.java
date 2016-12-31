package leetCode;

import basicAlgorithms.TreeNode;

import java.util.Stack;

/**
 * Created by speng on 12/31/16.
 */
public class Q98_ValidateBinarySearchTree {
    /**
     * use an instance variable so we don't need pass along and return it in the recursive method.
     */
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        pre = null;
        return validateBST(root);
    }

    /**
     * Use in-order traversal to validate BST. Note that a simple pre-order traversal won't do because we need to compare
     * value of root and largest value in the left subtree, not just the left child!
     */
    private boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!validateBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return validateBST(root.right);
    }

    /**
     * When the binary tree is unbalanced, recursive algorithms may cause a stack overflow exception. The size of heap
     * memory much larger than size of stack memory. So it's better to use iterative algorithm.
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (pre != null && pre.val >= p.val) {
                    return false;
                }
                pre = p;
                p = p.right;
            }
        }
        return true;
    }

}
