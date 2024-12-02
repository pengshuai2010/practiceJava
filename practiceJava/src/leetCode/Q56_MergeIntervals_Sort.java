package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by speng on 1/8/17.
 */
public class Q56_MergeIntervals_Sort {
    // time complexity O(n*log(n))
    public int[][] merge(int[][] intervals) {
        // clarify handling null or empty
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(list, (Interval a, Interval b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        for (Interval item : list) {
            if (result.isEmpty()) {
                result.add(item);
                continue;
            }
            Interval last = result.get(result.size() - 1); // get the last one
            if (item.start <= last.end) {
                last.end = Math.max(last.end, item.end); // merge into the last one
            } else {
                result.add(item);
            }
        }
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = new int[]{result.get(i).start, result.get(i).end};
        }
        return answer;
    }

    /**
     * Context of the problem:
     * Example 1: merge blocked time windows
     * Example 2: given a list of [start watching, stop watching] intervals of a video, how many
     * minutes of this video has the user watched?
     * <p>
     * First sort the Intervals by their start point. Create a results list, in which all Intervals are
     * non-overlapping. Add first Interval into results list. Then for each interval in the input list, if it's overlapping
     * with the last interval in results list, merge these two; else add the interval into results list.
     */
    private static class Interval {
        int start;
        int end; // omit getter and setters

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
