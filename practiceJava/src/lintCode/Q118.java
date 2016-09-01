package lintCode;

/**
 * Created by shuaipeng on 8/29/16.
 */
public class Q118 {
    public static void main(String[] args) {
        System.out.println(new Q118().numDistinct("rabbbit", "rabbit"));
        System.out.println(new Q118().numDistinct("rabbbit", ""));
        System.out.println(new Q118().numDistinct("it", "rabbit"));
    }

    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    // http://bangbingsyb.blogspot.com/2014/11/leetcode-distinct-subsequences.html
    public int numDistinct(String S, String T) {
        if (S == null || T == null)
            return -1;
        if (T.length() == 0)// delete all characters in S
            return 1;
        if (S.length() < T.length())
            return 0;
        int m = T.length();
        int n = S.length();
        int[][] table = new int[m + 1][n + 1];
        for (int j = 0; j < n + 1; j++)
            table[0][j] = 1;
        for (int i = 1; i < m + 1; i++)
            table[i][0] = 0;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if (T.charAt(i - 1) == S.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + table[i][j - 1];
                else
                    table[i][j] = table[i][j - 1];
        // be careful! the largest index of a (n + 1)-long array is n
        return table[m][n];
    }
}
