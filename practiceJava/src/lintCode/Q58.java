package lintCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Q58 {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
    	ArrayList<ArrayList<Integer>> quadruplets = new ArrayList<ArrayList<Integer>>();
    	if (numbers == null || numbers.length < 4) 
    		return quadruplets;
    	int[] nums = numbers.clone();
    	Arrays.sort(nums);
    	Set<ArrayList<Integer>> set = new LinkedHashSet<ArrayList<Integer>>();
    	for (int a = 0; a < nums.length - 4; a++)
    		for (int b = a + 1; b < nums.length - 3; b++) {
    			int c = b + 1;
    			int d = nums.length - 1;
    			while (c < d) {
    				int sum = nums[a] + nums[b] + nums[c] + nums[d];
    				if (sum > target)
    					d--;
    				else if (sum < target)
    					c++;
    				else {
    					ArrayList<Integer> quadruplet = new ArrayList<Integer>();
    					quadruplet.add(nums[a]);
    					quadruplet.add(nums[b]);
    					quadruplet.add(nums[c]);
    					quadruplet.add(nums[d]);
    					set.add(quadruplet);
    					c++;
    					d--;
    				}
    			}
    		}
    	quadruplets.addAll(set);
    	return quadruplets;
    }
	public static void main(String[] args) {
//		int[] numbers = new int[] {1, 0, -1, 0, -2, 2};
//		int target = 0;
		int[] numbers = new int[] {0,0,-1012,0,0,0,-3002,0,0,0,-10,-19,0,0,90,0,92,0,1,1,1,9,9,9,10,11,1001,2001,-404,201,203,201,999,345,1,1,1,1,1,1,1,-2,1,1,1,1,1,-1,1,1,-2,1,1,1,1,3,1,1,1,1,1,-1200,1,1,1,1,1,2,1202,2,2,-4,2,2,2,2,4,5,6,1,1,-11,1,1,1,1,1,1,1,1,101,1,1,1,1,1,-1,1,-6};
		int target = 92;
		ArrayList<ArrayList<Integer>> quadruplets = new Q58().fourSum(numbers, target);
		System.out.println(quadruplets);
	}

}
