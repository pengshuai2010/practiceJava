package leetCode;

import java.util.Stack;

public class Q232_ImplementQueueUsingStacks {
    private final Stack<Integer> inStack;
    private final Stack<Integer> outStack;

    public Q232_ImplementQueueUsingStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {
        this.inStack.push(x);
    }

    public int pop() {
        // clarifying question: will all operations be valid?
        // if (this.empty()) {
        //     throw new NoSuchElementException("The queue is empty.");
        // }
        this.moveElementsIfOutStackEmpty();
        return this.outStack.pop();
    }

    private void moveElementsIfOutStackEmpty() {
        if (this.outStack.isEmpty()) {
            while (!this.inStack.isEmpty()) {
                this.outStack.push(this.inStack.pop());
            }
        }
    }

    public int peek() {
        // clarifying question: will all operations be valid?
        // if (this.empty()) {
        //     throw new NoSuchElementException("The queue is empty.");
        // }
        this.moveElementsIfOutStackEmpty();
        return this.outStack.peek();
    }

    public boolean empty() {
        return this.inStack.isEmpty() && this.outStack.isEmpty();
    }
}
