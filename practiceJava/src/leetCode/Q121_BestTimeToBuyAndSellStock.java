package leetCode;

/**
 * Created by speng on 11/26/16.
 */
public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit2(int[] prices) {
        int max = Integer.MIN_VALUE;
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i]);
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return maxProfit;
    }

    /**
     * by calculating the difference of prices, this problem is converted to a maximum subarray problem, which can be
     * readily solved by dynamic programming
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int maxsofar = 0, max = 0;
        for (int i = 0; i < diff.length; i++) {
            maxsofar = Math.max(maxsofar + diff[i], 0);
            max = Math.max(max, maxsofar);
        }
        return max;
    }
}
