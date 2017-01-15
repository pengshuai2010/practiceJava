package lintCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q15_Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        //ask interviewer what is expected when nums.length == 0
        if (nums == null) {
            return solutions;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int value : nums) {
            deque.add(value);
        }
        dfs(deque, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    /**
     * If we use an ArrayList for nums, each time removing and inserting will take
     * O(n) time, so building an one permutation will take O(n^2) time, overall
     * time complexity will be O(n^2*n!)
     * By using Deque/LinkedList, we can remove from and add to nums in O(1) time,
     * thus improving time complexity to O(n*n!).
     * Not much difference, but nice to mention in an interview.
     */
    private void dfs(Deque<Integer> nums, List<Integer> path, List<List<Integer>> solutions) {
        if (nums.size() == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.removeFirst();
            path.add(value);
            dfs(nums, path, solutions);
            path.remove(path.size() - 1);
            nums.addLast(value);
        }
    }
}
