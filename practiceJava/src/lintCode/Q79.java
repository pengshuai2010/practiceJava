package lintCode;

public class Q79 {
	/*
	 * Longest Common Substring Given two strings, find the longest common
	 * substring. Return the length of it. Example Given A = "ABCD", B = "CBCE",
	 * return 2.
	 */
	/**
	 * @param A,
	 *            B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public int longestCommonSubstring(String A, String B) {
		int table[][] = new int[A.length()][B.length()];
		for (int i = 0; i < A.length(); i++)
			for (int j = 0; j < B.length(); j++)
				if (A.charAt(i) == B.charAt(j))
					if (i > 0 && j > 0)
						table[i][j] = table[i - 1][j - 1] + 1;
					else
						table[i][j] = 1;
		int maxLength = 0;
		for (int i = 0; i < A.length(); i++)
			for (int j = 0; j < B.length(); j++)
				if (table[i][j] > maxLength)
					maxLength = table[i][j];
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ABCD";
		String B = "CBCE";
		int res = new Q79().longestCommonSubstring(A, B);
		System.out.println(res);
	}

}
