package lintCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> ineffectiveSubarraySum1(int[] nums) {
    	int[][] table = new int[nums.length][nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		table[i][i] = nums[i];
    		if (nums[i] == 0) {
    			    ArrayList<Integer> list = new ArrayList<Integer>();
    				list.add(i);
    				list.add(i);
    				return list;
    		}
    	}
    	for (int m = 0; m < nums.length; m++) 
    		for (int n = 0; n < nums.length - m - 1; n++) {
    			table[n][n + m + 1] = table[n][n + m] + nums[n + m + 1];
    			if (table[n][n + m + 1] == 0) {
    				ArrayList<Integer> list = new ArrayList<Integer>();
    				list.add(n);
    				list.add(n + m + 1);
    				return list;
    			}
    		}
    	return null;
    }
    public ArrayList<Integer> ineffectiveSubarraySum2(int[] nums) {
    	int[] a = new int[nums.length];
    	int[] b = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == 0) {
			    ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(i);
				return list;
    		}
    		a[i] = nums[i];
    	}
    	for (int m = 0; m < nums.length; m++) {
    		for (int n = 0; n < nums.length - m - 1; n++) {
    			b[n] = a[n] + nums[m + n + 1];
//    			System.out.print(b[n] + "\t");
        		if (b[n] == 0) {
    				ArrayList<Integer> list = new ArrayList<Integer>();
    				list.add(n);
    				list.add(n + m + 1);
    				return list;
        		}
    		}
    		int[] tmp = a;
    		a = b;
    		b = tmp;
//    		System.out.println();
    	}
    	return null;
    }
    
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				answer.add(map.get(sum) + 1);
				answer.add(i);
				return answer;
			}
			map.put(sum, i);
		}
		return null;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {-3, 1, 2, -3, 4};
//		int[] nums = new int[] {0, 1, 2};
		System.out.println(new Q138().subarraySum(nums));
	}

}
