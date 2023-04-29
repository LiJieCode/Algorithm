package huawei.test02;

/**
 *
 * 题目地址：
 * https://leetcode.cn/problems/symmetric-tree/
 *
 * 题目内容：
 * 判断一个二叉树是否是对称的二叉树
 *
 *
 *
 */
public class Main {

    public boolean isSymmetric(TreeNode root) {

        return check(root, root);

    }

    public boolean check (TreeNode p, TreeNode q){

        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        return p.val == q.val && check(p.right, q.left) && check(p.left, q.right);

    }


}
