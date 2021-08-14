/* Best Time To Buy And Sell Stock
 *
 * An array of which i-th element is the price of given stock on day i
 *
 * If you were only permitted to complete at most one transition (i.e., by one
 * and sell one share of stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one
 *
 * Input: [7, 1, 5, 3, 6, 4]
 * 7, 2, 5, 1
 * Output: 5
 * Explanation: Buy one day 2 (price = 1) and sell on day 5 (price = 6)
 *              Profit 6 - 1 = 5.
 */


class Solution {
    public int maxProfit(int[] prices) {
        int min_val = Integer.MAX_VALUE;
        int max_profit = 0;

        for (int i=0; i<prices.length; i++) {
            if (prices[i] < min_val) {
                min_val = prices[i];
            } else if (prices[i] - min_val > max_profit) {
                max_profit = prices[i] - min_val;
            }
        }

        return max_profit;
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 5, 3, 6, 4};

        Solution sol = new Solution();
        System.out.println(sol.maxProfit(A));
    }
}

