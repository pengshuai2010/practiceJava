package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/23/16.
 */
public class Q102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        if (root == null)
            return layers;
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while (curr.size() != 0) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : curr) {
                list.add(node.val);
                if (node.left != null)
                    next.add(node.left);
                if (node.right != null)
                    next.add(node.right);
            }
            layers.add(list);
            curr = next;
        }
        return layers;
    }
}
