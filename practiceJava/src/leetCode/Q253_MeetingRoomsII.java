package leetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by speng on 1/8/17.
 */
public class Q253_MeetingRoomsII {
    /**
     * This problem is somewhat similar to the skyline problem. We sort the start points and end points, then scan
     * through them, increase number of rooms need by 1 at a start point, decrease number of rooms need by one at
     * a end point. We need to pay attention the case when one meeting ends at the same time when another meeting starts:
     * the end point should comes before the start point.
     * <p>
     * Time complexity is O(n*log(n)) as we need to sort the start points and end points.
     */
    public int minMeetingRooms1(Interval[] intervals) {
        if (intervals == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }
        int rooms = 0, maxRooms = 0;
        for (int time : map.keySet()) {
            rooms += map.get(time);
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }

    /**
     * A clever idea: put start points and end points in separate arrays and sort. Then process them like merging two
     * sorted arrays.
     */
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) {
            throw new java.lang.IllegalArgumentException();
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0, maxRooms = 0;
        int i = 0, j = 0;
        while (i < start.length) {//no need for j < end.length because i always reaches boundary before j does
            if (start[i] < end[j]) {
                i++;
                rooms++;
                maxRooms = Math.max(maxRooms, rooms);
            } else {
                //when one meeting ends at the same time of another meeting begins, we should decrease rooms first, then increase
                j++;
                rooms--;
            }
        }
        return maxRooms;
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
