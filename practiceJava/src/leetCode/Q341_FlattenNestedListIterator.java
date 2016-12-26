package leetCode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by speng on 12/25/16.
 */
public class Q341_FlattenNestedListIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    /**
     * To tackle this kind of problem, we start by writing code like generators in functional programming language, then
     * adapt it to Iterator interface.
     */
    public Q341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {//if hasNext() returns true, the top of stack is guaranteed to be an Integer
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) {
                return true;//if it were functional programming, we just need to write a yield statement here
            } else {
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
