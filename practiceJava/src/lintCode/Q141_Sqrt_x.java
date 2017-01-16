package lintCode;

public class Q141_Sqrt_x {
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
    public static void main(String[] args) {
        // int x = 1;
        int x = 999999999;
        int res = new Q141_Sqrt_x().sqrt(x);
        System.out.println(res);
        double preciseRes = new Q141_Sqrt_x().sqrt((double) x);
        System.out.println(preciseRes);
        System.out.println(Math.sqrt((double) x));
    }

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        //actually look for the maximum number y such that y * y <= x
        long low = 0;
        long high = x;
        while (low + 1 < high) {
            long mid = low + (high - low) / 2;
            long midSquared = mid * mid;//always beware of overflow when multiply!
            if (midSquared < x) {
                low = mid;
            } else if (midSquared > x) {
                high = mid - 1;
            } else {
                return (int) mid;
            }
        }
        if (high * high <= x) {
            return (int) high;
        }
        if (low * low <= x) {
            return (int) low;
        }
        return -1;
    }

    //Newton's method
    //To solve f(x) = 0,
    //x_next = x_curr - f(x_curr)/f'(x_curr), where f'(x) is the derivative of function f(x)
    //until abs(x_next - x_curr) < a small decimal like 1e-3
    public double sqrt(double m) {
        double last = 0;
        double current = 1;//initial guess
        double diff = 0.0001;
        while (last - current > diff || last - current < -diff) {
            last = current;
            current = (last + m / last) / 2;
        }
        return current;
    }

}
