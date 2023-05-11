package sort10;

public class ConMethod {
    public static void swapArrayElement(int[] arr, int i, int j){

        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
