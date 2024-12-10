package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q129_SumRootToLeafNumbers_iterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Q129_SumRootToLeafNumbers_iterative solution = new Q129_SumRootToLeafNumbers_iterative();
        System.out.println(solution.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Item> stack = new ArrayDeque<>();
        stack.addLast(new Item(root, 0));
        int sum = 0;
        int pathValue = 0;
        while (!stack.isEmpty()) {
            Item item = stack.removeLast();
            TreeNode node = item.node;
            pathValue = item.pathValue * 10 + node.val;
            if (node.left == null && node.right == null) {
                sum += pathValue;
            }
            if (node.right != null) {
                stack.addLast(new Item(node.right, pathValue));
            }
            if (node.left != null) {
                stack.addLast(new Item(node.left, pathValue));
            }
        }
        return sum;
    }

    private static class Item {
        TreeNode node;
        int pathValue;

        Item(TreeNode node, int pathValue) {
            this.node = node;
            this.pathValue = pathValue;
        }
    }
}
