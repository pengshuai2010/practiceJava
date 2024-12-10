package leetCode;

import treeAlgorithms.TreeNode;

public class Q129_SumRootToLeafNumbers_recursive {
    private int sum;

    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        if (root == null) {
            return this.sum;
        }
        helper(root, 0);
        return this.sum;
    }

    // There is no need to keep the path because all we need is pathValue
    // for calculating the root to leaf value.
    private void helper(TreeNode root, int pathValue) {
        pathValue = pathValue * 10 + root.val;
        if (root.left == null && root.right == null) {
            this.sum += pathValue;
            return;
        }
        if (root.left != null) {
            helper(root.left, pathValue);
        }
        if (root.right != null) {
            helper(root.right, pathValue);
        }
    }
}
