package leetCode;

/**
 * Created by shuaipeng on 12/28/16.
 */
public class Q387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
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
}
