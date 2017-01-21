package lintCode;

import basicAlgorithms.TreeNode;

/**
 * Created by speng on 1/21/17.
 */
public class Q597_SubtreeWithMaximumAverage {
    private ResultType maxAveRes;
    private TreeNode maxAveSubtree;

    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        maxAveRes = null;//reset the instance variable because this method might be called more than once
        maxAveSubtree = null;
        findMaxAveSubtree(root);
        return maxAveSubtree;
    }

    private ResultType findMaxAveSubtree(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType leftRes = findMaxAveSubtree(root.left);
        ResultType rightRes = findMaxAveSubtree(root.right);
        ResultType res = new ResultType(leftRes.sum + rightRes.sum + root.val, leftRes.number + rightRes.number + 1);
        //avoid loss of precision when using double to represent average
        if (maxAveRes == null || res.sum * maxAveRes.number > maxAveRes.sum * res.number) {
            maxAveRes = res;
            maxAveSubtree = root;
        }
        return res;
    }

    private class ResultType {
        int sum;
        int number;

        ResultType(int s, int n) {
            sum = s;
            number = n;
        }
    }
}
