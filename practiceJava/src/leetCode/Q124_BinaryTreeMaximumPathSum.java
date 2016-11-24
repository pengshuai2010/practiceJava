package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/23/16.
 */
public class Q124_BinaryTreeMaximumPathSum {
    int max;// we use a field variable so we don't need pass an int array as argument in the recursive method

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        max = Integer.MIN_VALUE;
        maxDownPathSum(root);
        return max;
    }

    /**
     * this method also updates the field variable max, if the max of path sum of paths going through root is greater than the current max.
     * a path going through root can starts or ends with root.
     *
     * @return the max path sum from root going down one of its two branches
     */
    private int maxDownPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDownPathSum(root.left);// the max path sum of paths going down from root.left
        left = Math.max(0, left);// if it's less than 0, we discard it - won't add it when calculating other max path sums
        int right = maxDownPathSum(root.right);
        right = Math.max(0, right);
        // left + right + root.val is the max of path sum of paths going through root
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
