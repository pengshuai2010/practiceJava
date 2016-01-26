package lintCode;

public class Q60 {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
    	if (A == null || A.length == 0)
    		return 0;
    	int s = 0, e = A.length - 1;
    	while (s < e) {
    		int mid = (s + e)/2;
    		if (A[mid] > target)
    			e = mid - 1;
    		else if (A[mid] < target)
    			s = mid + 1;
    		else
    			return mid;
    	}
    	if (A[s] < target)
    		s += 1;
    	return s;
    }
	public static void main(String[] args) {
		int[] A = new int[] {1,3,5,6};
//		int target = 5;
//		int target = 2;
//		int target = 7;
		int target = 0;
		int res = new Q60().searchInsert(A, target);
		System.out.println(res);
	}

}
