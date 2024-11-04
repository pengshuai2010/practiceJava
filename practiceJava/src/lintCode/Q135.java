package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 8/20/16.
 */
public class Q135 {
    public static void main(String[] args) {
        System.out.println(new Q135().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Q135().combinationSum(new int[]{2, 2, 3}, 7));
    }

    // space complexity is O(n^(target/min)), where min is the smallest element in the candidates. The idea is that the
    // max length of a solution is target/min, and at each position in the solution there are at most n choices.
    // so the size of all the solutions are O(n^(target/min)).
    // target/min is also the max depth the stack.
    // time complexity is O(S), where S is the total length of all the solutions. And the upper bound is O(n^(target/min))
    private static void dfs(int[] candidates, int startIndex, int target, List<Integer> partial, List<List<Integer>> results) {
        if (target == 0) {
            List<Integer> copy = new ArrayList<>(partial);
            results.add(copy);
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target - candidate < 0) { // a little optimization
                break;
            }
            if (i > 0 && candidates[i - 1] == candidates[i]) { // skip duplicates
                continue;
            }
            partial.add(candidate);
            // the same element can be use more than once, so the startIndex is i instead of i + 1.
            dfs(candidates, i, target - candidate, partial, results);
            partial.remove(partial.size() - 1);
        }
    }

    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     *          we will sort your return value in output
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // clarifying questions: are candidate guranteed to be postivie?
        // otherwise it could be that target is 0, and candidates are {1, -1}
        // are candidates unique?
        // order of numbers in the combination? Should be ascending order.
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates); // clarify: is candidates already sorted? can I change the input?
        List<Integer> partial = new ArrayList<>();
        dfs(candidates, 0, target, partial, results);
        return results;
    }
}
