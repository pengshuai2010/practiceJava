package lintCode;

import java.util.*;

/**
 * Created by speng on 2/11/17.
 */
public class Q582_WordBreakII {

    /**
     * @param s        a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> solutions = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return solutions;
        }

        HashMap<String, List<String>> memo = new HashMap<>();
        //dfs(s, 0, new ArrayList<String>(), solutions, wordDict);
        return dfsMemoized(s, wordDict, memo);
    }

    private List<String> dfsMemoized(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        //we should not rely on the following code to handle exit condition, because this will cause the
        // "for (String secondPart : tmp)" loop not being entered by the end of input string, workBreak() will
        //return an empty list.
//        if (s.length() == 0) {
//            return new ArrayList<>();
//        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String firstPart = s.substring(0, i + 1);
            if (wordDict.contains(firstPart)) {
                if (i + 1 == s.length()) {//we have reached the end of input string, no need to dfs further
                    res.add(firstPart);
                    break;
                }
                List<String> tmp = dfsMemoized(s.substring(i + 1), wordDict, memo);
                for (String secondPart : tmp) {
                    res.add(firstPart + " " + secondPart);
                }
            }
        }
        memo.put(s, res);
        return res;
    }


    /**
     * This solution takes O(S*n) time. S is the number of answers, n is the time it takes to build an answer. When the
     * input is s = "aaaaaaaaaa...a", wordDict = ["a", "aa", "aaa", "aaaa", ..., "aaaaa..a"], there are 2^n answers, so
     * in the worst case the time complexity is O(n*2^n), which is too long time.
     */
    private void dfs(String s, int start, List<String> path, List<String> solutions, Set<String> wordDict) {
        if (start == s.length()) {
            solutions.add(buildSolution(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String part = s.substring(start, i + 1);
            if (wordDict.contains(part)) {
                path.add(part);
                dfs(s, i + 1, path, solutions, wordDict);
                path.remove(path.size() - 1);
            }
        }
    }


    /**
     * test case: path is empty, path has only one element
     */
    private String buildSolution(List<String> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i == 0) {
                sb.append(path.get(i));
            } else {
                sb.append(" ").append(path.get(i));
            }
        }
        return sb.toString();
    }
}
