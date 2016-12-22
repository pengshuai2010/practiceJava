package basicAlgorithms;

/**
 * See http://algs4.cs.princeton.edu/15uf/ and
 * http://algs4.cs.princeton.edu/15uf/WeightedQuickUnionPathCompressionUF.java.html
 * Created by speng on 12/18/16.
 */
public class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;//how many sets

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        int[][] intput = new int[][]{{8, 9}, {5, 6}, {7, 8}, {6, 7},
                {1, 2}, {0, 2}};
        System.out.println(uf.getCount());
        System.out.println(uf.isInSameSet(5, 9));
        for (int[] pair : intput) {
            uf.union(pair[0], pair[1]);
        }
        System.out.println(uf.getCount());
        System.out.println(uf.isInSameSet(5, 9));
    }

    public int find(int p) {
        int root = p;
        while (parent[root] != root) {//find root
            root = parent[root];
        }
        while (parent[p] != root) {//path compression
            int tmp = parent[p];
            parent[p] = root;
            p = tmp;
        }
        return root;
    }

    public boolean isInSameSet(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {//avoid increasing size multiple times
            return;
        }
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public int getCount() {
        return count;
    }
}
