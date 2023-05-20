package backTracking.test02;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> output = new ArrayList<>();

        int length = nums.length;
        boolean[] vis = new boolean[length];

        backTracking(nums, vis, res, output, 0);
        return res;

    }

    public void backTracking(int[] nums, boolean[] vis, List<List<Integer>> res, List<Integer> output, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(output));
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件：
            // 把 相同的数 看成一个定序
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;

            output.add(nums[i]);
            vis[i] = true;
            backTracking(nums, vis, res, output, pos + 1);
            vis[i] = false;
            output.remove(output.size() - 1);
        }


    }
}
