package lintCode;

/**
 * Created by shuaipeng on 8/19/16.
 */
public class Q87 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root = new Q87().removeNode(root, 2);
        System.out.println(new Q7().serialize(root));
        TreeNode.inorderTraverse(root);
    }

    /**
     * @param root:  The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null)
            return null;
        if (root.val == value) {
            TreeNode dummy = new TreeNode(0);
            dummy.left = root;
            remove(dummy, value);
            return dummy.left;
        } else {
            TreeNode parent = search(root, value);
            if (parent == null)
                return root;
            remove(parent, value);
            return root;
        }
    }

    // recursively search a BST
    private TreeNode search2(TreeNode root, int val) {
        if (root.left != null && root.left.val == val || root.right != null && root.right.val == val)
            return root;
        if (val < root.val)
            if (root.left == null)
                return null;
            else
                return search(root.left, val);
        else if (root.right == null)
            return null;
        else
            return search(root.right, val);
    }

    // iteratively search a BST
    private TreeNode search(TreeNode root, int val) {
        TreeNode previous = root;
        TreeNode current = val < root.val ? root.left : root.right;
        while (current.val != val) {
            TreeNode next;
            if (val < current.val)
                next = current.left;
            else
                next = current.right;
            if (next == null)
                break;
            previous = current;
            current = next;
        }
        if (current.val == val)
            return previous;
        return null;
    }

    // remove a node from a BST
    // the node is a child of the parent, and its value is val
    // case 1: both left subtree and right subtree of the node to be removed is empty. We simply replace it with null.
    // case 2: only one of the subtrees of the node to be removed is empty. We replace the node with the non-empty subtree.
    // case 3: both the subtrees are non-empty. We find out the node of minimum value in the right subtree, copy the value
    // to the node to be removed(this will cause duplicate nodes), then remove the now-duplicate node.
    private void remove(TreeNode parent, int val) {
        if (parent == null)
            return;
        TreeNode toBeRemoved;
        if (parent.left != null && parent.left.val == val)
            toBeRemoved = parent.left;
        else if (parent.right != null && parent.right.val == val)
            toBeRemoved = parent.right;
        else
            return;
        if (toBeRemoved.left == null || toBeRemoved.right == null) {
            TreeNode newNode;
            if (toBeRemoved.left == null)
                newNode = toBeRemoved.right;
            else
                newNode = toBeRemoved.left;
            if (parent.left == toBeRemoved)
                parent.left = newNode;
            else
                parent.right = newNode;
            return;
        }
        int minVal = findMinVal(toBeRemoved.right);
        toBeRemoved.val = minVal;
        toBeRemoved.right = removeNode(toBeRemoved.right, minVal);
    }

    private int findMinVal(TreeNode root) {
        //assuming root is not null
        TreeNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.val;
    }
}
