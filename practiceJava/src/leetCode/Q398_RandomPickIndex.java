package leetCode;

import java.util.*;

public class Q398_RandomPickIndex {
    private final Map<Integer, List<Integer>> indices;
    private final Random random;

    public Q398_RandomPickIndex(int[] nums) {
        this.indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
        this.random = new Random();
    }

    public int pick(int target) {
        // assuming target must exist
        List<Integer> potentialIndices = this.indices.get(target);
        int indexOfIndex = this.random.nextInt(potentialIndices.size());
        return potentialIndices.get(indexOfIndex);
    }
}
