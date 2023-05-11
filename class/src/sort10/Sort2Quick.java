package sort10;


import java.util.Arrays;

public class Sort2Quick {

    public static void quick1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 这里有个 shuffle 操作没有实现

        quick1(arr, 0, arr.length - 1);
    }


    public static void quick1(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        quick1(arr, lo, j-1 );
        quick1(arr, j+1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = arr[i];
        while (true) {
            while (arr[++i] < v) if (i == hi) break;
            while (arr[--j] > v) if (j == lo) break;
            if (i >= j) break;

            //ConMethod.swapArrayElement(arr, i, j);
        }
        //ConMethod.swapArrayElement(arr, lo, j);
        return j;
    }


    /**
     * 三向切的快速排序
     * @param arr 待排序数组
     */
    public static void quick2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quick1(arr, 0, arr.length - 1);
    }


    public static void quick2(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        quick1(arr, lo, j-1 );
        quick1(arr, j+1, hi);
    }
}
