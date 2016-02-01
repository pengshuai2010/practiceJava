package lintCode;

public class Q82 {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
//		if (A == null || A.length == 0)
//			return 0;
		int num = 0;
		for (int item: A)
			num ^= item;
		return num;
	}
	public static void main(String[] args) {
		int[] A = new int[] {1,2,2,1,3,4,3};
		int res = new Q82().singleNumber(A);
		System.out.println(res);
	}

}
