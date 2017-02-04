package lintCode;

import java.util.*;

/**
 * Created by speng on 2/4/17.
 */
public class Q178_GraphValidTree {
    /**
     * @param n     an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n < 0 || edges == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (n == 0) {//ask interviewer how to handle this case
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = initializeGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : map.get(curr)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited.size() == n;
    }

    /**
     * initialize the graph in a separate method, so the calling method is better
     * structured and easier to understand.
     */
    private Map<Integer, List<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            //add the edge at both nodes because this is an undirected graph
            //if don't do so, test case n = 2, edges = [[1,0]] will fail
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }
}
