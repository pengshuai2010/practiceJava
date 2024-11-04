package leetCode;

public class Q426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
    private static Result helper(Node root) {
        if (root == null) {
            return new Result(null, null);
        }
        Result leftResult = helper(root.left);
        Result rightResult = helper(root.right);
        if (leftResult.max != null) {
            leftResult.max.right = root;
        }
        root.left = leftResult.max;
        if (rightResult.min != null) {
            rightResult.min.left = root;
        }
        root.right = rightResult.min;
        Node min = leftResult.min != null ? leftResult.min : root;
        Node max = rightResult.max != null ? rightResult.max : root;
        return new Result(min, max);
    }

    Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Result result = helper(root);
        result.min.left = result.max;
        result.max.right = result.min;
        return result.min;
    }
}

class Result {
    Node min;
    Node max;

    Result(Node min, Node max) {
        this.min = min;
        this.max = max;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

