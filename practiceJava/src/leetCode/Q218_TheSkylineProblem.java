package leetCode;

import java.util.*;

/**
 * Created by speng on 12/30/16.
 */
public class Q218_TheSkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{0, 3, 3}, {1, 5, 3}, {2, 4, 3}, {3, 7, 3}};
        Q218_TheSkylineProblem solution = new Q218_TheSkylineProblem();
        List<int[]> res = solution.getSkyline(buildings);
        for (int[] segment : res) {
            System.out.print("[");
            for (int num : segment) {
                System.out.print(num + ", ");
            }
            System.out.print("], ");
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyLine = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return skyLine;
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] building : buildings) {
            for (int j = 0; j < 2; j++) {
                if (!map.containsKey(building[j])) {
                    map.put(building[j], new ArrayList<>());
                }
                map.get(building[j]).add(building);
            }
        }
        List<Integer> criticalPoints = new ArrayList<>();
        criticalPoints.addAll(map.keySet());
        Collections.sort(criticalPoints);
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                //a[2] as first key, a[1] as secondary key, a[0] as third key
                //A Comparator class or compareTo() method is consistent with equals() when a.compareTo(b) is equivalent
                // to a.equals(b).
                // Generally, Set and Map operations ared based upon equals(). But SortedSet and SortedMap are different.
                // For SortedSet and SortedMap, if a.compareTo(b) == 0, a and b are considered to be equal.
                //So in SortedMap or SortedSet, if Comparator or compareTo() is not consistent with equals, we will see
                //"strange" things.
                //read https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html
                if (a[2] == b[2]) {
                    if (a[1] == b[1]) {
                        return a[0] - b[0];
                    }
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        });
        int lastHeight = -1;
        for (int x : criticalPoints) {
            for (int[] building : map.get(x)) {
                if (x == building[0]) {
                    set.add(building);
                } else {
                    set.remove(building);
                }
            }
            int currHeight = 0;
            if (!set.isEmpty()) {//handle the case when last one in a group of buildings is removed
                currHeight = set.last()[2];
            }
            if (currHeight != lastHeight) {
                skyLine.add(new int[]{x, currHeight});
                lastHeight = currHeight;
            }

        }
        return skyLine;
    }
}
