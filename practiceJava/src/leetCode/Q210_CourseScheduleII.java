package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q210_CourseScheduleII {
    private static int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        List<List<Integer>> dependents = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependents.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int dependent = edge[0];
            int node = edge[1];
            dependents.get(node).add(dependent);
            indegree[dependent]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.addLast(i);
            }
        }
        List<Integer> ordering = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            ordering.add(node);
            for (int dependent : dependents.get(node)) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    queue.addLast(dependent);
                }
            }
        }
        if (ordering.size() == numCourses) {
            return toArray(ordering);
        }
        return new int[0];
    }
}
