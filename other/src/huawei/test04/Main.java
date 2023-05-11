package huawei.test04;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 我没有到这个变量
        int n = sc.nextInt();
        String line = sc.next();
        String str = line.replace("+", " ");

        // 这里就是把  字符串  分成了两部分
        String[] strs = str.split(" ");

        // 把两个 量 的整数和小数分开
        // 如果只有整数，则数组只有一个元素
        String[] s1 = strs[0].replace(".", " ").split(" ");
        String[] s2 = strs[1].replace(".", " ").split(" ");

        // 这里要存储运算规则
        HashMap<String, Integer> map = new HashMap<>();
        map.put("!!", 0);
        map.put("!@", 13);
        map.put("!#", 4);
        map.put("@@", 7);
        map.put("@#", 20);
        map.put("##", 5);

        // 创建一个可变字符串
        StringBuilder res = new StringBuilder();

        // 存储进位
        int temp = 0;
        int s11 = 0;
        int s21 = 0;
        // 先计算小数部分  这里有点问题的？万一没有小数呢
        if (s1.length == 1 && s2.length == 2){
            s21 = s2[1].length();
        } else if (s1.length == 2 && s2.length == 1){
            s11 = s1[1].length();
        } else {
            s11 = s1[1].length();
            s21 = s2[1].length();
        }

        if (s11 >= s21) {
            for (int i = 0; i < s11 - s21; i++) {
                res.append(s1[1].charAt(s11 - 1 - i));
            }
            for (int i = 0; i < s21; i++) {
                char c1 = s1[1].charAt(s21 - 1 - i);
                char c2 = s2[1].charAt(s21 - 1 - i);
                String s_point1 = String.valueOf(c1) +String.valueOf(c2);
                String s_point2 = String.valueOf(c2) +String.valueOf(c1);

                int i1 = 0;
                if (map.containsKey(s_point1) || map.containsKey(s_point2)){
                    if (c1 == c2) {
                        i1 = map.getOrDefault(s_point1, 0) + temp;
                    } else {
                        i1 = map.getOrDefault(s_point1, 0) + map.getOrDefault(s_point2, 0) + temp;
                    }
                } else{
                    i1 = Integer.parseInt(String.valueOf(c1)) + Integer.parseInt(String.valueOf(c2)) + temp;
                }
                res.append(i1 % 10);
                temp = i1 / 10;
            }
        } else {            // s21 > s11
            for (int i = 0; i < s21 - s11; i++) {
                res.append(s2[1].charAt(s21 - 1 - i));
            }
            for (int i = 0; i < s11; i++) {
                char c1 = s1[1].charAt(s11 - 1 - i);
                char c2 = s2[1].charAt(s11 - 1 - i);
                String s_point1 = String.valueOf(c1) +String.valueOf(c2);
                String s_point2 = String.valueOf(c2) +String.valueOf(c1);

                int i1 = 0;
                if (map.containsKey(s_point1) || map.containsKey(s_point2)){
                    if (c1 == c2) {
                        i1 = map.getOrDefault(s_point1, 0) + temp;
                    } else {
                        i1 = map.getOrDefault(s_point1, 0) + map.getOrDefault(s_point2, 0) + temp;
                    }
                } else{
                    i1 = Integer.parseInt(String.valueOf(c1)) + Integer.parseInt(String.valueOf(c2)) + temp;
                }
                res.append(i1 % 10);
                temp = i1 / 10;
            }
        }

        res.append(".");
        // 再计算整数部分
        int s10 = s1[0].length();
        int s20 = s2[0].length();
        int min = Math.min(s10, s20);

        for (int i = 0; i < min; i++) {
            char c1 = s1[0].charAt(s10 - 1 - i);
            char c2 = s2[0].charAt(s20 - 1 - i);
            String s_point1 = String.valueOf(c1) + String.valueOf(c2);
            String s_point2 = String.valueOf(c2) + String.valueOf(c1);

            int i1 = 0;
            if (map.containsKey(s_point1) || map.containsKey(s_point2)){
                if (c1 == c2) {
                    i1 = map.getOrDefault(s_point1, 0) + temp;
                } else {
                    i1 = map.getOrDefault(s_point1, 0) + map.getOrDefault(s_point2, 0) + temp;
                }
            } else{
                i1 = Integer.parseInt(String.valueOf(c1)) + Integer.parseInt(String.valueOf(c2)) + temp;
            }
            res.append(i1 % 10);
            temp = i1 / 10;
        }


        if (s10 > s20) {
            for (int i = 0; i < s10 - s20; i++) {
                char c = s1[0].charAt(s10 - s20 - 1 - i);
                int i1 = Integer.parseInt(String.valueOf(c)) + temp;
                res.append(i1 % 10);
                temp = i1 / 10;
            }
        } else if (s10 < s20) {   // s20 > s10
            for (int i = 0; i < s20 - s10; i++) {
                char c = s2[0].charAt(s20 - s10 - 1 - i);
                int i1 = Integer.parseInt(String.valueOf(c)) + temp;
                res.append(i1 % 10);
                temp = i1 / 10;
            }
        } else {
            if(temp != 0) {
                res.append(temp);
            }
        }

        // 反转字符串，并转化成double
        Double ans = Double.valueOf(res.reverse().toString());
        System.out.println(ans);
    }
}