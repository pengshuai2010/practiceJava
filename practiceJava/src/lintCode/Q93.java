package lintCode;


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
    public boolean isBalanced(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(null, 0);
        getDepth(root, map);
        return isBalancedRecursive(root, map);
    }

    boolean isBalancedRecursive(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null)
            return true;
        if (root == null)
            return true;
        int lDepth = map.get(root.left);
        int rDepth = map.get(root.right);
        return isBalancedRecursive(root.left, map) && isBalancedRecursive(root.right, map) && Math.abs(lDepth - rDepth) <= 1;
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

}
