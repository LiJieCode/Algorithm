package tree.isTargetSum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目地址：
 * https://leetcode.cn/problems/path-sum/description/
 *
 * 题目内容：
 * 【路径总和】
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 解题思路：
 * 广度优先
 *
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();

        nodeQueue.add(root);
        valueQueue.add(root.val);

        while (!nodeQueue.isEmpty()){
            // 取出当前节点和值
            TreeNode currNode = nodeQueue.poll();
            int currValue = valueQueue.poll();
            // 判断是否是叶子节点
            if (currNode.left == null && currNode.right == null) {
                // 判断和是否与目标值相等
                if (currValue == targetSum) return true;
            }

            // 更新当前节点
            if (currNode.left != null) {
                nodeQueue.add(currNode.left);
                valueQueue.add(currNode.left.val + currValue);
            }
            // 更新当前值
            if (currNode.right != null) {
                nodeQueue.add(currNode.right);
                valueQueue.add(currNode.right.val + currValue);
            }
        }
        return false;
    }
}
