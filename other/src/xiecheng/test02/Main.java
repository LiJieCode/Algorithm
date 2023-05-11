package xiecheng.test02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> ansMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int anInt = sc.nextInt();
            ansMap.put(str, anInt);
        }

        int maxValue = -1;

        int i = 0;
        for (Map.Entry<String, Integer> entry1 : ansMap.entrySet()) {
            i++;
            String key1 = entry1.getKey();
            int j = 0;
            for (Map.Entry<String, Integer> entry2 : ansMap.entrySet()) {
                j++;
                String key2 = entry2.getKey();
                //  这里有问题
                if (key1.contains(key2) && i != j) {
                    maxValue = Math.max(maxValue, ansMap.get(key1) + ansMap.get(key2));
                }
            }
        }
        System.out.println(maxValue);
    }
}
