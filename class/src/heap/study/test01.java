package heap.study;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 测试优先队列
 *
 */
public class test01 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> pq1 = new PriorityQueue<>();

        pq.add(3);
        pq.add(6);
        pq.add(2);
        pq.add(4);
        pq.add(9);
        pq.add(5);
        pq.add(1);
        pq.add(7);

        System.out.println(pq.size()
        );
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            System.out.println(pq.poll());
        }



    }

}
