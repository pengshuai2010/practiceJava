package lintCode;

import java.util.Arrays;

public class Q52 {
	/*
	 * Next Permutation Show result
	 * 
	 * You have exceeded the time limit Reset Given a list of integers, which
	 * denote a permutation.
	 * 
	 * Find the next permutation in ascending order.
	 * example:
	 * [1,3,2,3], the next permutation is [1,3,3,2]
	 * 
	 * For [4,3,2,1], the next permutation is [1,2,3,4]
	 * 
	 * Note The list may contains duplicate integers.
	 * http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html
	 */
	/**
	 * @param nums:
	 *            an array of integers
	 * @return: return nothing (void), do not return anything, modify nums
	 *          in-place instead
	 */
	public int[] nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return nums;
		int index1 = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				index1 = i;
				break;
			}
		}
		if (index1 < 0) {
			reverse(nums, 0, nums.length - 1);
			return nums;
		}
		int index2 = index1;
		for (int i = nums.length - 1; i > index1; i--) {
			if (nums[i] > nums[index1]) {
				index2 = i;
				break;
			}
		}
		swap(nums, index1, index2);
		reverse(nums, index1 + 1, nums.length - 1);
		return nums;
	}

	private static void reverse(int[] nums, int left, int right) {
		if (left >= right)
			return;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private static void swap(int[] nums, int index1, int index2) {
		int tmp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = tmp;
	}

	public static void main(String[] args) {
		// int[] nums = new int[] {1,3,2,3};
		// int[] nums = new int[] {4,3,2,1};
		// int[] nums = new int[] {1, 2};
		// int[] nums = new int[] {1, 2, 3, 2, 4, 3};
		int[] nums = new int[] { 1, 3, 2, 1 };
		int[] res = new Q52().nextPermutation(nums);
		System.out.println(Arrays.toString(res));
	}

}
