package backTracking.quanpailie;

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

public class Solution46_1 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        List<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtracking(n, res, output, 0);
        return res;


    }

    public void backtracking(int n, List<List<Integer>> res, List<Integer> output, int first){
        if (first == n) {
            res.add(new ArrayList<>(output));
        }

        for (int i = 0; i < n; i++) {

            Collections.swap(output,i,first);

            backtracking(n, res, output, first + 1);

            Collections.swap(output, first, i);

        }

    }

}