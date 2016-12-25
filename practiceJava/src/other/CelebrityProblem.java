package other;

/**
 * Created by speng on 12/24/16.
 */
public class CelebrityProblem {

    /**
     * see http://www.geeksforgeeks.org/the-celebrity-problem/
     * find out the in degree and out degree for each node. Then find a node whose in degree is (n - 1) and out degree
     * is 0. Takes O(n^2) time.
     */
    int getId1(int M[][], int n) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && M[i][j] == 1) {
                    inDegree[j]++;
                    outDegree[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * if i knows j, then i is not a celebrity; else j is not a celebrity. So we can maintain a pool of possible celebrities,
     * and each time choose two persons i and j, see if i knows j. We can always exclude one person each time. After
     * (n - 1) rounds, there's only one person left in the pool. Then we verify if he is a celebrity by check if everybody
     * else knows him and if he doesn't know anybody. We need to do 3*(n - 1) checks in total. So time complexity is O(n)
     */
    int getId(int M[][], int n) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();
            if (M[i][j] == 1) {
                stack.push(j);
            } else {
                stack.push(i);
            }
        }
        int p = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != p && (M[i][p] == 0 || M[p][i] == 1)) {
                return -1;
            }
        }
        return p;
    }
}
