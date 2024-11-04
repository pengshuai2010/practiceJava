package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q257_BinaryTreePaths {
    private static List<List<Integer>> helper(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        if (root.left == null && root.right == null) {
            List<Integer> result = new LinkedList<>();
            result.add(root.val);
            results.add(result);
            return results;
        }
        if (root.left != null) {
            List<List<Integer>> leftResults = helper(root.left);
            for (List<Integer> result : leftResults) {
                // use a LinkedList and add at the front so no need to reverse later
                result.add(0, root.val);
                results.add(result);
            }
        }
        if (root.right != null) {
            List<List<Integer>> rightResults = helper(root.right);
            for (List<Integer> result : rightResults) {
                result.add(0, root.val);
                results.add(result);
            }
        }
        return results;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<List<Integer>> results = helper(root);
        // separating the logic of building results and presenting the results
        for (List<Integer> result : results) {
            List<String> items = result.stream().map(Object::toString).collect(Collectors.toList());
            String path = String.join("->", items);
            paths.add(path);
        }
        return paths;
    }
}
