package leetCode;

/**
 * Created by speng on 1/6/17.
 */
public class Q351_AndroidUnlockPatterns {
    private int count;
    private int[][] skip;

    public Q351_AndroidUnlockPatterns() {
        //since the pattern is small, we can hard code it. It's easier than deciding it programmically
        //the square is flattened
        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = 5;
        skip[3][7] = skip[7][3] = 5;
    }

    public int numberOfPatterns(int m, int n) {
        if (m < 1 || n > 9 || m > n) {
            throw new java.lang.IllegalArgumentException();
        }
        count = 0;
        for (int i = 1; i <= 9; i++) {
            dfs(i, new boolean[10], 1, m, n);
        }
        return count;
    }

    private void dfs(int curr, boolean[] visited, int layer, int m, int n) {
        if (layer > n) {
            return;
        }
        visited[curr] = true;
        if (layer >= m) {
            count++;
        }
        for (int i = 1; i <= 9; i++) {
            // if i is not visited and there's no unvisited node between i and id
            if (!visited[i] && (skip[i][curr] == 0 || visited[skip[i][curr]])) {
                dfs(i, visited, layer + 1, m, n);
            }
        }
        visited[curr] = false;
    }
}
