package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q323_NumberOfConnectedComponentsInAnUndirectedGraph_BFS {
    private static void bfs(int node, List<List<Integer>> neighbors, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();
            for (int neighbor : neighbors.get(curr)) {
                if (!visited[neighbor]) {
                    queue.addLast(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        int numComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numComponents++;
                bfs(i, neighbors, visited);
            }
        }
        return numComponents;
    }
}
