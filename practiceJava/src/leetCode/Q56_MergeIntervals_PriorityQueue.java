package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q56_MergeIntervals_PriorityQueue {
    // time complexity O(n*log(n))
    public int[][] merge(int[][] intervals) {
        // clarify handling null or empty
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        PriorityQueue<Interval> queue = new PriorityQueue<>(list);
        List<Interval> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Interval next = queue.remove();
            if (result.isEmpty()) {
                result.add(next);
                continue;
            }
            Interval last = result.get(result.size() - 1);
            if (next.start <= last.end) {
                last.end = Math.max(last.end, next.end);
            } else {
                result.add(next);
            }
        }
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = new int[]{result.get(i).start, result.get(i).end};
        }
        return answer;
    }

    private static class Interval implements Comparable<Interval> {
        int start;
        int end; // omit getter and setters

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval other) {
            return this.start - other.start; // only start time matters
        }
    }
}
