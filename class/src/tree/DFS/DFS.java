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

    // 先序遍历
    public int[] preorderTraversal(TreeNode root) {
        if (root == null) return new int[0];

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // 当前节点弹栈
            TreeNode node = stack.pop();
            // 访问当前节点的值，并添加到链表中年
            temp.add(node.val);
            // 先压栈右节点，再压栈左节点
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }



    // 中序遍历
    public int[] inorderTraversal(TreeNode root) {
        if (root == null) return new int[0];

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null){
                // 当前节点不为空，压栈
                stack.push(curr);
                curr = curr.left;
            } else {
                // 当前节点为空了，在栈中弹出最顶的节点
                curr = stack.pop();
                // 访问节点，并将值添加链表中
                temp.add(curr.val);
                curr = curr.right;
            }
        }

        int size = temp.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = temp.get(i);
        }
        return result;
    }



    // 后序遍历
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
            result[i] = temp.get(size - i - 1);
        }
        return result;

    }
}


