package leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by shuaipeng on 1/10/17.
 */
public class Q239_SlidingWindowMaximum {
    /**
     * Using a binary search tree to store values in the sliding window would take O(n*log(k)) time.
     * <p>
     * Instead, we use a Deque that maintains two invariants: values in the deque are in descending order; values in the deque
     * are within the sliding window.
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length < k) {
            return new int[0];
        }
        //We could also use a Pair class which has an index and a value field, making the code more readable.
        Deque<Pair> deque = new LinkedList<>();
        int[] slidingMax = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //sliding window is {nums[i - k + 1], ..., nums[i - 1], nums[i]}
            //remove values out of this window
            //note that we must first remove values outside window, then remove from head the values less than nums[i]
            //otherwise the values outside window may "shield" the values less than nums[i] from being removed.
            while (!deque.isEmpty() && deque.getFirst().index < i - k + 1) {
                //for stack, queue, deque etc., always first check if empty before push() or pop()!
                deque.removeFirst();
            }
            //the values before nums[i] and is less than nums[i] has no chance of becoming max, so we remove them
            while (!deque.isEmpty() && deque.getLast().value < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(new Pair(i, nums[i]));
            if (i >= k - 1) {
                slidingMax[i - k + 1] = deque.getFirst().value;
            }
        }
        return slidingMax;
    }

    private class Pair {
        int index;
        int value;

        private Pair(int i, int v) {
            index = i;
            value = v;
        }
    }
}
