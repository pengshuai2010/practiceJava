package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by speng on 8/13/16.
 */
public class Q66 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //        root.right = new TreeNode(3);
        System.out.println(new Q66().preorderTraversal(root).toString());
    }

    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

//
//    public ArrayList<Integer> preorderTraversal(TreeNode root) {
//        TreeNode lastNode = null;
//        TreeNode current = root;
//        Stack<TreeNode> stack = new Stack<>();
//        while (true) {
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//            if (stack.empty())
//                break;
//            current = stack.pop();
//
//        }
//        return
//    }

    /**
     * pre-order traversal using stack and iteration
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }
}
