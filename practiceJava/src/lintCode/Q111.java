package lintCode;

/**
 * Created by speng on 8/27/16.
 */
public class Q111 {
    public static void main(String[] args) {
        System.out.println(new Q111().climbStairs(-1));
        System.out.println(new Q111().climbStairs(0));
        System.out.println(new Q111().climbStairs(1));
        System.out.println(new Q111().climbStairs(2));
        System.out.println(new Q111().climbStairs(3));

    }

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs1(int n) {
        if (n < 0)
            return 0;
        if (n <= 1)
            return 1;
        int[] table = new int[n + 1];
        table[0] = 1;
        table[1] = 1;
        return dp(n, table);
    }

    // top-down solution takes O(n) space
    private int dp(int n, int[] table) {
        if (table == null || n >= table.length)
            return -1;
        if (table[n] == 0)
            table[n] = dp(n - 2, table) + dp(n - 1, table);
        return table[n];
    }

    // bottom-up solution, use constant space
    public int climbStairs(int n) {
        if (n < 0)
            return 0;
        if (n < 2)
            return 1;
        int p = 1;
        int q = 1;
        for (int i = 2; i <= n; i++) {
            int r = p + q;
            p = q;
            q = r;
        }
        return q;
    }
}
