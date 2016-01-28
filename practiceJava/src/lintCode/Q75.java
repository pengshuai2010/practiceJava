package lintCode;

public class Q75 {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
    	if (A == null || A.length < 3)
    		return -1;
    	int s = 0;
    	int e = A.length - 1;
    	int mid;
    	while (s <= e) {
    		mid = s + (e - s)/2;
    		if (mid - 1 >= 0 && A[mid] < A[mid - 1])
    			e = mid - 1;
    		else if (A[mid] < A[mid + 1])
    			s = mid + 1;
    		else
    			return mid;
    	}
    	return -1;
    }
	public static void main(String[] args) {
//		int[] A = new int[] {1, 2, 1, 3, 4, 5, 7, 6};
		int[] A = new int[] {1, 2, 1, 2, 3, 1};
		int res = new Q75().findPeak(A);
		System.out.println(res);
	}

}
