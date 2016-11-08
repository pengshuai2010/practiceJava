package leetCode;

/**
 * Created by shuaipeng on 11/8/16.
 */
public class Q29_DivideTwoIntegers {
    public static void main(String[] args) {
        Q29_DivideTwoIntegers solution = new Q29_DivideTwoIntegers();
        int[] inputs = new int[]{0, 3, 2, 3, 12, 3, 16, 3, -2, 3, -12, 3, -16, 3, 2147483647, 2};
        for (int i = 0; i < inputs.length; i += 2) {
            System.out.println(inputs[i] + " / " + inputs[i + 1]);
            System.out.println(solution.divide(inputs[i], inputs[i + 1]));
        }
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new ArithmeticException("divide by zero");
        if (dividend == 0)
            return 0;
        int sign = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
            sign = -1;
        // use long type to avoid overflow
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long res = 0;
        // a naive solution
//        while (ldividend >= ldivisor) {
//            ldividend -= ldivisor;
//            res++;
//        }
        // O(log(n)) solution
        res = fastDivide(ldividend, ldivisor);
        if (res > Integer.MAX_VALUE)
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return (int) (sign * res);
    }

    /**
     * similar to the idea of binary search
     */
    private long fastDivide(long dividend, long divisor) {
        if (dividend < divisor)// recursion exit condition
            return 0;
        if (dividend == divisor)
            return 1;
        long res = 1;
        long sum = divisor;
        while (sum <= dividend) {
            sum <<= 1;
            res <<= 1;
        }
        sum >>= 1;
        res >>= 1;
        // the remaining part is also divided using fast divide
        // so that there is no slow O(n) add up
        return res + fastDivide(dividend - sum, divisor);
    }
}
