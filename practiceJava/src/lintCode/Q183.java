package lintCode;

public class Q183 {
	/** 
	 *@param L: Given n pieces of wood with length L[i]
	 *@param k: An integer
	 *return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0)
			return 0;
		long sum = 0;
		for (int item: L)
			sum += item;
		int e = (int) (sum/k);
		int s = 1;
		int mid = (s + e)/2;
		int numPieces = 0;
		while (s <= e) {
			mid = (s + e)/2;
			numPieces = calcNumPieces(L, mid);
			if (numPieces < k) 
				e = mid - 1;
			else if (numPieces > k)
				s = mid + 1;
			else
				break;
		}
		if (numPieces >=k) {
			while (calcNumPieces(L, mid) >= k)
				mid++;
			return mid-1;
		} else {
			while (calcNumPieces(L, mid) < k)
				mid--;
			return mid;
		}
	}
	
	private static int calcNumPieces(int[] L, int l) {
		int numPieces = 0;
		for (int item: L)
			numPieces += item/l;
		return numPieces;
	}
	public static void main(String[] args) {
//		int[] L = new int[] {232, 124, 456};
//		int k = 7;
		int[] L = new int[] {2147483644, 2147483645, 2147483646, 2147483647};
		int k = 4;
		int res = new Q183().woodCut(L, k);
		System.out.println(res);
	}

}
