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
    public List<List<String>> partition1(String s) {
        List<List<String>> solutions = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return solutions;
        }
        palindrome = new HashMap<>();
        return dfs(s, new HashMap<>());
    }

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

    /**
     * simple DFS, takes O(2^n) time in worst case. e.g. "aaaaaaaaaaaaaaa"
     */
    public List<List<String>> partition(String s) {
        List<List<String>> solutions = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return solutions;
        }
        helper(s, 0, new ArrayList<>(), solutions);
        return solutions;
    }

    private void helper(String s, int start, List<String> path, List<List<String>> solutions) {
        if (start == s.length()) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(path);
            solutions.add(tmp);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {//i is exclusive
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i));
                helper(s, i, path, solutions);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * end is exclusive
     */
    private boolean isPalindrome(String s, int start, int end) {
        if (end - start < 2) {
            return true;
        }
        for (int i = start, j = end - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
