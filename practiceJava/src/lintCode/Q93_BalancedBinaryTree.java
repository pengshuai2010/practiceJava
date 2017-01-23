package lintCode;


import basicAlgorithms.TreeNode;

/**
 * Created by speng on 8/10/16.
 */
public class Q93_BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return -1 != getTreeHeight(root);
    }

    /**
     * Divided and conquer.
     * Definition of balanced tree: a tree is balanced if and only if its left and right subtree are both balanced, and
     * the difference of the height of left and right subtree is no more than 1.
     * The definition itself follows a divided-and-conquer approach. From the definition we know that for each subtree
     * we need two kinds of information: height and if its balanced. One way is to definde a ResultType class. But since
     * height is no longer useful once we know the tree is not balanced, we can use just one integer as return value.
     * Return value is -1 means that the tree is not balanced, otherwise the return value is the height of the tree.
     *
     * @param root
     * @return
     */
    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getTreeHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
