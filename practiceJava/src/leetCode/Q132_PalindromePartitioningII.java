package leetCode;

/**
 * Created by speng on 1/1/17.
 */
public class Q132_PalindromePartitioningII {
    public static void main(String[] args) {
        String[] inputs = new String[]{"aab", "abaa"};
        Q132_PalindromePartitioningII solution = new Q132_PalindromePartitioningII();
        for (String input : inputs) {
            System.out.println(solution.minCut(input));
        }
    }

    // takes O(2^n) time
    public int minCut1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = s.charAt(j) == s.charAt(n - 1) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = s.charAt(n - 1 - i) == s.charAt(0) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(n - 1 - i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        if (dp[n - 1][n - 1] == n) {
            return 0;
        }
        for (int i = 1; i < n - 1; i++) {
            if (dfs(s.toCharArray(), 0, i, dp)) {
                return i;
            }
        }
        return n - 1;//for a string of length n, (n - 1) cuts surely works
    }

    private boolean dfs(char[] s, int start, int count, int[][] dp) {
        if (count == 0) {
            return isPalindrome(s, start, s.length - 1, dp);
        }
        for (int i = start; i < s.length - count; i++) {
            if (isPalindrome(s, start, i, dp)) {
                if (dfs(s, i + 1, count - 1, dp)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPalindrome(char[] s, int start, int end, int[][] dp) {
        return dp[s.length - 1 - start][end] >= (end - start + 1);
    }

    /**
     * Use dynamic programming, takes O(n^2) time
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int k = 2; k < n; k++) {//k is the distance between i and j
            for (int i = 0; i + k < n; i++) {
                int j = i + k;
                //s[i, ..., j] is a palindrome if s[i + 1, ..., j - 1] is a palindrome && s[i] == s[j]
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        //dp[i] is the least number of cuts needed for string s[0, ..., (i - 1)], where i >= 1 and i <= n
        int[] dp = new int[n + 1];
        //initialize with maximum possible cuts
        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;//for the first i letters, there are at most (i - 1) cuts, i.e. each letter is its own palindrome
        }
        // dp[i] = min(j) {dp[j] + 1 | j >= 0 and j < i and s[j, ..., (i - 1)] is a palindrome}
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}
