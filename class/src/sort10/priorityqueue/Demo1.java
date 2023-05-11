package sort10.priorityqueue;

import java.util.PriorityQueue;

public class Demo1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(100);
        priorityQueue.offer(120);
        priorityQueue.offer(80);
        priorityQueue.offer(140);
        priorityQueue.offer(60);

//        for (Integer integer : priorityQueue) {
//            System.out.println(integer);
//        }

        System.out.println(priorityQueue.poll());


    }
}
