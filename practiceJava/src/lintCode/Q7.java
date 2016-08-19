package lintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaipeng on 8/18/16.
 */
public class Q7 {
    public static void main(String[] args) {
        TreeNode root = null;
//        TreeNode root = new TreeNode(3);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(7);
        String data = new Q7().serialize(root);
        System.out.println(data);
        System.out.println(new Q7().serialize(new Q7().deserialize(data)));
    }

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        List<Integer> list = LevelOrderTraversal(root);
        return list.toString().replace("null", "#").replace('[', '{').replace(']', '}');
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        return buildBinaryTree(stringToList(data));
    }

    private TreeNode buildBinaryTree(List<Integer> list) {
        if (list == null || list.size() == 0)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        for (Integer number : list)
            if (number == null)
                queue.add(null);
            else
                queue.add(new TreeNode(number));
        List<TreeNode> currentLevel = new ArrayList<>();
        TreeNode root = queue.remove();
        currentLevel.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            for (TreeNode node : currentLevel) {
                if (node == null) {
                    queue.remove();
                    queue.remove();
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    node.left = queue.remove();
                    node.right = queue.remove();
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
                currentLevel = nextLevel;
            }
        }
        return root;
    }

    private List<Integer> stringToList(String data) {
        List<Integer> list = new ArrayList<>();
        data = data.replace('{', ' ').replace('}', ' ').trim();
        if (data == null || data.isEmpty())
            return list;
        String[] tokens = data.split(",");
        for (String token : tokens) {
            if (token.contains("#"))
                list.add(null);
            else
                list.add(Integer.parseInt(token.trim()));// note that Integer.parseInt() won't automatically trim the string
        }
        return list;
    }

    private List<Integer> LevelOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        // The Queue interface is not used here because we need to use null to represent absent nodes,
        // and generally there should not be null in Queue because Queue use null indicate errors, e.g. polling from
        // an empty queue
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nextLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    list.add(null);
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    list.add(node.val);
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            boolean isAllNull = true;
            for (TreeNode node : nextLevel) {
                if (node != null) {
                    isAllNull = false;
                    break;
                }
            }
            if (!isAllNull)
                queue.addAll(nextLevel);
        }
        return list;
    }


}
