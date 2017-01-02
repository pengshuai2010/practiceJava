package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 1/2/17.
 */
public class Q113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (root == null) {
            return solutions;
        }
        dfs(root, sum, new ArrayList<>(), solutions);
        return solutions;
    }

    private void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> solutions) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                solutions.add(new ArrayList<>(path));
            }
        }
        if (root.left != null) {
            dfs(root.left, target - root.val, path, solutions);
        }
        if (root.right != null) {
            dfs(root.right, target - root.val, path, solutions);
        }
        path.remove(path.size() - 1);
    }
}
