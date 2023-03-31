package senior.day02.test01;
/**
 *
 * 题目地址：
 * https://leetcode.cn/problems/WGki4K/description/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=xhwzd117
 *
 * 题目：
 * 给你一个整数数组 nums ，除某个元素仅出现一次外，其余每个元素都恰出现三次 。请你找出并返回那个只出现了一次的元素。
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // 将 num 依次存入哈希表
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 从hash表中判断那个出现 1 次，并返回
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) return key;
        }

        return 0;
    }
}