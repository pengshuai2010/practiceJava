package lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by speng on 8/20/16.
 */
public class Q152 {
    public static void main(String[] args) {
        System.out.println(new Q152().combine(5, 3));
        System.out.println(new Q152().combine(5, 5));
    }

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (k < 0 || n < 0 || k > n)
            return combinations;
        Stack<Integer> stack = new Stack<>();
        combineRecursive(n, 1, k, stack, combinations);
        return combinations;
    }

    // use DFS
    private void combineRecursive(int n, int start, int k, Stack<Integer> stack, List<List<Integer>> combinations) {
        if (stack.size() == k) {
            List<Integer> combination = new ArrayList<>();
            combination.addAll(stack);
            combinations.add(combination);
            return;
        }
        // trim the branch
        if (start > n)
            return;
        for (int i = start; i <= n; i++) {
            stack.push(i);
            combineRecursive(n, i + 1, k, stack, combinations);
            stack.pop();
        }
    }
}
