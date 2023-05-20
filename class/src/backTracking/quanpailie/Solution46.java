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

public class Solution46 {

//    public List<List<Integer>> permute(int[] nums) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums.length == 0) return res;
//
//        List<Integer> output = new ArrayList<>();
//
//        int n = nums.length;
//
//        backtracking(nums, n, res, output, 0);
//        return res;
//
//
//    }
//
//    public void backtracking(int[] nums,int n, List<List<Integer>> res, List<Integer> output, int first){
//        if (first == n) {
//            res.add(new ArrayList<Integer>(output));
//        }
//
//        for (int i = first; i < n; i++) {
//
//            output.add(nums[i]);
//
//            backtracking(nums, n, res, output, first + 1);
//
//            output.remove(output.size() - 1);
//
//
//        }
//    }



    boolean[] vis;

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        vis = new boolean[nums.length];

        backtracking(nums, n, res, output, 0);
        return res;


    }

    public void backtracking(int[] nums,int n, List<List<Integer>> res, List<Integer> output, int first){
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            output.add(nums[i]);
            vis[i] = true;
            backtracking(nums, n, res, output, first + 1);
            vis[i] = false;
            output.remove(output.size() - 1);

        }
    }
}