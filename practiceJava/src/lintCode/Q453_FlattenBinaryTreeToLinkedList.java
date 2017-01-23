package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/22/17.
 */
public class Q453_FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenTree(root);
    }

    /**
     * Divide and Conquer solution.
     */
    private TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftLastNode = flattenTree(root.left);
        TreeNode rightLastNode = flattenTree(root.right);
        //2 corner cases: root.left == null, root.right == null
        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //when root.right == null, we should return leftLastNode
        return rightLastNode == null ? leftLastNode : rightLastNode;
    }
}
