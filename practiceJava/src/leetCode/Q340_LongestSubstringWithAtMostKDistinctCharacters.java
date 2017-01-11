package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by speng on 1/10/17.
 */
public class Q340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (s == null || k < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = -1;
        int maxLength = 0;
        while (j < s.length()) {
            if (map.size() <= k) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
                if (j < s.length()) {//need to check because we increased j
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }
            } else {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        return maxLength;
    }

    /**
     * Using two pointers as a sliding window, and use HashMap to count occurrences of distinct characters
     * in the sliding window. Same idea but this implementation is better.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            while (map.size() > k) {
                char lChar = s.charAt(left);
                //each time before calling map.get(key) must make sure key is in the map
                //we don't use if (map.containsKey(lChar)) here because it's loop invariant that
                //at this point s[left] must have been sweeped by right pointer
                map.put(lChar, map.get(lChar) - 1);
                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }
                left++;
            }
            //afthe the while loop, it is guaranteed that distinct characters are no more than k
            maxLength = Math.max(maxLength, right - left + 1);
            //we must increase left pointer AFTER updating maxLength
            right++;
        }
        return maxLength;
    }
}
