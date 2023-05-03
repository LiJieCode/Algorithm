package tree.depth;

public class Solution1 {
    // 利用深度优先  -  迭代法
    public int maxDepth(TreeNode root) {
        // 如果根节点为空，直接返回0
        if (root == null) return 0;
        // 根节点不为空，那就遍历左右子树，求左右子树的最大值
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        // 最后返回的就是左右子树高度的最大值+1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
