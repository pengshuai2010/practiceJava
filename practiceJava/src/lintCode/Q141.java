package lintCode;

public class Q141 {
	/*
	 * Sqrt(x) Show result
	 * 
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 * 
	 * Example sqrt(3) = 1
	 * 
	 * sqrt(4) = 2
	 * 
	 * sqrt(5) = 2
	 * 
	 * sqrt(10) = 3
	 * 
	 * Challenge O(log(x))
	 */
	/**
	 * @param x:
	 *            An integer
	 * @return: The sqrt of x
	 */
	public int sqrt(int x) {
		// assume x >= 0
		if (x == 0)
			return 0;
		long start = 1;// since product is involved, use long to avoid overflow
		long end = x/2 + 1;
		while (start < end) {
			long mid = (start + end) / 2;
			long squared = mid * mid;
			if (squared > x)
				end = mid - 1;
			else if (squared < x)
				start = mid + 1;
			else
				return (int) mid;
		}
		if (start * start > x)
			return (int) (start - 1);
		else
			return (int) start;
	}
	
	public double sqrt(double m) {
		double last = 0;
		double current = 1;//initial guess
		double diff = 0.0001;
		while(last - current > diff || last - current < - diff) {
			last = current;
			current = (last + m/last)/2;
		}
		return current;
	}

	public static void main(String[] args) {
		// int x = 1;
		int x = 999999999;
		int res = new Q141().sqrt(x);
		System.out.println(res);
		double  preciseRes = new Q141().sqrt((double)x);
		System.out.println(preciseRes);
		System.out.println(Math.sqrt((double)x));
	}

}
