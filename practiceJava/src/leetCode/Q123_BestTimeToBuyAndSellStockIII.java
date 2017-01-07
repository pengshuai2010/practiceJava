package leetCode;

/**
 * Created by shuaipeng on 1/6/17.
 */
public class Q123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        Q123_BestTimeToBuyAndSellStockIII solution = new Q123_BestTimeToBuyAndSellStockIII();
        int[][] input = new int[][]{{}, {7, 8, 0, 4, 3, 2, 9}};
        for (int[] prices : input) {
            System.out.println(solution.maxProfit(prices));
        }
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[] diff = new int[prices.length + 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i] = prices[i] - prices[i - 1];
        }
        int[] leftMax = new int[prices.length + 1];
        int maxSofar = 0;
        for (int i = 1; i < leftMax.length; i++) {
            maxSofar = diff[i] + Math.max(0, maxSofar);
            leftMax[i] = Math.max(leftMax[i - 1], maxSofar);
        }
        int[] rightMax = new int[prices.length + 1];
        maxSofar = 0;
        for (int i = rightMax.length - 2; i >= 0; i--) {
            maxSofar = diff[i] + Math.max(0, maxSofar);
            rightMax[i] = Math.max(rightMax[i + 1], maxSofar);
        }
        int maxProfit = 0;
        for (int i = 1; i < rightMax.length; i++) {
            maxProfit = Math.max(maxProfit, leftMax[i - 1] + rightMax[i]);
        }
        return maxProfit;
    }
}
