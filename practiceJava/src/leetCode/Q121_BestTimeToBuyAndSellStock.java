package leetCode;

/**
 * Created by speng on 11/26/16.
 */
public class Q121_BestTimeToBuyAndSellStock {
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        final int n = prices.length;
        int[] largest = new int[n];
        largest[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            largest[i] = Math.max(prices[i], largest[i + 1]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            maxProfit = Math.max(maxProfit, largest[i + 1] - prices[i]);
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
