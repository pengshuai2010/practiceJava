package leetCode;

public class Q125_ValidPalindrome {
    private static boolean isValid(char ch) {
        return isLowerCaseLetter(ch) || isUpperCaseLetter(ch) || isDigit(ch);
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private static boolean isLowerCaseLetter(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private static boolean isUpperCaseLetter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static char toLowerCase(char ch) {
        int diff = 'A' - 'a';
        return (char) (ch - diff);
    }

    private static boolean equalsIgnoreCase(char ch1, char ch2) {
        if (isUpperCaseLetter(ch1)) {
            ch1 = toLowerCase(ch1);
        }
        if (isUpperCaseLetter(ch2)) {
            ch2 = toLowerCase(ch2);
        }
        return ch1 == ch2;
    }

    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // clarify if s is null
        // clarify what could be in s, letters, numbers, symbols etc, what is counted when deciding if palindrome
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) { // check the invariant in inner loop!
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
            if (!equalsIgnoreCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
