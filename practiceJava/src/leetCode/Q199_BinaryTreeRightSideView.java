package leetCode;

import treeAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q199_BinaryTreeRightSideView {
    // a clever idea: if we use root-right-left order to traverse the tree, then it is always the
    // rightmost node on each level that gets visited first.
    // However, beware of the danger of stack overflow if the tree is very deep
    private static void helper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        helper(root.right, level + 1, result);
        helper(root.left, level + 1, result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, 0, result);
        return result;
    }
}
