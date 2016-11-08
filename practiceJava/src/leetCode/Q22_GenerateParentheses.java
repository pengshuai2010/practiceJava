package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 11/7/16.
 */
public class Q22_GenerateParentheses {
    public static void main(String[] args) {
        Q22_GenerateParentheses solution = new Q22_GenerateParentheses();
        int[] inputs = new int[]{0, 1, 2, 3};
        for (int num : inputs) {
            System.out.println(num);
            System.out.println(solution.generateParenthesis(num).toString());
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n < 0)
            return results;
        dfs(new char[n * 2], 0, 0, results);
        return results;
    }

    /**
     * we already know that at each node in the tree, there are only two possible branches: '(' and ')'. So we don't need
     * a list of possible options and delete the one we choose, do dfs, then recover it -- as we did in permutation.
     * Using char array to store partial results is way more efficient than String, as String concatenation takes O(n) time.
     * We can use char array here because we know that the length of final result(leaf) is fixed.
     */
    private void dfs(char[] partial, int open, int close, List<String> solutions) {
        if (open + close == partial.length) {
            solutions.add(new String(partial));
            return;
        }
        if (open * 2 < partial.length) {// trim branch: number of '('s should be <= half of total length
            partial[open + close] = '(';
            dfs(partial, open + 1, close, solutions);
        }
        if (open > close) {// trim branch: at any time number of '('s should be no less than number of ')'s
            partial[open + close] = ')';
            dfs(partial, open, close + 1, solutions);
        }
    }
}
