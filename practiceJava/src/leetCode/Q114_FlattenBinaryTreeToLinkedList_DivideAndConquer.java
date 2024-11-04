package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q114_FlattenBinaryTreeToLinkedList_DivideAndConquer {
    private static TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftEnd = helper(root.left);
        TreeNode rightEnd = helper(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.left = null;
            root.right = left;
            leftEnd.left = null;
            leftEnd.right = right;
        }
        if (rightEnd != null) {
            return rightEnd;
        }
        if (leftEnd != null) {
            return leftEnd;
        }
        return root;
    }

    public void flatten(TreeNode root) {
        helper(root);
    }
}
