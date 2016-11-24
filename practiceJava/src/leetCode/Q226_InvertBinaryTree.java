package leetCode;

import basicAlgorithms.TreeNode;

import java.util.Stack;

/**
 * Created by speng on 11/23/16.
 */
public class Q226_InvertBinaryTree {
    public TreeNode invertTree1(TreeNode root) {
        invertRecursive(root);
        return root;
    }

    /**
     * recursive solution is simple and easy to understand, but not robust.
     * If the tree is guaranteed to be balanced, it's no big deal. Even if there millions of nodes in tree, it takes only 20~30 recursions to finish.
     * But we would have stack overflow if the tree is not balanced and there are millions of nodes in the tree.
     */
    private void invertRecursive(TreeNode root) {
        if (root == null)
            return;
        // yet another variant of recursive preorder traversal
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertRecursive(root.left);
        invertRecursive(root.right);
    }

    /**
     * Change the recursive solution to an iterative solution.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        // yet another variant of iterative preorder traversal
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }
}
