package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 12/3/16.
 */
public class Q104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {//consider this as exit condition of recursion
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
