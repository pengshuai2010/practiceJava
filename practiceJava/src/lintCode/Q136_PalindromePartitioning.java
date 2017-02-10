package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 2/9/17.
 */
public class Q136_PalindromePartitioning {
    private boolean[][] isPalindrome;

    /**
     * @param s: A string
     * @return A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        isPalindrome = new boolean[n][n];
        //dp[i][i] = true
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        //dp[i - 1][i] = s[i - 1] == s[i]
        for (int i = 1; i < n; i++) {
            isPalindrome[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        //dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j] when j >= i + 2
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int index, List<String> path, List<List<String>> solutions) {
        if (index == s.length()) {
            solutions.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                path.add(s.substring(index, i + 1));
                dfs(s, i + 1, path, solutions);
                path.remove(path.size() - 1);
            }
        }
    }
}
