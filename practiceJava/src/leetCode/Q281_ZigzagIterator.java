package leetCode;

import java.util.*;

/**
 * Created by speng on 12/10/16.
 */
public class Q281_ZigzagIterator {

    Queue<Iterator<Integer>> queue;

    /**
     * Elegant solution. Make use of the iterators of the lists instead of iterate manually.
     * Can be easily extend to k lists.
     */
    public Q281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1 != null && v1.size() > 0) {
            queue.add(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            queue.add(v2.iterator());
        }
    }

    public static void main(String[] args) {
//        test cases
//        [1,2]
//        [3,4,5,6]
//        []
//        [1]
//        [1, 2, 3, 4]
//        [5]
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 2));
        lists.add(Arrays.asList(3, 4, 5, 6));
        Q281_ZigzagIterator solution = new Q281_ZigzagIterator(lists.get(0), lists.get(1));
        while (solution.hasNext()) {
            System.out.println(solution.next());
        }

    }

    public int next() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        Iterator<Integer> it = queue.poll();
        int val = it.next();
        // loop invariant is that iterators in the queue all has next
        if (it.hasNext()) {
            queue.offer(it);
        }
        return val;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
