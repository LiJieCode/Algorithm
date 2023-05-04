package dynamicProgramming.test10;

public class Solution_self {
    public int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfits = 0;
        // 遍历数组
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfits = Math.max(maxProfits, prices[i] - minPrice);
        }
        return maxProfits;
    }
}
