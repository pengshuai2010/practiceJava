package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by speng on 12/11/16.
 */
public class Q346_MovingAverageFromDataStream {
    private int size;
    private Queue<Integer> queue;
    private double sum;//prevent overflow! consider the case when all inputs are Integer.MAX_VALUE

    /**
     * Initialize your data structure here.
     */
    public Q346_MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
