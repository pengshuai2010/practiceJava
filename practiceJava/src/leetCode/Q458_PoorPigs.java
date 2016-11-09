package leetCode;

/**
 * Created by speng on 11/8/16.
 */
public class Q458_PoorPigs {
    /**
     * a clear explanation https://discuss.leetcode.com/topic/66856/major-flaw-in-current-algorithm-fixed/4
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // assume buckets > 0, minutesToDie < minutesToTest
        if (buckets == 1)
            return 0;
        int base = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(base));
    }
}
