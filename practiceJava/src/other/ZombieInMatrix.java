package other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Location {
    int row;
    int col;

    Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

// Give a two-dimensional grid, each grid has a value, 2 for wall, 1 for zombie, 0 for human (numbers 0, 1, 2).
// Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall.
// How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.
public class ZombieInMatrix {
    private static final int HUMAN = 0;
    private static final int ZOMBIE = 1;
    private static final int WALL = 2;

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean isValid(List<List<Integer>> grid, boolean[][] visited, int row, int col) {
        int numRows = visited.length;
        int numCols = visited[0].length;
        return inBoundary(numRows, numCols, row, col) && !visited[row][col] && grid.get(row).get(col) != WALL;
    }

    private static boolean inBoundary(int numRows, int numCols, int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    int minHours(int rows, int columns, List<List<Integer>> grid) {
        // clarify about input: grid == null?
        // what if there are no humans in the grid?
        // what to return if it is impossible to infect everybody? return -1 in such case.
        boolean[][] visited = new boolean[rows][columns];
        Deque<Location> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == ZOMBIE) {
                    queue.addLast(new Location(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int numLevels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            numLevels++;
            for (int i = 0; i < size; i++) {
                Location location = queue.removeFirst();
                for (int[] direction : DIRECTIONS) {
                    int row = location.row + direction[0];
                    int col = location.col + direction[1];
                    if (isValid(grid, visited, row, col)) {
                        queue.addLast(new Location(row, col));
                        visited[row][col] = true;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == HUMAN && !visited[i][j]) {
                    return -1;
                }
            }
        }
        return numLevels;
    }
}

