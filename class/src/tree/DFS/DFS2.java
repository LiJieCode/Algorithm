package tree.DFS;

import scala.reflect.internal.Trees;

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
import java.util.Stack;

public class DFS2 {
    public int[] preorderTraversal(TreeNode root) {
        if (root == null) return new int[0];

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            ans.add(curr.val);

            if (curr.right != null) nodeStack.push(curr.right);
            if (curr.left != null) nodeStack.push(curr.left);
        }

        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(size - 1 - i);
        }
        return res;

    }

    public int[] inorderTraversal(TreeNode root){

        if (root == null) return new int[0];

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !nodeStack.isEmpty()) {

            if (curr != null){
                nodeStack.push(curr);
                curr = curr.left;
            } else {
                curr = nodeStack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }

        int size = ans.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = ans.get(size - 1 - i);
        }
        return res;


    }



//    public int[] postorderTraversal(TreeNode root){
//
//
//    }
}
