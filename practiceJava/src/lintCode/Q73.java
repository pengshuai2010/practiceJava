package lintCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 8/16/16.
 */
public class Q73 {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart,
                               int inorderEnd) {
        if (preorder == null || preorderStart < 0 || preorderEnd > preorder.length || preorderEnd - preorderStart <= 0
                || inorder == null || inorderStart < 0 || inorderEnd > inorder.length || inorderEnd - inorderStart <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int inorderIndex = searchArray(inorder, inorderStart, inorderEnd, root.val);
        if (inorderIndex == -1) {
            // TODO how to deal with this case?
            System.err.println("not found");
            return null;
        }
        int inorderLeftStart = inorderStart;
        int inorderLeftEnd = inorderIndex;
        int inorderRightStart = inorderIndex + 1;
        int inorderRightEnd = inorderEnd;

        int preorderLeftStart = preorderStart + 1;
        int preorderLeftEnd = preorderLeftStart + inorderLeftEnd - inorderLeftStart;
        int preorderRightStart = preorderLeftEnd;
        int preorderRightEnd = preorderEnd;

        root.left = buildTree(preorder, preorderLeftStart, preorderLeftEnd, inorder, inorderLeftStart, inorderLeftEnd);
        root.right = buildTree(preorder, preorderRightStart, preorderRightEnd, inorder, inorderRightStart, inorderRightEnd);
        return root;
    }

    private static int searchArray(int[] array, int start, int end, int key) {
        for (int i = start; i < array.length && i < end; i++)
            if (array[i] == key)
                return i;
        return -1;
    }

    public static void main(String[] args) {
//        int[] preorder = new int[] {2, 1, 3};
//        int[] inorder = new int[] {1, 2, 3};
        int[] preorder = new int[] {1, 2, 3};
        int[] inorder = new int[] {3, 2, 1};
//        int[] preorder = new int[] {2, 0, -1, 1, 3, 4};
//        int[] inorder = new int[] {-1, 0, 1, 2, 3, 4};
        TreeNode root = new Q73().buildTree(preorder, inorder);
        TreeNode.preorderTraverse(root);
        System.out.println();
        TreeNode.inorderTraverse(root);
    }
}
