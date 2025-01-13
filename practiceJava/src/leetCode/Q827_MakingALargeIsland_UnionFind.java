package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q827_MakingALargeIsland_UnionFind {
    public static void main(String[] args) {
        Q827_MakingALargeIsland_UnionFind solution = new Q827_MakingALargeIsland_UnionFind();
//        int[][] grid = new int[][]{{1,0},{0,1}};
        int[][] grid = new int[][]{{1, 1},{1, 0}};
        System.out.println(solution.largestIsland(grid));
    }

    private static final int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find(int a) {
            int node = a;
            while (parent[node] != node) {
                node = parent[node];
            }
            int root = node;
            node = a;
            while (parent[node] != root) {
                int tmp = parent[node];
                parent[node] = root;
                node = tmp;
            }
            return root;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            if (size[rootA] < size[rootB]) {
                int tmp = rootA;
                rootA = rootB;
                rootB = tmp;
            }
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        public int getSize(int a) {
            return size[find(a)];
        }
    }

    public int largestIsland(int[][] grid) {
        // will there be numRows == 0 or numCols == 0?
        int numRows = grid.length;
        int numCols = grid[0].length;
        UnionFind unionFind = getUnionFind(grid, numRows, numCols);
        boolean allOnes = true;
        int maxArea = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 0) {
                    allOnes = false;
                    // We need to use a set because an empty cell could touch the same island in multiple directions
                    Set<Integer> adjacentIslands = new HashSet<>();
                    for (int[] direciton: DIRECTIONS) {
                        int row = i + direciton[0];
                        int col = j + direciton[1];
                        if (inBoundary(row, col, numRows, numCols) && grid[row][col] == 1) {
                            int index = getIndex(row, col, numCols);
                            // use root as the ID of an island
                            int root = unionFind.find(index);
                            adjacentIslands.add(root);
                        }
                    }
                    int area = 1;
                    for (int root: adjacentIslands) {
                        int size = unionFind.getSize(root);
                        area += size;
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        if (allOnes) {
            return numRows * numCols;
        }
        return maxArea;
    }

    private UnionFind getUnionFind(int[][] grid, int numRows, int numCols) {
        UnionFind unionFind = new UnionFind(numRows * numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == 1) { // do a union only if both cells are '1'.
                    int index = getIndex(i, j, numCols);
                    for (int[] direction : DIRECTIONS) {
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if (inBoundary(row, col, numRows, numCols) && grid[row][col] == 1) {
                            int neighborIndex = getIndex(row, col, numCols);
                            unionFind.union(index, neighborIndex);
                        }
                    }
                }
            }
        }
        return unionFind;
    }

    private boolean inBoundary(int row, int col, int numRows, int numCols) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    private int getIndex(int row, int col, int numCols) {
        return row * numCols + col;
    }

}
