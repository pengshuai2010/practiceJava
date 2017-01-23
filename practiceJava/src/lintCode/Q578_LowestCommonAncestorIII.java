package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/22/17.
 */
public class Q578_LowestCommonAncestorIII {
    /**
     * @param root The root of the binary tree.
     * @param A    and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        //ask interviewer if can assume A != B
        ResultType res = helper(root, A, B);
        if (res.foundA && res.foundB) {
            return res.lca;
        }
        return null;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        ResultType res = new ResultType();
        if (root == null) {
            return res;
        }
        ResultType left = helper(root.left, A, B);
        if (left.lca != null) {// the field lca is not null means the LCA has been found
            return left;
        }
        ResultType right = helper(root.right, A, B);
        if (right.lca != null) {
            return right;
        }
        res.foundA = left.foundA || right.foundA || root == A;
        res.foundB = left.foundB || right.foundB || root == B;
        if (res.foundA && res.foundB) {
            res.lca = root;
        }
        return res;
    }

    private class ResultType {
        boolean foundA;
        boolean foundB;
        TreeNode lca;
    }
}
