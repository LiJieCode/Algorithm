package dynamicProgramming.test05;

/**
 * 题目地址：
 * https://leetcode.cn/problems/unique-paths-ii/
 *
 * 题目说明：
 * test04的进阶题目，可以先完成test04
 * test04中的网格没有障碍，这里的网格有障碍
 * 题目需求都一样
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            //
            if (obstacleGrid[i][0] == 1) break;   // 后面的网格都是0
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            //
            if (obstacleGrid[0][i] == 1) break;   // 后面的网格都是0
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 跳过，也就意味着这个网格的值为0
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
