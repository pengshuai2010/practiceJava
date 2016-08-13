package lintCode;

/**
 * Created by speng on 8/13/16.
 */
public class Q85 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(-1);
//        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(6);
        TreeNode root = null;
        TreeNode.inorderTraverse(root);
        System.out.println();
        TreeNode node = new TreeNode(7);
//        TreeNode node = null;
        root = new Q85().insertNode(root, node);
        TreeNode.inorderTraverse(root);
    }

    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        // always check for null!!!
        if (node == null)
            return root;
        if (root == null)
            return node;
        if (node.val >= root.val)
            if (root.right == null)
                root.right = node;
            else
                insertNode2(root.right, node);
        else if (root.left == null)
            root.left = node;
        else
            insertNode2(root.left, node);
        return root;
    }

    // a better solution, more compact, more clear
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (node == null)
            return root;
        if (root == null)
            return node;
        if (node.val >= root.val)
            root.right = insertNode(root.right, node);
        else
            root.left = insertNode2(root.left, node);
        return root;
    }
}
