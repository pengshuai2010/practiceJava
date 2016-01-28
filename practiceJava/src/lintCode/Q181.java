package lintCode;

public class Q181 {
	/*
	 * Flip Bits Show result
	 * 
	 * 15:00 Start Determine the number of bits required to flip if you want to
	 * convert integer n to integer m.
	 * 
	 * Have you met this question in a real interview? Yes Example Given n = 31
	 * (11111), m = 14 (01110), return 2.
	 * 
	 * Note Both n and m are 32-bit integers.
	 */
	/**
	 * @param a,
	 *            b: Two integer return: An integer
	 */
	public static int bitSwapRequired(int a, int b) {
		int num = a ^ b;
		int sumOfOnes = 0;
		while (num != 0) {
			// result of modulo is negative if the num is negative
			int tmp = num % 2;
			if (tmp < 0)
				tmp = -tmp;
			sumOfOnes += tmp;
			// The unsigned right shift operator ">>>" shifts a zero into the
			// leftmost position, while the leftmost position after ">>" depends
			// on sign extension.
			num >>>= 1;
		}
		return sumOfOnes;
	}

	public static void main(String[] args) {
		// int a = -31, b = 14;
		// int a = -2147483648, b = 2147483647;
		int a = 1, b = -1;
		int res = Q181.bitSwapRequired(a, b);
		System.out.println(res);
	}

}
