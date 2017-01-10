package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by speng on 1/9/17.
 */
public class Q212_WordSearchII {
    private class TrieNode {
        boolean isEnd = false;
        /**
         * In this problem, the character set is limited to lower case English letters, so we don't need to store
         * character at TrieNode class, just use "TrieNode[] children = new TrieNode[26]" is enough.
         * If the character set is unicode, we would need to use a HashMap<Character, TrieNode>
         */
        TrieNode[] children = new TrieNode[26];
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * time complexity is O(m^2*n^2 + sum(strings' length)), as adding a word to a trie takes O(l) time where l is the
     * length of string, and DFS takes O(mn) time.
     */
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList<>();
        }
        int m = board.length;
        int n = board[0].length;
        TrieNode root = new TrieNode();
        for (String word : words) {
            addToTrie(root, word);
        }
        //use HashSet because the same word may appear multiple times in the board
        Set<String> foundWords = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(root, i, j, board, foundWords, new StringBuilder());
                if (foundWords.size() == words.length) {
                    break;
                }
            }
        }
        return new ArrayList<>(foundWords);
    }

    private void addToTrie(TrieNode root, String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.children[ch - 'a'] == null) {
                p.children[ch - 'a'] = new TrieNode();
            }
            p = p.children[ch - 'a'];
        }
        p.isEnd = true;
    }

    private class TrieNode {
        boolean isEnd = false;
        /**
         * In this problem, the character set is limited to lower case English letters, so we don't need to store
         * character at TrieNode class, just use "TrieNode[] children = new TrieNode[26]" is enough.
         * If the character set is unicode, we would need to use a HashMap<Character, TrieNode>
         */
        TrieNode[] children = new TrieNode[26];
    }

    private void dfs(TrieNode p, int x, int y, char[][] board, Set<String> foundWords, StringBuilder path) {
        //change character on board to '#' to save the space for boolean[][] visited. But remember to change it back and
        //verify if board[x][y] != '#' before p.children[board[x][y] - 'a'] to avoid indexOutOfBoundException
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#' && p.children[board[x][y] - 'a'] != null) {
            TrieNode curr = p.children[board[x][y] - 'a'];
            path.append(board[x][y]);
            char ch = board[x][y];
            board[x][y] = '#';
            if (curr.isEnd) {
                foundWords.add(path.toString());
            }
            for (int[] dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                dfs(curr, i, j, board, foundWords, path);
            }
            board[x][y] = ch;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
