package dynamicProgramming.test10;


/**
 * 题目地址：
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 *
 * 题目内容：
 * 【买卖股票的最佳时机】
 *
 */
public class Solution {
    public int maxProfit(int prices[]) {
        // 记录最小的股票价格
        int minprice = Integer.MAX_VALUE;
        // 最大收益
        int maxprofit = 0;
        // 遍历数组的元素
        for (int i = 0; i < prices.length; i++) {
            //
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
