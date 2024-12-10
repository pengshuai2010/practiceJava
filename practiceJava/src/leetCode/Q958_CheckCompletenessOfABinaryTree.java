package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q958_CheckCompletenessOfABinaryTree {
    // Think of how a heap is implemented with an array.
    // If a node's index is i, then the index of it's left and right children are (2*i + 1) and (2*i + 2)
    // And a complete tree can be implmented with an array, i.e. no gap in the indices.
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int index = 0;
        Deque<Item> queue = new ArrayDeque<>();
        queue.addLast(new Item(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Item item = queue.removeFirst();
                TreeNode node = item.node;
                int number = item.number;
                if (number != index) {
                    return false;
                }
                index++;
                if (node.left != null) {
                    queue.addLast(new Item(node.left, number * 2 + 1));
                }
                if (node.right != null) {
                    queue.addLast(new Item(node.right, number * 2 + 2));
                }
            }
        }
        return true;
    }

    private static class Item {
        TreeNode node;
        int number;

        Item(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }
}
