package lintCode;

public class Q55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "ABCDEFG";
		String B = "ACC";
		boolean res = new Q55().compareStrings(A, B);
		System.out.println(res);
	}

	/**
	 * @param A
	 *            : A string includes Upper Case letters
	 * @param B
	 *            : A string includes Upper Case letter
	 * @return : if string A contains all of the characters in B return true
	 *         else return false
	 */
	public boolean compareStrings(String A, String B) {
		// Compare two strings A and B, determine whether A contains all of the
		// characters in B.
		// The characters in string A and B are all Upper Case letters.
		if (A.length() < B.length()) {
			return false;
		}
		int[] stats = new int[26];
		for (int i = 0; i < A.length(); i++) {
			stats[A.charAt(i) - 'A']++;
		}
		for (int i = 0; i < B.length(); i++) {
			stats[B.charAt(i) - 'A']--;
			if (stats[B.charAt(i) - 'A'] < 0) {
				return false;
			}
		}
		return true;
	}
}
