package lintCode;

public class Q140 {
	/*
	 * Fast Power Show result
	 * 
	 * 30:00 Start Calculate the an % b where a, b and n are all 32bit integers.
	 * 
	 * Example For 231 % 3 = 2
	 * 
	 * For 1001000 % 1000 = 0
	 * 
	 * Challenge O(logn)
	 */
	/*
	 * @param a, b, n: 32bit integers
	 * 
	 * @return: An integer
	 */
	public int fastPower(int a, int b, int n) {
		// return (int) fPRecursion(a, b, n);
		return (int) fPIteration(a, b, n);
	}

	/*
	 * a recusive solution
	 */
	public static long fPRecursion(int a, int b, int n) {
		if (n == 0)
			return 1 % b;
		if (n == 1)
			return a % b;
		if ((n & 1) == 1)// n is odd
			return (fPRecursion(a, b, n - 1) * fPRecursion(a, b, 1)) % b;
		else {
			long res = fPRecursion(a, b, n / 2);
			return (res * res) % b;
		}
	}

	/*
	 * an iterative solution
	 */
	public static long fPIteration(int a, int b, int n) {
		int power = n;
		long value = a;
		long result = 1;
		while (power > 0) {
			if ((power & 1) == 1) {
				result *= value;
				result %= b;
				power--;
			}
			value *= value;
			value %= b;
			power >>= 1;
		}
		result %= b;
		return result;
	}

	public static void main(String[] args) {
		// int a = 2, b = 3, n = 31;
		// int a = 100, b = 1000, n = 1000;
		// pow(2,100)%1000000007 = 976371285
		// int a = 2, b = 1000000007, n = 100;
		// 27123, 5201314, 78965412, expected out 842799
		// int a = 27123, b = 5201314, n = 78965412;
		int a = 3, b = 1, n = 0;
		int res = new Q140().fastPower(a, b, n);
		System.out.println(res);
	}

}
