package senior.day16.test03;

/**
 * 题目地址：
 * https://leetcode.cn/problems/3Etpl5/solutions/?envType=study-plan-v2&id=coding-interviews-special
 *
 *
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
