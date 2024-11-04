package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q114_FlattenBinaryTreeToLinkedList_Traverse {
    private static void preorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }

    private static void buildLinkedList(List<TreeNode> nodes) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode curr = nodes.get(i);
            TreeNode next = nodes.get(i + 1);
            curr.left = null;
            curr.right = next;
        }
        if (!nodes.isEmpty()) {
            TreeNode last = nodes.get(nodes.size() - 1);
            last.left = null;
            last.right = null;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        preorder(root, nodes);
        buildLinkedList(nodes);
    }
}
