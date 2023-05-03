package tree.width;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 求叶子节点
 *
 *
 *
 */

public class Solution_true {
    public int widthOfBinaryTree(TreeNode root) {
        // 不说了
        if(root == null) return 0;
        // 用来存放树的节点
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        // 记录最大的宽度
        int width = 0;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            // 重点就是这一句代码
            // 每次对比最大值和该层的宽度，选择两者的最大值
            width = Math.max(nodeQueue.size(), width);
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode curr = nodeQueue.poll();
                // 左右子树添加到队列
                if (curr.left != null) nodeQueue.add(curr.left);
                if (curr.right != null) nodeQueue.add(curr.right);
            }
        }
        return width;
    }
}
