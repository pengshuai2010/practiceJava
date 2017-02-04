package lintCode;

import java.util.*;

/**
 * Created by speng on 2/4/17.
 */
public class Q616_CourseScheduleII {
    /**
     * @param numCourses    a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null) {
            return new int[]{};
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            int src = prereq[1];
            int dest = prereq[0];
            graph.get(src).add(dest);
            indegree[dest]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index] = curr;
            index++;
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (index < numCourses) {
            return new int[]{};
        }
        return order;
    }
}
