package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
 *  Majority Number Show result 
 *  Reset
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1

 * Challenge
 * O(n) time and O(1) extra space
 */

public class Q46 {
	/**
	 * time complexity is O(n*log(n))
	 * 
	 * @param nums:
	 *            a list of integers
	 * @return: find a majority number
	 */
	public int majorityNumber1(ArrayList<Integer> nums) {
		Collections.sort(nums);
		return nums.get(nums.size() / 2);
	}

	/*
	 * O(n) time, O(1) space
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		// assume that nums is not null or empty
		int res = nums.get(0);
		int count = 0;
		for (int item : nums) {
			if (item == res)
				count++;
			else {
				count--;
				if (count < 0) {
					res = item;
					count = 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 2, 2));
		int res = new Q46().majorityNumber(nums);
		System.out.println(res);

	}

}
