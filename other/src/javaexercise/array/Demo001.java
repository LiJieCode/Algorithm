package javaexercise.array;

import java.util.Arrays;

/**
 *
 * 数组反转
 * 数据工具类的使用 Arrays
 *
 */
public class Demo001 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,4,3};

        // 指定数组中的范围进行字典排序
        //parallelSort 和 sort 用法类似，功能类似
        Arrays.sort(arr, 1,4);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        // 数组排序
        // Arrays.sort
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        // 赋值子数组
        // Arrays.copyOfRange
        int[] arrcopy = Arrays.copyOfRange(arr, 1, 3);
        for (int i : arrcopy) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 打印数组
        // Arrays.toString()
        System.out.println(Arrays.toString(arr));
        // System.out.println(arr);  // 输出的是引用

        //




    }
}
