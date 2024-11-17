package lintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 8/22/16.
 */
public class Q33 {
    public static void main(String[] args) {
        System.out.println(new Q33().solveNQueens(4));
    }

    // the time and space complexity is O(n!), because on the first row, there are n locations to place a queen, on the
    // second row, there are at most (n - 1) locations to place a queen, ..., on the nth row, at most 1 location.
    // Hence, there are at most n! solutions. Build each solution take polynomial time and can be omitted compared to n!.
    private static void dfs(int n, int row, List<Integer> queens, List<List<String>> solutions) {
        if (row == n) {
            List<String> board = generateBoard(n, queens);
            solutions.add(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!conflictWithQueens(queens, row, col)) {
                queens.add(col);
                dfs(n, row + 1, queens, solutions);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private static boolean conflictWithQueens(List<Integer> queens, int row, int col) {
        for (int queenRow = 0; queenRow < queens.size(); queenRow++) {
            int queenCol = queens.get(queenRow);
            if (queenCol == col) {
                return true;
            }
            if (queenRow - row == queenCol - col) {
                return true;
            }
            if (queenCol + queenRow == col + row) {
                return true;
            }
        }
        return false;
    }

    private static List<String> generateBoard(int n, List<Integer> queens) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < n; col++) {
            sb.append(".");
        }
        for (int row = 0; row < n; row++) {
            int queenCol = queens.get(row);
            sb.setCharAt(queenCol, 'Q');
            board.add(sb.toString());
            sb.setCharAt(queenCol, '.');
        }
        return board;
    }

    /**
     * @param n: The number of queens
     * @return: All distinct solutions
     *          we will sort your return value in output
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n == 0) {
            return solutions;
        }
        dfs(n, 0, new ArrayList<>(), solutions);
        return solutions;
    }
}
