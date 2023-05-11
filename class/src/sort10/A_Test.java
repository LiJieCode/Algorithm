package sort10;

import java.util.Arrays;
import java.util.Random;

public class A_Test {
    public static void main(String[] args) {
        // 对数器
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int[] ints = new int[random.nextInt(21)];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = random.nextInt(100);
            }
            // Sort1.selection(ints);
            // Sort1.bubble(ints);
            // Sort1.Insertion(ints);
            // Sort2Merge.merge1(ints);
            // Sort2Merge.merge2(ints);
            Sort2Quick.quick2(ints);
            // Sort4.heapSort(ints);

            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=====================================");






    }
}
