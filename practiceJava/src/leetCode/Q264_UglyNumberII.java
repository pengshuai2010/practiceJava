package leetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q264_UglyNumberII {
    public int nthUglyNumber(int n) {
        // ask clarifying questions: how big can n be? Do we need to use Long type?
        if (n < 1) {
            throw new IllegalArgumentException("n is less than one. n: " + n);
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        pq.add(1L);
        visited.add(1L);
        int[] primeFactors = new int[]{2, 3, 5};
        long curr = 1;
        for (int i = 0; i < n; i++) {
            curr = pq.poll();
            for (int primeFactor : primeFactors) {
                long number = curr * primeFactor;
                if (!visited.contains(number)) {
                    pq.add(number);
                    visited.add(number);
                }
            }
        }
        // n can be a large number so we need to use Long instead Integer. But why downcasting the answer can work?
        // It's because we calculated a lot more ugly numbers than needed. When using integer type, those numbers overflows and become negative, and are moved to the top of the priority queue, then are picked to calculated next ugly numbers, leading to a wrong answer.
        // the nth number itself is still within the boundary of integer, so it is safe to downcast. 
        return (int) curr;
    }
}
