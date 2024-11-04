package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/22/16.
 */
public class Q236_LowestCommonAncestorOfaBinaryTree_Traverse {
    private static List<TreeNode> getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return null;
        }
        if (root == target) {
            path.add(root);
            List<TreeNode> result = new ArrayList<>(path);
            path.remove(path.size() - 1);
            return result;
        }
        path.add(root);
        List<TreeNode> leftResult = getPath(root.left, target, path);
        if (leftResult != null) {
            path.remove(path.size() - 1);
            return leftResult;
        }
        List<TreeNode> rightResult = getPath(root.right, target, path);
        path.remove(path.size() - 1);
        return rightResult;
    }

    /**
     * get the path from root to p, and the path from root to q. Compare these two paths.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        List<TreeNode> path = new ArrayList<>();
        List<TreeNode> path1 = getPath(root, p, path);
        List<TreeNode> path2 = getPath(root, q, path);
        TreeNode lca = null;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                lca = path1.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
