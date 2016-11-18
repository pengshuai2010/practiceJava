package leetCode;

/**
 * Created by speng on 11/17/16.
 */
public class Q200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int islands = 0;
        // if we can modify grid, we won't need visited matrix, we can simply set visited element to '0'
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islands++;
                    dfs(i, j, visited, grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j, boolean[][] visited, char[][] grid) {
        // we validate the positions here instead of in the for neighbours loop, making the code look more concise
        if (i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            dfs(i, j + 1, visited, grid);//direct add or minus i and j instead of using operation array
            dfs(i, j - 1, visited, grid);
            dfs(i + 1, j, visited, grid);
            dfs(i - 1, j, visited, grid);
        }
    }
}
