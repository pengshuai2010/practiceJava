package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/21/17.
 */
public class Q596_MinimumSubtree {
    private int minSum;
    private TreeNode minSumTree;

    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        minSum = Integer.MAX_VALUE;
        minSumTree = null;
        findMinSumTree(root);
        return minSumTree;
    }

    private int findMinSumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = findMinSumTree(root.left) + findMinSumTree(root.right) + root.val;
        if (sum < minSum) {
            minSum = sum;
            minSumTree = root;
        }
        return sum;
    }
}
