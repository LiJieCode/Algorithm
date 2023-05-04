package javaexercise.collect;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Collections工具类的使用
 *
 */
public class Demo001 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(1);
        System.out.println(arrayList.toString());

        // 交换元素
        // Collections.swap
        Collections.swap(arrayList, 0,1);
        System.out.println(arrayList.toString());


        // 随机打乱
        // Collections.shuffle
        Collections.shuffle(arrayList);
        System.out.println(arrayList.toString());

        // 最大值，最小值
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));

        // 排序
        Collections.sort(arrayList);
        System.out.println(arrayList.toString());

        // 二分查找
        // list 保证有序，返回目标值下标
        System.out.println(Collections.binarySearch(arrayList, 3));


        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(5);
        linkedList.add(3);
        linkedList.add(1);
        System.out.println(linkedList.toString());





    }
}
