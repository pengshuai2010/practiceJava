package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/30/16.
 */
public class Q386_LexicographicalNumbers {
    public List<Integer> lexicalOrder1(int n) {
        List<Integer> nums = new ArrayList<>();
        if (n < 1) {
            return nums;
        }
        dfs1(1, n, nums);
        return nums;
    }

    /**
     * For each num, there are two options, times 10 or plus 1(if last digit is not 9). Thus forming a binary tree.
     * We always try to times 10 first. So it will be pre-order traversal: root, left, then right.
     */
    private void dfs1(int start, int n, List<Integer> nums) {
        if (start > n) {
            return;
        }
        nums.add(start);
        dfs1(start * 10, n, nums);
        if (start % 10 < 9) {
            dfs1(start + 1, n, nums);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums = new ArrayList<>();
        if (n < 1) {
            return nums;
        }
        for (int i = 1; i < 10; i++) {//note that i starts from 1
            if (i > n) {
                break;
            }
            dfs(i, n, nums);
        }
        return nums;
    }

    /**
     * A better way of constructing a tree. For each number, there are 9 branches [num * 10, num * 10 + 1, ..., num * 10 + 9]
     * And we try the branches from left to right.
     * This way, the tree is more flat.
     */
    private void dfs(int start, int n, List<Integer> nums) {
        if (start > n) {
            return;
        }
        nums.add(start);
        for (int i = 0; i < 10; i++) {
            if (start * 10 + i > n) {
                break;
            }
            dfs(start * 10 + i, n, nums);
        }
    }
}
