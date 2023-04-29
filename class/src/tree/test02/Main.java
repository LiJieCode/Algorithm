package tree.test02;

import java.util.Arrays;

/**
 * 题目地址：
 *
 *
 * 题目内容：
 *
 *
 */
public class Main {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0, index = 0;
        int[] res = new int[length1 + length2];

        while (index1  < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];

            if (num1 == num2){
                if (index == 0 || num1 != res[index - 1]){
                    res[index++] = num2;
                }
                index1++;
                index2++;
            } else if (num1 > num2) {
                index2++;
            } else{
                index1++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


    public static void main(String[] args) {
        int[] ans1 = {1,2,3,4,5,6};
        int[] ans2 = {8,3,5,1,9,4,2,4,2,4,2};

        Main main = new Main();
        int[] ints = main.intersection(ans1, ans2);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
