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
	 * @param n,
	 *            m: positive integer (1 <= n ,m <= 100)
	 * @return an integer
	 */
	public int uniquePaths(int m, int n) {
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

	public static void main(String[] args) {
		int m = 3, n = 80;
		int res = new Q114().uniquePaths(m, n);
		System.out.println(res);
	}

}
