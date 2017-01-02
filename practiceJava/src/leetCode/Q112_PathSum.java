package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/2/17.
 */
public class Q112_PathSum {
    /**
     * pre-order traversal. Instead of having a target and a pathSum argument, we only use a sum, and keep decreasing it.
     * a path is defined as from root to a leaf, so we check if sum == 0 when root is a leaf node. We don't check when
     * root == null because we don't know if the parent of root is a leaf.
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {//ask interviewer how to handle null.
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return root.left != null && hasPathSum(root.left, sum - root.val)
                || root.right != null && hasPathSum(root.right, sum - root.val);
    }
}
