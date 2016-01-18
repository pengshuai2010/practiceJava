package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q57 {
	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Example For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
	 * 
	 * (-1, 0, 1) (-1, -1, 2) Note Elements in a triplet (a,b,c) must be in
	 * non-descending order. (ie, a ≤ b ≤ c)
	 * 
	 * The solution set must not contain duplicate triplets.
	 */
	/**
	 * @param numbers
	 *            : Give an array numbers of n integer
	 * @return : Find all unique triplets in the array which gives the sum of
	 *         zero.
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();
		int target = 0;
		int[] nums = numbers.clone();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			// to skip duplicates
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			int sum;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (sum > target)
					right--;
				else if (sum < target)
					left++;
				else {
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[i]);
					triplet.add(nums[left]);
					triplet.add(nums[right]);
					triplets.add(triplet);
					right--;
					left++;
					// to skip duplicates
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}
			}
		}
		return triplets;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { -1, 0, 1, 2, -1, -4 };
		List<ArrayList<Integer>> res = new Q57().threeSum(numbers);
		System.out.println(res.toString());
	}

}
