package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 9/3/16.
 */
public class Q255implementStackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] arg) {
        Q255implementStackUsingQueues stack = new Q255implementStackUsingQueues();
        System.out.println(stack.empty());
        stack.push(1);
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public int pop() {
        while (q1.size() > 1)
            q2.offer(q1.poll());
        int top = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return top;
    }

    // Get the top element.
    public int top() {
        while (q1.size() > 1)
            q2.offer(q1.poll());
        int top = q1.poll();
        q2.offer(top);
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
