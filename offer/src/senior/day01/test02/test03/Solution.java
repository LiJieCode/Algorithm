package senior.day01.test02.test03;

public class Solution {
    /**
     * 方法一：Brian Kernighan 算法
     * 原理：对于任意整数x，令 x = x & (x−1)x，该运算将 x 的二进制表示的最后一个 1 变成 0。
     *     因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     */
    public int[] countBits(int n) {
        // 0-n，一共n+1个数，声明一个n+1的数组
        int[] res = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            // countOnes() 利用 Brian Kernighan算法 计算十进制i的二进制对应的1的个数
            res[i] = countOnes(i);
        }

        return res;
    }

    // 返回x对应二进制数中1的个数
    public int countOnes(int x) {
        int one = 0;

        while (x > 0) {
            // 这个操作，自己动手举个简单的例子，就会很清晰了
            x = x & (x - 1);
            one++;
        }

        return one;
    }


    /**
     * 方法二：动态规划
     *        计算当前的值时，能用之前的值经过合适的计算得出
     *
     * 最高有效位
     *
     */
    public int[] countBits1(int n) {
        // 0-n，一共n+1个数，声明一个n+1的数组
        int[] res = new int[n + 1];
        // 记录最高有效位，最大的2的整数幂次的数，初始值为1；
        int highBit = 1;
        res[0] = 0;

        for (int i = 1; i < n + 1; i++) {

            // 更新，最高有效位
            if ((i & (i - 1)) == 0) highBit = i;

            // 计算；当前数值的结果，等于去掉最高有效位之后的数值结果 + 1
            //      动手举个最简单的例子，就会清楚了
            res[i] = res[i - highBit] + 1;
        }

        return res;
    }

    /**
     * 方法二：动态规划
     *        计算当前的值时，能用之前的值经过合适的计算得出
     *
     * 最低有效位
     *
     */
    public int[] countBits2(int n) {
        // 0-n，一共n+1个数，声明一个n+1的数组
        int[] res = new int[n + 1];
        res[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            // 图解见《刷题图解.pptx》P1
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }


    /** 总结沉淀
     * 1、List<Integer> list = new ArrayList<>();
     *   list.toArray()  返回的是Object, 怎么转成别的数组呐
     *
     * 2、怎么判断一个数x是不是2的整数幂次数？
     *    x & (x-1) == 0  true 代表是2的整数次幂，false代表不是
     *
     */
}
