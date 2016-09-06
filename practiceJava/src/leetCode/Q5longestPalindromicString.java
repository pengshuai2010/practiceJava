package leetCode;

/**
 * Created by speng on 9/5/16.
 */
public class Q5longestPalindromicString {
    public static void main(String[] args) {
        System.out.println(new Q5longestPalindromicString().longestPalindrome("ab"));
        System.out.println(new Q5longestPalindromicString().longestPalindrome("a"));
        System.out.println(new Q5longestPalindromicString().longestPalindrome("aa"));
        System.out.println(new Q5longestPalindromicString().longestPalindrome("xaa"));
        System.out.println(new Q5longestPalindromicString().longestPalindrome("zxabax"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int max = 0;
        int start = 0;
        // this algorithm is simple and intuitive. At each element, it tries to extend to a palindrome evenly and oddly,
        // and record the longest.
        // Another solution is dynamic programming.
        for (int i = 0; i < s.length(); i++) {
            int oddLength = extend(s, i, i);
            int evenLength = extend(s, i, i + 1);
            if (oddLength > evenLength && oddLength > max) {
                max = oddLength;
                start = i - oddLength / 2;
            } else if (evenLength > oddLength && evenLength > max) {
                max = evenLength;
                start = i - evenLength / 2 + 1;
            }
        }
        return s.substring(start, start + max);
    }

    private int extend(String s, int i, int j) {
        if (s == null || i > j)
            return 0;
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i + 1 - 2;
    }
}
