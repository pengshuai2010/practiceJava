package leetCode;

public class Q1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        // will any of word1 or word2 be empty?
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length() || i < word2.length(); i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
