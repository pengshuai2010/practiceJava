package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // clarify will nums1 or nums2 be null
        // clarify will it happen that numbers in nums1 not in nums2?
        // will there be dulicates in nums1 or nums2?
        if (nums1.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int element : nums2) {
            while (!stack.isEmpty() && stack.getLast() < element) {
                int previous = stack.removeLast();
                nextGreater.put(previous, element);
            }
            stack.addLast(element);
        }
        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return answer;
    }
}
