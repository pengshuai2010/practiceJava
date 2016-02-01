package lintCode;

public class Q163 {
	/**
	 * @paramn n: An integer
	 * @return: An integer
	 */
	public int numTrees1(int n) {
		if (n <= 1)
			return 1;
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += numTrees(i - 1) * numTrees(n - i);
		return sum;
	}

	/*
	 * use dynamic programming to avoid duplicated calculation in the recursion
	 * version
	 */
	public int numTrees(int n) {
		if (n <= 1)
			return 1;
		int[] count = new int[n + 1];
		count[0] = count[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++)
				sum += count[j - 1] * count[i - j];
			count[i] = sum;
		}
		return count[n];
	}

	public static void main(String[] args) {
		int n = 3;
		int res = new Q163().numTrees(n);
		System.out.println(res);
	}

}
