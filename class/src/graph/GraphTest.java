package graph;


import java.util.ArrayList;
import java.util.Scanner;

public class GraphTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> v = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            v.add(i);
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        System.out.println("请输入邻接矩阵：");
        for (int i = 0; i < 4; i++) {
            adj.add(i, new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                int num = scan.nextInt();
                adj.get(i).add(num);
            }
        }
        Graph1 graph = new Graph1(4, v, adj);
        graph.printGraph();
        System.out.println("广度优先遍历的结果：");
        graph.BFSTraverse();
        System.out.println("\n深度优先遍历的结果：");
        graph.DFSTraverse();
    }
}


