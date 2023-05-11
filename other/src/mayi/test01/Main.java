package mayi.test01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // 在不考虑 0 的前提下
        // 只有在 a+b==c 和 a+b=c+1 这两种情况下
        // 才能构造出合适的数
        // 其他情况都不存在

        if (a + b == c) {
            int x = 9 * (int) Math.pow(10, a - 1);
            int y = 9 * (int) Math.pow(10, b - 1);
//            for (int i = 1; i < a; i++) {
//                x = x * 10 + 9;
//            }
//            for (int i = 1; i < b; i++) {
//                y = y * 10 + 9;
//            }
            System.out.println(x + " " + y);
        } else if (a + b == c + 1) {
            int x = (int) Math.pow(10, a - 1);
            int y = (int) Math.pow(10, b - 1);
//            for (int i = 1; i < a; i++) {
//                x = x * 10;
//            }
//            for (int i = 1; i < b; i++) {
//                y = y * 10;
//            }
            System.out.println(x + " " + y);
        } else
            System.out.println(-1);
    }
}


// else if (a == 1 && c == 1 && b > 1) {
//         int x = 0;
//         int y = 9 * (int) Math.pow(10, b);
//         System.out.println(x + " " + y);
//         } else if (b == 1 && c == 1 && a > 1) {
//         int x = 9 * (int) Math.pow(10, a);
//         int y = 0;
//         System.out.println(x + " " + y);
//         }



