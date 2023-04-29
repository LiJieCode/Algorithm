package huawei.test01;

/**
 *
 *
 *
 *
 *
 */
public class Main {
     public int jump1(int[] nums) {
         int position = nums.length - 1;
         int steps = 0;
         while(position > 0) {
             for (int i = 0; i < position; i++) {
                 if (i + nums[i] >= position) {
                     position = i;
                     steps++;
                     break;
                 }
             }
         }
         return steps;
     }


    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
