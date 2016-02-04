package lintCode;

public class Q116 {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
    	boolean[] jumpable = new boolean[A.length];
    	for (int i = 0; i < A.length; i++)
    		for (int j = 0; j < A[i] && i + j < A.length; j++)
    			jumpable[i + j] = true;
    	for (int i = 0; i < jumpable.length - 1; i++)
    		if(!jumpable[i])
    			return false;
    	return true;
    }
	public static void main(String[] args) {
//		int[] A = new int[] {2,3,1,1,4};
		int[] A = new int[] {3,2,1,0,4};
		boolean res = new Q116().canJump(A);
		System.out.println(res);
	}

}
