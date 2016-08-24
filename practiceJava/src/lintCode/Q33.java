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

    /**
     * Get all distinct N-Queen solutions
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        List<Integer> board = new ArrayList<>();
        for (int i = 0; i < n; i++)
            board.add(-1);
        List<List<Integer>> solutions = new ArrayList<>();
        nQueensDFS(board, 0, solutions);
        return convertSolutions(solutions);
    }

    ArrayList<ArrayList<String>> convertSolutions(List<List<Integer>> solutions) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        if (solutions == null || solutions.size() == 0)
            return results;
        int n = solutions.get(0).size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(".");
        for (List<Integer> solution : solutions) {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sb.setCharAt(solution.get(i), 'Q');
                result.add(sb.toString());
                sb.setCharAt(solution.get(i), '.');
            }
            results.add(result);
        }
        return results;
    }

    private void nQueensDFS(List<Integer> board, int row, List<List<Integer>> solutions) {
        int n = board.size();
        if (row == n) {
            List<Integer> solution = new ArrayList<>();
            solution.addAll(board);
            solutions.add(solution);
            return;
        }
        for (int i = 0; i < n; i++) {
            board.set(row, i);
            if (checkValidity(board, row))
                nQueensDFS(board, row + 1, solutions);
        }
    }

    private boolean checkValidity(List<Integer> board, int row) {
        if (board == null || row > board.size())
            return false;
        for (int i = 0; i < row; i++) {
            int prev = board.get(i);
            int curr = board.get(row);
            if (prev == curr)
                return false;
            // note there are two kind of diagonals!!!
            if (curr - prev == row - i || prev - curr == row - i)
                return false;
        }
        return true;
    }
}
