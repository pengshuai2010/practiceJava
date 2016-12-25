package leetCode;

import basicAlgorithms.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by speng on 12/25/16.
 */
public class Q133_CloneGraph {
    /**
     * use BFS, takes O(|V| + |E|) time
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        //map origin to clone
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    // map also serves as visited
                    //to avoid adding a node into queue twice, we should put it in map as soon as adding it to queue
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));//add node in the cloned graph
                }
                map.get(curr).neighbors.add(map.get(neighbor));//add edge in the cloned graph
            }

        }
        return map.get(node);
    }
}
