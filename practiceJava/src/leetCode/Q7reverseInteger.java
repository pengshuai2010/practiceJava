package leetCode;

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

    public int reverse2(int x) {
        boolean isNegative = x < 0;
        long number = Math.abs((long) x);
        long reverse = 0;
        long base = 10;
        while (number != 0) {
            reverse = reverse * base + number % base;
            number /= base;
        }
        if (isNegative)
            reverse = -reverse;
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reverse;
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;
        // the following statement won't work as you expect when x = -2147483648 i.e. Interger.MIN_VALUE
        // this is because +2147483648 is greater than Interger.MAX_VALUE, so it will roll over to -2147483648
//        long number = Math.abs(x);
        long number = Math.abs((long) x);
        StringBuilder sb = new StringBuilder(number + "");
        sb.reverse();
        long reverse = Long.parseLong(sb.toString());
        if (isNegative)
            reverse = -reverse;
        if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)
            return 0;
        return (int) reverse;
    }
}
