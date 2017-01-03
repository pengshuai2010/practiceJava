package leetCode;

import java.util.*;

/**
 * Created by speng on 1/3/17.
 */
public class Q279_PerfectSquares {
    /**
     * Think numbers in range [0, n] as nodes. If there is a square number r such that m + r = n, there is a edge from m to n.
     * Thus a directed graph is formed. We can find the least number of square numbers that sum to n by BFS starting from 0.
     * <p>
     * Generally, the time complexity of BFS is O(|V| + |E|), where |V| is number of nodes, and |E| is number of edges.
     * In this problem, there are (n + 1) nodes. Each node has sqrt(n) edges. So time complexity is O(n + sqrt(n)*n) = O(n^(3/2))
     */
    public int numSquares(int n) {
        if (n < 1) {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int layers = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n) {
                    return layers;
                }
                for (int j = 1; curr + j * j <= n; j++) {//use curr + j * j <= n to trim branch
                    int neighbor = curr + j * j;
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            layers++;
        }
        return -1;
    }

    /**
     * Dynamic Programming.
     * Define dp[i] as least number of square numbers that sum to i. Initially, dp[0] = 0
     * dp[i] = min(j) {dp[i - j^2] + 1 | j >= 1 && j^2 <= i}
     * takes O(n^(3/2)) time and O(n) space.
     */
    public int numSquares2(int n) {
        if (n < 1) {
            return -1;
        }
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                table[i] = Math.min(table[i], table[i - j * j] + 1);
            }
        }
        return table[n];
    }

    private List<Integer> dp;

    /**
     * Static Dynamic Programming. Cache the DP array. when requested result is in the range, return look up in the table and return immediately;
     * else expand the DP array incrementally.
     */
    public int numSquares3(int n) {
        if (n < 1) {
            return -1;
        }
        if (dp == null) {
            dp = new ArrayList<>();
            dp.add(0);
        }
        while (dp.size() <= n) {
            int next = Integer.MAX_VALUE;
            for (int i = 1; i * i <= dp.size(); i++) {
                next = Math.min(next, dp.get(dp.size() - i * i) + 1);
            }
            dp.add(next);
        }
        return dp.get(n);
    }
}
