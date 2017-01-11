package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by speng on 17-1-11.
 */
public class Q425_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        if (words == null) {
            throw new java.lang.IllegalArgumentException();
        }
        if (words.length == 0) {
            return new ArrayList<>();
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        List<List<String>> solutions = new ArrayList<>();
        dfs(words[0].length(), trie, new ArrayList<String>(), solutions);
        return solutions;
    }

    private void dfs(int n, Trie trie, List<String> square, List<List<String>> solutions) {
        if (square.size() == n) {
            solutions.add(new ArrayList<>(square));
            return;
        }
        int j = square.size();//how many rows we have in the square now
        StringBuilder prefix = new StringBuilder();
        //when square.size() == 0, prefix will be empty -- this is exactly what we want,
        //when prefix is empty string, all words in the trie will be returned.
        for (int i = 0; i < square.size(); i++) {
            prefix.append(square.get(i).charAt(j));
        }
        List<String> candidates = trie.startsWith(prefix.toString());
        for (String s : candidates) {
            square.add(s);
            dfs(n, trie, square, solutions);
            square.remove(square.size() - 1);
        }
    }

    /**
     * In this solution, we need to quickly find out all the strings starting with a prefix,
     * so we add a List<String> startsWithMe as field in TrieNode, and updates this field when
     * adding a string to the Trie.
     * And since all strings in the trie have the same length, we no longer need boolean isEnd.
     */
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> startsWithMe = new ArrayList<>();
    }

    private class Trie {
        TrieNode root = new TrieNode();

        void add(String s) {
            TrieNode p = root;
            p.startsWithMe.add(s);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (p.children[ch - 'a'] == null) {
                    p.children[ch - 'a'] = new TrieNode();
                }
                p = p.children[ch - 'a'];
                p.startsWithMe.add(s);
            }
        }

        List<String> startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (p.children[ch - 'a'] == null) {
                    //return empty list when no string starts with this prefix
                    return new ArrayList<>();
                }
                p = p.children[ch - 'a'];
            }
            return new ArrayList<>(p.startsWithMe);
        }
    }
}
