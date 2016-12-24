package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 12/23/16.
 */
public class Q235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val < q.val) {
            return lca(root, p, q);
        }
        return lca(root, q, p);
    }

    /**
     * Make use of the fact that this is a Binary Search Tree. We look for the highest node whose val is between [p.val, q.val]
     * This is similar to pre-order traversal, except that we only take one branch each time.
     */
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val) {
            return lca(root.right, p, q);
        } else if (root.val > q.val) {
            return lca(root.left, p, q);
        } else {
            return root;
        }
    }
}
