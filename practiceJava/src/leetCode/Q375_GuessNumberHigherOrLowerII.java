package leetCode;

/**
 * Created by speng on 11/27/16.
 */
public class Q375_GuessNumberHigherOrLowerII {
    int[][] dp;

    /**
     * Note that in this game the house "cheats": the number is pre-decided, rather, the house choose the option that costs
     * player most money.
     * <p>
     * In the game, player is playing with the house. The house will always choose the answer that costs player most money,
     * i.e. based on player's choice in last step, the house will choose an option the maximize the player's loss. And
     * the player should choose an option that minimize that maximum. This is min-max algorithm.
     * <p>
     * Define dp[i, j] as the minimum amount of money to gurantee a win in range[i, j].
     * <p>
     * In the number range [i, j], if player choose number x, apparently the house will never say "you're right!", rather,
     * it will say "lower" or "higher" based on which one will cost player more money. So the cost of choosing x will be
     * x + max{dp[i, x - 1], dp[x + 1, j]}. As a player, we will choose an x such that x + max{dp[i, x - 1], dp[x + 1, j]}
     * is minimum. So dp[i, j] = min(i<=x<=j) {x + max{dp[i, x - 1], dp[x + 1, j]}}
     *
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return dfs(1, n);
    }

    private int dfs(int low, int high) {
        if (low >= high)
            return 0;
        if (dp[low][high] != 0)
            return dp[low][high];
        int min = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++) {
            int cost = i + Math.max(dfs(low, i - 1), dfs(i + 1, high));
            min = Math.min(min, cost);
        }
        dp[low][high] = min;
        return min;
    }
}
