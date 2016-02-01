package lintCode;

import java.math.BigInteger;

public class Q114 {
	/*
	 * Unique Paths Show result
	 * 
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 * 
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 * 
	 * How many possible unique paths are there? Note m and n will be at most
	 * 100.
	 */
	/**
	 * n choose k approach, calculate (l + s)*(l + s-1)*...*(l +
	 * 1)/s/(s-1)/.../2/1 (s-1) multiplies and (s-1) divides in total, where s =
	 * min(m-1, n-1), l = max(m-1, n-1) so time complexity is O(min(m, n)) note
	 * that intermediate result can be very large, we need use long or
	 * BigInteger
	 * 
	 * @param n,
	 *            m: positive integer (1 <= n ,m <= 100)
	 * @return an integer
	 */
	public int uniquePaths1(int m, int n) {
		int large = Math.max(m - 1, n - 1);
		int small = Math.min(m - 1, n - 1);
		BigInteger res = BigInteger.valueOf(1L);
		for (int tmp = small; tmp >= 1; tmp--) {
			res = res.multiply(BigInteger.valueOf(large + tmp));
		}
		for (int tmp = small; tmp >= 1; tmp--) {
			res = res.divide(BigInteger.valueOf(tmp));
		}
		return res.intValue();
	}

	/*
	 * dynamic programming approach we need to fill up a m by n table, so time
	 * complexity is O(m*n) note that unlike the n choose k approach, only
	 * addition is involved so the constant part is much smaller
	 */
	public int uniquePaths(int m, int n) {
		int[][] table = new int[m][n];
		for (int i = 0; i < m; i++)
			table[i][0] = 1;
		for (int j = 0; j < n; j++)
			table[0][j] = 1;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				table[i][j] = table[i - 1][j] + table[i][j - 1];
		return table[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int m = 3, n = 80;
		int res = new Q114().uniquePaths(m, n);
		System.out.println(res);
	}

}
