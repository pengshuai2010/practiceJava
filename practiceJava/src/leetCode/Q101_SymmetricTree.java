package leetCode;

import lintCode.TreeNode;

import java.util.Stack;

/**
 * Created by speng on 11/22/16.
 */
public class Q101_SymmetricTree {
    //some other thoughts: 1. we can construct a mirror of this tree, then compare if they are same. takes O(n) space.
    //2. or we can get the preorder, inorder, postorder of this tree. If the tree is symmetric, its preorder and postorder
    // should be symmetric, and its inorder should be self-symmetric.

    public boolean isSymmetric1(TreeNode root) {
        return root == null || isSymmetricRecursive(root.left, root.right);
    }

    /**
     * recursive solution. Note that to determine if symmetric, we compare root.left.left with root.right.right,
     * and root.left.right with root.right.left.
     */
    private boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSymmetricRecursive(p.right, q.left) && isSymmetricRecursive(p.left, q.right);
    }

    /**
     * The iterative version. Recursive algorithms use stack implicitly. So any recursive algorithm can be changed to
     * iterative algorithm with the help of stack.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if (p == null && q == null)
                continue;
            if (p == null || q == null)
                return false;
            if (p.val != q.val)
                return false;
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }
}
