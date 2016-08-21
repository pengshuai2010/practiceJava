package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by speng on 8/20/16.
 */
public class Q135 {
    public static void main(String[] args) {
        System.out.println(new Q135().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Q135().combinationSum(new int[]{2, 2, 3}, 7));
    }

    /**
     * @param candidates: A list of integers
     * @param target:An   integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // ask questions!!! clarify the problem, e.g. what the input is like? Does it have duplicates? Is it sorted? ...
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return combinations;
        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        sumRecursive(candidates, 0, target, stack, combinations);
        return combinations;
    }

    // use DFS
    private void sumRecursive(int[] candidates, int startIndex, int target, Stack<Integer> stack, List<List<Integer>> combinations) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(stack);
            combinations.add(list);
        } else if (target > 0) {
            int prev = -1;// use this to indicate first run of the loop because candidates are positive
            for (int i = startIndex; i < candidates.length; i++) {
                if (prev == candidates[i]) // a technique to skip duplicates
                    continue;
                stack.push(candidates[i]);
                sumRecursive(candidates, i, target - candidates[i], stack, combinations);
                stack.pop();
                prev = candidates[i];
            }
        }
    }
}
