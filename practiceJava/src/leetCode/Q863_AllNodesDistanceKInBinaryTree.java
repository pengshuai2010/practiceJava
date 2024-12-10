package leetCode;

import treeAlgorithms.TreeNode;

import java.util.*;

public class Q863_AllNodesDistanceKInBinaryTree {
    // First step: build a graph by adding a pointer to parent for each TreeNode.
    //              This can be done by building an adjacency list representation of the graph,
    //              or simply create a HashMap for pointer to parent
    // Second step: level order traversal from the target, add nodes when distance reaches k, and stop
    // both steps take O(n) time. Space complexity is O(n) because we need to store a pointer to parent for each TreeNode
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // will target be null, root be null, is target garanteed to be in the tree?
        // will k be too big?
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        helper(root, parentMap);
        // level order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        queue.addLast(target);
        seen.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (distance == k) {
                    result.add(node.val);
                } else if (distance > k) {
                    break;
                }
                if (node.left != null && !seen.contains(node.left)) {
                    queue.addLast(node.left);
                    seen.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)) {
                    queue.addLast(node.right);
                    seen.add(node.right);
                }
                if (parentMap.containsKey(node) && !seen.contains(parentMap.get(node))) {
                    queue.addLast(parentMap.get(node));
                    seen.add(parentMap.get(node));
                }
            }
            distance++;
        }
        return result;
    }

    private void helper(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            helper(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            helper(root.right, parentMap);
        }
    }
}
