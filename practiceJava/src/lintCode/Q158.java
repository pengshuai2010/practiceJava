/**
 * 
 */
package lintCode;

/**
 * @author shuaipeng
 *
 */
public class Q158 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @param s:
	 *            The first string
	 * @param b:
	 *            The second string
	 * @return true or false
	 */
	public boolean anagram(String s, String t) {
		//Write a method anagram(s,t) to decide if two strings are anagrams or not.
		//need to ask range of character in the string
		//are they garanteed to be ascii characters?
		if (s.length() != t.length()) {
			return false;
		}
		char[] stats = new char[256];
		for (int i = 0; i < s.length(); i++) {
			stats[s.charAt(i)]++;
		}
		for (int i = 0; i < t.length(); i++) {
			stats[t.charAt(i)]--;
			if (stats[t.charAt(i)] < 0) {
				return false;
			}
		}
		for (int i = 0; i < 256; i++) {
			if (stats[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
