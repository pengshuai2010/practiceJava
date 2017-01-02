package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by speng on 1/2/17.
 */
public class Q437_PathSumIII {
    private int count;

    /**
     * Pre-order traversal. At each non-null node, add the val to path, then check how many suffix sums equals target. Checking a path takes O(d) time, where d is depth of the node. And we need to check the path for each node. So time complexity is
     * O(n*h), where h is the height of tree.
     */
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        count = 0;
        preorder(root, new ArrayList<>(), sum);
        return count;
    }

    private void preorder(TreeNode root, List<Integer> path, long target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        count += countQualifiedPaths(path, target);
        preorder(root.left, path, target);
        preorder(root.right, path, target);
        path.remove(path.size() - 1);
    }

    private int countQualifiedPaths(List<Integer> path, long target) {
        int count = 0;
        long sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == target) {
                count++;
            }
        }
        return count;
    }

    /**
     * We only want to know how many paths' sum is target, so there's actually no need to calculate all paths' sum and compare with target.
     * Use a HashMap to record all prefix path sums(sum of path that starts from root), if current prefix path sum(sum of the path from root
     * to this node) minus target is in the map, that means there's subpath whose sum is target.
     * See https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method
     * <p>
     * takes only O(n) time. This can be abstracted to a more general problem: given an array of integers, and a target,
     * how many subarrays' sum equals to the target?
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        count = 0;
        helper(root, 0, sum, new HashMap<>());
        return count;
    }

    private void helper(TreeNode root, int sum, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == target) {
            count++;
        }
        count += map.getOrDefault(sum - target, 0);
        //there should be at least one node in a path. Put map.put() after increasing count to handle the case when target is 0.
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        helper(root.left, sum, target, map);
        helper(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        if (map.get(sum) == 0) {
            map.remove(sum);
        }
    }
}
