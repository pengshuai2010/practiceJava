package leetCode;

/**
 * Created by shuaipeng on 1/8/17.
 */
public class Q276_PaintFence {
    /**
     * When the last two posts have same color, we have (k - 1) ways to paint the next post; when the last two posts have
     * different colors, we have k ways to paint the next post. The number of ways to paint a new post only depends on the
     * state of last two posts. So we can define state S0 as the state when last two posts have same color, S1 as the state
     * when last two posts have different colors. From S0 we can only go to S1, and there (k - 1) ways(because we cannot
     * choose the same color as the last post). From S1 we have 1 way to go to S0(by choose the same color as the last post),
     * and (k - 1) ways to go to S1.
     * Thus S0[i] = S1[i - 1], S1[i] = (k - 1) * (S0[i - 1] + S1[i - 1]). Initial state is S0[0] = 0, S1[1] = k.
     */
    public int numWays(int n, int k) {
        if (n < 1 || k < 1) {
            return 0;//or throw new IllegalArugmentException? ask interviewer
        }
        int s0 = 0;
        int s1 = k;
        for (int i = 1; i < n; i++) {
            int nextS0 = s1;//use nextS0 and nextS1 to avoid overwriting values of old S0, S1
            int nextS1 = (k - 1) * (s0 + s1);
            s0 = nextS0;
            s1 = nextS1;
        }
        return s0 + s1;
    }
}
