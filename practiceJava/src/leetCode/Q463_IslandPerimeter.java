package leetCode;

/**
 * Created by speng on 12/27/16.
 */
public class Q463_IslandPerimeter {
    /**
     * Don't even need DFS or BFS. Just count how many external sides in total.
     * Another cleverer solution: 4*lands - 2*internalEdges. The intuition is that each land add 4 sides and each internal
     * edge eliminates 2 sides. see https://discuss.leetcode.com/topic/68786/clear-and-easy-java-solution/12
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += countExternalSides(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private int countExternalSides(int[][] grid, int x, int y) {
        int externalSides = 4;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int i = x + dir[0], j = y + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                externalSides--;
            }
        }
        return externalSides;
    }
}
