package leetCode;

import treeAlgorithms.TreeNode;

import java.util.*;

// When you do a level oreder traversal, the row order, left to right order is automatically sovled.
// You only need to keep track of the columns range, so that we can simply iterate from minCol to maxCol in the map
// to build the result
// Map<Integer, List<integer>> colMap
// row = 0
// minCol = 0
// maxCol = 0
// queue.add(root)
// Level order traversal over the tree,
//     when visiting a node, update minCol, maxCol, add to colMap
//     if left child is not empty, add new Item(root.left, col - 1) to queue
//     if right child is not empty, add new Item(root.right, col + 1) to queue
// List<List<Integer>> result
// build result from colMap
public class Q314_BinaryTreeVerticalOrderTraversal_BFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int minCol = 0;
        int maxCol = 0;
        Deque<Item> queue = new ArrayDeque<>();
        queue.addLast(new Item(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item item = queue.removeFirst();
                TreeNode node = item.node;
                int col = item.col;
                minCol = Math.min(minCol, col);
                maxCol = Math.max(maxCol, col);
                if (!colMap.containsKey(col)) {
                    colMap.put(col, new ArrayList<>());
                }
                colMap.get(col).add(node.val);
                if (node.left != null) {
                    queue.addLast(new Item(node.left, col - 1));
                }
                if (node.right != null) {
                    queue.addLast(new Item(node.right, col + 1));
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int col = minCol; col <= maxCol; col++) {
            result.add(colMap.get(col));
        }
        return result;
    }

    private static class Item {
        TreeNode node;
        int col;

        Item(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
