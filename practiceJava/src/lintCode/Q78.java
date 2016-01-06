package lintCode;

public class Q78 {
	/*
	 * Longest Common Prefix Show result 

	Given k strings, find the longest common prefix (LCP).

	Example
	For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"

	For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"
	 */
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return "";
    	for (String s: strs)
    		if (s == null || s.length() == 0)
    			return "";
    	int lcp = 0;
    	for (int i = 0; i < strs[0].length(); i++) {
    		boolean allSame = true;
    		for (int j = 1; j < strs.length; j++)
    			if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
    				allSame = false;
    				break;
    			}
    		if (allSame)
    			lcp++;
    	}
		return strs[0].substring(0, lcp);
    }
	public static void main(String[] args) {
		String[] strs = new String[] {"ABCDEFG", "ABCEFG",  "ABCEFA"};
		String res = new Q78().longestCommonPrefix(strs);
		System.out.println(res);
	}

}
