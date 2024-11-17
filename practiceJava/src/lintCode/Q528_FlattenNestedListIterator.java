package lintCode;

import java.util.*;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    private final Integer integer;
    private final List<NestedInteger> list;

    NestedInteger(int integer) {
        this.integer = integer;
        this.list = null;
    }

    NestedInteger(List<NestedInteger> list) {
        this.integer = null;
        this.list = list;
    }

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger() {
        return this.integer != null;
    }

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return this.integer;
    }

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return this.list;
    }
}

public class Q528_FlattenNestedListIterator implements Iterator<Integer> {
    private final Deque<NestedInteger> stack;

    public Q528_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque<>();
        pushListToStack(nestedList);
    }

    public static void main(String[] args) {
        // [[1,1],2,[1,1]]
        List<NestedInteger> nestedList = Arrays.asList(
                new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))),
                new NestedInteger(2),
                new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))));
        Q528_FlattenNestedListIterator solution = new Q528_FlattenNestedListIterator(nestedList);
        while (solution.hasNext()) {
            System.out.println(solution.next());
        }

    }

    private void pushListToStack(List<NestedInteger> nestedList) {
        List<NestedInteger> tmp = new ArrayList<>(nestedList);
        while (!tmp.isEmpty()) {
            stack.addFirst(tmp.get(tmp.size() - 1));
            tmp.remove(tmp.size() - 1);
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (this.hasNext()) {
            NestedInteger item = stack.removeFirst();
            return item.getInteger();
        } else {
            throw new NoSuchElementException();
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.getFirst().isInteger()) {
            List<NestedInteger> list = stack.removeFirst().getList();
            pushListToStack(list);
        }
        return !stack.isEmpty();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
