package tree.BFS;

/**
 *
 * 测试程序
 *
 */

public class TestTree {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode6.right = treeNode10;
        treeNode4.left = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        BFS bfs = new BFS();
        int[] ints = bfs.treePrintBFS(treeNode1);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
