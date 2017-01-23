package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/22/17.
 */
public class Q88_LowestCommonAncestor {
    /**
     * Find lowest common ancestor of A and B. Assume A and B exist in tree.
     * Divide and conquer. Each subtree should return 3 kinds of information: if A is present, if B is present, the pointer
     * to the LCA of A and B. We can use a ResultType class. But since A and B are guaranteed be present in the tree,
     * we simplify the implementation.
     * Consider the cases: A and B both in one subtree; A and B each in a subtree; A is root, B is in a subtree, or
     * vice versa; only A or B is in one of the subtrees; A or B is root; A or B are both absent.
     *
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        //ask interviewer if A and B are guaranteed not null
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
