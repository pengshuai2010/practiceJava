package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 12/4/16.
 */
public class Q60_PermutationSequence {
    /**
     * We want the kth permutation when permutations are sorted. If we generate the permutations until kth one, it takes
     * O(k) time, in worst case O(n!). So we'd want to figure out how to generate the kth directly.
     * <p>
     * when n = 4, we have nums = [1, 2, 3, 4]. And the permutations are
     * 1, {permutations of [2, 3, 4], sorted}
     * 2, {permutations of [1, 3, 4], sorted}
     * 3, {permutations of [1, 2, 4], sorted}
     * 4, {permutations of [1, 2, 3], sorted}
     * <p>
     * let k' = k - 1, then the first number would be nums[index], where index = k' / ((n - 1)!)
     * then we remove nums[index] from the list, decrease k and n by 1 each, and repeat this process to get the second
     * number, and so on.
     * <p>
     * Note that we have a while loop of n iterations, and removing an element from an ArrayList take O(n) time, so
     * time complexity is O(n^2)
     */
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        int[] factorial = new int[n + 1];//so that factorial[n] == n!
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        k--;// calculation would be easier if k starts from 0
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int index = k / factorial[n - 1];
            sb.append(Integer.toString(nums.get(index)));
            nums.remove(index);
            k %= factorial[n - 1];
            n--;
        }
        return sb.toString();
    }
}
