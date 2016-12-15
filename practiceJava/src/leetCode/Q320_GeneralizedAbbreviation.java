package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/14/16.
 */
public class Q320_GeneralizedAbbreviation {
    /**
     * For each character, we can choose whether to abbreviate it or not, so there are 2^n abbreviations. It takes O(n)
     * time to generate an abbreviation. So time complexity is O(n*2^n).
     */
    public List<String> generateAbbreviations1(String word) {
        List<String> list = new ArrayList<>();
        if (word == null) {
            return list;
        }
        boolean[] abbreviated = new boolean[word.length()];
        dfs(word.toCharArray(), 0, abbreviated, list);
        return list;
    }

    /**
     * Use a boolean array to represent if i-th character will be abbreviated.
     */
    private void dfs(char[] word, int start, boolean[] abbreviated, List<String> list) {
        list.add(getAbbreviation(word, abbreviated));
        if (start == word.length) {
            return;
        }
        for (int i = start; i < word.length; i++) {
            abbreviated[i] = true;
            dfs(word, i + 1, abbreviated, list);
            abbreviated[i] = false;
        }
    }

    private String getAbbreviation(char[] word, boolean[] abbrevated) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (abbrevated[i]) {
                count++;
            } else {
                if (count > 0) {
                    sb.append(count);
                    count = 0;
                }
                sb.append(word[i]);
            }
        }
        if (count > 0) {
            sb.append(count);
        }
        return sb.toString();
    }

    /**
     * A trick for problems that need 2^n combinations. We use 1 bit to represent if include or not, so integers in [0, 1 << n)
     * can represent 2^n combinations. This way we don't need DFS or backtracking.
     */
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        if (word == null) {
            return list;
        }
        char[] a = word.toCharArray();
        // can represent at most 2^32 - 1 combinations. This is sufficient for this problem - before we hit that limit,
        // we probably have exhausted heap memory.
        for (int i = 0; i < (1 << word.length()); i++) {
            list.add(getAbbreviation(i, a));
        }
        return list;
    }

    /**
     * essentially the same as getAbbreviation(char[] word, boolean[] abbrevated), except we now use n bits instead of
     * an boolean array of length n.
     */
    private String getAbbreviation(int x, char[] word) {
        int mask = 1 << (word.length - 1);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++, mask >>= 1) {
            if ((x & mask) > 0) {
                count++;
            } else {
                if (count > 0) {
                    sb.append(count);
                    count = 0;
                }
                sb.append(word[i]);
            }
        }
        if (count > 0) {
            sb.append(count);
        }
        return sb.toString();
    }
}
