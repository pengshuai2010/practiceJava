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

    private int start;
    private int end;
    private int maxLength;

    public String longestPalindrome(String s) {
        // will s be empty? null?
        this.start = 0;
        this.end = -1;
        this.maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            expand(i, i, s);
            // at the end (i + 1) is s.length() but it's OK because there is an inBoundary check in expand method
            expand(i, i + 1, s);
        }
        if (this.maxLength == 0) {
            return "";
        }
        return s.substring(start, end + 1);
    }

    private void expand(int left, int right, String s) {
        while (inBoundary(left, right, s.length()) && s.charAt(left) == s.charAt(right)) {
            int length = right - left + 1;
            if (length > this.maxLength) {
                this.start = left;
                this.end = right;
                this.maxLength = length;
            }
            left--;
            right++;
        }
    }

    private boolean inBoundary(int j, int k, int length) {
        return j >= 0 && k < length;
    }
}
