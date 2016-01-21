package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q139 {
	/*
	 * Subarray Sum Closest Show result
	 * 
	 * Given an integer array, find a subarray with sum closest to zero. Return
	 * the indexes of the first number and last number.
	 * 
	 * Have you met this question in a real interview? Yes Example Given [-3, 1,
	 * 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
	 * 
	 * Challenge O(nlogn) time
	 */
	/**
	 * @param nums:
	 *            A list of integers
	 * @return: A list of integers includes the index of the first number and
	 *          the index of the last number
	 */
	public int[] subarraySumClosest1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(-1, 0);
		for (int i = 0; i < nums.length; i++) {
			map.put(i, map.get(i - 1) + nums[i]);
		}
		int[] ans = new int[2];
		int closest = Integer.MAX_VALUE;
		int target = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				int subarraySum = map.get(j) - map.get(i - 1);
				int distence = Math.abs(subarraySum - target);
				if (distence < closest) {
					closest = distence;
					ans[0] = i;
					ans[1] = j;
				}
				if (distence == 0)
					break;
			}
		}
		return ans;
	}

	/*
	 * more efficient solution. time complexity is O(n*lg(n))
	 */
	public int[] subarraySumClosest(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				return new int[] { map.get(sum) + 1, i };
			}
			map.put(sum, i);
		}
		int[] ans = new int[2];
		List<Integer> accum = new ArrayList<Integer>(map.keySet());
		Collections.sort(accum);
		int minimum = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < accum.size() - 1; i++) {
			int tmp = accum.get(i + 1) - accum.get(i);
			if (tmp < minimum) {
				minimum = tmp;
				index = i;
			}
		}
		ans[0] = map.get(accum.get(index));
		ans[1] = map.get(accum.get(index + 1));
		Arrays.sort(ans);
		ans[0]++;
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 10, 5, 3, 2, 1, 1, -2, -4, 3 };
		int[] res = new Q139().subarraySumClosest(nums);
		System.out.println(Arrays.toString(res));
	}

}
