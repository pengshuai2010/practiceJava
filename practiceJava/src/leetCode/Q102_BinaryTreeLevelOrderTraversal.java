package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/23/16.
 */
public class Q102_BinaryTreeLevelOrderTraversal {

    /**
     * traverse by layer, a variant of BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> curr = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (TreeNode node : curr) {
                level.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            result.add(level);
            curr = next;
            next = new ArrayList<>();
        }
        return result;
    }
}
