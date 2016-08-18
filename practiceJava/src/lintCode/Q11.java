package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 8/18/16.
 */
public class Q11 {
    public static void main(String[] args) {
        int k1 = 10;
        int k2 = 22;
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.right = new TreeNode(22);
        System.out.println(new Q11().searchRange(root, k1, k2).toString());
    }

    /**
     * @param root: The root of the binary search tree.
     * @param k1    and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null || k1 > k2)
            return list;
        searchRange(root, k1, k2, list);
        return list;
    }

    private void searchRange(TreeNode root, int k1, int k2, List<Integer> list) {
        if (root == null)
            return;
        if (root.val > k1)
            searchRange(root.left, k1, k2, list);
        if (root.val >= k1 && root.val <= k2)
            list.add(root.val);
        if (root.val < k2)
            searchRange(root.right, k1, k2, list);
    }
}

