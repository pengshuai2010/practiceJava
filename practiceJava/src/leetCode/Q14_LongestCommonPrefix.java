package leetCode;

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // will strs be null, will str be empty?
        // will any string in str be null or empty?
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int j = 0; j < strs[0].length(); j++) {  // the length of common prefix is at most the length of strs[0]
            char ch = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == j || strs[i].charAt(j) != ch) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }
}
