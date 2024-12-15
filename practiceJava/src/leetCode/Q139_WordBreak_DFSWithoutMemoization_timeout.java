package leetCode;

import java.util.List;

public class Q139_WordBreak_DFSWithoutMemoization_timeout {
    private boolean canBeSegmented;

    public boolean wordBreak(String s, List<String> wordDict) {
        // will s be null or empty ? will word dict be emtpy?
        if (s.isEmpty()) {
            return false;
        }
        this.canBeSegmented = false;
        helper(s, 0, wordDict);
        return this.canBeSegmented;
    }

    // Consider when s = "aaaaaaaaaa...a", and wordDict is ["a", "aa", "aaa", "aaaa", ...], and
    // the total number of 'a's is the same as that in s. The size of wordDict n is about O(sqrt(s))
    // because (1 + n) * n / 2 = s. So the total number of combination is n!, i.e. (sqrt(s))!
    // By memoization, each position in s is only calculated once.
    private void helper(String s, int startIndex, List<String> wordDict) {
        if (this.canBeSegmented) {
            return;
        }
        if (startIndex == s.length()) {
            this.canBeSegmented = true;
            return;
        }
        for (String word : wordDict) {
            if (s.indexOf(word, startIndex) == startIndex) {
                helper(s, startIndex + word.length(), wordDict);
            }
        }
    }
}
