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
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        preorder(root, 0);
        return maxDepth;
    }

    /**
     * pre-order traversal. Use instance variable to keep track of max depth we had ever been, use input argument to
     * keep track of which layer we are on now.
     */
    private void preorder(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        preorder(root.left, depth);
        preorder(root.right, depth);
    }
}
