package tree.DFS;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 深度优先搜索
 * 递归实现
 */

public class DFS3 {
    // 1、先序遍历
    public int[] preorderTraversal(TreeNode root) {

        if (root == null) return new int[0];
        ArrayList<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    public void preorder(TreeNode root, ArrayList<Integer> ans){
        if (root == null) return;
        ans.add(root.val);  // 中
        preorder(root.left, ans);
        preorder(root.right, ans);
    }



    // 2、中序遍历
    public int[] inorderTraversal(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> ans = new ArrayList<>();

        inorder(root, ans);

        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    public void inorder(TreeNode root, ArrayList<Integer> ans){
        if (root == null) return;
        inorder(root.left, ans);    // 左
        ans.add(root.val);          // 中
        inorder(root.right, ans);   // 右
    }

    // 3、后序遍历
    public int[] postorderTraversal(TreeNode root) {
        if (root == null) return new int[0];
        ArrayList<Integer> ans = new ArrayList<>();

        postorder(root, ans);

        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
    public void postorder(TreeNode root, ArrayList<Integer> ans){
        if (root == null) return;

        postorder(root.left, ans);      //左
        postorder(root.right, ans);     // 右
        ans.add(root.val);              // 中
    }
}


