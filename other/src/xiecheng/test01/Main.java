package xiecheng.test01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c>= 65 && c < 90) {
                c += 1;
            } else if (c == 90 ) {
                c = 65;
            } else if (c > 97 && c <= 122){
                c -= 1;
            } else if (c == 97) {
                c = 122;
            }
            str.append(c);
        }

        System.out.println(str.toString());
    }

}
