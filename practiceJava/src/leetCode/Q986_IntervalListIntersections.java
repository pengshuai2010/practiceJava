package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q986_IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // will any of the two be null? will the intervals be valid, i.e. will there be invalid input like [2, 0]?
        List<int[]> result = new ArrayList<>();
        int p = 0;
        int q = 0;
        while (p < firstList.length && q < secondList.length) {
            int start = Math.max(firstList[p][0], secondList[q][0]);
            int end = Math.min(firstList[p][1], secondList[q][1]);
            if (start <= end) { // clarify: do [1, 2] and [2, 3] have an intersection?
                result.add(new int[]{start, end});
            }
            if (firstList[p][1] < secondList[q][1]) {
                p++;
            } else {
                q++;
            }
        }
        int[][] intersections = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            intersections[i][0] = result.get(i)[0];
            intersections[i][1] = result.get(i)[1];
        }
        return intersections;
    }
}
