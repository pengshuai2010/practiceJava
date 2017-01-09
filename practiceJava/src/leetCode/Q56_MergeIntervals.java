package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by speng on 1/8/17.
 */
public class Q56_MergeIntervals {
    /**
     * First sort the Intervals by their start point. Create a results list, in which all Intervals are
     * non-overlapping
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Collections.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        //ask interview if we can modify the input list and its elements, and if Interval is modifiable
        for (Interval curr : intervals) {
            if (res.size() == 0) {
                res.add(new Interval(curr.start, curr.end));//Since Interval is modifiable, we create a new object here
            } else {
                Interval prev = res.get(res.size() - 1);
                if (prev.end >= curr.start) {
                    prev.end = Math.max(prev.end, curr.end);
                } else {
                    res.add(new Interval(curr.start, curr.end));
                }
            }
        }
        return res;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
