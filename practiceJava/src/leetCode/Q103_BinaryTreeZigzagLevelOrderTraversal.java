package leetCode;

import basicAlgorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by speng on 11/23/16.
 */
public class Q103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        if (root == null)
            return layers;
        boolean left2right = true;// use a boolean to control direction
        Queue<TreeNode> curr = new LinkedList<>();
        curr.offer(root);
        while (!curr.isEmpty()) {
            Queue<TreeNode> next = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            while (!curr.isEmpty()) {
                TreeNode node = curr.poll();
                if (left2right)
                    list.add(node.val);
                else
                    list.addFirst(node.val);
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
            }
            layers.add(list);
            curr = next;
            left2right = !left2right;
        }
        return layers;
    }
}
