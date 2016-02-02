package lintCode;

import java.util.ArrayList;
import java.util.List;

public class Q182 {
	/**
	 * @param A:
	 *            A positive integer which has N digits, A is a string.
	 * @param k:
	 *            Remove k digits.
	 * @return: A string
	 */
	public String DeleteDigits(String A, int k) {
		if (A == null || A.length() == 0 || A.length() <= k)
			return "";
		StringBuilder builder = new StringBuilder(A);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < builder.length(); j++) {
				if (j == builder.length() - 1 || builder.charAt(j) > builder.charAt(j + 1)) {
					builder.deleteCharAt(j);
					break;
				}
			}
		}
		while (builder.charAt(0) == '0')
			builder.deleteCharAt(0);
		return builder.toString();
	}

	public static void main(String[] args) {
		 String A = "178542";
		 int k = 4;
//		 String A = "";
//		 int k = 4;
//		 String A = "1234";
//		 int k = 4;
//		 String A = "1234";
//		 int k = 0;
//		String A = "254193";
//		int k = 1;
//		String A = "123456789";
//		int k = 1;
		String res = new Q182().DeleteDigits(A, k);
		System.out.println(res);
	}

}
