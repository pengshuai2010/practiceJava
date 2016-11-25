package leetCode;

import basicAlgorithms.DirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by speng on 11/24/16.
 */
public class Q207_CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{2, 0}, {2, 1}};
        int numCourses = 3;
        Q207_CourseSchedule solution = new Q207_CourseSchedule();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }


//      If we use adjacency matrix to represent graph, time complexity will be O(|V|^2), because we need to go through
//      each element of the matrix to check if there's an edge there. And space complexity is O(|V|^2) too, which is
//      not efficient when the graph is large and sparse.

    /**
     * use adjacency list to represent graph, use BFS to do topological sort
     * time complexity O(|V| + |E|), where |V| is number of nodes and |E| is number of edges
     * space complexity O(|V| + |E|). the representation of graph taks O(|E|).
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null)
            throw new RuntimeException("invalid input");
        Map<DirectedGraphNode, Integer> map = new HashMap<>();// keep track of indegree of nodes
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        DirectedGraphNode[] nodes = new DirectedGraphNode[numCourses];
        for (int i = 0; i < numCourses; i++)
            nodes[i] = new DirectedGraphNode(i);
        // build graph
        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[1]].neighbors.add(nodes[prerequisite[0]]);
        }
        // get the indegree of each node
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        // find out nodes whose indegree is 0
        for (DirectedGraphNode node : nodes) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }
        // BFS
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        for (DirectedGraphNode node : map.keySet()) {
            if (map.get(node) != 0) {
                return false;// there exists at least one cycle
            }
        }
        return true;
    }

}
