package tree.width;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目地址：
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 *
 * 题目内容：
 * 【662. 二叉树最大宽度】
 * 给你一棵二叉树的根节点 root ，返回树的最大宽度。
 *
 */

public class Solution {

    //
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}
