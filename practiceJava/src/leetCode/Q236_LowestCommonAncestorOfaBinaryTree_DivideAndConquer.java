package leetCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 11/22/16.
 */
public class Q236_LowestCommonAncestorOfaBinaryTree_DivideAndConquer {
    /**
     * The relationship is complex so we need a truth table.
     * when root == null, return value is null
     * | root == p |                R                       |
     * |-----------|--------------|-----|------|-----|------|
     * | L         | return value | p   | q    | LCA | null |
     * |           | p            | N/A | N/A  | N/A | N/A  |
     * |           | q            | N/A | N/A  | N/A | root |
     * |           | LCA          | N/A | N/A  | N/A | N/A  |
     * |           | null         | N/A | root | N/A | root |
     * hence when root == p, the return value should always be root.
     * Similarly, when root == q, the return value should always be root.
     * | root != p && root != q |              | R    |      |     |      |
     * |------------------------|--------------|------|------|-----|------|
     * | L                      | return value | p    | q    | LCA | null |
     * |                        | p            | N/A  | root | N/A | L    |
     * |                        | q            | root | N/A  | N/A | L    |
     * |                        | LCA          | N/A  | N/A  | N/A | L    |
     * |                        | null         | R    | R    | R   | null |
     * when root is not null, not p, not q,
     * if both leftResult and rightResult are not null, return value is root.
     * otherwise, if leftResult is not null, return value is root.left;
     * if rightResult is not null, return value is root.right; if both are null,
     * then return value is null.
     **/
    private static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lResult = helper(root.left, p, q);
        TreeNode rResult = helper(root.right, p, q);
        if (lResult != null && rResult != null) {
            return root;
        }
        if (lResult != null) {
            return lResult;
        }
        return rResult;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // clarify: will p and q be the same? Will p or q be null? will one be another's ancestor
        // are p and q guranteed to in in the tree?
        return helper(root, p, q);
        // assuming p and q guranteed to be in the tree
    }
}
