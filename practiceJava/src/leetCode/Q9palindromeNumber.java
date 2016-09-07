package leetCode;

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
        if (x < 0)
            return false;
        long reverse = 0;
        long tmp = (long) x;
        while (tmp != 0) {
            long val = tmp % 10;
            tmp /= 10;
            reverse = reverse * 10 + val;
        }
        return reverse == (long) x;
    }
}
