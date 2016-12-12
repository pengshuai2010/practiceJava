package leetCode;

/**
 * Created by shuaipeng on 12/12/16.
 */
public class Q289_GameOfLife {
    /**
     * for each cell, we need to store 2 bits information, current state(live or dead), next state(live or dead). To save
     * space, we can use two bits in the int. e.g. LSB for current state, 2nd LSB for next state.
     * <p>
     * Examining all neighbors takes O(8) time, so time complexity is O(8mn), or O(mn). Space complexity is O(1) because we
     * are doing it in-place.
     */
    public void gameOfLife(int[][] board) {
        //ask interviwer: can I assume there are only zeros and ones in the board?
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                decideLife(board, i, j);
            }
        }
        //move next to current
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    /**
     * get current state by (board[i][j] & 1), set next state to live by board[i][j] \= 1<<1
     */
    private void decideLife(int[][] board, int i, int j) {
        int liveNeighbors = 0;
        int m = board.length;
        int n = board[0].length;
        //use max() and min() to take array boundaries into account
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                liveNeighbors += board[x][y] & 1;
            }
        }
        liveNeighbors -= board[i][j] & 1;//exclude the cell itself
        //the 2nd LSB is initially 0, so we only care about the case when cell becomes alive
        if ((board[i][j] & 1) > 0) {
            if (liveNeighbors == 2 || liveNeighbors == 3) {
                board[i][j] |= 1 << 1;
            }
        } else {
            if (liveNeighbors == 3) {
                board[i][j] |= 1 << 1;
            }
        }
    }
}
