package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by shuaipeng on 12/7/16.
 */
public class Q45_JumpGameII {
    public static void main(String[] args) {
        Q45_JumpGameII solution = new Q45_JumpGameII();
        int[][] inputs = new int[][]{{0}, {2, 3, 1, 1, 4}, {2, 1}};
        for (int[] input : inputs) {
            System.out.println(solution.jump(input));
        }
    }

    //O(n^2)
    public int jump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] leastJumps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            leastJumps[i] = Integer.MAX_VALUE;
        }
        leastJumps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j >= 1; j--) {
                if (i + j < nums.length) {
                    leastJumps[i + j] = Math.min(leastJumps[i] + 1, leastJumps[i + j]);
                    if (i + j == nums.length - 1) {
                        return leastJumps[i + j];
                    }
                }
            }
        }
        return leastJumps[nums.length - 1];
    }

    //BFS is most natural solution for shortest path problems.
    // O(n) space, O(n^2) time with trimming. still exceeds time limit
    //time complexity O(|V| + |E|), |V| is n, |E| = O(n^2), e.g.
    //[3, 2, 1, 1, 0]
    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int numJumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                set.add(index);
                if (index == nums.length - 1) {
                    return numJumps;
                }
                for (int j = 1; j <= nums[index] && index + j < nums.length; j++) {
                    if (!set.contains(index + j)) {//trim brach
                        queue.add(index + j);
                    }
                }
            }
            numJumps++;
        }
        return -1;
    }

    // O(n) time, O(1) space. The trick is that the array itself can serve as a queue. All we need to do is to decide the bound of
    // each level. [0], [1, 2], [3, 4]
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int currMax = 0;
        int i = 0;
        int level = 0;
        while (i <= currMax) {
            int nextMax = 0;
            if (currMax >= nums.length - 1) {
                return level;
            }
            for (; i <= currMax; i++) {
                nextMax = Math.max(nextMax, i + nums[i]);
            }
            currMax = nextMax;
            level++;
        }
        return -1;
    }
}
