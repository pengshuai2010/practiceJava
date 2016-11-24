package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by speng on 11/23/16.
 */
public class Q94_BinaryTreeInorderTraversa {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        inorderRecursive(root, list);
        return list;
    }

    private void inorderRecursive(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorderRecursive(root.left, list);
        list.add(root.val);
        inorderRecursive(root.right, list);
    }

    /**
     * Iterative inorder traversal is a bit tricky. First add nodes to stack as current pointer goes left, when reach left most,
     * pop out a node and set it to current pointer, then go to its right subtree. repeat this until the current pointer
     * is null AND stack is empty.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
        return list;
    }
}
