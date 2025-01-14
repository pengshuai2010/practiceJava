package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 9/6/16.
 */
public class Q9palindromeNumber {
    public static void main(String[] args) {
        System.out.println(new Q9palindromeNumber().isPalindrome(0));
        System.out.println(new Q9palindromeNumber().isPalindrome(1));
        System.out.println(new Q9palindromeNumber().isPalindrome(10));
        System.out.println(new Q9palindromeNumber().isPalindrome(101));
        System.out.println(new Q9palindromeNumber().isPalindrome(-101));
        System.out.println(new Q9palindromeNumber().isPalindrome(Integer.MAX_VALUE));
        System.out.println(new Q9palindromeNumber().isPalindrome(Integer.MIN_VALUE));
    }

    // another solution is to use string
    // yet another, same idea but faster https://discuss.leetcode.com/topic/8090/9-line-accepted-java-code-without-the-need-of-handling-overflow
    public boolean isPalindrome(int x) {
        // will x be negative?
        if (x < 0) {
            return false;
        }
        List<Integer> digits = new ArrayList<>();
        int value = x;
        while (value > 0) {
            digits.add(value % 10);
            value /= 10;
        }
        for (int i = 0, j = digits.size() - 1; i < j; i++, j--) {
            if (digits.get(i) != digits.get(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        // will x be negative?
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
