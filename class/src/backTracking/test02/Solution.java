package backTracking.test02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目地址：
 * https://leetcode.cn/problems/permutations-ii/description/
 *
 * 题目内容：
 * 【47. 全排列 II】
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 解题思路：
 *
 *
 */

public class Solution {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        // 排序
        Arrays.sort(nums);
        //
        backtracking(nums, result, 0, output);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, int idx, List<Integer> output) {
        if (idx == nums.length) {
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            backtracking(nums, result, idx + 1, output);
            vis[i] = false;
            output.remove(idx);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};

        Solution solution = new Solution();

        List<List<Integer>> list = solution.permuteUnique(nums);

        System.out.println("hello");

    }
}