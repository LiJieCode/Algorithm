package senior.day16.test01;

/**
 * 题目地址：
 * https://leetcode.cn/problems/pOCWxh/?envType=study-plan-v2&id=coding-interviews-special
 *
 * 题目内容：
 * 【剑指 Offer II 047. 二叉树剪枝】
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 *
 * 总结沉淀：
 *
 */

public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return  null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.right == null && root.left == null && root.val == 0) return null;

        return root;
    }
}
