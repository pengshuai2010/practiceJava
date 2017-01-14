/**
 *
 */
package lintCode;

/**
 * @author speng
 */
public class Q13_strStr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "";
        // String s = "abcdefg";
        // String t = "abcdefg";
        // String t = "abc";
        // String t = "bcd";
        // String t = "efg";
        String t = "efi";
        // String t = "i";
        // String t = "";
        int p = new Q13_strStr().strStr(s, t);
        System.out.println(p);
        if (p != -1) {
            System.out.println(s.substring(p, p + t.length()));
        }

    }

    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        //ask interview what is expected if target is empty string
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {//be careful of boundary!
            boolean isEqual = true;
            for (int j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return i;
            }
        }
        return -1;
    }
}
