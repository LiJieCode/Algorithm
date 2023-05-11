package sort10;


/**
 *
 * https://blog.csdn.net/m0_57410337/article/details/126123389
 *
 */
public class Sort4 {

    // 堆排序部分
    public static void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            heapAdjest(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            ConMethod.swapArrayElement(arr, 0, i);
            // int temp = arr[0];
            // arr[0] = arr[i];
            // arr[i] = temp;
            heapAdjest(arr, 0, i);
        }
    }

    // 堆调整部分
    public static void heapAdjest(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int child = parent * 2 + 1;
        while (child < length) {
            if (child + 1 < length && arr[child + 1] > arr[child]) {
                child++;
            }
            if (temp >= arr[child]) {
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        arr[parent] = temp;
    }
}
