package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1650_LowestCommonAncestorOfABinaryTreeIII {
    private static List<Node> getPathFromRoot(Node node) {
        List<Node> path = new ArrayList<>();
        Node p = node;
        while (p != null) {
            path.add(p);
            p = p.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // Time complexity O(m) + O(n), which m is the length of p's path to root, and n is
    // the length of q's path to root.
    // Space complexity is O(m) + O(n).
    Node lowestCommonAncestor(Node p, Node q) {
        // clarify will p or q be null?
        if (p == null || q == null) {
            return null;
        }
        List<Node> pathP = getPathFromRoot(p);
        List<Node> pathQ = getPathFromRoot(q);
        Node lca = null;
        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            } else {
                break;
            }
        }
        return lca;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

}
