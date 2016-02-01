package lintCode;

import java.util.Arrays;

public class Q61 {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	public int[] searchRange1(int[] A, int target) {
    	if (A == null || A.length == 0)
    		return new int[] {-1, -1};
    	int[] res = bsearch(A, 0, A.length - 1, target);
    	if (res[1] == -1)
    		return new int[] {-1, -1};

    	int s = res[0];
    	int mid = res[1];
    	int e = res[2];	
    	while (A[s] != target) {
    		int[] tmp = bsearch(A, s, mid, target);
    		s = tmp[0];
    		mid = tmp[1];
    	}
    	int start = s;
    	
    	s = res[0];
    	mid = res[1];
    	e = res[2];	
    	while (A[e] != target && e - mid > 1) {
    		int[] tmp = bsearch(A, mid, e, target);
    		mid = tmp[1];
    		e = tmp[2];
    	}
    	if (A[e] != target)
    		e = mid;
    	int end = e;
    		
    	
    	return new int[] {start, end};
    }
    
    private int[] bsearch(int[] A, int s, int e, int target) {
    	int mid;
    	while (s <= e) {
    		mid = s + (e - s)/2;
    		if (A[mid] < target)
    			s = mid + 1;
    		else if (A[mid] > target)
    			e = mid - 1;
    		else
    			return new int[] {s, mid, e};
    	}
    	return new int[]{-1, -1, -1};
    }
    
    
	public int[] searchRange(int[] A, int target) {
		int lIndex = findLeftmost(A, target);
		int rIndex = findRightmost(A, target);
		return new int[] {lIndex, rIndex};
	}
	
	private int findLeftmost(int[] A, int target) {
		int s = 0;
		int e = A.length - 1;
		int mid;
		while (s <= e) {
			mid = s + (e - s)/2;
			if (A[mid] > target)
				e = mid - 1;
			else if (A[mid] < target)
				s = mid + 1;
			else
				e = mid - 1;//search in the left part when equal
		}
		//if there exits target, it must be at the right of e
		//s will be (e + 1) after the last iteration
		if (s >= 0 && s < A.length && A[s] == target)
			return s;
		return -1;
	}
	
	private int findRightmost(int[] A, int target) {
		int s = 0;
		int e = A.length - 1;
		int mid;
		while (s <= e) {
			mid = s + (e - s)/2;
			if (A[mid] > target)
				e = mid - 1;
			else if (A[mid] < target)
				s = mid + 1;
			else
				s = mid + 1;//search in the right part when equal
		}
		if (e >= 0 && e < A.length && A[e] == target)
			return e;
		return -1;
	}
	public static void main(String[] args) {
		int[] A = new int[] {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] res = new Q61().searchRange(A, target);
		System.out.println(Arrays.toString(res));
	}

}
