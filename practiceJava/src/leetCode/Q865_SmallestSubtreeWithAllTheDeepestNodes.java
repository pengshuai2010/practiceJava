package leetCode;

import treeAlgorithms.TreeNode;

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Solution.ResultType result = helper(root);
        return result.subtree;
    }

    private Solution.ResultType helper(TreeNode root) {
        if (root == null) {
            return new Solution.ResultType(0, null);
        }
        Solution.ResultType leftResult = helper(root.left);
        Solution.ResultType rightResult = helper(root.right);
        TreeNode resultSubtree = null;
        int depth = 0;
        if (leftResult.depth > rightResult.depth) {
            resultSubtree = leftResult.subtree;
            depth = leftResult.depth + 1;
        } else if (leftResult.depth < rightResult.depth) {
            resultSubtree = rightResult.subtree;
            depth = rightResult.depth + 1;
        } else {
            resultSubtree = root;
            depth = leftResult.depth + 1;
        }
        return new Solution.ResultType(depth, resultSubtree);
    }

    static class ResultType {
        int depth; // omit getter, setter
        TreeNode subtree;

        ResultType(int depth, TreeNode subtree) {
            this.depth = depth;
            this.subtree = subtree;
        }
    }
}
