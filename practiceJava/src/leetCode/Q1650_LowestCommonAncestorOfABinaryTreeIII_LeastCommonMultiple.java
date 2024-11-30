
package leetCode;

public class Q1650_LowestCommonAncestorOfABinaryTreeIII_LeastCommonMultiple {
    Node lowestCommonAncestor(Node p, Node q) {
        // clarify will p or q be null?
        if (p == null || q == null) {
            return null;
        }
        // Imagine p's path to root is a loop, and the root connects back to p, same for q.
        // Suppose the length of p's path to loop is m, and that of q is n, and pointer A travels along the loop of p,
        // and pointer B travels along the loop of q. After going the Least Common Multiples of m and n, a and b will meet
        // at the LCA.
        // Time complexity is O(least common multiple of m and n)
        // Space complexity is O(1)

        // assuming p and q is indeed in the same tree.
        // If not, this algorithm won't work
        Node a = p;
        Node b = q;
        while (a != b) {
            a = a.parent == null ? p : a.parent;
            b = b.parent == null ? q : b.parent;
        }
        return a;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

}
