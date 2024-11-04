package lintCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q595_BinaryTreeLongestConsecutiveSequence_DivideAndConquerTraverse {
    private int longestSequenceLength;

    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        this.longestSequenceLength = 0;
        helper(root);
        return this.longestSequenceLength;
    }

    private List<Integer> helper(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> leftResult = helper(root.left);
        if (!leftResult.isEmpty() && leftResult.get(leftResult.size() - 1) - root.val != 1) {
            leftResult = new ArrayList();
        }
        leftResult.add(root.val);
        List<Integer> rightResult = helper(root.right);
        if (!rightResult.isEmpty() && rightResult.get(rightResult.size() - 1) - root.val != 1) {
            rightResult = new ArrayList();
        }
        rightResult.add(root.val);
        List<Integer> result;
        if (leftResult.size() > rightResult.size()) {
            result = leftResult;
        } else {
            result = rightResult;
        }
        if (result.size() > this.longestSequenceLength) {
            this.longestSequenceLength = result.size();
        }
        return result;
    }
}
