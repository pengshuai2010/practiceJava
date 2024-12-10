package other;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStack {
    public static void main(String[] args) {
        MonotonicStack monotonicStack = new MonotonicStack();
        monotonicStack.getNextGreaterElementIndex(new int[]{3, 1, 2, 4});
    }

    // Given integer array nums, for each element in this array, find out the index of
    // the next greater element. If there is no next greater element, retrurn -1.
    // e.g. for [3, 1, 2, 4], the answer would be [3, 2, 3, -1]
    // To find out the index of previous greater element, the answer would be
    // [-1, 0, 0, -1]

    // see https://leetcode.com/discuss/study-guide/2347639/A-comprehensive-guide-and-template-for-monotonic-stack-based-problems
    // for a more detailed explanation of the monotonic stack algorithm
    // Brute force approach will take O(n^2) time
    // Monotonic stack approach takes O(n) time
    void getNextGreaterElementIndex(int[] nums) {
        int[] nextGreaterElemIndex = new int[nums.length];
        Arrays.fill(nextGreaterElemIndex, -1);
        int[] prevGreaterElemIndex = new int[nums.length];
        Arrays.fill(prevGreaterElemIndex, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.getLast()] < nums[i]) {
                int prevIndex = stack.removeLast();
                nextGreaterElemIndex[prevIndex] = i;
            }
            if (!stack.isEmpty()) {
                prevGreaterElemIndex[i] = stack.getLast();
            }
            stack.addLast(i);
        }
        System.out.println("next greater element index:");
        System.out.println(Arrays.toString(nextGreaterElemIndex));
        System.out.println("previous greater element index:");
        System.out.println(Arrays.toString(prevGreaterElemIndex));
    }
}
