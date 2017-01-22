package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/21/17.
 */
public class Q595_BinaryTreeLongestConsecutiveSequence {
    private int maxLength;

    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        maxLength = 0;
        findMaxLength(root, 0, null);
        return maxLength;
    }

    private void findMaxLength(TreeNode root, int length, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null && parent.val + 1 == root.val) {
            length++;
        } else {
            length = 1;
        }
        maxLength = Math.max(maxLength, length);
        findMaxLength(root.left, length, root);
        findMaxLength(root.right, length, root);
    }
}
