class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int bestBuy = prices[0]; // bestBuy starts from 1st element

        for (int i=1; i<prices.length; i++) {
            // comapare the current price with the best buy 
            // if current buy is greater there is profit
            if (prices[i] > bestBuy) {
                maxProfit = Math.max(maxProfit, prices[i]-bestBuy);
            }

            // else update the bestbuy
            bestBuy = Math.min(bestBuy, prices[i]);
        }

        return maxProfit;
    }

}