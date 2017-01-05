package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by speng on 1/4/17.
 */
public class Q305_NumberOfIslandsII {
    private int[] parent;
    private int[] weight;
    private int count;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        parent = new int[m * n + 1];
        Arrays.fill(parent, m * n);
        weight = new int[m * n + 1];
        Arrays.fill(weight, 1);
        weight[m * n] = m * n + 1;
        count = 1;
        for (int[] pos : positions) {//is it guaranteed addLang() is valid? not called on the element more than once?
            int index = pos[0] * n + pos[1];
            parent[index] = index;
            weight[m * n]--;
            count++;
            for (int[] dir : dirs) {
                int i = pos[0] + dir[0], j = pos[1] + dir[1];
                int neighbor = i * n + j;
                if (i >= 0 && i < m && j >= 0 && j < n && find(neighbor) != m * n) {
                    union(index, neighbor);
                }
            }
            list.add(count - 1);
        }
        return list;
    }

    private int find(int p) {
        int root = p;
        while (parent[root] != root) {
            root = parent[root];
        }
        while (parent[p] != root) {
            int tmp = parent[p];
            parent[p] = root;
            p = tmp;
        }
        return root;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {//don't forget this! or weight and count will be wrong!
            return;
        }
        if (weight[rootP] > weight[rootQ]) {
            parent[rootQ] = rootP;
            weight[rootP] += weight[rootQ];
        } else {
            parent[rootP] = rootQ;
            weight[rootQ] += weight[rootP];
        }
        count--;
    }
}
