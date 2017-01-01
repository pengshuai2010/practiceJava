package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 12/31/16.
 */
public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return constructTree(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode constructTree(int[] preorder, int ps, int[] inorder, int is, int length) {
        if (length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        if (length == 1) {
            return root;
        }
        int rootIndex = is;
        while (rootIndex < is + length) {
            if (inorder[rootIndex] == root.val) {
                break;
            }
            rootIndex++;
        }
        root.left = constructTree(preorder, ps + 1, inorder, is, rootIndex - is);
        root.right = constructTree(preorder, ps + (rootIndex - is) + 1, inorder, rootIndex + 1, length - (rootIndex - is + 1));
        return root;
    }
}
