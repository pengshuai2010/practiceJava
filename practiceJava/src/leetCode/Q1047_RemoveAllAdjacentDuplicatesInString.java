package leetCode;

public class Q1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        // will s be empty?
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != ch) {
                sb.append(ch);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
