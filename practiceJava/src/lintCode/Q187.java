package lintCode;

public class Q187 {
	/**
	 * @param gas:
	 *            an array of integers
	 * @param cost:
	 *            an array of integers
	 * @return: an integer
	 */
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0)
			return -1;
		int i = 0;
		boolean hasPassedZero = false;
		while (!hasPassedZero && i < gas.length) {
			int sum = 0;
			int j = i;
			sum += gas[i] - cost[j];
			while (sum >= 0) {
				j++;
				if (!hasPassedZero)
					hasPassedZero = j >= gas.length;
				j = j % gas.length;
				if (j == i)
					return i;
				sum += gas[j] - cost[j];
			}
			i = j + 1;
		}
		return -1;
	}

	/*
	 * http://www.cnblogs.com/yuzhangcmu/p/4179228.html
	 * http://www.algorithmist.com/index.php/Kadane%27s_Algorithm
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0)
			return -1;
		int total = 0;
		int sum = 0;
		int startIndex = 0;
		for (int i = 0; i < gas.length; i++) {
			int diff = gas[i] - cost[i];
			sum += diff;
			total += diff;
			if (sum < 0) {
				startIndex = i + 1;
				sum = 0;
			}
		}
		if (total < 0)
			return -1;
		return startIndex;
	}

	public static void main(String[] args) {
		// int[] gas = new int[] {1,1,3,1};
		// int[] cost = new int[] {2,2,1,1};
		// int[] gas = new int[] {4};
		// int[] cost = new int[] {5};
		int[] gas = new int[] { 2, 4 };
		int[] cost = new int[] { 3, 4 };
		int res = new Q187().canCompleteCircuit(gas, cost);
		System.out.println(res);

	}

}
