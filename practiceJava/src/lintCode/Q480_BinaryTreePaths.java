package lintCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 1/22/17.
 */
public class Q480_BinaryTreePaths {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> solutions = new ArrayList<>();
        if (root == null) {
            return solutions;
        }
        preorder(root, "", solutions);
        return solutions;
    }

    /**
     * Pre-order traversal. As we traversal through the tree, we use a String path to keep record of the path from root
     * to current node. Note that unlike List, String is immutable, so there's no need to recover path at the end of
     * method.
     * <p>
     * It would be more efficient if we use a List as path, and turn the List into a String only at leaf nodes.
     */
    private void preorder(TreeNode root, String path, List<String> solutions) {
        if (root.left == null && root.right == null) {
            path += root.val;
            solutions.add(path);
            return;
        }
        path += root.val + "->";
        if (root.left != null) {
            preorder(root.left, path, solutions);
        }
        if (root.right != null) {
            preorder(root.right, path, solutions);
        }
    }

    /**
     * Divide and Conquer solution.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> solutions = new ArrayList<>();
        if (root == null) {
            return solutions;
        }
        if (root.left == null && root.right == null) {
            solutions.add(Integer.toString(root.val));
            return solutions;
        }
        if (root.left != null) {
            List<String> paths = binaryTreePaths(root.left);
            for (String path : paths) {
                solutions.add(root.val + "->" + path);
            }
        }
        if (root.right != null) {
            List<String> paths = binaryTreePaths(root.right);
            for (String path : paths) {
                solutions.add(root.val + "->" + path);
            }
        }
        return solutions;
    }
}
