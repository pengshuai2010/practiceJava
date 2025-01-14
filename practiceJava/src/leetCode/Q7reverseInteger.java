package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuaipeng on 9/6/16.
 */
public class Q7reverseInteger {
    public static void main(String[] args) {
        System.out.println(new Q7reverseInteger().reverse(190));
        System.out.println(new Q7reverseInteger().reverse(-190));
        System.out.println(new Q7reverseInteger().reverse(Integer.MAX_VALUE));
        System.out.println(new Q7reverseInteger().reverse(Integer.MIN_VALUE));
    }

    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        boolean nonNegative = x >= 0;
        List<Integer> digits = new ArrayList<>();
        int value = nonNegative ? x : -x;
        while (value > 0) {
            digits.addLast(value % 10);
            value /= 10;
        }
        // for x = 123, digits is [3, 2, 1]
        long sum = 0;
        for (int digit: digits) {
            sum = sum * 10 + digit;
        }
        sum = nonNegative ? sum : -sum;
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }
}
