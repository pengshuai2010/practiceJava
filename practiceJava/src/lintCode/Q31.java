package lintCode;

import java.util.Arrays;

public class Q31 {
	/*
	 * Partition Array Show result
	 * 
	 * Given an array nums of integers and an int k, partition the array (i.e
	 * move the elements in "nums") such that:
	 * 
	 * All elements < k are moved to the left All elements >= k are moved to the
	 * right Return the partitioning index, i.e the first index i nums[i] >= k.
	 * 
	 * Have you met this question in a real interview? Yes Example If nums =
	 * [3,2,2,1] and k=2, a valid answer is 1.
	 */
	/**
	 * @param nums:
	 *            The integer array you should partition
	 * @param k:
	 *            As description return: The index after partition
	 */
	public int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] < k)
				i++;
			else if (nums[j] >= k)
				j--;
			else
				swap(nums, i, j);
		}
		if (nums[j] < k)
			j++;
		return j;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		// int[] nums = new int[]{3, 2, 2, 1};
		// int[] nums = new int[]{2, 2, 2, 2};
		int[] nums = new int[] { 3, 0, 3, 1 };
		int k = 2;
		int res = new Q31().partitionArray(nums, k);
		System.out.println(Arrays.toString(nums));
		System.out.println(res);
	}

}
