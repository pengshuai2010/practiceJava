package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by speng on 12/31/16.
 */
public class Q266_PalindromePermutation {
    public boolean canPermutePalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        //when need hash table of characters, ask about character set first
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int numOddCounts = 0;
        for (char ch : map.keySet()) {
            if (map.get(ch) % 2 == 1) {
                numOddCounts++;
            }
            if (numOddCounts > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Another way to do it is to use HashSet. We don't really care about the exact occurrence count of each character,
     * we only care about if the count is odd. So For each character in the string, if it's not in the set, we add it in;
     * if already there, we removed it. At the end we only need to check if the size of the set is less than 2.
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() < 2;
    }
}
