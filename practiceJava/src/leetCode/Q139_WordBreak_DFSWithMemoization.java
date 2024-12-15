package leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139_WordBreak_DFSWithMemoization {
    private boolean canBeSegmented;

    public boolean wordBreak(String s, List<String> wordDict) {
        // will s be null or empty ? will word dict be emtpy?
        if (s.isEmpty()) {
            return false;
        }
        Set<Integer> seen = new HashSet<>();
        this.canBeSegmented = false;
        helper(s, 0, wordDict, seen);
        return this.canBeSegmented;
    }

    private void helper(String s, int startIndex, List<String> wordDict, Set<Integer> seen) {
        if (seen.contains(startIndex)) { // memoization
            return;
        }
        seen.add(startIndex);
        if (this.canBeSegmented) {
            return;
        }
        if (startIndex == s.length()) {
            this.canBeSegmented = true;
            return;
        }
        for (String word : wordDict) {
            if (s.indexOf(word, startIndex) == startIndex) {
                helper(s, startIndex + word.length(), wordDict, seen);
            }
        }
    }
}
