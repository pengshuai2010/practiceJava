package lintCode;

public class Q179 {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
    	// always pay extra attention to overflow in bit manipulation
    	long mask =  (1L<<(j - i + 1)) - 1;
    	mask <<= i;
    	mask = ~mask;
    	long res = n & mask;
    	m <<= i;
    	res |= m;
    	return (int) res;
    }
	public static void main(String[] args) {
//		int n = 0b10000001101;
//		int m = 0b10101;
//		int i=2, j=6;
		int n = -2147483648;
		int m = 2147483647;
		int i=0, j=30;
		int res = new Q179().updateBits(n, m, i, j);
		System.out.println(Integer.toBinaryString(res));
		System.out.println(res);
	}

}
