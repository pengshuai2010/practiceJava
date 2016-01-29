package lintCode;

public class Q142 {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
    	if (n <= 0)
    		return false;
    	return (n & (n - 1)) == 0;
    }
	public static void main(String[] args) {
		int n = 0;
		boolean res = new Q142().checkPowerOf2(n);
		System.out.println(res);
	}

}
