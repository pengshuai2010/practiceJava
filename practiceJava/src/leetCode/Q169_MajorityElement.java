package leetCode;

public class Q169_MajorityElement {
    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        // assuming nums is not empty
        Integer candidate = null;
        int count = 0;
        for (int num: nums) {
            // We discard the previous candidate when count is reduced to 0
            // By doing so, we discard at most equal number of majorarity element and non-majority element
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
