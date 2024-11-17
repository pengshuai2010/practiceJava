package leetCode;

public class Q905_SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        // clarify what to do when nums is null
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
