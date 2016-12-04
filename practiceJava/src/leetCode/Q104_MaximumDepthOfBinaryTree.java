package leetCode;

import basicAlgorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 12/3/16.
 */
public class Q104_MaximumDepthOfBinaryTree {
    public int maxDepth1(TreeNode root) {
        if (root == null) {//consider this as exit condition of recursion
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Iterative solution is better a recursive solution when the tree is unbalanced and have a lot of nodes.
     * <p>
     * The depth of a tree is by definition the number of layers of the tree, so level order traversal(i.e. BFS) is most
     * natural.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int numLayers = 0;
        while (!queue.isEmpty()) {
            numLayers++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return numLayers;
    }
}
