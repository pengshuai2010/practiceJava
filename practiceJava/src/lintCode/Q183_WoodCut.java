package lintCode;

public class Q183_WoodCut {
    /**
	 * @param L:
	 *            Given n pieces of wood with length L[i]
	 * @param k:
	 *            An integer return: The maximum length of the small pieces.
	 */
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0)
			return 0;
        //let high = sum / n. Or we can let high = max(L[i])
        long sum = 0;
		for (int item : L)
			sum += item;
        int high = (int) (sum / k);
        if (high == 0) {//to avoid divided by zero error, handle the case where sum < k
            return 0;
        }
        int low = 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            int pieces = calcNumPieces(L, mid);
            if (pieces >= k) {
                low = mid;
            } else if (pieces < k) {
                high = mid - 1;
            }
        }
        if (calcNumPieces(L, high) >= k) {
            return high;
        }
        if (calcNumPieces(L, low) >= k) {
            return low;
        }
        return 0;
    }

    private int calcNumPieces(int[] L, int l) {
        int numPieces = 0;
		for (int item : L)
			numPieces += item / l;
		return numPieces;
	}
}
