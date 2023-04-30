package dynamicProgramming.test01;

/**
 * 题目地址：
 * https://leetcode.cn/problems/climbing-stairs/description/
 *
 * 题目内容：
 * 【70. 爬楼梯】  -  简单
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 解题思路：
 *  - 递归  比较耗时
 *  - 动态规划  推荐选择
 */
public class Solution {
    // 动态规划
    public int climbStairs(int n) {
        int preLast = 0, last = 0, curr = 1;
        for (int i = 0; i <= n; i++) {
            preLast = last;
            last = curr;
            curr = preLast + last;
        }
        return curr;
    }

    // 第二种动态规划
    public int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;
        int preLast = 1, last = 2, curr = 3;
        for (int i = 4; i <= n; i++) {
            preLast = last;
            last = curr;
            curr = preLast + last;
        }
        return curr;
    }

    // 最后给个递归的方法
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) return n;
        // 递归的思想在这
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}
