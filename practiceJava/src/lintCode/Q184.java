package lintCode;

import java.util.Arrays;
import java.util.Comparator;

/*
 *  Largest Number Show result 

You have exceeded the time limit
 Reset
Given a list of non negative integers, arrange them such that they form the largest number.

Have you met this question in a real interview? Yes
Example
Given [1, 20, 23, 4, 8], the largest formed number is 8423201.

Note
The result may be very large, so you need to return a string instead of an integer.

Challenge
Do it in O(nlogn) time complexity.
 */
public class Q184 {
    /**
     * @param num:
     *            A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] num) {
	if (num == null || num.length == 0)
	    return "0";
	String[] str = new String[num.length];
	for (int i = 0; i < num.length; i++)
	    str[i] = Integer.toString(num[i]);
	// we need to define our own comparator because the default
	// lexicographical order cannot meet our requirement
	// concatenate the two strings in two different order to form two
	// numbers, then compare the two numbers
	Arrays.sort(str, new Comparator<String>() {
	    public int compare(String str1, String str2) {
		String num1 = str1 + str2;
		String num2 = str2 + str1;
		for (int i = 0; i < num1.length(); i++)
		    if (num1.charAt(i) != num2.charAt(i))
			return num2.charAt(i) - num1.charAt(i);
		return 0;
	    }
	});
	if (str[0].equals("0"))
	    return "0";
	StringBuilder builder = new StringBuilder();
	for (String item : str)
	    builder.append(item);
	return builder.toString();
    }

    public static void main(String[] args) {
	// int[] num = new int[] {1, 20, 23, 4, 8};
	// int[] num = new int[] {0, 0};
	// int[] num = new int[] {1, 0};
	// int[] num = new int[] {8, 99, 992};
	// int[] num = new int[] {};
	int[] num = new int[] { 41, 23, 87, 55, 50, 53, 18, 9, 39, 63, 35, 33, 54, 25, 26, 49, 74, 61, 32, 81, 97, 99,
		38, 96, 22, 95, 35, 57, 80, 80, 16, 22, 17, 13, 89, 11, 75, 98, 57, 81, 69, 8, 10, 85, 13, 49, 66, 94,
		80, 25, 13, 85, 55, 12, 87, 50, 28, 96, 80, 43, 10, 24, 88, 52, 16, 92, 61, 28, 26, 78, 28, 28, 16, 1,
		56, 31, 47, 85, 27, 30, 85, 2, 30, 51, 84, 50, 3, 14, 97, 9, 91, 90, 63, 90, 92, 89, 76, 76, 67, 55 };
	// expected:
	// 99999897979696959492929190908989888878785858585848181808080807876767574696766636361615757565555555453525150505049494743413938353533332313030282828282726262525242322222181716161614131313121111010

	String res = new Q184().largestNumber(num);
	System.out.println(res);
    }

}
