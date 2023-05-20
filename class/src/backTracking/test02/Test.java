package backTracking.test02;


import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        Solution solution = new Solution();

        List<List<Integer>> res = solution.permuteUnique(nums);

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }

    }
}
