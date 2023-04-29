package backTracking.test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 题目地址：
 * https://leetcode.cn/problems/permutations/?envType=study-plan-v2&id=top-100-liked
 *
 * 题目内容：
 * 【46. 全排列】
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 解题思路：
 * 回溯算法
 *
 */

public class Solution1 {
    boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();

        vis = new boolean[nums.length];

        //
        backtracking(nums, result, output, 0);
        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> output, int idx) {
        if (idx == nums.length) {
            result.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //
            if (vis[i]) continue;

            output.add(nums[i]);
            vis[i] = true;
            backtracking(nums, result, output, idx + 1);
            vis[i] = false;
            output.remove(idx);
        }
    }
}
