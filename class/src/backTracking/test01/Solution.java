package backTracking.test01;

import java.util.ArrayList;
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

public class Solution {
    public List<List<Integer>> permute(int[] nums) {

        // 结果
        List<List<Integer>> result = new ArrayList<>();
        // 中间结果
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtracking(n, output, result, 0);
        return result;

    }

    public void backtracking(int n, List<Integer> output, List<List<Integer>> result, int first){
        // 终止条件
        if (first == n){
            result.add(new ArrayList<>(output));
        }

        for (int i = first; i < n; i++) {
            // 交换
            Collections.swap(output, first, i);
            // 下一层
            backtracking(n, output, result, first + 1);
            // 撤销，再交换回来
            Collections.swap(output, first, i);
        }
    }
}
