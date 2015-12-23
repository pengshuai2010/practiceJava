package leetCode;

public class Q26 {
	public static void main(String[] args) {
//		int[] nums = {1, 2, 3, 4, 4, 6, 6};
//		int[] nums = {1, 1, 1, 1};
//		int[] nums = {1, 2, 3, 4};
//		int[] nums = {1};
//		int[] nums = {};
		int[] nums = null;
		System.out.println(new Q26().removeDuplicates(nums));
	}
	
    public int removeDuplicates(int[] nums) {
    	if( nums == null) {
    		return -1;
    	}
    	if(nums.length == 0 || nums.length == 1) {
    		return nums.length;
    	}
        int p1 = 0;
        int p2 = 1;
        while(p2 < nums.length) {
        	if(nums[p2] > nums[p1]) {
        		p1++;
//        		swap(nums, p1, p2);
        		nums[p1] = nums[p2];
        	}
        	p2++;
        }
		return p1+1;
    }
    
    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
