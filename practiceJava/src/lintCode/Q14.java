package lintCode;

public class Q14 {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
    	if (nums == null || nums.length == 0)
    		return -1;
		int s = 0, e = nums.length - 1, mid = (s + e)/2;
		while (s <= e) {
			mid = (s + e)/2;
			if (target > nums[mid])
				s = mid + 1;
			else if (target < nums[mid])
				e = mid - 1;
			else
				break;
		}
		if (nums[mid] != target)
			return -1;
		while (mid >= 0 && nums[mid] == target)
			mid --;
		return mid + 1;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 3, 4, 5, 10};
//		int target = 3;
//		int target = 1;
//		int target = -1;
//		int target = 10;
		int target = 11;
		int res = new Q14().binarySearch(nums, target);
		System.out.println(res);
	}

}
