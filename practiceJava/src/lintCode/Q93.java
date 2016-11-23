package lintCode;


import basicAlgorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 8/10/16.
 * http://www.jiuzhang.com/solutions/balanced-binary-tree/
 */
public class Q93 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(2);
        System.out.println(new Q93().isBalanced(root));
    }

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced2(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        getDepth(root, map);
        return isBalancedRecursive2(root, map);
    }

    boolean isBalancedRecursive2(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return true;
        int lDepth = map.get(root.left);
        int rDepth = map.get(root.right);
        return isBalancedRecursive2(root.left, map) && isBalancedRecursive2(root.right, map) && Math.abs(lDepth - rDepth) <= 1;
    }

    int getDepth(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return 0;
        int lDepth = getDepth(root.left, map);
        int rDepth = getDepth(root.right, map);
        int depth = Math.max(lDepth, rDepth) + 1;
        map.put(root, depth);
        return depth;
    }

    public boolean isBalanced1(TreeNode root) {
        return isBalancedRecursive1(root).isBalanced;
    }

    Result isBalancedRecursive1(TreeNode root) {
        if (root == null)
            return new Result(0, true);
        Result lResult = isBalancedRecursive1(root.left);
        Result rResult = isBalancedRecursive1(root.right);
        return new Result(Math.max(lResult.depth, rResult.depth) + 1,
                lResult.isBalanced && rResult.isBalanced && Math.abs(lResult.depth - rResult.depth) <= 1);
    }

    boolean isBalanced(TreeNode root) {
        int result = isBalancedRecursive(root);
        return result != -1;
    }

    // if returned value == -1, that means the tree is unbalanced.
    // if returned value >= 0, that represents depth
    int isBalancedRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = isBalancedRecursive(root.left);
        // improve efficiency
        if (lDepth == -1)
            return -1;
        int rDepth = isBalancedRecursive(root.right);
        if (rDepth == -1 || Math.abs(lDepth - rDepth) > 1)
            return -1;
        return Math.max(lDepth, rDepth) + 1;
    }

    // use a Result class to return both depth and isBalance, so that we can get them both in one run
    class Result {
        int depth;
        boolean isBalanced;

        Result(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
}
