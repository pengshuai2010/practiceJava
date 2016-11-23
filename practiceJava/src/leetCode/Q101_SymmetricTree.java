package leetCode;

import lintCode.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetricRecursive(root.left, root.right);
    }

    private boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        return p.val == q.val && isSymmetricRecursive(p.right, q.left) && isSymmetricRecursive(p.left, q.right);
    }
}
