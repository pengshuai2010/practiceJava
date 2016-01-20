package lintCode;

import java.util.Arrays;

public class Q101 {
	/*
	 * Remove Duplicates from Sorted Array II Show result
	 * 
	 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
	 * twice?
	 * 
	 * For example, Given sorted array A = [1,1,1,2,2,3],
	 * 
	 * Your function should return length = 5, and A is now [1,1,2,2,3].
	 */
	/**
	 * @param A:
	 *            a array of integers
	 * @return : return an integer
	 */
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] tmp = new int[nums.length];
		int count = 0;
		int last = nums[0];
		int i = 0, j = 0;
		while (i < nums.length) {
			if (nums[i] == last)
				count++;
			else {
				count = 1;
				last = nums[i];
			}
			if (count <= 2) {
				tmp[j] = nums[i];
				j++;
			}
			i++;
		}
		int length = j;
		for (int k = 0; k < length; k++) {
			nums[k] = tmp[k];
		}
		return length;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int res = new Q101().removeDuplicates(nums);
		System.out.println(Arrays.toString(Arrays.copyOf(nums, res)));
	}

}
