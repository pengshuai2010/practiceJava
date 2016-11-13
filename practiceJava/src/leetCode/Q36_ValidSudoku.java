package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuaipeng on 11/11/16.
 */
public class Q36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int len = 9;
        if (board == null || board.length != len)
            return false;
        for (int i = 0; i < len; i++)
            if (board[i] == null || board[i].length != len)
                return false;
        for (int row = 0; row < len; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < len; col++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                else
                    set.add(ch);
            }
        }
        for (int col = 0; col < len; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < len; row++) {
                char ch = board[row][col];
                if (ch == '.')
                    continue;
                if (set.contains(ch))
                    return false;
                else
                    set.add(ch);
            }
        }
        for (int i = 0; i < len; i += 3) {
            for (int j = 0; j < len; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        char ch = board[row][col];
                        if (ch == '.')
                            continue;
                        if (set.contains(ch))
                            return false;
                        else
                            set.add(ch);
                    }
                }
            }
        }
        return true;
    }
}
