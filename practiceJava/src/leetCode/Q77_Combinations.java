package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 11/30/16.
 */
public class Q77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) {
            return solutions;
        }
        dfs(new ArrayList<Integer>(), k, 1, n, solutions);
        return solutions;
    }

    private void dfs(List<Integer> path, int k, int start, int n, List<List<Integer>> solutions) {
        if (k == 0) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i + k - 1 <= n; i++) {
            path.add(i);
            dfs(path, k - 1, i + 1, n, solutions);
            path.remove(path.size() - 1);
        }
    }
}
