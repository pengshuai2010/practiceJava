package lintCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 1/22/17.
 */
public class Q376_BinaryTreePathSum {
    /**
     * @param root   the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (root == null) {
            return solutions;
        }
        preorder(root, new ArrayList<>(), target, solutions);
        return solutions;
    }

    /**
     * The traversal way of solving this problem. We traversal through each node in pre-order, use a list to keep record
     * of the path from root to current node.
     */
    private void preorder(TreeNode root, List<Integer> path, int target, List<List<Integer>> solutions) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                solutions.add(new ArrayList<>(path));
            }
        } else {
            preorder(root.left, path, target, solutions);
            preorder(root.right, path, target, solutions);
        }
        path.remove(path.size() - 1);
    }
}
