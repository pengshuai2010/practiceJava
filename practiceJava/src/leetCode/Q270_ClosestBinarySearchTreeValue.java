package leetCode;

import treeAlgorithms.TreeNode;

public class Q270_ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        // will root be null?
        // assuming root is not null
        double minDiff = Math.abs(root.val - target);
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            double diff = Math.abs(node.val - target);
            if (diff < minDiff) {
                minDiff = diff;
                closest = node.val;
            } else if (diff == minDiff) {
                closest = Math.min(node.val, closest);
            }
            if (target < node.val) {
                node = node.left;
            } else if (target > node.val) {
                node = node.right;
            } else {
                break;
            }
        }
        return closest;
    }
}
