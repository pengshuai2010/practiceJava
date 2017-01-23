package lintCode;


import basicAlgorithms.TreeNode;

/**
 * Created by speng on 8/10/16.
 */
public class Q97_MaximumDepthOfBinaryTree {
    /**
     * Classical divide and conquer.
     *
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
