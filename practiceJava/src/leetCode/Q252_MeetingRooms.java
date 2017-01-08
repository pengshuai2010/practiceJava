package leetCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 1/8/17.
 */
public class Q252_MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
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
