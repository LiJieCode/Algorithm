package huawei.demo03;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 输入
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int n = sc.nextInt();
        int day = 0;
        int overMax = 0;
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // x y   "x y"
            // System.out.println(x + " " + y);
            res.put(x + " " + y, res.getOrDefault(x + " " + y, 0) + 1);
            overMax = Math.max(overMax, res.get(x + " " + y));
            if (overMax == M) {
                System.out.println(day);
                return;
            }
        }

        // 计算
        ArrayList<String> root = new ArrayList<>();
        for (String key : res.keySet()) {
            root.add(key);
        }

        while (overMax < M) {
            day += 1;
            int length = 2 * day + 1;

            for (String key : root) {
                int[] arr_x = new int[length];
                int[] arr_y = new int[length];
                String[] s = key.split(" ");
                int x1 = Integer.parseInt(s[0]);
                int y1 = Integer.parseInt(s[1]);
                for (int i = 0; i < length; i++) {
                    arr_x[i] = x1 - day + i;
                    arr_y[i] = y1 - day + i;
                }

                int x2 = arr_x[length / 2];
                // System.out.println(x2);
                int y2 = arr_y[length / 2];
                // System.out.println(y2);

                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < length; j++) {

                        String x_y = arr_x[i] + " " + arr_y[j];
                        double d = Math.sqrt(Math.pow(arr_x[i] - x2, 2) + Math.pow(arr_y[j] - y2, 2));
                        if (d < day) continue;
                        // System.out.println(d);

                        res.put(x_y, res.getOrDefault(x_y, 0) + 1);
                        overMax = Math.max(overMax, res.get(x_y));
                        if (overMax == M) {
                            System.out.println(day);
                            return;
                        }
                    }
                }
            }
        }
    }
}
