package leetCode;

import java.util.*;

public class Q127_WordLadder {
    private static List<String> getNeighbors(String word) {
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != word.charAt(i)) {
                    sb.setCharAt(i, ch);
                    words.add(sb.toString());
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
        return words;
    }

    // Shorted path in undirected graph
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0; // clarify what is the expected outpu for error case
        }
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);
        visited.add(beginWord);
        int numLevels = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.removeFirst();
                if (curr.equals(endWord)) {
                    return numLevels;
                }
                for (String neighbor : getNeighbors(curr)) {
                    if (dictionary.contains(neighbor) && !visited.contains(neighbor)) {
                        queue.addLast(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            numLevels++;
        }
        return 0;
    }
}
