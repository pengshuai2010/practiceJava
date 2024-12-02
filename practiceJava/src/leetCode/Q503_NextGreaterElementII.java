package leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int actualIndex = i % nums.length;
            while (!stack.isEmpty() && nums[stack.getLast()] < nums[actualIndex]) {
                int index = stack.removeLast();
                nextGreater[index] = nums[actualIndex];
            }
            stack.addLast(actualIndex);
        }
        return nextGreater;
    }
}
