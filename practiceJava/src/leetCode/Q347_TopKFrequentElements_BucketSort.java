package leetCode;

import java.util.*;

/**
 * Created by speng on 12/27/16.
 */
public class Q347_TopKFrequentElements_BucketSort {
    /**
     * A classical bucket sort problem.
     * Usually time complexity of bucket sort is O(n) only if the keys are distributed evenly. However in this case the
     * time complexity is guaranteed to be O(n) because we map only one key to one bucket. We can do this because the range
     * of key(i.e. frequency in this case) is bounded by n.
     * <p>
     * Time complexity is guaranteed to be O(n), which is better than worst case O(n^2) with quick selection. However even
     * if the number of unique elements m is much less than n, bucket sort still needs O(n) space, while quick selection
     * only needs O(m) space.
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        //question to ask interviewer: what if there's a tie? e.g. k == 1 and nums = [1, 1, 2, 3, 3]
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<List<Integer>> bucket = new ArrayList<>();//use list of lists instead of array of lists!
        bucket.addAll(Collections.nCopies(nums.length + 1, null));
        for (int num : map.keySet()) {
            int frequency = map.get(num);
            if (bucket.get(frequency) == null) {
                bucket.set(frequency, new ArrayList<>());
            }
            bucket.get(frequency).add(num);
        }
        for (int frequency = bucket.size() - 1; frequency >= 0 && list.size() < k; frequency--) {
            if (bucket.get(frequency) != null) {
                list.addAll(bucket.get(frequency));
            }
        }
        if (list.size() > k) {//if there's a tie
            list = list.subList(0, k);
        }
        return list;
    }
}
