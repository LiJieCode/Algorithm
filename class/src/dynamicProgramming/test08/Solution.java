package dynamicProgramming.test08;

import com.sun.security.auth.NTUserPrincipal;
import com.sun.xml.internal.bind.v2.model.core.MaybeElement;
import sun.text.resources.cldr.ti.FormatData_ti;

import java.util.Arrays;

/**
 * 题目地址：
 * https://leetcode.cn/problems/house-robber-ii/
 * <p>
 * 题目内容：
 * 【打家劫舍2】
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 题目说明：
 * 这是test07的进阶题，可以先看懂test07的题目
 * 这里和test07唯一的不同就是，这里的房子是环形的。
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        // 分两种情况讨论
        // 第一种：不偷第一个
        // 第二种：不偷最后一个
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    // 这里就是打家劫舍1 的解题方案嘛。
    public int myRob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n > 1) nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[n - 1];
    }
}
