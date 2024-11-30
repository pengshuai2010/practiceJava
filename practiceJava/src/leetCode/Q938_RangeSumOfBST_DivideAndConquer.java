package leetCode;

import treeAlgorithms.TreeNode;

public class Q938_RangeSumOfBST_DivideAndConquer {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val <= high) {
            sum += rangeSumBST(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        return sum;
    }
}
