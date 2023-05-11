package sort10;

public class Sort2Merge {

    public static int[] aux;

    // 自顶向下的归并排序
    public static void merge1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        aux = new int[arr.length];   // 一次性分配空间
        merge1(arr, 0, arr.length - 1);
    }

    // 方法的overloading
    public static void merge1(int[] arr, int l, int h) {
        if (h <= l) return;
        int m = l + (h - l) / 2;
        merge1(arr, l, m);
        merge1(arr, m + 1, h);
        mergeA_B(arr, l, m, h);
    }

    // 自底向上的归并排序
    public static void merge2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                mergeA_B(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    // 把两个有序数组，归并排序
    public static void mergeA_B(int[] arr, int l, int m, int h) {
        int i = l;
        int j = m + 1;
        // 把arr复制到aux中
        for (int k = l; k <= h; k++) {
            aux[k] = arr[k];
        }
        for (int k = l; k <= h; k++) {
            if (i > m) arr[k] = aux[j++];
            else if (j > h) arr[k] = aux[i++];
            else if (aux[i] > aux[j]) arr[k] = aux[j++];
            else arr[k] = aux[i++];
        }
    }


}
