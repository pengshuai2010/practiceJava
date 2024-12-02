package leetCode;

import java.util.Arrays;

public class Q261_GraphValidTree_UnionFind {
    public boolean validTree(int n, int[][] edges) {
        // clarify what if n is 0?
        // Do all the nodes have to be in one same tree? Yes

        // grap theory: a graph is a tree if and only if all the nodes are connected, and there are exactly (n - 1) edges,
        // with n being the number of nodes.
        if (edges.length != n - 1) {
            return false;
        }
        // Next step is to check whether all nodes are connected.
        // We could either 1. build an adjacency list representation of the graph,
        // then use BFS or DFS to traverse the graph, and see if all nodes are visited
        // or 2. use Union Find data structure to check if all nodes are connected.

        // The amortized time complexity of union and find operation is basically O(1)
        // initializing the set take O(n) time. Checking all the nodes are in the same tree takes O(n) time.
        // Overall, time complexity is O(n)
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            if (unionFind.inSameSet(edge[0], edge[1])) { // there is a cycle
                return false;
            }
            unionFind.union(edge[0], edge[1]);
        }
        for (int i = 1; i < n; i++) {
            if (!unionFind.inSameSet(0, i)) { // not all nodes are connected
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) { // already in the same set
                return;
            }
            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }

        int find(int a) {
            int p = a;
            while (p != parent[p]) {
                p = parent[p];
            }
            int root = p;
            p = a;
            while (parent[p] != root) {
                int parentP = parent[p];
                parent[p] = root;
                p = parentP;
            }
            return root;
        }

        boolean inSameSet(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
    }


}
