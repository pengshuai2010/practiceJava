package leetCode;

/**
 * Created by speng on 12/26/16.
 */
public class Q211_AddAndSearchWord_DataStructureDesign {
    private final int charSetSize = 26;
    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.children[word.charAt(i) - 'a'] == null) {
                p.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            p = p.children[word.charAt(i) - 'a'];
        }
        p.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.isEnd;
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < charSetSize; i++) {
                if (search(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            if (search(word, index + 1, node.children[word.charAt(index) - 'a'])) {
                return true;
            }
        }
        return false;
    }

    private class TrieNode {
        boolean isEnd;
        TrieNode[] children = new TrieNode[charSetSize];
    }
}
