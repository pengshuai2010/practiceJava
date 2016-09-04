package lintCode;

/**
 * Created by shuaipeng on 9/1/16.
 */
public class Q29InterleavingString {
    public static void main(String[] args) {
        System.out.println(new Q29InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Q29InterleavingString().isInterleave("aabcc", "dbbca", "aabdbbcacc"));
        System.out.println(new Q29InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new Q29InterleavingString().isInterleave("sdfjas;dfjoisdufzjkndfasdkfja;sdfa;dfa;dfaskdjhfasdhjdfakhdgfkajdfasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfhakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh",
                "dfnakdjnfjkzghdufguweygfasjkdfgb2gf8asf7tgbgasjkdfgasodf7asdgfajksdfguayfgaogfsdkagfsdhfajksdvfbgkadsghfakdsfgasduyfgajsdkfgajkdghfaksdgfuyadgfasjkdvfjsdkvfakfgauyksgfajkefgjkdasgfdjksfgadjkghfajksdfgaskdjfgasjkdgfuyaegfasdjkfgajkdfygadjskfgjkadfg",
                "sdfjas;dfjoisdfnakdjnfjkzghdufguwdufzjkeygfasjkdfgb2gf8asf7ndtgbgasjkdfgasodf7asdfgfajkasdksdfguayfgaogfsdkagfsfjadhfajksdvfbgkadsghfa;sdkdsfgasduyfgajsdkfgafajkdghfaksdgfuyadgfas;dfjkdvfjsdkvfakfgauyksa;dgfajkefgjkdasgfdjksffaskdjhfasdhjdfakhdgadjkghfajgfkajdfksdfgaskdjfgasjkdgfuasdjfgajksdfgaksdhfasdkbfjkdsfbajksdfyaegfasdjkfgajkdfygadjskfgjkadfghakjsdfbajkdfbakdjsfgaksdhgfjkdsghfkdsfgadsjfgkajsdgfkjasdfh"));
    }

    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     *
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] DP = new boolean[s1.length() + 1][s2.length() + 1];
        DP[0][0] = true;
        for (int i = 1; i < s1.length() + 1; i++)
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                DP[i][0] = true;
            else break;
        for (int j = 1; j < s2.length() + 1; j++)
            if (s2.charAt(j - 1) == s3.charAt(j - 1))
                DP[0][j] = true;
            else
                break;
        for (int i = 1; i < s1.length() + 1; i++)
            for (int j = 1; j < s2.length() + 1; j++)
                DP[i][j] = DP[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || DP[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        return DP[s1.length()][s2.length()];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if (s1.length() + s2.length() != s3.length())
            return false;
        boolean[] prev = new boolean[s2.length() + 1];
        prev[0] = true;
        for (int j = 1; j < s2.length() + 1; j++)
            prev[j] = prev[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        boolean isMatch = true;
        for (int i = 1; i < s1.length() + 1; i++) {
            boolean[] curr = new boolean[s2.length() + 1];
            if (isMatch && s1.charAt(i - 1) == s3.charAt(i - 1))
                curr[0] = true;
            else
                isMatch = false;
            for (int j = 1; j < s2.length() + 1; j++)
                curr[j] = prev[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || curr[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            prev = curr;
        }
        return prev[s2.length()];

    }
}
