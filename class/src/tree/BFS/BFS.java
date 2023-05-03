package tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索，借助队列实现
 */
public class BFS {
    // 第一种：以数组的方式返回结果
    public int[] levelOrder1(TreeNode root) {
        // 如果根节点为空，返回空数组
        if (root == null) return new int[0];
        // 声明一个队列，用来存储树的节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 声明一个链表，用来存储节点值
        ArrayList<Integer> ans = new ArrayList<>();
        // 根节点进队列
        queue.add(root);

        // !queue.isEmpty()
        // 但队列不为空时，继续访问队列
        while (queue.size() != 0) {
            // 取出下一个要访问的节点，称为当前节点
            TreeNode curr = queue.poll();
            // 访问当前节点的值，并添加到ans链表中
            ans.add(curr.val);
            // 向队列中添加左右子树节点
            // 先添加左子树
            if (curr.left != null) queue.add(curr.left);
            // 再添加右子树
            if (curr.right != null) queue.add(curr.right);
        }

        // 下面代码的作用是将链表ans的结果传给数组，并返回。
        int size = ans.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    // 第二种：以List集合返回 层先方法
    public List<List<Integer>> levelOrder2(TreeNode root) {
        // 这里先创建一个结果链表
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)  return  res;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()) {
            //这里是每一层创建一个链表，用来存放当前一层的节点值
            ArrayList<Integer> ans = new ArrayList<>();
            // 循环当前队列的所有节点，即为树的该层所有的节点
            for (int i = nodeQueue.size(); i > 0; i--) {
                TreeNode curr = nodeQueue.poll();
                ans.add(curr.val);
                // 这里相当于是把下一层节点放入队列中
                if (curr.left != null) nodeQueue.add(curr.left);
                if (curr.right != null) nodeQueue.add(curr.right);
            }
            // 将存放每一层的节点值的链表添加到结果链表中
            res.add(ans);
        }
        // 直接返回结果
        return res;
    }
}
