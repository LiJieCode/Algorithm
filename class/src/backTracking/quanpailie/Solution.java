package backTracking.quanpailie;

import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯算法，数组的全排序46/47
 *
 * 无重复值 和 有重复值
 *
 */

public class Solution {

    boolean vis[];
    // 无重复值
    public List<List<Integer>> permute(int[] nums) {
        // 创建结果链表和中间结果链表
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        vis = new boolean[n];

        backtracking1(nums, n, res, output, 0);
        return res;
    }

    public void backtracking1(int[] nums, int n,
                              List<List<Integer>> res,
                              List<Integer> output, int depth){
        // 终止条件
        if (depth == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        //
        for (int i = 0; i < n; i++) {
            // 如果是true，证明已经选过了，直接跳过。
            if (vis[i])  continue;

            // 添加并标记为true
            output.add(nums[i]);
            vis[i] = true;

            backtracking1(nums, n, res, output, depth + 1);
            // 撤销，标记为false
            vis[i] = false;
            output.remove(output.size() - 1);
        }
    }

    /***************************************************************************************
     */

    // 有重复值
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 创建结果链表和中间结果链表
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int n = nums.length;
        vis = new boolean[n];
        Arrays.sort(nums);     // 多了一个排序

        backtracking2(nums, n, res, output, 0);
        return res;
    }

    public void backtracking2(int[] nums, int n,
                              List<List<Integer>> res,
                              List<Integer> output, int depth){
        // 终止条件
        if (depth == n) {
            res.add(new ArrayList<>(output));
            return;
        }

        //
        for (int i = 0; i < n; i++) {
            // 剪枝         这里的剪枝条件还不是很理解
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]))  continue;

            // 添加并标记为true
            output.add(nums[i]);
            vis[i] = true;

            backtracking2(nums, n, res, output, depth + 1);
            // 撤销，标记为false
            vis[i] = false;
            output.remove(output.size() - 1);
        }
    }
}
