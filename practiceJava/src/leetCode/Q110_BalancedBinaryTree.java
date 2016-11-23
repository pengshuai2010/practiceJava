package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedRecursive(root) != -1;
    }

    /**
     * similar to get binary tree height but use -1 to indicate imbalancement
     * time complexity O(n), where n is the number of nodes in the tree
     */
    private int isBalancedRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = isBalancedRecursive(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedRecursive(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
