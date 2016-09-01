package lintCode;

/**
 * Created by speng on 8/28/16.
 */
public class Q119 {
    public static void main(String[] args) {
//        String word1 = "mart";
//        String word2 = "karma";
//        String word1 = "";
//        String word2 = "karma";
        String word1 = "dinitrophenylhydrazine";
        String word2 = "acetylphenylhydrazine";

        System.out.println(new Q119().minDistance(word1, word2));
    }

    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // use Wagner–Fischer algorithm to calculate edit distance
        // see https://en.wikipedia.org/wiki/Wagner–Fischer_algorithm
        if (word1 == null || word2 == null)
            return -1;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int m = word1.length();
        int n = word2.length();
        int[][] table = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++)
            table[i][0] = i;
        for (int j = 0; j < n + 1; j++)
            table[0][j] = j;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1];
                else {
                    int ins = table[i][j - 1] + 1;
                    int del = table[i - 1][j] + 1;
                    int sub = table[i - 1][j - 1] + 1;
                    table[i][j] = Math.min(ins, Math.min(del, sub));
                }
        return table[m][n];
    }
}
