package tree.DFS;

import java.util.ArrayList;
import java.util.Stack;

public class DFS1 {
    // 前序遍历
    public int[] preorderTraversal(TreeNode root) {
        if (root == null)  return new int[0];
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        ArrayList<Integer> res = new ArrayList<>();

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            res.add(curr.val);

            if (curr.right != null) nodeStack.push(curr.right);
            if (curr.left != null) nodeStack.push(curr.left);
        }

        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }


    // 后序遍历
    public int[] postorderTraversal(TreeNode root) {
        if (root == null)  return new int[0];
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        ArrayList<Integer> res = new ArrayList<>();

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            res.add(curr.val);

            if (curr.left != null) nodeStack.push(curr.left);
            if (curr.right != null) nodeStack.push(curr.right);

        }

        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(size - 1 - i);
        }

        return ans;
    }


    // 中序遍历
    public int[] inorderTraversal(TreeNode root) {

        if(root == null) return new int[0];

        Stack<TreeNode> nodeStack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !nodeStack.isEmpty()){

            if (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            } else {
                curr = nodeStack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        // ArrayLiat -> Array
        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

}
