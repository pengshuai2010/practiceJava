package lintCode;

import java.util.Arrays;

public class Q59 {
	int[] numbers;
	int target;
	boolean[] isSelected;
	int best;

	/**
	 * @param numbers:
	 *            Give an array numbers of n integer
	 * @param target
	 *            : An integer
	 * @return : return the sum of the three integers, the sum closest target.
	 */
	// time complexity is O(n^3)
	public int threeSumClosest1(int[] numbers, int target) {
		// assume numbers is not null and has at least 3 elements
		int n = 3;
		this.numbers = numbers;
		this.target = target;
		isSelected = new boolean[numbers.length];
		best = Integer.MAX_VALUE;
		findClosest(0, n, 0);
		return best;
	}

	private void findClosest(int begin, int n, int sum) {
		if (n == 0) {
			if (Math.abs((double) sum - target) < Math.abs((double) best - target))// avoid
																					// overflow
				best = sum;
			return;
		}
		for (int i = begin; i < numbers.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				findClosest(i + 1, n - 1, sum + numbers[i]);
				isSelected[i] = false;
			}
		}
	}

	// time complexity is O(n^2)
	public int threeSumClosest(int[] numbers, int target) {
		int[] nums = numbers.clone();
		Arrays.sort(nums);
		int best = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			int sum;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				if (Math.abs((double) sum - target) < Math.abs((double) best - target)) {
					best = sum;
				}
				if (sum > target)
					right--;
				else if (sum < target)
					left++;
				else
					return sum;
			}
		}
		return best;
	}

	public static void main(String[] args) {
		int[] numbers = new int[] { -1, 2, 1, -4 };
		int target = 1;
		int res = new Q59().threeSumClosest(numbers, target);
		System.out.println(res);
	}

}
