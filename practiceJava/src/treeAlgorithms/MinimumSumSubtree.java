package treeAlgorithms;

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * The range of input and output data is in int.
 */
public class MinimumSumSubtree {
    private int minimumSum;
    private TreeNode minimumSubSubtree;

    TreeNode findMinimumSumSubtree(TreeNode root) {
        if (root == null) { // handle the empty tree case at the beginning of the outer method
            return null;
        }
        this.minimumSum = Integer.MAX_VALUE;
        this.minimumSubSubtree = null;
        helper(root);
        return this.minimumSubSubtree;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            // we don't need to special handling of leaf node. We just need to not updating
            // minimumSub and minimumSumSubtree in case of null root.
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int sum = leftSum + rightSum + root.val;
        if (sum < this.minimumSum) {
            this.minimumSum = sum;
            this.minimumSubSubtree = root;
        }
        return sum;
    }
}

// null

