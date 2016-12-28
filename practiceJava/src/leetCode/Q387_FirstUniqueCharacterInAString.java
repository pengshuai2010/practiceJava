package leetCode;

/**
 * Created by shuaipeng on 12/28/16.
 */
public class Q387_FirstUniqueCharacterInAString {
    /**
     * When dealing with this kind of problems, always clarify the character set.
     */
    public int firstUniqChar1(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * when string is very long, we can save some time by saving index of first occurrence
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] frequency = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            if (frequency[s.charAt(i) - 'a'] == 1) {
                pos[s.charAt(i) - 'a'] = i;
            }
        }
        int firstUnique = s.length();
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1) {
                firstUnique = Math.min(firstUnique, pos[i]);
            }
        }
        if (firstUnique == s.length()) {
            return -1;
        }
        return firstUnique;
    }
}
