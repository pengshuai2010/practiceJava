package leetCode;

import java.util.Arrays;

/**
 * Created by shuaipeng on 12/9/16.
 */
public class Q361_BombEnemy {
    public int maxKilledEnemies1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] kills = new int[m][n];
        for (int i = 0; i < m; i++) {
            int start = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    if (count > 0) {
                        Arrays.fill(kills[i], start, j, count);
                    }
                    start = j;
                    count = 0;
                }
            }
            if (count > 0) {
                Arrays.fill(kills[i], start, n, count);
            }
        }
        for (int j = 0; j < n; j++) {
            int start = 0;
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    if (count > 0) {
                        for (int k = start; k < i; k++) {
                            kills[k][j] += count;
                        }
                    }
                    start = i;
                    count = 0;
                }
            }
            if (count > 0) {
                for (int k = start; k < m; k++) {
                    kills[k][j] += count;
                }
            }
        }
        int maxX = 0, maxY = 0, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int e = kills[i][j];
                    if (e > max) {
                        max = e;
                        maxX = i;
                        maxY = j;
                    }
                }
            }
        }
        return max;
    }

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxX = 0, maxY = 0, max = 0;
        int rowKills = 0;
        int[] colKills = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //when current element is 'W', there's no need to update rowKills and colKills, so we can skip consecutive walls
                if (grid[i][j] == 'W') {
                    continue;
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colKills[j] = getColKills(grid, i, j);
                }
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowKills = getRowKills(grid, i, j);
                }
                if (grid[i][j] == '0' && rowKills + colKills[j] > max) {
                    max = rowKills + colKills[j];
                    maxX = i;
                    maxY = j;
                }
            }
        }
        return max;
    }

    private int getColKills(char[][] grid, int i, int j) {
        int count = 0;
        for (; i < grid.length && grid[i][j] != 'W'; i++) {
            if (grid[i][j] == 'E') {
                count++;
            }
        }
        return count;
    }

    /**
     * get number of enemies in [0 or position immediate right to a wall, n - 1 or position immediately left to a wall]
     */
    private int getRowKills(char[][] grid, int i, int j) {
        int count = 0;
        for (; j < grid[i].length && grid[i][j] != 'W'; j++) {
            if (grid[i][j] == 'E') {
                count++;
            }
        }
        return count;
    }
}
