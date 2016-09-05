package lintCode;

import java.util.Stack;

/**
 * Created by speng on 9/3/16.
 */
public class Q12minStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();

    public Q12minStack() {
        // do initialize if necessary
    }

    public static void main(String[] args) {
        Q12minStack stack = new Q12minStack();
        stack.push(1); //[1]
        System.out.println("min: " + stack.min());
        System.out.println(stack.pop());
        stack.push(2); //[2]
        System.out.println("min: " + stack.min());
        stack.push(0); //[2, 0]
        System.out.println("min: " + stack.min());
        System.out.println(stack.pop()); //[2]
        System.out.println("min: " + stack.min());
        stack.push(2); //[2, 2]
        System.out.println("min: " + stack.min());
        System.out.println(stack.pop());
        System.out.println("min: " + stack.min());
    }

    // save some space, but is quite complex, and the space efficiency is still O(n)
    public void push2(int number) {
        // the condition should not be min.isEmpty() || number < stack.peek(),
        // because in case of pushing 1 into [1, 1, 2], min should be updated
        // and pusing 5 into [-1, 10]
        if (min.isEmpty() || (number < stack.peek() && number <= min.peek()))
            min.push(number);
        stack.push(number);
    }

    public int pop2() {
        int top = stack.pop();
        if (top == min.peek() && (stack.empty() || stack.peek() > min.peek()))
            min.pop();
        return top;
    }

    // less space efficient, O(n) space complexity
    public void push(int number) {
        if (min.isEmpty() || number <= min.peek())
            min.push(number);
        stack.push(number);
    }

    // simple but also O(n) space complexity
    // min and stack have the same size

    public int pop() {
        // should not use '==' because you are comparing two Integer objects!
        if (stack.peek().equals(min.peek()))
            min.pop();
        return stack.pop();
    }

    public int min() {
        return min.peek();
    }
}
