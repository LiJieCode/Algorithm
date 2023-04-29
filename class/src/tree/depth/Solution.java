package tree.depth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目地址：
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 *
 * 题目内容：
 * 二叉树的最大深度
 */
public class Solution {

    // 深度优先  -  迭代法
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }


    // 广度优先  -  借助队列实现
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int res = 0;
        while (!nodeQueue.isEmpty()) {
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode node = nodeQueue.poll();
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }
            res++;
        }
        return res;
    }
}
