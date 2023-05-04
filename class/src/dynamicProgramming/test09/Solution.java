package dynamicProgramming.test09;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目地址：
 * https://leetcode.cn/problems/house-robber-iii/description/
 *
 * 题目内容：
 * 【打家劫舍3】
 * 以二叉树为基础，求偷盗的最大金额
 */
public class Solution {

    // f
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
