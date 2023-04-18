package senior.day10.test01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目地址：
 *
 *
 * 题目内容：
 * 【】
 *
 *
 * 解题思路：
 *
 */
//public class LRUCache {
//
//    public LRUCache(int capacity) {
//        Map<>
//
//    }
//
//    public int get(int key) {
//        return 1;
//
//    }
//
//    public void put(int key, int value) {
//
//    }
//}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}



