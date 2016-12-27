package leetCode;

/**
 * Created by speng on 12/26/16.
 */
public class Q348_DesignTicTacToe {
    private long[][] rows;
    private long[][] cols;
    private long[] diagonal;
    private long[] antiDiagonal;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public Q348_DesignTicTacToe(int n) {
        rows = new long[2][n];
        cols = new long[2][n];
        diagonal = new long[2];
        antiDiagonal = new long[2];
        this.n = n;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        //since we only need to count how many tokens a player has in a row/column/diagonal/anti-diagonal, and the
        //moves are guaranteed to be valid, we don't even need to store the board, just store the count for each
        //row/column/diagonal/anti-diagonal.
        rows[player - 1][row]++;
        cols[player - 1][col]++;
        if (row == col) {
            diagonal[player - 1]++;
        }
        if (row + col == n - 1) {
            antiDiagonal[player - 1]++;
        }
        if (rows[player - 1][row] == n
                || cols[player - 1][col] == n
                || diagonal[player - 1] == n
                || antiDiagonal[player - 1] == n) {
            return player;
        }
        return 0;
    }
}
