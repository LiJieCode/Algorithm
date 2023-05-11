package sort10;

public class Sort1 {

    /**
     * 选择排序
     *
     * @param arr 待排序数组
     */
    public static void selection(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int indexMin = i;
            for (int j = i + 1; j < N; j++) {
                indexMin = arr[j] > arr[indexMin] ? indexMin : j;
            }
            ConMethod.swapArrayElement(arr, i, indexMin);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr 待排序数组
     */
    public static void bubble(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                // 一句代码，主要的是上述的变量 j 的界
                if (arr[j] > arr[j + 1]) {
                    ConMethod.swapArrayElement(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr 待排序数组
     */
    public static void Insertion(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    ConMethod.swapArrayElement(arr, j, j - 1);
                }
            }
            // for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--)  ConMethod.swapArrayElement(arr, j, j - 1);
        }
    }


}
