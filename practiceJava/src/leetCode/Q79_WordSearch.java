package leetCode;

/**
 * Created by speng on 12/4/16.
 */
public class Q79_WordSearch {
    /**
     * Yet another DFS.
     * <p>
     * Note that we can save some space by using bitmap instead of boolean matrix to mark visited.
     * Or we can change the element on the board to some invalid character to indicate visited.
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, boolean[][] visited, int x, int y, String word, int index) {
        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && index < word.length() && board[x][y] == word.charAt(index)) {//don't forget examine if index is within length of word, or we will have null point exception
            // when call a method or a field of a reference variable always be aware of null pointer exception!
            if (index == word.length() - 1) {
                return true;
            }
            visited[x][y] = true;
            if (dfs(board, m, n, visited, x - 1, y, word, index + 1)) {
                return true;
            }
            if (dfs(board, m, n, visited, x, y + 1, word, index + 1)) {
                return true;
            }
            if (dfs(board, m, n, visited, x + 1, y, word, index + 1)) {
                return true;
            }
            if (dfs(board, m, n, visited, x, y - 1, word, index + 1)) {
                return true;
            }
            visited[x][y] = false;
        }
        return false;
    }
}
