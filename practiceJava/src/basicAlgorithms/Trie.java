package basicAlgorithms;

/**
 * Created by speng on 12/11/16.
 */
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

/**
 * leetcode 208. Implement Trie (Prefix Tree)
 * see https://leetcode.com/articles/implement-trie-prefix-tree/ about implementing a Trie
 * We use links to represent characters instead of storing characters in the nodes
 */
class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;

    // Initialize your data structure here.
    public TrieNode() {
        int charSetSize = 26;
        links = new TrieNode[charSetSize];
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void set(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.get(word.charAt(i)) == null) {
                node.set(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    /**
     * @param word
     * @return null if the prefix is not found; a TrieNode if the prefix is found
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.get(word.charAt(i)) == null) {
                return null;
            }
            node = node.get(word.charAt(i));
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}


