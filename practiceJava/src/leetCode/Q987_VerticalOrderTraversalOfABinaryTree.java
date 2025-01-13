package leetCode;

import treeAlgorithms.TreeNode;

import java.util.*;

public class Q987_VerticalOrderTraversalOfABinaryTree {
    private int maxRow;
    private int minCol;
    private int maxCol;

    // Compare with Q314. Binary Tree Vertical Order Traversal https://leetcode.com/problems/binary-tree-vertical-order-traversal/
    // Q314 requires that when two nodes are at the row and col, they are sorted by the horizontal order, which can
    // be achieved by simply traversing the left branch before the right branch.
    // This problem requires that two nodes at the row and col be sorted by their value, this mean we need to we have to
    // actually sort the nodes at the same (row, col) location.
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        this.maxRow = Integer.MIN_VALUE;
        this.minCol = Integer.MAX_VALUE;
        this.maxCol = Integer.MIN_VALUE;
        // col,          row
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        inorder(root, 0, 0, map);
        result = buildVerticalTraversalResult(map);
        return result;
    }

    // Alternatively, we can use BFS to traverse the tree. We will need an Item class that has row, col and TreeNode
    // fields.
    private void inorder(TreeNode root, int row, int col, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(col)) {
            map.put(col, new HashMap<>());
        }
        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<>());
        }
        map.get(col).get(row).add(root.val);
        this.maxRow = Math.max(this.maxRow, row);
        this.minCol = Math.min(this.minCol, col);
        this.maxCol = Math.max(this.maxCol, col);
        inorder(root.left, row + 1, col - 1, map);
        inorder(root.right, row + 1, col + 1, map);
    }

    private List<List<Integer>> buildVerticalTraversalResult(Map<Integer, Map<Integer, List<Integer>>> map) {
        List<List<Integer>> result = new ArrayList<>();
        for (int col = this.minCol; col <= this.maxCol; col++) { // maxCol is inclusive
            List<Integer> colList = new ArrayList<>();
            result.add(colList);
            Map<Integer, List<Integer>> colMap = map.get(col);
            for (int row = 0; row <= this.maxRow; row++) { // maxRow is inclusive
                if (colMap.containsKey(row)) {
                    // for a particular col, not all rows in [0, maxRow] exists, e.g. a column at the left most won't have row 0
                    Collections.sort(colMap.get(row));
                    colList.addAll(colMap.get(row));
                }
            }
        }
        return result;
    }
}
