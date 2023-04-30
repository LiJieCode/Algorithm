package dynamicProgramming.test06;

/**
 * 题目地址：
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * 题目内容；
 * 【最小路径和】
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 解题思路： 动态规划
 */
public class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
