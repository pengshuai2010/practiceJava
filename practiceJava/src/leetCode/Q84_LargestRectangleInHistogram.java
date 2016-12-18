package leetCode;

import java.util.Stack;

/**
 * Created by speng on 12/17/16.
 */
public class Q84_LargestRectangleInHistogram {
    /**
     * brute force solution takes O(n^2) time.
     * By using stack, we can achieve O(n) time complexity. The reason is that we maintain a stack in which bars are
     * monotonically increasing in height, so we avoid lots of unnecessary comparisons. For example, when heights = [1, 2, 3, 4]
     * we only need to compare 4*1, 3*2, 2*3, 1*4. We don't need to compare 1*3 and 1*4.
     * see https://www.youtube.com/watch?v=ZmnqCZp9bBs
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int largest = 0;
        while (i < heights.length) {
            //loop invariant is that bars in the stack are increasing
            // using "heights[i] >= heights[stack.peek()" can satisfy this invariant, but if input is [1, 1, 1,..., 1]
            // we will push all 0, 1, 2, ..., n -1 into the stack first and then calculate, which will unnecessarily consume too much memory
            // and will be slow
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {//note it's indeces in the stack!
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                //when stack is empty, that means height[top] is the smallest in the range [0, i - 1]
                //when stack is not empty, we use (i - stack.peek() - 1) instead of (i - top), because the stack may look
                // like [0, 4], after popping, becomes [0]. The bars in range [1, 3] are all higher than the bar at 4 (we
                // know this because they are popped out before 4 is pushed in)
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = len * heights[top];
                largest = Math.max(largest, area);
            }
        }
        // handle the case where the last bars in heights are monotonically strictly increasing
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int len = stack.isEmpty() ? i : i - stack.peek() - 1;
            int area = len * heights[top];
            largest = Math.max(largest, area);
        }
        return largest;
    }
}
