package lintCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q56 {
	/*
	 * Two Sum Show result
	 * 
	 * Given an array of integers, find two numbers such that they add up to a
	 * specific target number.
	 * 
	 * The function twoSum should return indices of the two numbers such that
	 * they add up to the target, where index1 must be less than index2. Please
	 * note that your returned answers (both index1 and index2) are NOT
	 * zero-based.
	 * 
	 * Example numbers=[2, 7, 11, 15], target=9
	 * 
	 * return [1, 2]
	 * 
	 * Note You may assume that each input would have exactly one solution
	 */
	/*
	 * @param numbers : An array of Integer
	 * 
	 * @param target : target = numbers[index1] + numbers[index2]
	 * 
	 * @return : [index1 + 1, index2 + 1] (index1 < index2)
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2)
			return new int[] {};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}
		for (int i = 0; i < numbers.length; i++) {
			int other = target - numbers[i];
			int index1 = i + 1;
			if (map.containsKey(other) && map.get(other) != index1) {
				int[] ans = new int[] { index1, map.get(other) };
				Arrays.sort(ans);
				return ans;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// int[] numbers = new int[] {2, 7, 11, 15};
		// int target = 9;
		int[] numbers = new int[] { 1, 0, -1 };
		int target = -1;
		// int[] numbers = new int[] {1,2,5,6,7,3,5,8,-33,-5,-72,12,-34,100,99};
		// int target = -64;
		int[] res = new Q56().twoSum(numbers, target);
		System.out.println(Arrays.toString(res));
	}

}
