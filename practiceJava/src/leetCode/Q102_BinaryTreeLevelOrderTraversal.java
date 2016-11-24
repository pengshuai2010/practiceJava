package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by speng on 11/23/16.
 */
public class Q102_BinaryTreeLevelOrderTraversal {

    /**
     * traverse by layer, a variant of BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        if (root == null)
            return layers;
        Queue<TreeNode> curr = new LinkedList<>();
        curr.offer(root);
        while (curr.size() != 0) {
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while (!curr.isEmpty()) {
                TreeNode node = curr.poll();
                list.add(node.val);
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
            }
            layers.add(list);
            curr = next;
        }
        return layers;
    }
}
