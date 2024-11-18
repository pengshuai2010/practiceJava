package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Q560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // clarify if elements in nums are all non-negative, does [] count as a subarray, if k == 0?
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSum[i + 1] = sum;
        }
        int answer = 0;
        Map<Integer, Integer> occurances = new HashMap<>();
        for (int i = 0; i < prefixSum.length; i++) {
            int complement = prefixSum[i] - k;
            if (occurances.containsKey(complement)) {
                answer += occurances.get(complement);
            }
            occurances.put(prefixSum[i], occurances.getOrDefault(prefixSum[i], 0) + 1);
        }
        return answer;
    }
}
