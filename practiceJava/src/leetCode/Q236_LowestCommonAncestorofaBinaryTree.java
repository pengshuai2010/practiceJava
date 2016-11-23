package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/22/16.
 */
public class Q236_LowestCommonAncestorofaBinaryTree {
    /**
     * get the path from root to p, and the path from root to q. Compare these two paths.
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        getPath(root, p, path1);
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        getPath(root, q, path2);
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    /**
     * basically a variant of preorder traversal, except using a list to store path, and when target is found,
     * return true immediately.
     */
    private boolean getPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        //assuming target is not null
        if (root == null)
            return false;
        path.add(root);
        if (root == target)// == or equals()?
            return true;
        if (getPath(root.left, target, path))
            return true;
        if (getPath(root.right, target, path))
            return true;
        path.remove(path.size() - 1);
        return false;
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
