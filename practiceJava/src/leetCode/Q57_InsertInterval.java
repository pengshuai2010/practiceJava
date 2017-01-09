package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 1/8/17.
 */
public class Q57_InsertInterval {
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            throw new java.lang.IllegalArgumentException();
        }
        List<Interval> res = new ArrayList<>();
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (isOverlapping(curr, newInterval)) {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            } else {
                if (curr.start < newInterval.start) {
                    res.add(curr);
                } else {//when we found an Interval that is non-overlapping with newInterval and is after newInterval
                    res.add(newInterval);
                    res.addAll(intervals.subList(i, intervals.size()));
                    break;
                }
            }
        }
        if (i == intervals.size()) {
            //if newInterval wasn't added to res inside the loop
            // handles the case where newInterval is behind all, or newInterval merged with last interval
            res.add(newInterval);
        }
        return res;
    }

    private boolean isOverlapping(Interval a, Interval b) {
        //be careful about the condition. It should be symmetric.
        // "a.start >= b.start && a.start <= b.end || a.end >= b.start && a.end <= b.end" won't work for the case where
        // a = [1, 5] and b = [2, 3]
        return a.start >= b.start && a.start <= b.end || b.start >= a.start && b.start <= a.end;
    }

    /**
     * use three while loops, making the code structure cleaner
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            throw new java.lang.IllegalArgumentException();
        }
        List<Interval> res = new ArrayList<>();
        int i = 0;
        //add all intervals that is before newInterval and is not overlapping with newInterval to res
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }
        //merge all intervals that is overlapping with newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        //add newInterval to res
        res.add(newInterval);
        //add all the rest to res
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }

    private class Interval {
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
