package lintCode;

import java.util.Stack;

/**
 * Created by speng on 9/3/16.
 */
public class Q40implementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Q40implementQueueByTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public static void main(String[] args) {
        Q40implementQueueByTwoStacks queue = new Q40implementQueueByTwoStacks();
        queue.push(1);
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        queue.push(2);
        System.out.println(queue.isEmpty());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
    }

    public void push(int element) {
        stack1.push(element);
    }

    private void move() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public int pop() {
        move();
        return stack2.pop();
    }

    public int top() {
        move();
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean isEmpty() {
        move();
        return stack2.isEmpty();
    }
}
