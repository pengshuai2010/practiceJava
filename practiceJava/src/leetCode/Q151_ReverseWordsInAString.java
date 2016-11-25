package leetCode;

/**
 * Created by speng on 11/24/16.
 */
public class Q151_ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null)
            return "";
        s = s.trim();
        if (s.length() == 0)
            return "";
        String[] tokens = s.split("\\s+");// note that '\s' is not an escape character like '\n', so we need to escape the
        // backlash using double backlash
        StringBuilder sb = new StringBuilder();//or use StringJoiner if Java 8 is supported
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (i == tokens.length - 1)
                sb.append(tokens[i]);
            else
                sb.append(" ").append(tokens[i]);
        }
        return sb.toString();
    }
}
