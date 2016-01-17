/**
 * 
 */
package lintCode;

/**
 * @author speng
 *
 */
public class Q13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "";
//		String s = "abcdefg";
//		String t = "abcdefg";
//		String t = "abc";
//		String t = "bcd";
//		String t = "efg";
		String t = "efi";
//		String t = "i";
//		String t = "";
		int p = new Q13().strStr(s, t);
		System.out.println(p);
		if (p != -1) {
			System.out.println(s.substring(p, p + t.length()));
		}
		
	}
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
    	//what if target is empty string?
    	if (source == null || target == null) {
    		return -1;
    	}
    	int p;
        for (p = 0; p + target.length() - 1 < source.length(); p++) {
        	int i = 0;
        	//note put i < target.length() to take advantage of logic shortcut
        	while (i < target.length() && source.charAt(p + i) == target.charAt(i))
        		i++;
        	if (i == target.length())
        		break;
        }
        //we should use '>=' instead of '==', or result is wrong when source is empty string
        if (p + target.length() - 1 >= source.length()) 
        	return -1;
        return p;
    }
}
