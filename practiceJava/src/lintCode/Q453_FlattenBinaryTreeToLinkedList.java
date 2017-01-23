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
    public void flatten1(TreeNode root) {
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

    TreeNode last = null;

    public void flatten(TreeNode root) {
        last = null;//reset last because this method might be called multiple times
        preorder(root);
    }

    /**
     * pre-order traversal. We use instance variable last to keep record of the last node in the "linked list" as we are
     * traversing the tree.
     */
    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (last != null) {
            last.right = root;
            last.left = null;
        }
        last = root;
        //preserve root.right because root.right will be changed by flatten(root.left)
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
