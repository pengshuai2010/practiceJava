package leetCode;

/**
 * Created by speng on 11/13/16.
 */
public class Q50_Power_x_n {
    /**
     * time complexity log(n)
     */
    public double myPow(double x, int n) {
        //assume no double overflow
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return power(x, n);
    }

    /**
     * all natural numbers can be considered as the sum of powers of 2
     * 13 = 8 + 4 + 1 = 2^3 + 2^2 + 2^1
     */
    private double power1(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        int pow = 1;
        double res = x;
        while (pow <= n / 2) {
            res *= res;
            pow <<= 1;
        }
        // after loop, n >= pow
        return res * power(x, n - pow);
    }

    /**
     * more concise and elegant
     * 13 = 1 + 2*6 = 1 + 2*2*3 = 1 + 2*2*(1 + 2)
     */
    private double power(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        return n % 2 == 0 ? power(x * x, n / 2) : x * power(x * x, n / 2);
    }
}
