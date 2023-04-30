package tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索，借助队列实现
 */
public class BFS {

    public int[] treePrintBFS(TreeNode root) {

        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(root);

        // !queue.isEmpty()
        while (queue.size() != 0) {
            // 取出当前节点
            TreeNode curr = queue.poll();
            // 访问当前节点的值，并添加到链表中
            temp.add(curr.val);
            // 向队列中添加左右子树节点
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

    // 以List集合返回 层先方法
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)  return  res;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode curr = nodeQueue.poll();
                ans.add(curr.val);
                if (curr.left != null) nodeQueue.add(curr.left);
                if (curr.right != null) nodeQueue.add(curr.right);
            }
            res.add(ans);
        }

        return res;
    }

}
