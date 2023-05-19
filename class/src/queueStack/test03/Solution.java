package queueStack.test03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目地址：
 * https://leetcode.cn/problems/top-k-frequent-elements/description/
 *
 * 题目内容：
 * 【前k个高频元素】
 *
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 首先把nums放到HashMap表中
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] p, int[] q) {
//                return p[1] - q[1];
//            }
//        });

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            //
            if (queue.size() == k) {
                // 这里就两种情况
                // 第一种：队列元素不满k个，直接进队列
                // 第二种：和队列中最小的元素比较，大于最小的元素，才有机会成为前K个高频元素
                // 小顶堆，来一个元素和最小的比较，大于最小的元素，才能成为前K个高频元素
                if (queue.peek()[1] < count) {
                    queue.poll();  //根节点（最小的取出）
                    queue.offer(new int[]{num, count});     // 加入当前元素
                }
            } else {
                // 如果优先队列的元素小于k，直接加进去，也就是假设前k个就是出现频率最高的k个
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            // 按出现次数从小到大依次取出
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
