package lintCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by speng on 8/31/16.
 */
public class Q107wordBreak {
    public static void main(String[] args) {
        System.out.println(new Q107wordBreak().wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code", "lee"))));
        System.out.println(new Q107wordBreak().wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "ode", "lee"))));
        System.out.println(new Q107wordBreak().wordBreak("leetcode", new HashSet<String>(Arrays.asList("leetc", "code", "lee"))));
    }

    /**
     * @param s:    A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null)
            return false;
        if (s.length() == 0)
            return true;
        if (dict.size() == 0)
            return false;
        int maxLength = 0;
        for (String str : dict) {
            maxLength = Math.max(maxLength, str.length());
        }
        boolean[] table = new boolean[s.length() + 1];
        table[0] = true;
        for (int i = 1; i < s.length() + 1; i++)
            for (int j = i - 1; j >= 0 && i - j <= maxLength; j--)
                // use max length of strings in dict to trim branch
                if (table[j] && dict.contains(s.substring(j, i))) {
                    table[i] = true;
                    break;
                }
        return table[s.length()];
    }
}
