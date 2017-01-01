package leetCode;

import java.util.*;

/**
 * Created by speng on 1/1/17.
 */
public class Q131_PalindromePartitioning {
    private Map<String, Boolean> palindrome;

    /**
     * DFS + Memoization
     */
    public List<List<String>> partition(String s) {
        List<List<String>> solutions = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return solutions;
        }
        palindrome = new HashMap<>();
        return dfs(s, new HashMap<>());
    }

    /**
     * We use memoization, so no need for path and solutions.
     */
    private List<List<String>> dfs(String s, Map<String, List<List<String>>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        map.put(s, new ArrayList<>());
        if (s.length() == 0) {
            return map.get(s);
        }
        if (isPalindrome(s)) {
            map.get(s).add(Collections.singletonList(s));
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (isPalindrome(left)) {//optimize here?
                List<List<String>> right = dfs(s.substring(i, s.length()), map);
                for (List<String> part : right) {
                    List<String> whole = new ArrayList<>();
                    whole.add(left);
                    whole.addAll(part);
                    map.get(s).add(whole);
                }
            }
        }
        return map.get(s);
    }

    private boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        if (palindrome.containsKey(s)) {
            return palindrome.get(s);
        }
        boolean isPalindrome = true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
            }
        }
        palindrome.put(s, isPalindrome);
        return isPalindrome;
    }
}
