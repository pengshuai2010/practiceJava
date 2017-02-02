package lintCode;

import basicAlgorithms.UndirectedGraphNode;

import java.util.*;

/**
 * Created by speng on 2/1/17.
 */
public class Q618_SearchGraphNodes {
    /**
     * @param graph  a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node   an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if (graph == null || values == null || node == null) {
            return null;
        }
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.add(node);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            if (values.get(curr) == target) {//assuming all nodes are in the map values
                return curr;
            }
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return null;
    }
}
