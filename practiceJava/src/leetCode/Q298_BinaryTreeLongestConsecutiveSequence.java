package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 12/6/16.
 */
public class Q298_BinaryTreeLongestConsecutiveSequence {
    /**
     * we can eliminate instance variable by letting helper() return an int[].
     */
    private int max;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;//always remember to reset instance variable!
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        // when we find the left son is not consecutive, we reset left to 0
        if (root.left != null && root.val != root.left.val - 1) {
            left = 0;
        }
        if (root.right != null && root.val != root.right.val - 1) {
            right = 0;
        }
        int length = 1 + Math.max(right, left);
        max = Math.max(max, length);
        return length;
    }
}
