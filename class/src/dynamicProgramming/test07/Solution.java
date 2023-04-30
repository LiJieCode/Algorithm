package dynamicProgramming.test07;

/**
 * 题目地址：
 * https://leetcode.cn/problems/house-robber/
 *
 * 题目内容：
 * 【打家劫舍】
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // 数组长度大于1，就要提前更新1位置的数组，后面循环中会用到
        if (n > 1) nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // 这里有个两种情况：
            // 你偷 "当前位置的钱"，就只能再偷 "当前位置-2的位置的钱"
            // 或者，你不偷 "当前位置的钱"，那就只能偷 "当前位置-1的位置的钱"
            // 两种情况选择做大值，即可。
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return nums[n - 1];
    }
}
