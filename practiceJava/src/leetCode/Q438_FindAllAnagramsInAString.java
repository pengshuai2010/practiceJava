package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 1/14/17.
 */
public class Q438_FindAllAnagramsInAString {
    /**
     *
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() < 1 || p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] tableP = new int[26];
        for (int i = 0; i < p.length(); i++) {
            tableP[p.charAt(i) - 'a']++;
        }
        int[] tableS = new int[26];
        for (int i = 0; i < p.length(); i++) {
            tableS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(tableP, tableS)) {
            res.add(0);
        }
        //takes O((m - n)*l) time, where l is number of distinct characters in p
        //since we know the character set is lower case English letters, the time complexity is O(m - n)
        for (int i = 1; i < s.length() - p.length() + 1; i++) {
            tableS[s.charAt(i - 1) - 'a']--;
            tableS[s.charAt(i + p.length() - 1) - 'a']++;
            if (Arrays.equals(tableP, tableS)) {
                res.add(i);
            }
        }
        return res;
    }
}
