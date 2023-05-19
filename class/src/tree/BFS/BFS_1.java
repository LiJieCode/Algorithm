package tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_1 {

    public int[] levelOrder1(TreeNode root) {

        if (root == null) return new int[0];

        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();

            res.add(curr.val);

            if (curr.left != null) nodeQueue.add(curr.left);
            // 再添加右子树
            if (curr.right != null) nodeQueue.add(curr.right);

        }

        int size = res.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }

        return result;
    }


    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int maxWidth = 0;

        while (!nodeQueue.isEmpty()) {
            maxWidth = Math.max(maxWidth, nodeQueue.size());

            TreeNode curr = nodeQueue.poll();

            if (curr.left != null) nodeQueue.add(curr.left);
            // 再添加右子树
            if (curr.right != null) nodeQueue.add(curr.right);

        }

        return maxWidth;

    }
}
