package leetCode;

public class Q2149_RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        // clarify if nums guranteed to be contain equal numbers of positives and negatives
        // should we modify the input? Or return a new array?
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] answer = new int[nums.length];
        int evenIndex = 0;
        int oddIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                answer[evenIndex] = num;
                evenIndex += 2;
            } else {
                answer[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return answer;
    }
}
