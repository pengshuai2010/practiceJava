package lintCode;

import java.util.Arrays;

public class Q100 {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates1(int[] nums) {
    	if (nums == null || nums.length == 0) 
    		return 0;
    	int last = nums[0];
    	int i, j;
    	for (i = 1, j = i + 1; i < nums.length; i++) {
    		if (nums[i] <= last) {
    			for (; j < nums.length; j++) {
    				if (nums[j] > last) {
    					nums[i] = nums[j];
    					break;
    				}
    			}
    			if (j == nums.length) 
    				break;
    		}
    		last = nums[i];
    	}
    	return i;
    }
    /*
     * this algorithm is simpler
     */
    public int removeDuplicates(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int i = 0;
    	for (int j = i + 1; j < nums.length; j++) {
    		if (nums[j] > nums[i]) {
    			i++;
    			nums[i] = nums[j];
    		}
    	}
    	return i + 1;
    }
	public static void main(String[] args) {
//		int[] nums = new int[] {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
//		int[] nums = new int[] {1, 2, 3, 4};
		int[] nums = new int[] {1, 2, 2, 3, 4};
		int res = new Q100().removeDuplicates(nums);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, res)));
	}

}
