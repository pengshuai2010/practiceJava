package lintCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by speng on 9/4/16.
 */
public class Q4UglyNumberII {
    public static void main(String[] args) {
        System.out.println(new Q4UglyNumberII().nthUglyNumber(41));
//        for (int i = 1; i < 11; i++)
//            System.out.println(new Q4UglyNumberII().nthUglyNumber(i));
    }

    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // use heap and set, O(n*lg(n)) time complexity
        if (n <= 0)
            return 0;
        int[] factors = new int[]{2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long number = heap.poll();
            set.remove(number);
            for (int factor : factors) {
                long newNumber = number * factor;
                if (!set.contains(newNumber)) {
                    heap.offer(newNumber);
                    set.add(newNumber);
                }
            }
        }
//        return Math.toIntExact(heap.poll());
        return heap.poll().intValue();
    }
}
