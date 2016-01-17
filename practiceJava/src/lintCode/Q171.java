package lintCode;

import java.util.ArrayList;
import java.util.List;

public class Q171 {
	/*
	 * Given an array of strings, return all groups of strings that are
	 * anagrams. Example Given ["lint", "intl", "inlt", "code"], return ["lint",
	 * "inlt", "intl"].
	 * 
	 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
	 */
	/**
	 * @param strs:
	 *            A list of strings
	 * @return: A list of strings
	 */
	public List<String> anagrams(String[] strs) {
		boolean[] isRemoved = new boolean[strs.length];
		final int numChars = 26;
		int[][] fingerPrint = new int[strs.length][numChars];
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				fingerPrint[i][strs[i].charAt(j) - 'a']++;
			}
		}
		for (int i = 0; i < strs.length; i++) {
			if (!isRemoved[i]) {
				boolean firstTime = true;
				for (int j = i + 1; j < strs.length; j++) {
					if (!isRemoved[j]) {
						boolean res = compareFingerPrint(fingerPrint[i], fingerPrint[j]);
						if (res) {
							if (firstTime) {
								list.add(strs[i]);
								firstTime = false;
								isRemoved[i] = true;
							}
							list.add(strs[j]);
							isRemoved[j] = true;
						}
					}
				}
			}
		}
		return list;
	}

	private static boolean compareFingerPrint(int[] fp1, int[] fp2) {
		for (int i = 0; i < fp1.length; i++) {
			if (fp1[i] != fp2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] strs = new String[] { "lint", "intl", "inlt", "code", "cd", "a", "dc" };
		List<String> list = new Q171().anagrams(strs);
		System.out.println(list);
	}
}
