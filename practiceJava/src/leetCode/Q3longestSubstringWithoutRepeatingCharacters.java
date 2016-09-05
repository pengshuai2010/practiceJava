package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by speng on 9/5/16.
 */
public class Q3longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new Q3longestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Q3longestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Q3longestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int p = 0, q = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (p < s.length()) {
            if (set.contains(s.charAt(p))) {
                set.remove(s.charAt(q));
                q++;
            } else {
                set.add(s.charAt(p));
                if (set.size() > max)
                    max = set.size();
                p++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int p = 0, q = 0;
        int max = 0;
        int length = 0;
        // if the character set is ascii, we can simply use boolean array
        // but be sure to ask the interview what is the character set
        boolean[] isInSubstring = new boolean[128];
        while (p < s.length()) {
            if (isInSubstring[s.charAt(p)]) {
                isInSubstring[s.charAt(q)] = false;
                length--;
                q++;
            } else {
                isInSubstring[s.charAt(p)] = true;
                length++;
                max = Math.max(length, max);
                p++;
            }
        }
        return max;
    }
}
