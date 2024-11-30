package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BFS would be a more straightforward solution.
 */
public class Q314_BinaryTreeVerticalOrderTraversal_DFS {
    // key is col number, value is minRow in that col.
    private final Map<Integer, Integer> minRow = new HashMap<>();
    private final Map<Integer, Integer> maxRow = new HashMap<>();
    private int minCol = 0;
    private int maxCol = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // col, row
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        preorder(root, 0, 0, map);
        return buildResult(map);
    }

    private void preorder(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(col)) {
            map.put(col, new HashMap<>());
        }
        Map<Integer, List<Integer>> colMap = map.get(col);
        if (!colMap.containsKey(row)) {
            colMap.put(row, new ArrayList<>());
        }
        colMap.get(row).add(root.val); // preorder traversal is root, left, right.
        this.minRow.put(col, Math.min(row, this.minRow.getOrDefault(col, Integer.MAX_VALUE)));
        this.maxRow.put(col, Math.max(row, this.maxRow.getOrDefault(col, 0)));
        this.minCol = Math.min(this.minCol, col);
        this.maxCol = Math.max(this.maxCol, col);
        preorder(root.left, row + 1, col - 1, map);
        preorder(root.right, row + 1, col + 1, map);
    }

    private List<List<Integer>> buildResult(Map<Integer, Map<Integer, List<Integer>>> map) {
        List<List<Integer>> result = new ArrayList<>();
        for (int col = this.minCol; col <= this.maxCol; col++) {
            result.add(new ArrayList<>());
            for (int row = this.minRow.get(col); row <= this.maxRow.get(col); row++) {
                if (map.get(col).containsKey(row)) {
                    result.get(result.size() - 1).addAll(map.get(col).get(row));
                }
            }
        }
        return result;
    }
}
