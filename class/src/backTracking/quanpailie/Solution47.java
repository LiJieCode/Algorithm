package backTracking.quanpailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution47 {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<Integer>();
        int n = nums.length;
        vis = new boolean[n];

        Arrays.sort(nums);

        backtracking(nums, n, res, output, 0);
        return res;
    }

    public void backtracking(int[] nums, int n, List<List<Integer>> ans, List<Integer> output, int depth) {
        if (depth == n) {
            ans.add(new ArrayList<Integer>(output));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue; // 剪枝
            }
            output.add(nums[i]);
            vis[i] = true;
            backtracking(nums, n, ans, output,depth + 1);
            vis[i] = false;
            output.remove(depth);
        }
    }
}