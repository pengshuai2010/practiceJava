package leetCode;

/**
 * Created by shuaipeng on 11/9/16.
 */
public class Q27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int p1 = 0, p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] != val)
                p1++;
            else if (nums[p2] == val)
                p2--;
            else {
                nums[p1] = nums[p2];
                nums[p2] = val;
            }
        }
        return p1;
    }

    // test cases
    // [], 3, [3, 3], 3, [2, 2], 3, [3, 2, 3, 2], 3

}
