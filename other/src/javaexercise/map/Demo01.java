package javaexercise.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 遍历Map的方法
 *
 *
 */

public class Demo01 {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1,"tom1");
        map.put(2,"tom2");
        map.put(3,"tom3");
        map.put(4,"tom4");

        // 第一种遍历方法  map.keySet()
        for (Integer key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
        System.out.println();


        // 第二种遍历方法  map.entrySet()
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }

        // 第三种遍历方法
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.print(next.getKey() + ":" + next.getValue() + "  ");
        }



    }
}
