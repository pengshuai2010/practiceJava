package lintCode;

import java.util.*;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q121 {
    public static void main(String[] args) {
        System.out.println(new Q121().isNeighbor("hit", "hot"));
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println(new Q120().ladderLength(start, end, dict));
    }

    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);
        set.add(start);
        set.add(end);
        Map<String, List<String>> neighbors = constructGraph(set);
        // get shortest path using Dijkstra's algorithm
        Map<String, Integer> dist = new HashMap<>();
        dist.put(start, 0);
        //TODO there is an implicit bug here: we use Integer.MAX_VALUE to indicate infinity. However the distance between two
        // nodes can actually be Integer.MAX_VALUE.
        dist.put(end, Integer.MAX_VALUE);
        for (String node : dict)
            dist.put(node, Integer.MAX_VALUE);
        PriorityQueue<String> queue = new PriorityQueue<>(set.size(), new NodeComparator(dist));
        queue.add(start);
        Map<String, List<String>> prev = new HashMap<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            // because we only care about the shortest path between start and end
            if (node.equals(end))
                break;
            for (String neighbor : neighbors.get(node)) {
                if (dist.get(node) + 1 < dist.get(neighbor)) {
                    dist.put(neighbor, dist.get(node) + 1);
                    List<String> tmp = new ArrayList<>();
                    tmp.add(node);
                    prev.put(neighbor, tmp);
                    if (queue.contains(neighbor))
                        queue.remove(neighbor);
                    queue.offer(neighbor);
                } else if (dist.get(node) + 1 == dist.get(neighbor)) {
                    prev.get(neighbor).add(node);
                }
            }
        }
        List<String> path = new ArrayList<>();
        //TODO use dfs to get all paths
        for (String node = end; !node.equals(start); node = prev.get(node))
            path.add(node);
        path.add(start);
        return path.size();
    }

    private Map<String, List<String>> constructGraph(Set<String> set) {
        Map<String, List<String>> neighbors = new HashMap<>();
        for (String node : set) {
            neighbors.put(node, new ArrayList<String>());
            // we can optimized here because neighborhood is bi-directional
            for (String other : set)
                if (!other.equals(node) && isNeighbor(node, other))
                    neighbors.get(node).add(other);
        }
        return neighbors;
    }

    private boolean isNeighbor(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int difference = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                difference++;
            if (difference > 1)
                return false;
        }
        return true;
    }

    private class NodeComparator implements Comparator<String> {
        Map<String, Integer> dist;

        private NodeComparator(Map<String, Integer> dist) {
            this.dist = dist;
        }

        @Override
        public int compare(String s, String t1) {
            return dist.get(s) - dist.get(t1);
        }

    }
}
