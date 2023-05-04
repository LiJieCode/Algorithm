package queueStack.test03;

import java.util.*;

public class Solution_self {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> occ = new HashMap<>();
        for (int num : nums) {
            occ.put(num, occ.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];   // 升序排列
            }
        });

        for (Map.Entry<Integer, Integer> entry : occ.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if(pq.size() == k){
                if (pq.peek()[1] < count){
                    pq.poll();
                    pq.add(new int[]{num, count});
                }
            } else pq.add(new int[]{num, count});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
