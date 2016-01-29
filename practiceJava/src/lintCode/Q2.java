package lintCode;

public class Q2 {
	/*
	 * Trailing Zeros Show result
	 * 
	 * You have exceeded the time limit Reset Write an algorithm which computes
	 * the number of trailing zeros in n factorial.
	 * 
	 * Example 11! = 39916800, so the out should be 2
	 */
	/*
	 * a O(1) solution. The number of trailing zeros is equal to number of
	 * min(number of 5's, number of 2's). Since there far more 2's than 5's, it
	 * is then equal to number of 5's. note that threre are two 5's instead of
	 * one in the number 75.
	 */
	/**
	 * @param n
	 *            As desciption return:
	 * @return An integer, denote the number of trailing zeros in n
	 */
	public long trailingZeros(long n) {
		long numFives = 0;
		long fivePower = 5;
		while (fivePower <= n){
			numFives += n / fivePower;
			fivePower *= 5;
		} 
		return numFives;
	}

	public static void main(String[] args) {
		long n = 11;
		// long n = 105;
		long res = new Q2().trailingZeros(n);
		System.out.println(res);
	}

}
