package leetCode;


import java.util.List;

interface NestedInteger {
    // Constructor initializes an empty nested list.

    // Constructor initializes a single integer.

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

public class Q339_NestedListWeightSum_DFS {
    private static int helper(NestedInteger nestedInteger, int level) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * level;
        }
        List<NestedInteger> nestedList = nestedInteger.getList();
        int sum = 0;
        for (NestedInteger item : nestedList) {
            sum += helper(item, level + 1);
        }
        return sum;
    }

    // clarify is stack overflow is concern? Is it OK to use recursion?
    int depthSum(List<NestedInteger> nestedList) {
        // clarify if input can be null
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            sum += helper(nestedInteger, 1);
        }
        return sum;
    }
}
