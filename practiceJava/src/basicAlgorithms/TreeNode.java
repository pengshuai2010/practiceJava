package basicAlgorithms;

import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    public static void preorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ", ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    static void preorderiterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.print(p.val + ", ");// similar to iterative inorder traversal, difference is when to visit root
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public static void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left);
        System.out.print(root.val + ", ");
        inorderTraverse(root.right);
    }

    static void inorderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        // p == null and stack.isEmpty() is true only when p is the right subtree of the last node in order
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.val + ", ");
                p = p.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0).setLeft(new TreeNode(-10).setLeft(new TreeNode(-11)).setRight(new TreeNode(-5).setLeft(new TreeNode(-6)))).setRight(new TreeNode(1));
        TreeNode.inorderIterative(root);
        System.out.println();
        TreeNode.preorderiterative(root);
    }

    TreeNode setLeft(TreeNode node) {
        this.left = node;
        return this;
    }

    TreeNode setRight(TreeNode node) {
        this.right = node;
        return this;
    }
}
