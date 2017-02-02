package lintCode;

import java.util.*;

/**
 * Created by speng on 2/1/17.
 */
public class Q615_CourseSchedule {
    /**
     * @param numCourses    a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            throw new java.lang.IllegalArgumentException();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            indegree[dest]++;
            if (!map.containsKey(src)) {
                map.put(src, new ArrayList<>());
            }
            map.get(src).add(dest);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                for (int dest : map.get(curr)) {
                    indegree[dest]--;
                    if (indegree[dest] == 0) {
                        queue.offer(dest);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
