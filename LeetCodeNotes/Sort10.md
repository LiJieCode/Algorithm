## 排序算法

- 简单排序：插入排序、选择排序、冒泡排序（必学）  

- 分治排序：快速排序、归并排序（必学，快速排序还要关注中轴的选取方式）  
- 分配排序：桶排序、基数排序  
- 树状排序：堆排序（必学）  
- 其他：计数排序（必学）、希尔排序  

```java
public static void swapArrayElement(int[] arr, int i, int j) {
    if (i == j ) return;
    arr[i] = arr[i] ^ arr[j];
    arr[j] = arr[i] ^ arr[j];
    arr[i] = arr[i] ^ arr[j];
}
```

## 插入排序

```java
public static void Insertion(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }
    int N = arr.length;
    for (int i = 1; i < N; i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j] < arr[j - 1]) ConMethod.swapArrayElement(arr, j, j - 1);
        }
        // for (int j = i; j > 0 && (arr[j] < arr[j - 1]); j--)  {
        //     ConMethod.swapArrayElement(arr, j, j - 1);
    	// }
    }
}
```

## 选择排序

```java
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
```

## 冒泡排序

```java
public static void bubble(int[] arr) {
    if (arr == null || arr.length < 2) {
        return;
    }
    int N = arr.length;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - i - 1; j++) {
            // 一句代码，主要的是上述的变量 j 的界
            if (arr[j] > arr[j + 1]) ConMethod.swapArrayElement(arr, j, j + 1);
        }
    }
}
```

### 快速排序

```
```

## 归并排序

> 已经有序的数组，选归并排序

```java
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

    // 方法的 overloading
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
```

## 堆排序

```
```

## 计数排序

```
```

## 希尔排序  

```
```





