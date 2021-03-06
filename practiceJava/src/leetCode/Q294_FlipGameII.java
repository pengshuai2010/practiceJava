package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 1/5/17.
 */
public class Q294_FlipGameII {
    Map<String, Boolean> map = new HashMap<>();

    /**
     * min-max algorithm. Time complexity analysis: define T(n) as time complexity when input size is n. suppose input
     * are all "+", T(n) = (n - 2) * T(n - 2) = (n - 2) * (n - 4) * T(n - 4) = ... = O(n!). We can improve the time
     * complexity by memoization. With memoization, a loose bound is O(2^n) as each element can be either '+' or '-'.
     */
    public boolean canWin1(String s) {
        if (s == null) {
            throw new java.lang.IllegalArgumentException();
        }
        return canIwin(s.toCharArray());
    }

    /**
     * memoization won't work for char array, unless you wrap it in a class and override the equals() method using
     * Arrays.equals(char[], char[]) and override the hashcode() using Arrays.hashcode(char[])
     */
    private boolean canIwin(char[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                boolean wins = !canIwin(s);
                s[i] = '+';
                s[i + 1] = '+';
                if (wins) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * min-max algorithm with memoization
     */
    public boolean canWin(String s) {
        if (s == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        boolean canIwin = false;
        StringBuilder sb = new StringBuilder(s);//note that creating StringBuilder need to copy whole string, takes O(n) time
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                if (!canWin(sb.toString())) {
                    canIwin = true;
                    break;
                }
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
        }
        map.put(s, canIwin);
        return canIwin;
    }
}
