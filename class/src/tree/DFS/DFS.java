package tree.DFS;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 深度优先搜索
 *
 * - 先序遍历很好理解
 * - 中序遍历不怎么好理解
 * - 后序遍历是在先序遍历的基础上，加以修改
 *   - 先序遍历是：中左右
 *   - 调换一下顺序：中右左（这个很容易实现）
 *   - 然后反正数组：左右中（这正是后序遍历的顺序）
 */

public class DFS {
    // 1、先序遍历
    public int[] preorderTraversal(TreeNode root) {
        // 如果根节点为空，返回空数组
        if (root == null) return new int[0];
        // 声明一个栈，用来存放各节点
        Stack<TreeNode> stack = new Stack<>();
        // 声明一个链表，用来存放各节点的值
        ArrayList<Integer> ans = new ArrayList<>();
        // 根节点压栈
        stack.push(root);
        // 当栈不为空时，证明树的节点还未访问完，继续访问
        while (!stack.isEmpty()) {
            // 当前节点弹栈
            TreeNode node = stack.pop();
            // 访问当前节点的值，并添加到链表中年
            ans.add(node.val);
            // 先压栈右节点，再压栈左节点
            // 为什么先压右节点，再压左节点？这里自己动手画一画流程图就清楚明白了
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        // 下面代码的作用是将链表ans的结果传给数组，并返回。
        int size = ans.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    // 2、中序遍历
    public int[] inorderTraversal(TreeNode root) {
        if (root == null) return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        // 中序遍历，需要对当前节点进行判断，所以先声明一个当前节点
        TreeNode curr = root;
        // 如果当前节点不为空，或者栈不为空，都进入循环，为什么？
        // 第一次是因为栈空，但当前节点为root不为空
        // 中间两者都满足，都不为空
        // 当到叶子节点时，当前节点为空，但是栈不为空
        // 直到访问了最后一个叶子节点，两个都为空了，也就结束了
        while (curr != null || !stack.isEmpty()) {
            if (curr != null){
                // 当前节点不为空，压栈
                // 这里是因为中序遍历，所以要先访问左子树的最后一个节点
                // 所以要先压栈，不能访问
                stack.push(curr);
                // 当前节点压栈以后，指向自己的左子树
                curr = curr.left;
            } else {
                // 如果当前节点为空了，证明到了叶子节点，
                // 这时在栈中弹出最顶的节点，即为最左的一个节点
                curr = stack.pop();
                // 访问节点，并将值添加链表中
                ans.add(curr.val);
                // 指向右子树
                curr = curr.right;
            }
        }
        // 下面代码的作用是将链表ans的结果传给数组，并返回。
        int size = ans.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    // 3、后序遍历
    // 明白了先序遍历，后序遍历就简单跟多了
    public int[] postorderTraversal(TreeNode root) {
        if (root == null) return new int[0];
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            // 反向赋值
            result[i] = temp.get(size - i - 1);
        }
        return result;
    }
}


