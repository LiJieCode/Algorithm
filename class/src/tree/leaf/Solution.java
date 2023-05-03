package tree.leaf;

public class Solution {
    public int countOfLeaf(TreeNode root) {
        if (root == null) return 0;
        // 这里不管是||还是&&，都是可以实现的
        // 需要思考一下，为什么？
        // if (root.left == null && root.right == null) return 1;
        if (root.left == null || root.right == null) return 1;
        // 返回左右子树的叶子节点数的和
        return countOfLeaf(root.left) + countOfLeaf(root.right);
    }
}
