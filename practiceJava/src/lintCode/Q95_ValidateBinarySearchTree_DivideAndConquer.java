package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by shuaipeng on 8/15/16.
 * http://www.cnblogs.com/yuzhangcmu/p/4177047.html
 */
public class Q95_ValidateBinarySearchTree_DivideAndConquer {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(-1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        TreeNode.inorderTraverse(root);
        System.out.println();
        System.out.println(new Q95_ValidateBinarySearchTree_DivideAndConquer().isValidBST(root));
    }

    private static Result helper(TreeNode root) {
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            Result leftResult = helper(root.left);
            if (!leftResult.isValid) {
                return leftResult;
            }
            if (leftResult.max >= root.val) {
                return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
            }
            min = Math.min(min, leftResult.min);
            max = Math.max(max, leftResult.max);
        }
        if (root.right != null) {
            Result rightResult = helper(root.right);
            if (!rightResult.isValid) {
                return rightResult;
            }
            if (rightResult.min <= root.val) {
                return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, false);
            }
            min = Math.min(min, rightResult.min);
            max = Math.max(max, rightResult.max);
        }
        return new Result(min, max, true);
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) { // clarify
            return true;
        }
        Result result = helper(root);
        return result.isValid;
    }
}

class Result {
    int min;
    int max;
    boolean isValid;

    Result(int min, int max, boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}
