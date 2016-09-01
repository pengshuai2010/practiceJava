package lintCode;

/**
 * Created by shuaipeng on 9/1/16.
 */
public class Q92backPack {
    public static void main(String[] args) {
        System.out.println(new Q92backPack().backPack(11, new int[]{2, 3, 5, 7}));
        System.out.println(new Q92backPack().backPack(11, new int[]{7, 2, 3, 5}));
        System.out.println(new Q92backPack().backPack(12, new int[]{2, 3, 5, 7}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (m == 0 || A == null || A.length == 0)
            return 0;
        // classic 0-1 Knapsack problem
        // V[i] are values, W[i] are weights
        // define state DP[0...V.length][0...m]
        // DP[i][j] given a knapsack of capicity j, and the first i items(from 0 to (i-1)), how much value can fit in at most
        // DP[i][0] = 0
        // DP[0][j] = 0
        // if j - W[i - 1] >= 0  # it's possible for (i-1)th item(counting start from 0) to fit in a knapsack of capicity j
        //     DP[i][j] = max{DP[i - 1][j - W[i - 1]] + V[i - 1], DP[i - 1][j]}
        // else
        //    DP[i][j] = DP[i - 1][j]
        int[] prev = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            int[] curr = new int[m + 1];
            for (int j = 0; j < m + 1; j++)
                if (j - A[i] >= 0)
                    curr[j] = Math.max(prev[j - A[i]] + A[i], prev[j]);
                else
                    curr[j] = prev[j];
            prev = curr;
        }
        return prev[m];
    }
}
