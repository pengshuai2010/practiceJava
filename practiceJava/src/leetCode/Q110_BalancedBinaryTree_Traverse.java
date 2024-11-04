package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q110_BalancedBinaryTree_Traverse {
    private boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
        this.isBalanced = true;
        this.helper(root);
        return this.isBalanced;
    }

    // Divide and Conquer + Traverse
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = this.helper(root.left);
        int rightHeight = this.helper(root.right);
        this.isBalanced = this.isBalanced && Math.abs(leftHeight - rightHeight) <= 1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
