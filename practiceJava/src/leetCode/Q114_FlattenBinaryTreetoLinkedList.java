package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        flattenRecusive(root);
        return;
    }

    /**
     * return the last node of the flatterned tree
     */
    private TreeNode flattenRecusive(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;
        TreeNode lSubtree = root.left;
        TreeNode rSubtree = root.right;
        TreeNode lEnd = flattenRecusive(lSubtree);
        TreeNode rEnd = flattenRecusive(rSubtree);
        if (root.right == null) {
            root.right = lSubtree;
            root.left = null;
            return lEnd;
        }
        if (root.left == null) {
            return rEnd;
        }
        root.right = lSubtree;
        root.left = null;
        lEnd.right = rSubtree;
        return rEnd;
    }
}
