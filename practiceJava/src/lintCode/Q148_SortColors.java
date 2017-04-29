package lintCode;

/**
 * Created by speng on 3/5/17.
 */
public class Q148_SortColors {
    /**
     * counting sort, takes O(n) time
     *
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] colors = new int[3];
        for (int num : nums) {
            colors[num]++;
        }
        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }
}
