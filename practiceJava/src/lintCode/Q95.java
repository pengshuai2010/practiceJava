package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shuaipeng on 8/15/16.
 */
public class Q95 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    // use recursion, put all node in a list.
    // space efficiency O(n), n is the number of nodes
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        if (list.size() <= 1)
            return true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i))
                return false;
        }
        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }


    // use iteration, compare current node with last node
    // space efficiency O(lg(n)) for balanced tree, O(n) in worse case, n is the number of nodes
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if (stack.empty())
                break;
            current = stack.pop();
            if (lastNode != null && lastNode.val >= current.val)
                return false;
            lastNode = current;
            current = current.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        TreeNode.inorderTraverse(root);
        System.out.println();
        System.out.println(new Q95().isValidBST(root));
    }
}
