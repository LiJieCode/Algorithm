package base.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keySet = counts.keySet();
        int size = nums.length;

        for (int item: keySet) {
            if(counts.get(item) > size / 2) return item;
        }

        return -1;
    }
}
