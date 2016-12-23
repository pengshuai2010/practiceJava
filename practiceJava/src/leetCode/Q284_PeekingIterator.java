package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by speng on 12/22/16.
 */
public class Q284_PeekingIterator<E> implements Iterator<E> {
    private E cache;
    private Iterator<E> it;

    //the invariant here is that the next value is always in cache. If cache is null, it's only because there's no more elements.
    public Q284_PeekingIterator(Iterator<E> iterator) {
        it = iterator;
        cache = it.hasNext() ? it.next() : null;
    }

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.addAll(Arrays.asList(1.0, 0.0, 2.4, 3.1));
        Q284_PeekingIterator<Double> it = new Q284_PeekingIterator<>(list.iterator());
        System.out.println(it.peek());
        System.out.println(it.peek());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.peek());
        System.out.println(it.hasNext());
    }

    // Returns the next element in the iteration without advancing the iterator.
    public E peek() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public E next() {
        if (!hasNext()) {//we need this if statement to make next() behave the same way as Iterator interface
            throw new java.util.NoSuchElementException();
        }
        E val = cache;
        cache = it.hasNext() ? it.next() : null;
        return val;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }
}
