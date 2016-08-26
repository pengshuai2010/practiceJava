package lintCode;

import java.util.*;

/**
 * Created by shuaipeng on 8/25/16.
 */
public class Q121 {
    public static void main(String[] args) {
//        System.out.println(new Q121().isNeighbor("hit", "hot"));
//        String start = "hit";
//        String end = "cog";
//        Set<String> dict = new HashSet<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));

//        String start = "a";
//        String end = "c";
//        Set<String> dict = new HashSet<>(Arrays.asList("a", "b", "c"));
//        System.out.println(new Q121().findLadders(start, end, dict));

        String start = "hot";
        String end = "dog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
        System.out.println(new Q121().findLadders(start, end, dict));
    }

    /**
     * @param start, a string
     * @param end,   a string
     * @param dict,  a set of string
     * @return an integer
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);
        set.add(start);
        set.add(end);
        Map<String, List<String>> neighbors = constructGraph(set);
        // get shortest path using Dijkstra's algorithm
        Map<String, Integer> dist = new HashMap<>();
        //TODO there is an implicit bug here: we use Integer.MAX_VALUE to indicate infinity. However the distance between two
        // nodes can actually be Integer.MAX_VALUE.
        for (String node : set)
            dist.put(node, Integer.MAX_VALUE);
        dist.put(start, 0);
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
        LinkedList<String> path = new LinkedList<>();
        path.add(end);
        List<List<String>> paths = new ArrayList<>();
        dfs(prev, end, path, paths);
        return paths;
    }

    private void dfs(Map<String, List<String>> prev, String node, LinkedList<String> path, List<List<String>> paths) {
        if (prev.get(node) == null) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(path);
            paths.add(tmp);
            return;
        }
        for (String predecessor : prev.get(node)) {
            path.addFirst(predecessor);
            dfs(prev, predecessor, path, paths);
            path.removeFirst();
        }
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
