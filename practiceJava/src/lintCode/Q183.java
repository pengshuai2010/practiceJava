package lintCode;

public class Q183 {
	/*
	 * Given n pieces of wood with length L[i] (integer array). Cut them into
	 * small pieces to guarantee you could have equal or more than k pieces with
	 * the same length. What is the longest length you can get from the n pieces
	 * of wood? Given L & k, return the maximum length of the small pieces.
	 * 
	 * Have you met this question in a real interview? Yes Example For L=[232,
	 * 124, 456], k=7, return 114.
	 * 
	 * Note You couldn't cut wood into float length.
	 * 
	 * Challenge O(n log Len), where Len is the longest length of the wood.
	 */
	/**
	 * @param L:
	 *            Given n pieces of wood with length L[i]
	 * @param k:
	 *            An integer return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0)
			return 0;
		long sum = 0;
		for (int item : L)
			sum += item;
		int e = (int) (sum / k);
		int s = 1;
		int mid = (s + e) / 2;
		int numPieces = 0;
		while (s <= e) {
			mid = s + (e - s) / 2;
			numPieces = calcNumPieces(L, mid);
			if (numPieces < k)
				e = mid - 1;
			else if (numPieces > k)
				s = mid + 1;
			else// this problem is similar to Q61 "search for a range"
				s = mid + 1;
		}
		if (calcNumPieces(L, s) < k)
			s--;
		return s;
	}

	private static int calcNumPieces(int[] L, int l) {
		int numPieces = 0;
		for (int item : L)
			numPieces += item / l;
		return numPieces;
	}

	public static void main(String[] args) {
		int[] L = new int[] { 232, 124, 456 };
		int k = 7;
		// int[] L = new int[] {2147483644, 2147483645, 2147483646, 2147483647};
		// int k = 4;
		int res = new Q183().woodCut(L, k);
		System.out.println(res);
	}

}
