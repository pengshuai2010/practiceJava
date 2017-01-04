package leetCode;

/**
 * Created by speng on 1/3/17.
 */
public class Q400_Nth_Digit {
    /**
     * There are 9 1-digit numbers, 90 2-digit numbers, 900 3-digit numbers, ...
     */
    public int findNthDigit(int n) {
        //overflow corner case: n = 1000000000, expected result is 1
        long m = n;
        int numDigits = 1;
        int power = 1;
        while (m > 9L * power * numDigits) {
            m -= 9L * power * numDigits;
            power *= 10;
            numDigits++;
        }
        long number = power + (m - 1) / numDigits;
        long k = (m - 1) % numDigits + 1;
        while (numDigits > k) {
            number /= 10;
            numDigits--;
        }
        return (int) (number % 10);
    }
}
