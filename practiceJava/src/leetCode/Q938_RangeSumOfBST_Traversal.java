package leetCode;

import treeAlgorithms.TreeNode;

public class Q938_RangeSumOfBST_Traversal {
    // clarify, will this method be invoked concurrently?
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum = 0;
        helper(root, low, high);
        return this.sum;
    }

    private void helper(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low) {
            helper(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            this.sum += root.val;
        }
        if (root.val <= high) {
            helper(root.right, low, high);
        }
    }
}
