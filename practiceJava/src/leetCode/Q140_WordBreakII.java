package leetCode;

import java.util.*;

/**
 * Created by speng on 11/20/16.
 */
public class Q140_WordBreakII {
    private Map<String, List<String>> cache = new HashMap<>();

    //"catsanddog"
    //["cat","cats","and","sand","dog"]
    public static void main(String[] args) {
        Q140_WordBreakII solution = new Q140_WordBreakII();
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(solution.wordBreak("catsanddog", wordDict));
    }

    public List<String> wordBreak1(String s, Set<String> wordDict) {
        List<String> solutions = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return solutions;
        int maxLength = 0;//consider min length?
        for (String str : wordDict)
            maxLength = Math.max(maxLength, str.length());
        dfs(s.toCharArray(), 0, wordDict, new ArrayList<String>(), solutions, maxLength);
        return solutions;
    }

    /**
     * a naive DFS solution
     */
    private void dfs(char[] s, int index, Set<String> wordDict, List<String> partial, List<String> solutions, int maxLength) {
        if (index >= s.length) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String str : partial) {
                if (first) {
                    sb.append(str);
                    first = false;
                } else {
                    sb.append(" ").append(str);
                }
            }
            solutions.add(sb.toString());
            return;
        }
        for (int i = index + 1; i <= s.length && i - index <= maxLength; i++) {
            String cb = new String(s, index, i - index);
            if (wordDict.contains(cb)) {
                partial.add(cb);
                dfs(s, i, wordDict, partial, solutions, maxLength);
                partial.remove(partial.size() - 1);
            }
        }
    }

    // another solution is to use DP + DFS. see method 1 of https://discuss.leetcode.com/topic/34260/java-dp-dfs-memoization-dfs-and-dp-pruning-solutions-with-analysis

    /**
     * this is a DFS + memoization solution. We memoize previous results to avoid duplicate calculation.
     * If we remove the memoization code, it is still a correct solution. However, in the worst case where
     * s = "aaaaaa", wordDict = {"a", "aa", "aaa", "aaaa", "aaaaa"}, there will be many duplicate calculation,
     * time complexity is C(5, 5) + C(4, 5) + C(3, 5) + C(2, 5) + C(1, 5) = O(2^n).
     * With memoization, time complexity is O(n^2), because for "a", "aa", "aaa", "aaaa", "aaaaa", we only need
     * to calculate once, then get the results in O(1) later.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }
        if (cache.containsKey(s))// memoization
            return cache.get(s);
        if (wordDict.contains(s))
            res.add(s);
        // we can optimize here by first trimming branches: first get the max length of words in wordDict, then let
        // i < s.length() && i < maxLength
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left)) {
                for (String partial : wordBreak(s.substring(i), wordDict)) {
                    res.add(left + " " + partial);
                }
            }
        }
        cache.put(s, res);// memoization
        return res;
    }
}
