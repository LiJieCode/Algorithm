package tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 广度优先搜索，借助队列实现
 *
 */
public class BFS {

    public int[] treePrintBFS(TreeNode root) {

        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(root);

        // !queue.isEmpty()
        while (queue.size() != 0) {
            TreeNode curr = queue.poll();
            temp.add(curr.val);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }

}
