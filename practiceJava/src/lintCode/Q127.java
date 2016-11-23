package lintCode;

import basicAlgorithms.DirectedGraphNode;

import java.util.*;

/**
 * Created by speng on 8/21/16.
 */
public class Q127 {
    public static void main(String[] args) {
        ArrayList<DirectedGraphNode> graphNodes = new ArrayList<>();
        DirectedGraphNode n0 = new DirectedGraphNode(0);
        DirectedGraphNode n1 = new DirectedGraphNode(1);
        DirectedGraphNode n2 = new DirectedGraphNode(2);
        DirectedGraphNode n3 = new DirectedGraphNode(3);
        DirectedGraphNode n4 = new DirectedGraphNode(4);
        DirectedGraphNode n5 = new DirectedGraphNode(5);
        n0.neighbors.addAll(Arrays.asList(n1, n2, n3));
        n1.neighbors.add(n4);
        n2.neighbors.addAll(Arrays.asList(n1, n3, n4));
        n3.neighbors.add(n5);
        graphNodes.addAll(Arrays.asList(n0, n1, n2, n3, n4, n5));
        System.out.println(new Q127().topSort(graphNodes));
    }

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> ordering = new ArrayList<>();
        if (graph == null || graph.size() == 0)
            return ordering;
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor))
                    map.put(neighbor, map.get(neighbor) + 1);
                else
                    map.put(neighbor, 1);
            }
        }
        LinkedList<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph)
            if (!map.containsKey(node))
                queue.add(node);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.remove();
            ordering.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    map.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return ordering;
    }
}
